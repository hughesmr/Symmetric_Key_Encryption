
public class shift {
	
	/* leftShift and rightShift take two bytes, combine them into a 16bit char and then they do a bit 
	 * rotation either left or right. Finally splitting the 16 bit char back to 2 separate bytes.  
	 */
	
	
//  ================
//  Method leftShift
//	====================================
	public int[] leftShift(int shift[]){
		
		int[] ret = new int[2];
		int len;

		String binary = (Integer.toBinaryString(shift[0] & 0xFF));
		String temp = (Integer.toBinaryString(shift[1] & 0xFF));
		
        if((len = temp.length()) < 8){
			len = 8 - len;	
			for(int jj = len; jj > 0;jj--){
				temp = "0" + temp;
			}
		}
        if((len = binary.length()) < 8){
	        len = 8 - len;
	        for(int jj = len; jj > 0;jj--){
		        binary = "0" + binary;
	       }
        }
        
        len = Integer.parseInt((binary+temp), 2);

        len =  (char) ((len >>> 15) | (len << (16 - 15))); 
        
        ret[0] = (int)((len >> 8) & 0xff);
        ret[1] = (int)(len & 0xff);
		
		return ret;
		
	} // End method leftShift
//  =========================	
	
	
	public int[] rightShift(int[] shift){
		
		int[] ret = new int[2]; // Variable to hold return value
		int len;                // Variable to hold length

		String binary = (Integer.toBinaryString(shift[0] & 0xFF)); // String to hold first byte
		String temp = (Integer.toBinaryString(shift[1] & 0xFF)); // String to hold second byte
		
		/*add leading 0's to bytes*/
		
        if((len = temp.length()) < 8){ // If length less than 8
			len = 8 - len;
			for(int jj = len; jj > 0;jj--){ // Add 0 to string
				temp = "0" + temp;
			} // End add 0 to string		
			
			
		} // End if length less than 8 
        if((len = binary.length()) < 8){ // If less than 8
	        len = 8 - len;	
	        for(int jj = len; jj > 0;jj--){ // Add 0
		        binary = "0" + binary;
	        } // End add 0
        } // End if less than 8
        
            
        len = Integer.parseInt((binary+temp), 2);

        len =  (char) ((len >>> 1) | (len << (16 - 1))); 
        
        ret[0] = (int)((len >> 8) & 0xff);
        ret[1] = (int)(len & 0xff);
    
		return ret;
	
	} // End method rightShift
//  ==========================
	
/* 
 * The method below is kind of weird, it is for the 64 bit key's rotation. There are several
 * ways to do this. The way I am doing it is just string manipulation. I would much rather do 
 * a bit rotation using shifts such as above but java's lack of an unsigned 64 bit (pre java 8) type caused
 * some issues.
 */
	
//  =================	
//  Method rotateLeft	
//  ================================================
	public int[] rotateLeft(int[] bytes, int shift){
		
		int[] ret = new int[8];
		char a;
		
		String binary = ( padding((Integer.toBinaryString(bytes[0] & 0xFF))) + padding((Integer.toBinaryString(bytes[1] & 0xFF))) 
				+ padding((Integer.toBinaryString(bytes[2] & 0xFF))) + padding((Integer.toBinaryString(bytes[3] & 0xFF)))
				+ padding((Integer.toBinaryString(bytes[4] & 0xFF)))  + padding((Integer.toBinaryString(bytes[5] & 0xFF))) 
				+ padding((Integer.toBinaryString(bytes[6] & 0xFF)))  + padding((Integer.toBinaryString(bytes[7] & 0xFF))));
		
		
		if(shift == 1){
			a = binary.charAt(0);
			binary = binary.substring(1);
			binary = binary + a;
			ret[0] = Integer.parseInt(binary.substring(0,8), 2);
			ret[1] = Integer.parseInt(binary.substring(8,16), 2);
			ret[2] = Integer.parseInt(binary.substring(16,24), 2);
			ret[3] = Integer.parseInt(binary.substring(24,32), 2);
			ret[4] = Integer.parseInt(binary.substring(32,40), 2);
			ret[5] = Integer.parseInt(binary.substring(40,48), 2);
			ret[6] = Integer.parseInt(binary.substring(48,56), 2);
			ret[7] = Integer.parseInt(binary.substring(56,64), 2);
			
		}
		else{
			a = binary.charAt(63);
			binary = binary.substring(0, 63);
			binary = a + binary;
		
			ret[0] = Integer.parseInt(binary.substring(0,8), 2);
			ret[1] = Integer.parseInt(binary.substring(8,16), 2);
			ret[2] = Integer.parseInt(binary.substring(16,24), 2);
			ret[3] = Integer.parseInt(binary.substring(24,32), 2);
			ret[4] = Integer.parseInt(binary.substring(32,40), 2);
			ret[5] = Integer.parseInt(binary.substring(40,48), 2);
			ret[6] = Integer.parseInt(binary.substring(48,56), 2);
			ret[7] = Integer.parseInt(binary.substring(56,64), 2);
			 
		}
		
		
		return ret;
	}// End rotateLeft
//  ==================	
	
//	============== 
//  Method padding
//  ======================================	
	private String padding(String binary){
		int len = 0;
		
		if((len = binary.length()) < 8){ // If less than 8
	        len = 8 - len;	
	        for(int jj = len; jj > 0;jj--){ // Add 0
		        binary = "0" + binary;
	        } // End add 0
        } // End if less than 8
		return binary;
	} // End method padding
//  =============================================
	
} // End class shift
