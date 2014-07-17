
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cryptMain {


	/**
	 * @param args
	 * @throws IOException 
	 */
//  ==========
//  Method main
//  ===========================================================	
	public static void main(String[] args) throws IOException {
		
		int i = 0;                  // Variable to increment
		int keyByte;                // Variable to hold key byte
		int flag = 0;               // Flag used to determine if padding is needed
		int[] array = new int[8];   // Array to hold plaintext
		int[] key = new int[8];     // Array to hold key data
		FileInputStream in = null;  // File input stream for plaintext
		FileInputStream k = null;   // File input stream for key
		encrypt en = new encrypt(); // Create new instance of encrypt
		decryption de = new decryption(); // Create new instance of encrypt
		
		k = new FileInputStream("key.txt");       // Open key.txt
		
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter '0' for encryption and '1' for decryption:");
		int an;
		an =reader.nextInt();
		
		while ((keyByte = k.read()) != -1 && i < 8) { // While key data to read
			
			String temp = new String(new byte[]{ (byte)keyByte }, "US-ASCII"); // Convert byte to ascii
			keyByte = k.read(); // Read in second byte
			String temp1 = new String(new byte[]{ (byte)keyByte }, "US-ASCII"); // Convert byte to ascii
			temp = temp + temp1; // Create 8 bit hex value
			key[i] = Integer.parseInt(temp, 16); // Covert 8 bit hex value to byte
			
            i++;
            
        } // End while key data to read
		k.close();  // Close key.txt
        i = 0;
        
        
      if(an == 0){ // Encrypt data
    	   int txt;                    // Variable to hold plaintext byte
    	   keySchedule kS = new keySchedule();
   		   int[][] subKeys = kS.makeKeys(key, 0);
   		   		   
    	   in = new FileInputStream("plaintext.txt");// Open plaintext.txt
           File file = new File("ciphertext.txt");
        
		   if (!file.exists()) { // Create file if it doesn't exist
			   file.createNewFile();
		   } // End create file if it doesn't exist

		   FileWriter fw = new FileWriter(file.getAbsoluteFile());
		   BufferedWriter bw = new BufferedWriter(fw);

           while ((txt = in.read()) != -1) { // While bytes to read
          
        	   if(i < 9){ // If block read to encrypt
        		   i = 0;
        		   flag = 0;
        	 	   int[] enc = new int[8];
                   enc = en.getData(array, key, subKeys); // Send data to encryption
                   String hex = Integer.toHexString(enc[0]);
                   
        		   for(int j = 1; j < 8; j++){ // Create hex string
        			   hex = hex + " " + Integer.toHexString(enc[j]);
        		   } // End create hex string
        		
        		   bw.write(hex);
        		   bw.write(" ");
        	   } // End if block ready to encrypt
        	
        	   array[i] = txt;
        	   flag = 1;
        	   i++;
            } // End while bytes to read
        
            if(flag == 1){ // If padding need for last block
        	
        	    for(int j = 8-i; j < 8; j++){ // Begin add padding
        		    array[i] = 0;
        	    } // End add padding
        	
        	    int[] enc = new int[8];
                enc = en.getData(array, key, subKeys); // Send data to encryption

                String hex = Integer.toHexString(enc[0]); // Create hex string
    		    for(int j = 1; j < 8; j++){ // Create hex string
    			    hex = hex + " " + Integer.toHexString(enc[j]);
    		    } // End create hex string
    		
    		    bw.write(hex);
    		    bw.write(" ");
        	
            } // End if padding needed for last block
            System.out.println("Done Encypting");
           bw.close();
           in.close(); // Close plaintext.txt
       } // End if encryption
        
       else{
    	   int txt;
    	   keySchedule sK = new keySchedule();
   		   int[][] subKeys = sK.makeKeys(key, 1);
   	  
    	   in = new FileInputStream("ciphertext.txt");// Open plaintext.txt
    	   File file = new File("unEncryption.txt");

   		   if (!file.exists()) { // If file doesn't exist create it
   			   file.createNewFile();
   		   } // End if file doesn't exist

   		   FileWriter fw = new FileWriter(file.getAbsoluteFile());
   		   BufferedWriter bw = new BufferedWriter(fw);
          
   	 	   int[] array2 = new int[8];   // Array to hold plaintext
           String temp = "";
           i = 0;
           while ((txt = in.read()) != -1) { // While bytes to read
        	  
           	   if(i<8){ // If block not ready to deciphering
           		   if(temp.length() == 2){ // If hex ready for byte conversion
            
            	       array2[i] = Integer.parseInt(temp, 16);
            	      
            	       temp = "";
           	           i++;
           	           
           	           if (i == 8){// If block ready for deciphering
                		   i = 0;
                		   int[] enc = new int[8];
                           enc = de.getData(array2, key, subKeys); // Send data to encryption
                           
                		   for(int j = 0; j < 8; j++){
                			   
                			   bw.write(enc[j]);
                		   } // End if block ready for deciphering
           	           }  // End if block ready for deciphering
           	      }// End if hex ready for byte conversion
           		
           	      if(txt != ' ' && temp.length()==0  ){
           		      temp = Character.toString((char)txt);
           	      }
           	      else if(temp.length() == 1 && txt != ' '){
           	    	   temp = temp + Character.toString((char)txt);
           	      }
           	      else if(temp.length() == 1 && txt == ' '){
           		     temp = "0" + temp;
           	      }
           	   } // End if block not ready to deciphering
           
           	
             } // End while data to read
           	  System.out.println("Done decyphering");
              bw.close();
              in.close(); // Close plaintext.txt 
           } // End while bytes to read */

	} // End Method main
//  ====================	

} // End Class cryptMain