package LeetCoding;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AllOneDataStructure {
    @Override
    public String toString() {
        return "AllOneDataStructure{" +
                "allOneMap=" + allOneMap +
                '}';
    }

    public static void main(String[] args) {
        AllOneDataStructure allOne = new AllOneDataStructure();
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("c");
        allOne.dec("c");

        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        System.out.println(allOne);
    }

    private Map<String, BigInteger> allOneMap = null;

    /** Initialize your data structure here. */
    public AllOneDataStructure() {
        allOneMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (key == null || key.trim().equals("")) return;
        BigInteger value = allOneMap.get(key);
        if (value == null) {
            allOneMap.put(key, new BigInteger("1"));
        } else {
            allOneMap.put(key, value.add(new BigInteger("1")));
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (key == null || key.trim().equals("")) return;   // todo
        if (!allOneMap.containsKey(key)) return;
        BigInteger value = allOneMap.get(key);
        if (value.intValue() == 1) {
            allOneMap.remove(key);
        } else {
            allOneMap.put(key, value.subtract(new BigInteger("1")));
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        BigInteger maxValue = new BigInteger("0");
        String maxKey = "";
        for (String s : allOneMap.keySet()) {
            if (maxValue.subtract(allOneMap.get(s)).intValue() < 0) {
                maxValue = allOneMap.get(s);
                maxKey = s;
            }
        }
        return maxKey;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        String minKey = "";
        if (!allOneMap.values().isEmpty()) {
            BigInteger minValue = new BigInteger(allOneMap.values().toArray()[0] + "");
            for (String key : allOneMap.keySet()) {
                if (minValue.subtract(allOneMap.get(key)).intValue() >= 0) {
                    minValue = allOneMap.get(key);
                    minKey = key;
                }
            }
        }
        return minKey;
    }
}
