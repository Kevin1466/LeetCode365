package LeetCoding.march.eighteen;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class GraphTraversal {
    //Stack<List<Integer>> graph = new Stack<>();
    public static void main(String[] args) {
        Vector<List<Integer>> graph = new Vector<>(7);

        graph.add(0, Arrays.asList(2, 1));
        graph.add(1, Arrays.asList(0, 2));
        graph.add(2, Arrays.asList(4, 3, 0, 1));
        graph.add(3, Arrays.asList(2, 4, 5));
        graph.add(4, Arrays.asList(6, 5, 3, 2));
        graph.add(5, Arrays.asList(4, 3));
        graph.add(6, Arrays.asList(4));

        GraphTraversal traversal = new GraphTraversal();
        System.out.println("BFS:");
        traversal.bfs(0, graph);
        System.out.println("DFS:");
        traversal.dfs(0, graph);
    }

    private void bfs(int startNode, Vector<List<Integer>> adjLists) {
        Queue<Integer> notYetExplored = new LinkedList<>();
        Set<Integer> discovered = new HashSet<>();

        notYetExplored.add(startNode);
        discovered.add(startNode);

        while (!notYetExplored.isEmpty()) {
            int nodeToExplore = notYetExplored.poll();

            List<Integer> edges = adjLists.get(nodeToExplore);
            for (int edge : edges) {
                if (!discovered.contains(edge)) {
                    discovered.add(edge);
                    notYetExplored.add(edge);

                    System.out.println("Found " + edge + " from " + nodeToExplore);
                }
            }
        }
    }

    private void dfs(int startNode, Vector<List<Integer>> adjLists) {
        Set<Integer> discovered = new HashSet<>();
        discovered.add(startNode);
        dfsHelper(startNode, adjLists, discovered);
    }

    private void dfsHelper(int node, Vector<List<Integer>> adjLists, Set<Integer> discovered) {
        List<Integer> edges = adjLists.get(node);
        for (int edge : edges) {
            if (!discovered.contains(edge)) {
                discovered.add(edge);
                System.out.println("Found " + edge + " from " + node);
                dfsHelper(edge, adjLists, discovered);
            }
        }
    }
}
