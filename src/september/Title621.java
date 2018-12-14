package src.september;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Title621 {
    public static void main(String[] args) {
        System.out.println(6^3);
        //leastInterval(null, 0);
    }

    public static int leastInterval(char[] tasks, int n) {
        //array letters twisted
        //优先队列自然排序示例
        Queue<Integer> sortQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2-t1;
            }
        });
        sortQueue.offer(2);sortQueue.offer(4);sortQueue.offer(8);sortQueue.offer(5);
        int intervals = 0;
        while (sortQueue.size() >= 2) {
            int former = sortQueue.poll();
            int latter = sortQueue.poll();
            intervals += latter;
            sortQueue.offer(former - latter);
        }
        intervals += (sortQueue.size()-1)*2;
        System.out.println(sortQueue);
        return 0;
    }
}
