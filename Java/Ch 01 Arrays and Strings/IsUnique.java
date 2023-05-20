
public class IsUnique
{
	public static int getValue(char c)
	{
		return (int) c;
	}
	
	public static boolean BruteForce(String str)
	{
		for(int i=0; i<str.length()-1;i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(getValue(str.charAt(i))==getValue(str.charAt(j)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String[] testStrings = {"abcd","abca","aaa","", "aabc"};
		for(String str:testStrings)
		{
			System.out.println(str + " : " + BruteForce(str));
		}
	}
}
