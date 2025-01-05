import java.time.Duration;
import java.time.Instant;

public class SolutionExecutor {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abciiidef";

        Instant startTime = Instant.now();

        System.out.println(solution.maxVowels(s, 3));

        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);

        // Print execution time
        System.out.println("Execution time: " + duration);
    }
}
