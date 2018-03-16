package LeetCoding.march.twelvth;

import java.util.*;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {
    private static Map<Integer, Integer> hashMap = new HashMap<>();
    private static Set<Coordinate> hashSet = new HashSet<>();
    private static Set<Coordinate> hashSet2 = new HashSet<>();
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                hashSet.add(new Coordinate(i, j, grid[i][j]));
            }
        }

        Iterator<Coordinate> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().value == 0) {
                iterator.remove();
            }
        }

        int islandSize = 0;
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Iterator<Coordinate> iterator2 = hashSet2.iterator();

            if (!iterator2.hasNext()) {
                hashSet2.add(iterator.next());
            }

            while (iterator2.hasNext()) {
                Coordinate coordinate = iterator2.next();
                if (coordinate.x == 3 && coordinate.y == 4) {
                    System.out.println();
                }
                if (isAdjacentPoint(hashSet2, coordinate)) {
                    hashSet2.add(coordinate);
                }
            }

            if (islandSize < hashSet2.size()) {
                islandSize = hashSet2.size();
            }
        }

        System.out.println(hashSet2.size());
    }

    private static boolean isAdjacentPoint(Set<Coordinate> coordinateSet, Coordinate co) {
        for (Coordinate o : coordinateSet) {
            boolean adj = ((o.x == co.x) && Math.abs(o.y - co.y) == 1) || ((o.y == co.y) && Math.abs(o.x - co.x) == 1);
            if (adj) {
                return true;
            }
        }
        return false;
    }

    private static int maxAreaOfIsland(int[][] grid) {

        return -1;
    }

    private static int calculateAdjacentPoints(int[][] grid, int x, int y) {
        int count = 0;
        int indexLeft = y-1;
        int indexRight = y;
        while (indexLeft-- >= 0) {
            int o = grid[x][indexLeft];
            if (o != 1) break;
            count++;
        }

        while (indexRight ++ < grid[0].length) {
            int o = grid[x][indexRight];
            if (o != 1) break;
            count++;
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (!(entry.getKey() == x && entry.getValue() == y)) {
                hashMap.put(x, y);
            }
        }
        return count;
    }
}

class Coordinate {
    int x, y;
    int value;

    public Coordinate(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
