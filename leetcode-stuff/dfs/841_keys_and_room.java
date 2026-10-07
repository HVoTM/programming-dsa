/**
 * 841. Keys and Rooms
 * 
 * 
 * Topic: DepthFirst Search, HashMap
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // // Or use Hashmap
        // set all the room associated values as false
        // then mark as true when accessible with a key
        // Map<Integer, Boolean> encountered = new HashMap<>();
        Set<Integer> encountered = new HashSet<>();

        // stack for DFS
        Deque<Integer> stack = new ArrayDeque<>();

        // room 0th
        // System.out.println("Current rooms: " + rooms.get(0).toString());
        for (Integer num: rooms.get(0)) {
            stack.push(num);
        }
        encountered.add(0);

        // Perform DFS
        while(!stack.isEmpty()) {
            // visit the room we have on top of the stack
            Integer currRoom = stack.pop();

            // If room is not encountered, add to list 
            if (encountered.add(currRoom)) {
                for (Integer num: rooms.get(currRoom)) {
                    stack.push(num);
                }
                // System.out.println("Current stack: " + stack.toString());
            }
            // System.out.println("Encountered: " + encountered.toString());
        }
        // System.out.println(encountered.toString());
        return encountered.size() == rooms.size();

    }
}