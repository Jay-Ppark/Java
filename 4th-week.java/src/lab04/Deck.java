package lab04;

import java.util.Random;

public class Deck {
	private static final int TOTAL_CARDS = 52;
	private Card deck[];

	private Random randGener;

	private int curCard;

	public Deck() {
		deck = new Card[TOTAL_CARDS];
		int i = 0;
		for (int suit = Card.DIAMOND; suit <= Card.SPADE; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deck[i++] = new Card(rank, suit);
			}
		}
		curCard = 0;
	}

	public void Shuffle() {
		for (int i = 0; i < Deck.TOTAL_CARDS; i++) {
			int tmSwap = randGener.nextInt(TOTAL_CARDS);
			Card tmpCard = deck[tmSwap];
			deck[i] = deck[tmSwap];
			deck[tmSwap] = tmpCard;
		}
	}

	public Card deal() {
		if (curCard >= TOTAL_CARDS) {
			System.out.println("Error: Out of cards!");
			return null;
		} else {
			Card c = deck[curCard];
			curCard++;
			return c;
		}
	}
}
