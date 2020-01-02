import java.util.Arrays;

public class binaryrange 
{

	public static void main(String[] args)
	{
		int[] ray = new int[7];
		for(int spot = 0; spot<ray.length-1; spot++)
		{
			double y = Math.random();
			if(y<0.5)
			{
			y =Math.floor(y);
			}
			else
			{
			y= Math.ceil(y);
			}
			ray[spot] = (int)y;
		}
		String output = "";
		for(int spot = 0; spot<ray.length-1; spot++)
		{
			output = output + ray[spot];
		}
		System.out.println(output);
		System.out.println();

	for (int x=0; x<100; x++)
	{
		String temp = Integer.toBinaryString(x);
		System.out.println(temp);
		int num = Integer.parseInt(temp, 2);
		System.out.println(num);
	}
	}
}
// ascii values of importance 32 - 63 (six char), 64 - 99 (seven char)
// add a zero place holder for 32 - 63
