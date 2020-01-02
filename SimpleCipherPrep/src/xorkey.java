// Chris liu
import java.util.Scanner;

import javax.swing.*;
public class xorkey 
{
	public xorkey()
	{
		System.out.println("stuff");
	}
	public String cipherthat(String inputmessage, String inputkey)
	{
		String endmessage = "";
		for (int section = 0; section < inputmessage.length(); section++)
		{
			char tempmessagechar = inputmessage.charAt(section);
			boolean tempmessageboolean = true;
			if (tempmessagechar == '0')
			{
				tempmessageboolean = false;
			}
			if (tempmessagechar == '1')
			{
				tempmessageboolean = true;
			}
			char tempkeychar = inputkey.charAt(section);
			boolean tempkeyboolean = true;
			if (tempkeychar == '0')
			{
				tempkeyboolean = false;
			}
			if (tempkeychar == '1')
			{
				tempkeyboolean = true;
			}
			char tempendchar = '0';
			if (tempmessageboolean ^ tempkeyboolean)
			{
				tempendchar = '1';
			}
			else
			{
				tempendchar = '0';
			}
			
			endmessage = endmessage + tempendchar;
		}
		return endmessage;
	}
	
	// cipher and decipher is the same, same key for locking and unlocking!
	
	public static void main(String[] args) 
	{
	    JFrame frame = new JFrame("Input Dialog");
		JOptionPane.showMessageDialog(frame,"Welcome to the xorkey Program!");
		// message and key are both seven character "blocks"
		String key = JOptionPane.showInputDialog(frame, "enter a key of seven characters, either 0 or 1");
	    String message = "1100111";
	    xorkey chris = new xorkey();
	    System.out.println("the message: "+message);
	    System.out.println("and the key: "+key);
	    System.out.println("ciphering...");
	    System.out.println(chris.cipherthat(message, key));	
	    JOptionPane.showMessageDialog(frame,"time to decipher!");
	    String input = JOptionPane.showInputDialog(frame, "enter encrpyted message");
	    System.out.println("deciphering...");
	    System.out.println(chris.cipherthat(input, key));	
	}
}


/* 
EXAMPLE:
the message: 1100111
and the key: 1011101
ciphering...
0111010
deciphering...
1100111

XOR = ^
boolean[] all = { false, true };
for (boolean a : all) 
{
	for (boolean b: all) 
	{
		boolean c = a ^ b;
		System.out.println(a + " ^ " + b + " = " + c);
	}
}	
*/
