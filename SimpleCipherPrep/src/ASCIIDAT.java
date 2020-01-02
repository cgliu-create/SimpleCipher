// Chris liu
import javax.swing.*;

public class ASCIIDAT 
{
	public ASCIIDAT()
	{
		System.out.println("message");
	}
	public String converttonumbers(String inputone) 
	{
		String output = "";
		for (int section = 0; section < inputone.length(); section++)
		{
			int temp = (int)inputone.charAt(section);
			String tempstring = temp + "";
			output = output + tempstring;
		}
		return output;
	}
	public String converttocharacters(String inputtwo) 
	{
		// UpperCase messages only
		String output = "";
		String sectionofstring = "";
		for (int section = 0; section <= inputtwo.length()-2; section = section + 2)
		{ 
			if (section < inputtwo.length()-2)
			{
			sectionofstring = inputtwo.substring(section, section+2);
			}
			if (section == inputtwo.length()-2)
			{
			sectionofstring = inputtwo.substring(section);
			}
			int asciival = Integer.parseInt(sectionofstring);
			// Source for line above : https://alvinalexander.com/java/edu/qanda/pjqa00010.shtml
			char ascii = (char)asciival;
			output = output + ascii;
		}
		return output;
	}
	public static void main (String arg[])
	{
		String answer = "yes";
		JFrame frame = new JFrame("Input Dialog");
		ASCIIDAT messenger = new ASCIIDAT();
		JOptionPane.showMessageDialog(frame,"Welcome to the ASCIIDAT Program!");
		do {
			String choice = JOptionPane.showInputDialog(frame, "encrypt or decrypt (e or d)");
			if (choice.equals("e"))  
			{
				String message = JOptionPane.showInputDialog(frame, "Enter a message:");
				String response = messenger.converttonumbers(message.toUpperCase());
				JOptionPane.showMessageDialog(frame, response);
				System.out.println(response);
			}
			if (choice.equals("d"))  
			{
				String message = JOptionPane.showInputDialog(frame, "Enter a coded message");
				String response = messenger.converttocharacters(message);
				JOptionPane.showMessageDialog(frame, response.toLowerCase());
			}
			answer = JOptionPane.showInputDialog(frame, "Continue? (y or n)");
		}while (!(answer.equalsIgnoreCase("n")));
	}
}
// logical XOR operator block cipher key???

