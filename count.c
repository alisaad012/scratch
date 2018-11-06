# include <stdio.h>
# include <stdlib.h>
# include <time.h>

int main(int argc, char* argv[]) {
  unsigned long num = 1l << (argc > 1 ? atoi(argv[1]) : 10);
  int trials = argc > 2 ? atoi(argv[2]) : 3;
  clock_t start = clock();
  for (int i = 0; i < trials; i++) {
    unsigned long count = 0l;
    while (count < num) {
      count++;
    }
  }
  clock_t end = clock();
  printf("Counted to %lu in %.2f seconds\n", num, (float) (end-start) / CLOCKS_PER_SEC / trials);
}
