public class Card
{
   private String[] SUIT_STRING;
   private String[] RANK_STRING;
   private int rank;
   private int suit;

   public Card(int suit,int rank)
   {
      SUIT_STRING = new String[4];
      setSuitString();
      RANK_STRING = new String[14];
      setRankString();
      setSuit(suit);
      setRank(rank);
   }
   
   public void setSuitString()
   {
      SUIT_STRING[0] = "Diamonds";
      SUIT_STRING[1] = "Clubs";
      SUIT_STRING[2] = "Hearts";
      SUIT_STRING[3] = "Spades";
   }
   
   public void setRankString()
   {
      RANK_STRING[0] = "A";
      for(int i=1; i<10; i++)
      {
         RANK_STRING[i] = String.valueOf(i+1);
      }
      RANK_STRING[10] = "J";
      RANK_STRING[11] = "Q";
      RANK_STRING[12] = "K";
   }
   
   public void setSuit(int suit)
   {
      this.suit = suit;
   }
   public int getSuit()
   {
      return suit;
   }
   
   public void setRank(int rank)
   {
      this.rank = rank;
   }
   public int getRank()
   {
      return rank;
   }
   
   public String toString()
   {
      return RANK_STRING[rank] + " of " + SUIT_STRING[suit];
   }
}