import java.util.Random;
import java.util.Arrays;

class QuickSort
{
    public static void main(String[] args)
    {
	int arraySize = 100000;
	int[] toSort = new int[arraySize];
	int[] tempArray = new int[arraySize];
	Random rand = new Random();
	for(int j = 0; j < 20; j++)
	    {
		for(int i = 0; i < toSort.length; i++)
		    {
			toSort[i] = rand.nextInt(arraySize * 10);
			tempArray[i] = toSort[i];
		    }
		//print100(toSort,0);
		Long start = System.nanoTime();
		sort(toSort,0,arraySize - 1);
		Long end = System.nanoTime();
		System.out.println("Sorting took: " + (end - start));
		Arrays.sort(tempArray);
		for(int i = 0; i < arraySize; i++)
		    {
			if(tempArray[i] != toSort[i])
			    System.out.println("error");
		    }
		//print100(toSort,0);
		//System.out.println();
	    }
    }

    private static int[] sort(int[] toSort, int beg, int end)
    {
	if(end == beg)
	    return toSort;

	int pivot = getPivot(toSort, beg, end);
	int numSmall = 0;
	int numLarge = 0;
	int numEqual = 0;
	int[] smaller= new int[end-beg];
	int[] larger = new int[end-beg];

	for(int i = beg; i <= end; i++)
	    {
		if(toSort[i] < pivot)
		    {
			smaller[numSmall] = toSort[i];
			numSmall++;
		    }
		else if(toSort[i] > pivot)
		    {
			larger[numLarge] = toSort[i];
			numLarge++;
		    }
		else
		    numEqual++;
	    }
	for(int i = 0; i < numSmall; i++)
	    {
		toSort[beg + i] = smaller[i];
	    }
	for(int i = 0; i < numEqual; i++)
	    {
		toSort[beg + numSmall + i] = pivot;
	    }
	for(int i = 0; i < numLarge; i++)
	    {
		toSort[beg + numSmall + numEqual + i] = larger[i];
	    }
	if(numSmall > 0)
	    sort(toSort,beg,beg + (numSmall - 1));
	if(numLarge > 0)
	    sort(toSort,end - (numLarge - 1),end);
	return toSort;  
    }

    private static int getPivot(int[] toSort, int beg, int end)
    {
	int pivot;
		
	//The array is size 2, pivot doesn't matter
	if((end - beg) == 1)
	    return toSort[beg];

	//size 3 or greater
	if((end-beg) >= 2)
	    {
		int median = (int)Math.floor((end-beg)/2);
		int[] check = {toSort[beg], toSort[end], toSort[median]};
		//Finding the median without sorting...
		if((check[0] <= check[1]) && (check[0] <= check[2]))
		    {
			if(check[1] < check[2])
			    return check[1];
			return check[2];
		    }
		if((check[1] <= check[0]) && (check[1] <= check[2]))
		    {
			if(check[0] < check[2])
			    return check[0];
			return check[2];
		    }
		if((check[2] <= check[1]) && (check[2] <= check[0]))
		    {
			if(check[0] < check[1])
			    return check[0];
			return check[1];
		    }
	    }
	throw new IllegalArgumentException("Invalid bound for finding a median Beg: " + beg + " End: " + end);
    }

    private static void print100(int[] toSort, int beg)
    {
	for(int k = beg; (k < (beg + 100)) && (k < toSort.length); k++)
	    {
		System.out.println(toSort[k]);
	    }
    }
}

