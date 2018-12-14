package src.september;

import java.util.*;

public class LC310 {
    public static void main(String[] args) {
        List<Integer> minHeightTrees = findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        for (int i :minHeightTrees) {
            System.out.println(i);
        }
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if(n==0){
            return result;
        }
        if(n==1){
            result.add(0);
            return result;
        }

        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for(int i=0; i<n; i++){
            graph.add(new HashSet<Integer>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            if(graph.get(i).size()==1){
                leaves.offer(i);
            }
        }

        if(leaves.size()==0){
            return result;
        }

        while(n>2){
            n = n-leaves.size();

            LinkedList<Integer> newLeaves = new LinkedList<Integer>();

            for(int l: leaves){
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                if(graph.get(neighbor).size()==1){
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
        /*Set<Edge> edgeSet = new HashSet<>();
        for (int[] e : edges) {
            edgeSet.add(new Edge(e[0], e[1]));
        }

        for (Edge e : edgeSet) {

        }
        return null;*/
    }

    private static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
