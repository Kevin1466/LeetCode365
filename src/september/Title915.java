package src.september;

import java.util.*;

public class Title915 {
    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[] {1,1,0,1,2}));
    }

    public static int partitionDisjoint(int[] A) {
        int sizeA = A.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(sizeA, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < sizeA; i++) {
            if (i == 0) maxHeap.add(A[i]);
            else minHeap.add(A[i]);
        }

        // left <= right
        for (;;) {
            int topMinHeap = minHeap.peek();
            int topMaxHeap = maxHeap.peek();
            if (topMaxHeap <= topMinHeap) {
                return maxHeap.size();
            } else {
                int temp = A[maxHeap.size()];
                maxHeap.add(temp);
                minHeap.remove(temp);
            }
        }
    }
}
