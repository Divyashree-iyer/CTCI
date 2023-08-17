
class Common
{
	public static int getValue(char c)
	{
		return (int) c;
	}
}

class MergeSort {

	void merge(char[] chArr, int l, int m, int r)
    {
        // Find sizes of two substrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp strays */
        char[] L = new char[n1];
        char[] R = new char[n2];

        /*Copy data to temp strays*/
        for (int i = 0; i < n1; ++i)
            L[i] = chArr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = chArr[m + 1 + j];
 
        /* Merge the temp strays */
 
        // Initial indexes of first and second substrays
        int i = 0, j = 0;
 
        // Initial index of merged substray stray
        int k = l;
        while (i < n1 && j < n2) {
            if (Common.getValue(L[i]) <= Common.getValue(R[j])) {
                chArr[k] = L[i];
                i++;
            }
            else {
				chArr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
			chArr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
			chArr[k] = R[j];
            j++;
            k++;
        }

    }
	void sort(char[] chArr, int left, int right)
	{
		//Merge sort = O(NlogN)
		if(left>=right)
			return;
		int mid = (left+right)/2;
		sort(chArr,left,mid);
		sort(chArr,mid+1, right);
		merge(chArr,left,mid,right);
	}
	
	public static String sortStart(String str)
	{
		//Final Merge sort = O(NlogN)
		//final space complexity = O(N)
		int length = str.length();
		if(length==0)
			return str;
		char[] chArr = new char[str.length()];
		//This loop = O(N)
		for (int i = 0; i < str.length(); i++) {
            chArr[i] = str.charAt(i);
        }
		//Merge sort = O(NlogN)
		MergeSort ob = new MergeSort();
        ob.sort(chArr, 0, length - 1);
		//This assignment = O(N)
		str = new String(chArr);  
		return str;
	}
}

public class PalindromePermutation
{
	public static int getAbsValue(char c)
	{
		if( (int) c < 97 )
			return ((int) c + 32);
		return (int) c;
	}
		
	public static int getRelativeValue(char c)
	{
		if( (int) c < 97 )
			c = (char) ((int) c + 32);
		return (int) c - ((int) 'a');
	}
	
	public static boolean AfterMergeSort(String str)
	{
		//Final time complexity = O(NlogN)
		//final space complexity = O(N)
		//This method = O(N)
		if(str.length()<2)
			return true;
		str = MergeSort.sortStart(str);

		int count=0;
		int oddCount = 0;
		int prev = 0;
		for(int i=0; i<str.length()-1;i++)
		{
			if(getAbsValue(str.charAt(i))!=getAbsValue(str.charAt(i+1)))
			{
				count = i-prev;
				prev=i;
				if(count%2!=0)
				{
					oddCount++;
					if(oddCount>1)
						return false;
				}
				count=0;
			}
		}
		if(getAbsValue(str.charAt(str.length()-1))!=getAbsValue(str.charAt(str.length()-2)))
			{
				count = str.length()-1-prev;
				prev=str.length()-1;
				if(count%2!=0)
				{
					oddCount++;
					if(oddCount>1)
						return false;
				}
				count=0;
			}
		return true;
	}

	public static boolean HashMap(String str)
	{
		//Final time complexity = O(N)
		// Final space complexity = O(1) 
		
		int length = str.length();
		int[] intArr = new int[27];		

		for(int i=0; i<length;i++)
		{
			if(str.charAt(i)!=' ')
				intArr[getRelativeValue(str.charAt(i))] += 1;
		}
		
		int odd = 0;
		for(int i=0; i<27;i++)
		{		
			if(intArr[i]%2!=0)
			{
				odd++;
				if(odd>1)
					return false;
			}
		}
		return true;
	}
	

	
	public static void main(String[] args)
	{
		
		String[] testStrings = {"abcd","abca","aaa","", "aabc", "hell oo", "abcab","he ohe","Aa", "abb","abbb","abbc", "tact coa"};
		for(String str:testStrings)
		{
			System.out.println(str + " : " + HashMap(str));
		}
	}
}