import java.math.BigInteger;


public class ultimatecipher {
	
	public ultimatecipher()
	{
		System.out.println("message");
	}
	public String convertchartoascci(String inputone) 
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
	public String convertasciitochar(String inputtwo) 
	{
		// UpperCase messages only! ASCII value limitations
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
			char ascii = (char)asciival;
			output = output + ascii;
		}
		return output;
	}
	public String convertasciitobinary(String inputthree) 
	{
		BigInteger temp = new BigInteger(inputthree);
		String tempstring = temp.toString(2);
		return tempstring;
	}
	public String convertbinarytoascii(String inputfour) 
	{
		BigInteger temp = new BigInteger(inputfour, 2);
		String tempstring = temp + "";
		return tempstring;
	}
	public String generatesomezeroes(int length)
	{
		String key = "";
		for (int section = 0; section < length; section++)
		{
			String tempstring = "0";
			key = key + tempstring;
		}
		return key;
	}
	public String convertasciitohexadecimal(String inputfive) 
	{
		BigInteger temp = new BigInteger(inputfive);
		String tempstring = temp.toString(16);
		return tempstring;
	}
	public String converthexadecimaltoascii(String inputsix) 
	{
		BigInteger temp = new BigInteger(inputsix, 16);
		String tempstring = temp + "";
		return tempstring;
	}

	public String cipherit(String inputmessage, String inputkey)
	{
		// XOR key and lock system
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
	public String converttosomechar(String inputfive) 
	{
		String output = "";
		String sectionofstring = "";
		for (int section = 0; section <= inputfive.length()-2; section = section + 2)
		{ 
			if (section < inputfive.length()-2)
			{
			sectionofstring = inputfive.substring(section, section+2);
			}
			if (section == inputfive.length()-2)
			{
			sectionofstring = inputfive.substring(section);
			}
			char x = sectionofstring.charAt(0);
			char y = sectionofstring.charAt(1);
			if (x == '3' || x == '4' || x == '5' || x == '6' || x == '7' || x == '8' || x == '9')
			{
				if (y == '0' || y == '1'|| y == '2' || y == '3' || y == '4' || y == '5' || y == '6' || y == '7' || y == '8' || y == '9')
				{
					int asciival = Integer.parseInt(sectionofstring);
					if(asciival > 32 && !(asciival>47&&asciival<58) && !(asciival>96))
					{
						char temp = (char)asciival;
						output = output + temp;
					}
					else
					{
					String temp = sectionofstring;
					output = output + temp;
					}
				}
				else
				{
				String temp = sectionofstring;
				output = output + temp;
				}
			}
			else
			{
			String temp = sectionofstring;
			output = output + temp;
			}
		}
		if (inputfive.length()%2 ==1)
		{
		output = output + inputfive.charAt(inputfive.length()-1);
		}
		return output;
	}
	public String convertbackfromsomechar(String inputsix) 
	{
		String output = "";
		for (int section = 0; section <= inputsix.length()-1; section++)
		{
			char x = inputsix.charAt(section);
			if (x == '0' || x == '1'|| x == '2' || x == '3' || x == '4' || x == '5' || x == '6' || x == '7' || x == '8' || x == '9'
			|| x == 'a' || x == 'b'|| x == 'c' || x == 'd' || x == 'e' || x == 'f' || x == 'g' || x == 'h' || x == 'i' || x == 'j'
			|| x == 'k' || x == 'l'|| x == 'm' || x == 'n' || x == 'o' || x == 'p' || x == 'q' || x == 'r' || x == 's' || x == 't'
			|| x == 'u' || x == 'v'|| x == 'w' || x == 'x' || x == 'y' || x == 'z')
			{
				output = output + x;
			}
			else
			{
				int temp = (int)x;
				output = output + temp;
			}
		}
		return output;
	}
}

