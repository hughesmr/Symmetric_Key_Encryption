
public class encrypt {
	
//  ==============	
//  Method getData
//  ============================================	
	public int[] getData(int[] data, int[] key, int[][] subKeys){
		
		int[] w0 = new int[2];
		int[] w1 = new int[2]; 
		int[] w2 = new int[2]; 
		int[] w3 = new int[2]; 
		
		int[] k0 = new int[2];
		int[] k1 = new int[2]; 
		int[] k2 = new int[2]; 
		int[] k3 = new int[2];
	

		for(int i = 0; i < 2; i++){ // For split blocks
			
			w0[i] = data[i];
			w1[i] = data[i+2];
			w2[i] = data[i+4];
			w3[i] = data[i+6];
			
			k0[i] = key[i];
			k1[i] = key[i+2];
			k2[i] = key[i+3];
			k3[i] = key[i+4];
			
		} // End for split blocks
		return encryption(w0, w1, w2, w3, k0, k1, k2, k3, key, subKeys, 0);
		
	} // End Method getData
//  =======================	
	
//  =================	
//  Method encryption
//  ==========================	
	private int[] encryption(int[] w0, int[] w1, int[] w2, int[] w3, int[] k0, int[] k1, int[] k2, int[] k3, int[] key, int[][] subKeys, int round){
		
		fFunction f = new fFunction();
		shift s = new shift();
		int[] r0 = new int[2];
		int[] r1 = new int[2]; 
		int[] r2 = new int[2]; 
		int[] r3 = new int[2];
		int[] enc = new int[8];
		int[] fVal = new int[4];

		if(round == 0){ // If round == 0
            for(int i = 0; i < 2; i++){ // For split blocks
            	r0[i] = w0[i] ^ key[i];
				r1[i] = w1[i] ^ key[i+2];
				r2[i] = w2[i] ^ key[i+3];
				r3[i] = w3[i] ^ key[i+4];
		   } // End for split blocks
		} // If round == 0
		else{ // Else round > 0
			for(int i = 0; i < 2; i++){ // For split blocks
				r0[i] = w0[i];
				r1[i] = w1[i];
				r2[i] = w2[i];
				r3[i] = w3[i];
			} // End for split blocks
		} // Else round > 0

        fVal = f.getTVal(r0, r1, subKeys[round]);
        
        r2[0] = r2[0]^fVal[0];
        r2[1] = r2[1]^fVal[1];       
        r2 = s.rightShift(r2);

        r3 = s.leftShift(r3);
        r3[0] = r3[0]^fVal[2];
        r3[1] = r3[1]^fVal[3];

		if(round < 15){ // If more rounds to run
			round++;
            enc = encryption(r2, r3, r0, r1, k0, k1, k2, k3, key, subKeys,round);
        } // End if more rounds to run
		else{ // Else done
			
        	enc[0] = r0[0] ^ k0[0];
        	enc[1] = r0[1] ^ k0[1];
        	enc[2] = r1[0] ^ k1[0];
        	enc[3] = r1[1] ^ k1[1];
        	enc[4] = r2[0] ^ k2[0];
        	enc[5] = r2[1] ^ k2[1];
        	enc[6] = r3[0] ^ k3[0];
        	enc[7] = r3[1] ^ k3[1];  
        	
		} // End else done	
        return enc;
	} // End method encryption
//  ==========================	
} // End class encrypt
// ===================