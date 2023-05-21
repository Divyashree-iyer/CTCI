
class Common
{
	public static int getValue(char c)
	{
		return (int) c;
	}
	public static int getRelativeValue(char c)
	{
		return (int) c - ((int) 'a');
	}
}
class MergeSort {

	void
	merge(char[] chArr, int l, int m, int r)
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

public class IsUnique
{
	
	public static boolean BruteForce(String str)
	{
		//final time complexity O(N^2)
		//final space complexity O(1)
		for(int i=0; i<str.length()-1;i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(Common.getValue(str.charAt(i))==Common.getValue(str.charAt(j)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean AfterMergeSort(String str)
	{
		//Final time complexity = O(NlogN)
		//final space complexity = O(N)
		//This method = O(N)
		str = MergeSort.sortStart(str);
		for(int i=0; i<str.length()-1;i++)
		{
			if(Common.getValue(str.charAt(i))==Common.getValue(str.charAt(i+1)))
				return false;
		}
		return true;
	}

	public static boolean HashMap(String str)
	{
		//Final time complexity = O(N)
		// Final space complexity = O(1) because we assume only alphabets are in test cases hence an array for 26 alphabets is used
		//Optimization = remove second for loop and check similar condition in first loop
		
		int length = str.length();
		int[] intArr = new int[length];		
		for(int i=0; i<length;i++)
		{
			intArr[Common.getRelativeValue(str.charAt(i))] += 1;
		}
		for(int i=0; i<length;i++)
		{
			if(intArr[i] > 1)
				return false;
		}
		return true;
	}
	
	public static boolean BitVector(String str)
	{
		//Final time complexity = O(n)
		// Final space complexity = O(1)
		
		int checker = 0;	
		for(int i=0; i<str.length();i++)
		{
			int val = 1 << Common.getRelativeValue(str.charAt(i));
			if((checker & val) >0)
				return false;
			checker = checker | val;
		}

		return true;
	}
	
	public static void main(String[] args)
	{
		
		String[] testStrings = {"abcd","abca","aaa","", "aabc"};
		for(String str:testStrings)
		{
			System.out.println(str + " : " + BruteForce(str) + " : " + AfterMergeSort(str) + " : " + HashMap(str) + " : " + BitVector(str));
		}
	}
}
