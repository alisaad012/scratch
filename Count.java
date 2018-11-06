import java.time.Clock;

public class Count {
    public static void main(String[] args) {
        int power = args.length > 0 ? Integer.parseInt(args[0]) : 10;
        int trials = args.length > 1 ? Integer.parseInt(args[1]) : 3;
        long num = 1l << power;
        long count = 0l;
	Clock clock = Clock.systemDefaultZone();
	long start = clock.millis();
        for (int i = 0; i < trials; i++) {
	    count = 0l;
            while (count < num) {
                count++;
            }
        }
        long end = clock.millis();
        System.out.printf("Counted to %d in %.2f seconds.\n", count, (end - start) / 1000.0 / trials);
    }
}
