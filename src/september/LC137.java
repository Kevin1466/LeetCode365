package src.september;

import java.util.Hashtable;
import java.util.Set;

public class LC137 {
    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[] {0,1,0,9,9,1,0,1}));
    }

    public static int singleNumber2(int[] nums) {

        int K = 3, M = 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count += 1; // 这是统计(0-31)第i位上，'1'的个数有多少吗？
                }
            }
            ans |= (count % K) << i; //
        }

        ans /= M;
        if (ans >= (1<<31)) {
            ans -= (1<<32);
        }
        return (int)ans;
    }

    public static int singleNumber(int[] nums) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i : nums) hashtable.put(i, hashtable.getOrDefault(i, 0) + 1);

        Set<Integer> keySet = hashtable.keySet();
        for (int k : keySet) if (hashtable.get(k) != 3) return k;
        return 0;
    }
}
