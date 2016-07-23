import java.util.Random;

class SelectionSort
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
		sort(toSort);
		Long end = System.nanoTime();
		System.out.println("Sorting took: " + (end - start));

	    }
    }

    private static int[] sort(int[] toSort)
    {
	//Instantiant the two required ints
	int smallestEntry;
	int smallestEntryIndex;
	//Loop over all elements (last one not needed)
	for(int i = 0; i < toSort.length - 1; i++)
	    {
		smallestEntry = toSort[i];
		smallestEntryIndex = i;

		//See if we need to switch
		for(int j = i + 1; j < toSort.length; j++)
		    {
			if(smallestEntry > toSort[j])
			    {
				smallestEntry = toSort[j];
				smallestEntryIndex = j;
			    }
		    }
		toSort[smallestEntryIndex] = toSort[i];
		toSort[i] = smallestEntry;	    
	    }
	return toSort;
    }
}
