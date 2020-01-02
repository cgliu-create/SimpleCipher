import java.math.BigInteger;

public class keygeneration 
{
	public String generatekey(int length)
	{
		String key = "";
		for (int section = 0; section < length; section++)
		{
			int temp = (int)Math.round(Math.random());
			String tempstring = temp + "";
			if (section == 0)
			{
				tempstring = "1";		// has to start with 1
			}
			key = key + tempstring;
		}
		return key;
	}
	public String convertbinarytoascii(String inputfour) 
	{
		BigInteger temp = new BigInteger(inputfour, 2);
		String tempstring = temp + "";
		return tempstring;
	}
	public String convertasciitohexadecimal(String inputfive) 
	{
		BigInteger temp = new BigInteger(inputfive);
		String tempstring = temp.toString(16);
		return tempstring;
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
public static void main(String args[]) 
{ 
	keygeneration  chris = new keygeneration();
	String num = chris.generatekey(665);
	System.out.println(num);
	String somenum = chris.convertbinarytoascii(num);
	System.out.println(somenum);
	String someothernum = chris.convertasciitohexadecimal(somenum);
	System.out.println(someothernum);
	String someothernumb = chris.converttosomechar(someothernum);
	System.out.println(someothernumb);
}
}

