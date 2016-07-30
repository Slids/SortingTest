using System.IO;
using System;
class SelectionSort
{
    public static void Main(string[] args)
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
        //Loop over all elements (first one not needed)                                                                                                                                                     
        for(int i = 1; i < toSort.Length; i++)
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


