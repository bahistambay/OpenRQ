package RQLibrary;

abstract class Deg{

	protected static long deg(long v, long W){

		int i;
		for(i=0; i<31; i++){
			if(v < table[i])
				break;
		}

		if(i==31) throw new RuntimeException("Something went BOOM!");

		return(Math.min(i, W-2));	
	}

	private static long[] table = {
		0, 
		5243,
		529531,
	    704294,
		791675,
		844104,
		879057,
		904023,
		922747,
		937311,
		948962,
		958494,
		966438,
		973160,
		978921,
		983914,
		988283,
		992138,
		995565,
		998631,
		1001391,
		1003887,
		1006157,
		1008229,
		1010129,
		1011876,
		1013490,
		1014983,
		1016370,
		1017662,
		1048576
	};
}