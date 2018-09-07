package september.sixth;

import java.util.*;

/**
 341. Flatten Nested List Iterator
 Given a nested list of integers, implement an iterator to flatten it.
 Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 Example 1:
 Input: [[1,1],2,[1,1]]
 Output: [1,1,2,1,1]
 Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 Example 2:
 Input: [1,[4,[6]]]
 Output: [1,4,6]
 Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class NestedList {
    public static void main(String[] args) {
        List<NestedInteger> nestedIntList = new ArrayList<>();
        NestedInteger nestedInt1 = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 11;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        };

        NestedInteger nestedInt3 = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 22;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        };

        NestedInteger nestedInt2 = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(nestedInt1, nestedInt3);
            }
        };

        NestedInteger nestedInt4 = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(nestedInt1, nestedInt2);
            }
        };

        nestedIntList.add(nestedInt1);
        nestedIntList.add(nestedInt3);
        nestedIntList.add(nestedInt2);
        nestedIntList.add(nestedInt4);

        /**
         * 11, 22, 11, 22, 11, 11, 22,
         */
        NestedIterator nestedIterator = new NestedIterator(nestedIntList);
        while (nestedIterator.hasNext()) {
            System.out.print(nestedIterator.next() + ", ");
        }
    }

}

class NestedIterator implements Iterator<Integer> {
    private int index, pos;
    private List<Integer> plainIntList = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        plainIntList = goThroughNestedList(nestedList);
    }

    @Override
    public Integer next() {
        return plainIntList.get(pos++);
    }

    @Override
    public boolean hasNext() {
        return index++ < plainIntList.size();
    }

    private List<Integer> goThroughNestedList(List<NestedInteger> nestedList) {
        for (NestedInteger nInt : nestedList) {
            if (nInt.isInteger()) {
                plainIntList.add(nInt.getInteger());
            } else {
                goThroughNestedList(nInt.getList());
            }
        }
        return plainIntList;
    }
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
