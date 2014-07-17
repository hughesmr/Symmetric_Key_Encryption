Michael Hughes
michael.r.hughes@email.wsu.edu

64 bit implementation 

I am submitting my version of wsu crypt. I read a txt file called plaintext.txt and key.txt and outputs a encrypted file called cyphertext.txt. It will also decrypt the cyphertext.txt file by reading it in and the key.txt file. A few methods had been used that I found online but have been clearly documented.


To build the program open Eclipse ide and selected file at the top. Next select import, general, and then use the browser to find my project folder. Import the file and it is ready to run by pressing the green play button at the top. You will be asked to select encryption or decryption by entering 0 or 1. The program will output a file called cyphertext.txt if encrypting and a file called unEncryption.txt if decrypting. I decided to output the decrypted text in a separate file for easy comparison with the original.

Files included:

wsuCrypt

key.txt - My test key
plaintext.txt - This is test plaintext. 
README.txt - Explanation of program

bin

cryptMain.class - Byte code for cyrptMain
decryption.class - Byte code for decryption function
encryption.class - Byte code for Encryption function
fFunction.class - Byte code for fFunction
gFunction.class - Byte code for gFunction
fTable.class - Byte code for fTable
keySchedule.class - Byte code for key schedule
shift.class - Byte code for shift

src
cryptMain.class - Byte code for cryptMain
cryptMain.java - Source code for the main class
decryption.java - Source code for decryption
encryption.java - Source code for encryption
fFunction.java - Srouce code for fFunction
gFunction.java -Source code for gFunction
fTable.java - Source code for fTable
keySchedule.java - Source code for keySchedule class
shift.java - Source code for shift class
