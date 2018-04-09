package LeetCoding.march.eighteen;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class BackTracking {
    public static void main(String[] args) {

        Stack<Crossing> crossingStack = new Stack<>();
        Crossing c0 = new Crossing(0,0,0);
        Crossing c1 = new Crossing(2,0,0);
        Crossing c2 = new Crossing(4,0,0);
        Crossing c3 = new Crossing(0,0,0);
        Crossing c4 = new Crossing(3,5,0);
        Crossing c5 = new Crossing(6,0,0);
        Crossing c6 = new Crossing(7,0,0);
        Crossing c7 = new Crossing(8,9,0);
        Crossing c8 = new Crossing(0,0,0);
        Crossing c9 = new Crossing(10,0,0);

        crossingStack.push(c0);
        crossingStack.push(c1);
        crossingStack.push(c2);
        crossingStack.push(c3);
        crossingStack.push(c4);
        crossingStack.push(c5);
        crossingStack.push(c6);
        crossingStack.push(c7);
        crossingStack.push(c8);
        crossingStack.push(c9);

        Maze maze = new Maze(10, crossingStack);
        maze.getResult();
    }
}

class Crossing {
    int turn1, turn2, turn3;

    public Crossing(int turn1, int turn2, int turn3) {
        this.turn1 = turn1;
        this.turn2 = turn2;
        this.turn3 = turn3;
    }
}

class Maze {
    private int exit;
    Stack<Crossing> crossings;
    Stack<Integer> result = new Stack<>();

    public Maze(int exit, Stack<Crossing> crossings) {
        this.exit = exit;
        this.crossings = crossings;
    }

    private boolean findExit(int entrance) {
        if (entrance > 0) {
            if (entrance == exit) {
                result.push(entrance);
                return true;
            }
            if (findExit(crossings.get(entrance).turn1)) {
                result.push(entrance);
                return true;
            }
            if (findExit(crossings.get(entrance).turn2)) {
                result.push(entrance);
                return true;
            }
            if (findExit(crossings.get(entrance).turn3)) {
                result.push(entrance);
                return true;
            }
        }
        return false;
    }

    public void getResult() {
        findExit(1);
        Collections.reverse(result);
        System.out.println(result);
    }
}