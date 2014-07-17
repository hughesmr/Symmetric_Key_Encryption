
public class fFunction { // Begin class fFucntion

//  ==============	
//  Method getTVal
//  ======================	
	public int[] getTVal(int[] r0, int[] r1, int[] K){
		
		int[] t0 = new int[2];
		int[] t1 = new int[2];
		int[] f = new int[4];
		
		gFunction g = new gFunction();
	    t0 = g.gFunc(K[0], K[1], K[2], K[3], r0);
		t1 = g.gFunc(K[4], K[5], K[6], K[7], r1);
		
		
		int x = 0; x  = (int) (((int)t0[0] << 8) | t0[1]);
		int y = 0; y   = (int) (((int)t1[0] << 8) | t1[1]);
		int k11 =  (int) (((int)K[8] << 8) | K[9]);
		int k22 = (int) (((int)K[10] << 8) | K[11]);
		
		int a1 = 0; a1 = ((x + (2*y) + k11) % 65536);
		int a2 = 0; a2 = ((y + (2*x) + k22) % 65536);
	
		f[0]  = (a1 & 0xff);
		f[1] = ((a1 >> 8) & 0xff);
		f[2] = (a2 & 0xff);
		f[3] = ((a2 >> 8) & 0xff);
		
		
		return f;
		
	} // End method getTVal
//  =======================		
}// End class fFunction
// ====================