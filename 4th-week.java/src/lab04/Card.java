package lab04;

public class Card {

	public static final int DIAMOND = 1;
	public static final int CLUB = 2;
	public static final int HEART = 3;
	public static final int SPADE = 4;
	private String[] SUIT_STRING = { "*", "Diamond", "Club", "Heart", "Spade" };
	private String[] RANK_STRING = { "*", "A", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "J", "Q", "K" };
	public int rank;
	public int suit;

	public Card() {
		this(1, 1);
	}

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public String toString() {
		//Card c = new Card(rank, suit);
		return RANK_STRING[rank] + SUIT_STRING[suit];

	}

}
