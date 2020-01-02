import java.math.BigInteger; 
import java.util.Scanner; 
public class bignumstuff 
{
	BigInteger b;
	static String a;
	public static void main(String args[])
	{
		BigInteger num = new BigInteger("73327673756932807369");
		BigInteger somenum = new BigInteger("123456789123456789");
		System.out.println(somenum);
		System.out.println(num);
		BigInteger thing = num.add(somenum); 
		System.out.println(thing);
		BigInteger otherthing = num.subtract(somenum); 
		System.out.println(otherthing);
		BigInteger multthing = num.multiply(somenum);
		System.out.println(multthing);
		BigInteger divthing = multthing.divide(num);
		System.out.println(divthing);
		//String temp = Integer.toBinaryString(num);
		// does not work
		System.out.println("////");
		System.out.println(num);
		// converting big integers to binary!
		String temp = num.toString(2);
		System.out.println(temp);
		// converting binary to big integer!
		BigInteger othertemp = new BigInteger(temp, 2);
		System.out.println(othertemp);
		BigInteger i = new BigInteger("11101", 2);
		System.out.println(i);
		
		System.out.println("//////\\\\\\");
		BigInteger somenum1 = new BigInteger("13718331513323170659");
		String moo = somenum1.toString(2);
		System.out.println(moo);
		BigInteger meo = new BigInteger(moo, 2);
		System.out.println(meo);
		System.out.println("//////\\\\\\ ");
		System.out.println("13718331513323170659");
		System.out.println("//////\\\\\\");
		System.out.println("//////\\\\\\");
		BigInteger somedec = new BigInteger("99939291513323170659");
		System.out.println(somedec); 
		String hex = somedec.toString(16);
		System.out.println(hex); 
		BigInteger convertback =new BigInteger(hex,16);
		System.out.println(convertback);
	}
}
