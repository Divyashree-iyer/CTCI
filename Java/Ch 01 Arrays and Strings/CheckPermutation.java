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

public class CheckPermutation
{
	
	public static boolean isValid(String[] words)
	{
		if(words.length==2)
		{
			if(words[0].length() == words[1].length())
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean AfterSort(String[] words)
	{
		//final time complexity = O(NlogN)
		//final space complexity = O(N) since we are converting string to char arr
		if(isValid(words))
		{
			//equality check = O(N)
			if((MergeSort.sortStart(words[0])).equals(MergeSort.sortStart(words[1])))
				return true;
		}
		return false;
	}
	
	public static boolean HashTable(String[] words)
	{
		//final time complexity = O(N)
		//final space complexity = O(1) since we are using an array of 256 length 
		if(isValid(words))
		{
			int maxLength = 256;
			int[] arr = new int[maxLength];
			for(int i=0;i<words[0].length();i++)
			{
				arr[words[0].charAt(i)]++;
				arr[words[1].charAt(i)]--;
			}
			for(int i=0;i<maxLength;i++)
			{
				if(arr[i]!=0)
					return false;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		String[][] testCases = { { "","valid"}, {" ","o"},{"HELLO","LLOHE"},{"name","emna"},{"Hello","hello"}, {"Hello","Hell o"},{"one","two"},{"one","ono"},{},{"one"} };
		for(String[] words: testCases)
		{
			System.out.println(AfterSort(words) + " , " + HashTable(words));
		}
	}
}