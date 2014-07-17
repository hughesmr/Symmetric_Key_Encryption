
public class gFunction {
	
// 	============
//	Method gFunc
//  =============================================================	
	public int[] gFunc(int k0, int k1, int k2, int k3, int[] r0){
		
		fTable f = new fTable();
		
		int[] t = new int[2];
		int g1 = r0[0];
		int g2 = r0[1];
		int g3 = f.getFVal(g2^k0)^g1;
		int g4 = f.getFVal(g3^k1)^g2;
		int g5 = f.getFVal(g4^k2)^g3;
		int g6 = f.getFVal(g5^k3)^g4;
		
		t[0] = g5;
		t[1] = g6;
		
		return t;
		
	} // End method gFunc
//  =====================
	
} // End class gFunc
// =================