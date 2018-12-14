package src.september;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RerangeCards {
    private static final String[] SHAPE_ARR = {"Spade", "Diamond", "Club", "Heart"};
    public static void main(String[] args) {
        Set<Card> cardSet = new HashSet<>();
        for (int i = 1; i <= 13; i++) {
            for (String shape : SHAPE_ARR) {
                Card card;
                if (i == 1) {
                    card = new Card(shape, "A");
                } else if (i>=2 && i<=10) {
                    card = new Card(shape, i+"");
                } else {
                    card = new Card(shape, (char)('J'+(i-11))+"");
                }
                cardSet.add(card);
            }
        }
        cardSet.add(new Card("Red", "Joke"));
        cardSet.add(new Card("Black", "Joke"));
        for (Card card : cardSet) {
            System.out.println(card);
        }
    }

    private static class Card {
        String shape;
        String value;

        public Card(String shape, String value) {
            this.shape = shape;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "shape='" + shape + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
