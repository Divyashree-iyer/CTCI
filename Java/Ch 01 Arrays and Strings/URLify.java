
public class URLify
{
	static char[] convertToCharArr(String str)
	{
		char[] chArr = new char[str.length()];
		for(int i=0;i<str.length();i++)
			chArr[i]=str.charAt(i);
		return chArr;
	}
	
	static String func(String[] data)
	{		
		String str;
		if(data.length==2)
			str = data[0];
		else
			return "ERROR";
		char[] chArr = convertToCharArr(str);
		int prev=str.length()-1;
		int curr=str.length()-1;
		boolean flag = false;
		while(curr>=0)
		{
			if(str.charAt(curr)==' ')
			{
				if(flag)
				{
					chArr[prev]='0';
					chArr[--prev]='2';
					chArr[--prev]='%';
					prev--;
				}
			}
			else
			{
				chArr[prev]=chArr[curr];
				prev--;
				flag=true;
			}
			curr--;
		}
		return new String(chArr);
	}
	
	public static void main(String[] args)
	{
		String[][] testCases = {{"ab cd e    ","6"},{" abc d    ","4"},{"   ","0"},{"","0"},{"a   b      ","2"}};
		for(String[] data:testCases)
		{
			System.out.println(data[0] + " : " + func(data));
		}
	}
}