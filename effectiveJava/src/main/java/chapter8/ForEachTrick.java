package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class ForEachTrick {
    public static void main(String[] args) {
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());

        List<Card> arrayList = new ArrayList<Card>();

        // 错误的原因在于
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                System.out.println(i.next());// i和 j 迭代器对的 next
                System.out.println(j.next());
                arrayList.add(new Card(i.next(), j.next(

                )));

            }
        }

//        // 两者有区别
//        for (Suit suit :
//                suits) {
//            for (Rank rank :
//                    ranks) {
//                arrayList.add(new Card(suit, rank));
//            }
//        }

        //
        for (Card card :
                arrayList) {
            System.out.println(card);
        }
    }
}

enum Suit {
    CLUB, DIAMOND, HEART, SPADE
}

enum Rank {
    ACE, DEUCE, THREE, FOUR
}

class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}