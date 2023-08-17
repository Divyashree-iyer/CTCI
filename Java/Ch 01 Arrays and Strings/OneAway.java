
public class OneAway
{
	
	static boolean replaceAndInsertCheck(String[] strs)
	{
		if(strs[0].length() - strs[1].length() >1)
			return false;
		String s1 = strs[0].length()>=strs[1].length()?strs[1]:strs[0];
		String s2 = strs[0].length()<strs[1].length()?strs[1]:strs[0];
		
		int index1=0, index2=0;
		boolean flag = false;
		
		while(index1<s1.length() && index2<s2.length())
		{
			if(s1.charAt(index1)!=s2.charAt(index2))
			{
				if(flag)
					return false;
				flag = true;
				if(s1.length()==s2.length())
					index1++;
			}
			else
			{
				index1++;
			}
			index2++;
		}
		return true;
	}
	
	static boolean replacementCheck(String[] strs)
	{
		int flag = 0;
		for(int i = 0; i<strs[0].length(); i++)
			if((strs[0].charAt(i)- strs[1].charAt(i))!=0)
				flag++;
			if(flag>1)
				return false;		
		return true;
	}

	static boolean insertCheck(String one, String two)
	{
		int index1 = 0, index2 = 0;
		while(index2<two.length() && index1<one.length())
		{
			if(one.charAt(index1)!=two.charAt(index2))
			{
				if(index1!=index2)
					return false;
				index2++;
			}
			else
			{
				index1++;
				index2++;
			}
		}
		return true;
	}

	static boolean allTestPassed(String[] strs)
	{
		if(strs[0].length()==strs[1].length())
			return replacementCheck(strs);
		else if(strs[0].length()+1==strs[1].length())
			return insertCheck(strs[0],strs[1]);
		else if (strs[0].length()==strs[1].length()+1)
			return insertCheck(strs[1],strs[0]);
		return false;
	}

	public static void main(String[] args)
	{		
		String[][] testStrings = {{"pal","pl"},{"pal","pele"},{"pale","bale"},{"pale","pale"}, {"pale","pal"},{"pal","pale"},{"pale","bade"},{"pales","pasle"}, {"pale",""},{"orange","pale"}};
		for(String[] strs:testStrings)
		{
			System.out.println(strs[0] + ", " + strs[1] + " : " + allTestPassed(strs) + " : " + replaceAndInsertCheck(strs));
		}
	}
}