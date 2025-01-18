import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionExecutor {
    public static void main(String[] args) {
        int[][] input1 = { { 1 }, { 2 }, { 3 }, {} };
        int[][] input2 = { { 1, 3 }, { 3, 0, 1 }, { 2 }, { 0 } };
        List<List<Integer>> inputlist = Arrays.stream(input2)
                .map(innerArray -> Arrays.stream(innerArray).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        KeysToRoom841 solution = new KeysToRoom841();
        List<List<Integer>> rooms = new ArrayList<List<Integer>>(inputlist);

        Instant startTime = Instant.now();

        System.out.println(solution.canVisitAllRooms(rooms));

        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);

        // Print execution time
        System.out.println("Execution time: " + duration);
    }
}
