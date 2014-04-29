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
package net.fec.openrq.parameters;


import net.fec.openrq.util.arithmetic.ExtraMath;
import net.fec.openrq.util.rq.SystematicIndices;


/**
 */
final class InternalFunctions {

    // requires valid arguments
    static int KL(int n, int WS, int Al, int T) {

        final int upper_bound = WS / (Al * ExtraMath.ceilDiv(T, Al * n));
        return SystematicIndices.floor(upper_bound);
    }
    
    // requires valid arguments
    static int minWS(int KL, int n, int Al, int T) {
        
        return KL * (Al * ExtraMath.ceilDiv(T, Al * n));
    }

    private InternalFunctions() {

        // not instantiable
    }
}