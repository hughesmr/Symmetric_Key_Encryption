
public class keySchedule {

//  ===============
//  Method makeKeys	
//	===========================================
	public int[][] makeKeys( int[] kP, int op){
		
		int[] k = new int[8];
		int[][] rVal = new int[16][12];
		shift s = new shift();
	    int round = 0;
		
		if(op == 0){ // If encrypting
			k = s.rotateLeft(kP, 1);
		   
            while ( round < 16){ // While keys to create
            	
		        rVal[round][0] =  k[getKeys(4*round)];
		        k = s.rotateLeft(k,  1);
		        rVal[round][1] =  k[getKeys(4*round + 1)];
		        k = s.rotateLeft(k,  1);
		        rVal[round][2 ] =  k[getKeys(4*round + 2)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][3] =  k[getKeys(4*round + 3)];
		        k = s.rotateLeft(k,  1);
		        rVal[round][4] =  k[getKeys(4*round)];
		        k = s.rotateLeft(k,  1);
		        rVal[round][5] =  k[getKeys(4*round + 1)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][6] =  k[getKeys(4*round + 2)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][7] =  k[getKeys(4*round + 3)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][8] =  k[getKeys(4*round)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][9] =  k[getKeys(4*round + 1)]; 
		        k = s.rotateLeft(k, 1);
		        rVal[round][10] = k[getKeys(4*round + 2)];
		        k = s.rotateLeft(k, 1);
		        rVal[round][11] = k[getKeys(4*round + 3)];
		        k = s.rotateLeft(k,  1);
		        round++;
		     
            } // End while keys to create
          

		} // End if encrypting
		else{ // Else decryption
			
			  k = kP;
			 round = 1;
			 while (round < 17){ // WHile keys to create
				 
				 rVal[round-1][11] = k[getKeys(4*round + 3)];
				 k = s.rotateLeft(k,  63);
				 rVal[round-1][10] = k[getKeys(4*round + 2)];
				 k = s.rotateLeft(k,  63);
				 rVal[round-1][9] =  k[getKeys(4*round + 1)]; 
				 k = s.rotateLeft(k, 63); 
				 rVal[round-1][8] =  k[getKeys(4*round)];
				 k = s.rotateLeft(k, 63);	 
				 rVal[round-1][7] =  k[getKeys(4*round + 3)];
				 k = s.rotateLeft(k,  63); 
				 rVal[round-1][6] =  k[getKeys(4*round + 2)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][5] =  k[getKeys(4*round + 1)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][4] =  k[getKeys(4*round)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][3] =  k[getKeys(4*round + 3)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][2] =  k[getKeys(4*round + 2)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][1] =  k[getKeys(4*round + 1)];
				 k = s.rotateLeft(k, 63);
				 rVal[round-1][0] =  k[getKeys(4*round)];
				 k = s.rotateLeft(k, 63);
				 round++;
				
		        } // End while keys to create
		} // End if decrypting
		return rVal;
	} // End method makeKeys
//  ========================	
	
//  ==============
//	Method getKeys
//	===============================
	private int getKeys(int round){
		
		int x = round % 8; // Determine key
			return x;
		
		
	} // End method getKeys
//  =======================	
		
}
