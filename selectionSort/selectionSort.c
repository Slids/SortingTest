#include <stdlib.h>
#include <stdio.h>
#include <time.h>

void selectionSort(int *toSort, int size);
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
      selectionSort(toSort, arraySize);
      end = getNanos();

      fprintf(stdout, "Sorting took %ld\n", (end-start));

    }
  return 1;
}

void selectionSort(int *toSort, int size)
{
  int entryIndex;
  int entryVal;
  
  //Loop over the array
  for(int i =0; i < size - 1; i++)
    {
      entryIndex = i;
      entryVal = toSort[i];
      
      //Loop over the remaining items 
      for(int j = i; j < size; j++)
	{
	  if(toSort[j] < entryVal)
	    {
	      entryIndex = j;
	      entryVal = toSort[j];
	    }
	}
      toSort[entryIndex] = toSort[i];
      toSort[i] = entryVal;
    }
}

static unsigned long getNanos(void) {
  struct timespec ts;
  timespec_get(&ts, TIME_UTC);
  return (unsigned long)ts.tv_sec * 1000000000L + ts.tv_nsec;
}
