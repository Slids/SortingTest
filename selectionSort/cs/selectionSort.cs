using System;
using System.IO;

class SelectionSort
{
    public static void Main(String[] args)
    {
        int arraySize = 100000;
        int[] toSort = new int[arraySize];
        Random rand = new Random(arraySize);
        for(int j = 0; j < 20; j++)
            {
                for(int i = 0; i < toSort.Length; i++)
                    {
                        toSort[i] = rand.Next(arraySize * 10);
                    }
				var ts = DateTime.Now;
                sort(toSort);
                Console.Out.WriteLine("Sorting took: " + ((DateTime.Now - ts).Ticks * 100));

            }
    }

    private static int[] sort(int[] toSort)
    {
        //Instantiant the two required ints
        int smallestEntry;
        int smallestEntryIndex;
        //Loop over all elements (last one not needed)
        for(int i = 0; i < toSort.Length - 1; i++)
            {
                smallestEntry = toSort[i];
                smallestEntryIndex = i;

                //See if we need to switch
                for(int j = i + 1; j < toSort.Length; j++)
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

