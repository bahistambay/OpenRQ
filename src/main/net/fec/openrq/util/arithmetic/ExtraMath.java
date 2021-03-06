/*
 * Copyright 2014 Jose Lopes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.fec.openrq.util.arithmetic;


import java.math.BigInteger;


/**
 * Defines arithmetical functions not present in class {@code java.lang.Math}.
 */
public final class ExtraMath {

    /**
     * Returns the ceiling value of an integer division (requires non-negative arguments).
     * 
     * @param num
     *            The numerator
     * @param den
     *            The denominator
     * @return the ceiling value of an integer division
     * @exception ArithmeticException
     *                If the denominator is equal to zero
     */
    public static int ceilDiv(int num, int den) {

        return (int)((num + (den - 1L)) / den); // there is an implicit cast to long to prevent integer overflow
    }

    /**
     * Returns the ceiling value of a long integer division (requires non-negative arguments).
     * 
     * @param num
     *            The numerator
     * @param den
     *            The denominator
     * @return the ceiling value of a long integer division
     * @exception ArithmeticException
     *                If the denominator is equal to zero
     */
    public static long ceilDiv(long num, long den) {

        if (Long.MAX_VALUE - num < den - 1L) { // if num + (den - 1) overflows
            final BigInteger bigNum = BigInteger.valueOf(num);
            final BigInteger bigDen = BigInteger.valueOf(den);
            return bigNum.add(bigDen.subtract(BigInteger.ONE)).divide(bigDen).longValue();
        }
        else {
            return (num + (den - 1L)) / den;
        }
    }

    /**
     * Returns the (modular in case of overflow) integer power.
     * 
     * @param base
     *            The power base
     * @param exp
     *            The power exponent
     * @return base^^exp
     * @exception IllegalArgumentException
     *                If the exponent is negative or if both base and exponent are equal to zero
     */
    public static int integerPow(int base, int exp) {

        if (exp < 0) throw new IllegalArgumentException("exponent must be non-negative");
        if (base == 0) {
            if (exp == 0) throw new IllegalArgumentException("0^^0 is undefined");
            else return 0;
        }

        // exponentiation by squaring

        int result = 1;
        while (exp != 0)
        {
            if ((exp & 1) == 1) {
                result *= base;
            }
            exp >>= 1;
            base *= base;
        }

        return result;
    }

    /**
     * Returns the (modular in case of overflow) long integer power.
     * 
     * @param base
     *            The power base
     * @param exp
     *            The power exponent
     * @return base^^exp
     * @exception IllegalArgumentException
     *                If the exponent is negative or if both base and exponent are equal to zero
     */
    public static long integerPow(long base, long exp) {

        if (exp < 0) throw new IllegalArgumentException("exponent must be non-negative");
        if (base == 0) {
            if (exp == 0) throw new IllegalArgumentException("0^^0 is undefined");
            else return 0;
        }

        // exponentiation by squaring

        long result = 1;
        while (exp != 0)
        {
            if ((exp & 1) == 1) {
                result *= base;
            }
            exp >>= 1;
            base *= base;
        }

        return result;
    }

    private ExtraMath() {

        // not instantiable
    }
}
