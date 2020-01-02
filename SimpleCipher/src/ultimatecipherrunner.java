
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*Let the key equal the following
 * 11101101011001110010011011100010001000100000100011001101010110001111011010110110011111101110101011010101110001000110011110100101000111100111011100101111100001111010001101110001000000011100001101011101000110100101101101100000000100111111001100001111101110111011101011101000011001001011011000011111110011000000100011110101110111100110100001101001110100110011011110001001010001100111010011000000100001001001011010100101101010001000100000001010001010111000111101000110001110001010010101000010110100100111101010010001111001011111011111110111010011110101000110111011110010111011011110011000110011000000111100101111001010110010010000011110111000100111010111010100001100000
 * 141968907016211244000967215548705250210448314290038727097682674905536193867226691373120950966717741579028492759977101730499730064303743189253763765761068534767382461467336919636662337355566177172826208
 * 1dace4dc444119ab1ed6cfdd5ab88cf4a3cee5f0f46e20386ba34b6c027e61f7775d0c96c3f9811ebbcd0d3a66f128ce981092d4b511014571e8c714a85a4f523cbefee9ea377976f31981e5e56483dc4eba860
 * This:
 * 1dace4dc,)19ab1ed6cfdd5ab88cf4a3cee5f0f46e20&6ba34b6c027e=f7M5d0c`c3f9Q1ebbcd0d3aBf128ce9810\d4b51101-Ge8c714a85a4f523cbefee9ea%OLf319Qe5e5@Sdc4ebaV0
 */
public class ultimatecipherrunner 
{
	public static void main(String args[])
	{
		String answer = "yes";
		JFrame frame = new JFrame("Input Dialog");
		ultimatecipher messenger = new ultimatecipher();
		JOptionPane.showMessageDialog(frame,"Welcome to the Symmetric Key Cipher Program!");
		do {
			String choice = JOptionPane.showInputDialog(frame, "encrypt or decrypt (e or d)");
			if (choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("encrypt"))  
			{
				// message to binary
				String message = JOptionPane.showInputDialog(frame, "Enter your message");
				String simplifymessage = message.toUpperCase();
			//System.out.println(simplifymessage+ "//simplifymessage//");
				String asciimessage = messenger.convertchartoascci(simplifymessage);
			//System.out.println(asciimessage +"//asciimessage//");
				String binaryblockmessage = messenger.convertasciitobinary(asciimessage);
				// original binary message always starts with 1
				
				
				String thesetkey = "11101101011001110010011011100010001000100000100011001101010110001111011010110110011111101110101011010101110001000110011110100101000111100111011100101111100001111010001101110001000000011100001101011101000110100101101101100000000100111111001100001111101110111011101011101000011001001011011000011111110011000000100011110101110111100110100001101001110100110011011110001001010001100111010011000000100001001001011010100101101010001000100000001010001010111000111101000110001110001010010101000010110100100111101010010001111001011111011111110111010011110101000110111011110010111011011110011000110011000000111100101111001010110010010000011110111000100111010111010100001100000";
			// THE LINE ABOVE SETS THE KEY FOR ALL ENCRYPTIONS
			
			//System.out.println(thesetkey + "//thesetkey//");	
				int lengthofthesetkey = thesetkey.length(); // this is 665
			//System.out.println(lengthofthesetkey + "//lengthofthesetkey//");
				int lengthofbinaryblockmessage = binaryblockmessage.length();	
			//System.out.println(lengthofbinaryblockmessage + "//lengthofbinaryblockmessage//");
				int lengthinquestion = lengthofthesetkey - lengthofbinaryblockmessage;	
			//System.out.println(lengthinquestion + "//lengthinquestion//");
				String nonsense = messenger.generatesomezeroes(lengthinquestion);
				binaryblockmessage = nonsense + binaryblockmessage;
			//System.out.println(binaryblockmessage + "//binaryblockmessage//");
			//System.out.println(thesetkey + "//thesetkey//");	
				String encryptedbinarymessage = messenger.cipherit(binaryblockmessage,thesetkey);		
			//System.out.println(encryptedbinarymessage+"//encryptedbinarymessage//");
				String oneencryptedbinarymessage = "1"+encryptedbinarymessage;		// CANT HAVE THE FIRST NUM BE 0 WHEN CONVERTING
			//System.out.println(oneencryptedbinarymessage+"//oneencryptedbinarymessage//");
				String encryptedasciimessage = messenger.convertbinarytoascii(oneencryptedbinarymessage);
			//System.out.println(encryptedasciimessage+"//encryptedasciimessage//");
				
				
		// HEXADECIMALS!
				String encryptedhexmessage = messenger.convertasciitohexadecimal(encryptedasciimessage);
				
				
				String encrypedwithsomechar = messenger.converttosomechar(encryptedhexmessage);
			//System.out.println(encrypedwithsomechar + "//encrypedwithsomechar//");
				JOptionPane.showMessageDialog(frame, encrypedwithsomechar);
				System.out.println(encrypedwithsomechar);
				
			}
			if (choice.equalsIgnoreCase("d") || choice.equalsIgnoreCase("decrypt"))  
			{
				String message = JOptionPane.showInputDialog(frame, "Enter your coded message");	// encryptedmessage
				String key = JOptionPane.showInputDialog(frame, "Enter the key");		// thesetkey
				// ASCII key to binary
			//System.out.println(key+"//key//");
				String keyinhex = messenger.convertbackfromsomechar(key);
			//System.out.println(keyinhex+"//keyinhex//");
				
				
				String thekeyinascii = messenger.converthexadecimaltoascii(keyinhex);
				
				
			//System.out.println(thekeyinascii+"//thekeyinascii//");
				String thekeyinbinaryblock = messenger.convertasciitobinary(thekeyinascii);
			//System.out.println(thekeyinbinaryblock+"//thekeyinbinaryblock//");
				
				// encrypted message to binary block
			//System.out.println(message + "//message//");
				
				String hexmessage = messenger.convertbackfromsomechar(message);
			//System.out.println(hexmessage + "//hexmessage//");	
				
				
				
				String asciimessage = messenger.converthexadecimaltoascii(hexmessage);
				
			//System.out.println(asciimessage + "//asciimessage//");
				String tempmessage = messenger.convertasciitobinary(asciimessage);
			//System.out.println(tempmessage + "//tempmessage//");
				String thebinaryblockmessage = tempmessage.substring(1);	// GET RID OF THE ADDED 1 IN THE FRONT
			//System.out.println(thebinaryblockmessage + "//thebinaryblockmessage//");
				
				// decrypting message
			//System.out.println(thekeyinbinaryblock + "//thekeyinbinaryblock//");
				String decryptedbinarymessage = messenger.cipherit(thebinaryblockmessage,thekeyinbinaryblock); // ORIGINAL MESSAGE
			//System.out.println(decryptedbinarymessage + "//decryptedbinarymessage//");			

				String decryptedasciimessage = messenger.convertbinarytoascii(decryptedbinarymessage);	
			//System.out.println(decryptedasciimessage + "//decryptedasciimessage//");
				String decrypedcharmessage = messenger.convertasciitochar(decryptedasciimessage);
			//System.out.println(decrypedcharmessage + "//decrypedcharmessage//");
				String simplifymessage = decrypedcharmessage.toLowerCase();
			//System.out.println(simplifymessage + "//simplifymessage//");
				JOptionPane.showMessageDialog(frame, simplifymessage);
			}
			answer = JOptionPane.showInputDialog(frame, "Continue? (y or n)");
		}while (!(answer.equalsIgnoreCase("n")||answer.equalsIgnoreCase("no")));
	}
}