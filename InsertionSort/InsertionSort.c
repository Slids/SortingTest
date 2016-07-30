#include <stdlib.h>
#include <stdio.h>
#include <time.h>

void insertionSort(int *toSort, int size);
static unsigned long getNanos(void);

int main(void)
{
  time_t t1,t2;
  int elapsedTime;
  int arraySize = 100000;
  int toSort[arraySize];
  srand((unsigned int)arraySize);
  unsigned long start,end;

  for(int i = 0; i < 20; i++)
    {
      for(int j = 0; j < arraySize; j++)
	{
	  toSort[j] = rand() % (arraySize * 10);
	}

      start = getNanos();
      insertionSort(toSort, arraySize);
      end = getNanos();

      fprintf(stdout, "Sorting took %ld\n", (end-start));

    }
  return 1;
}

void insertionSort(int *toSort, int size)
{
  //Loop over the array (the first element is sorted
  for(int i =1; i < size; i++)
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
}

static unsigned long getNanos(void) {
  struct timespec ts;
  timespec_get(&ts, TIME_UTC);
  return (unsigned long)ts.tv_sec * 1000000000L + ts.tv_nsec;
}  
