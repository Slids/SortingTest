import java.util.Random;

class InsertionSort
{
    public static void main(String[] args)
    {
	int arraySize = 100000;
	int[] toSort = new int[arraySize];
	Random rand = new Random(arraySize);
	for(int j = 0; j < 20; j++)
	    {
		for(int i = 0; i < toSort.length; i++)
		    {
			toSort[i] = rand.nextInt(arraySize * 10);
		    }
		Long start = System.nanoTime();
		InsertionSort.sort(toSort);
		Long end = System.nanoTime();
		System.out.println("Sorting took: " + (end - start));
		//for(int k = 0; k < 100; k++)
		//    {
		//	System.out.print(toSort[k]);
		//    }
		//System.out.println();
	    }
    }

    private static int[] sort(int[] toSort)
    {
	//Loop over all elements (first one not needed)
	for(int i = 1; i < toSort.length; i++)
	    {
		int move = i;
		while((move > 0) && (toSort[move-1] > toSort[move]))
		    {
			toSort[move-1] += toSort[move];
			toSort[move] = toSort[move-1] - toSort[move];
			toSort[move-1] = toSort[move-1] - toSort[move];
			move--;
		    }
	    }
	return toSort;
    }
}

