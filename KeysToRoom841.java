import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysToRoom841 {
    // java set example
    HashSet<Integer> set = new HashSet<Integer>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);

        while (stack.size() > 0) {
            Integer currRoom = stack.pop();
            set.add(currRoom); // add the current room to the visited list
            stack.addAll(rooms.get(currRoom).stream().filter(x -> !set.contains(x)).toList());
        }

        return set.size() == rooms.size();
    }
}
