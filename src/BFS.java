import java.util.*;

import static java.util.Map.entry;

public class BFS {
    public static void demo() {
        Map<String, List<String>> G = Map.ofEntries(
                entry("a", Arrays.asList("b", "c")),
                entry("b", Arrays.asList("a", "e", "d")),
                entry("c", Arrays.asList("a", "d")),
                entry("d", Arrays.asList("b", "c", "e")),
                entry("e", Arrays.asList("b", "d", "g", "f")),
                entry("f", Arrays.asList("e", "g")),
                entry("g", Arrays.asList("e", "f", "h")),
                entry("h", Arrays.asList("g")));
        Queue<String> searchingQueue = new ArrayDeque<>();
        Map<String, String> finalMap = new HashMap<>();
        List<String> discovered = new ArrayList<>();
        List<String> closed = new ArrayList<>();
        String startPoint = "b";
        discovered.add(startPoint);
        searchingQueue.add(startPoint);
        searchGraph(G,
                startPoint,
                searchingQueue,
                finalMap,
                discovered,
                closed);

        System.out.println(finalMap);
    }

    private static void searchGraph(Map<String, List<String>> graph,
                                    String startPoint,
                                    Queue<String> searchingQueue,
                                    Map<String, String> finalMap,
                                    List<String> discovered,
                                    List<String> closed) {

        while (!searchingQueue.isEmpty()) {
            var children = graph.get(startPoint);
            for (var child : children) {
                if (!discovered.contains(child) && !closed.contains(child)) {
                    searchingQueue.add(child);
                    discovered.add(child);
                    finalMap.put(child, startPoint);
                }
            }
            searchingQueue.remove(startPoint);
            closed.add(startPoint);
            startPoint = searchingQueue.peek();
        }
    }
}
