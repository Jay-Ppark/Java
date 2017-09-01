import java.util.Random;

public class Deck
{
   public static final int TOTAL_CARDS = 52;
   private Card[] deck = new Card[TOTAL_CARDS];
   private Random randGener;
   private int curCard;

   public Deck()
   {
      setRandGener();
      setDeck();
      setCurCard();
   }

   public void setRandGener()
   {
      randGener = new Random();
   }

   public void setDeck()
   {
      int rand = 0;
      int arr[] = new int[52];
      int current_cards = 0;

      for (int i = 0; i < TOTAL_CARDS; i++)
      {
         rand = randGener.nextInt(TOTAL_CARDS);
         for (int j = 0; j < current_cards; j++)
         {
            if (arr[j] == rand)
            {
               rand = randGener.nextInt(TOTAL_CARDS);
               j = 0;
            }
         }
         current_cards++;
         arr[i] = rand;
         deck[i] = new Card((rand) / 13, (rand) % 13);
      }
   }

   public void getDeck()
   {
      int count_cards = 0;

      for(int i=0; i< TOTAL_CARDS / 4; i++)
      {
         for(int j=0; j<4; j++)
         {
            System.out.printf("%-18s ", deck[count_cards]);
            count_cards++;
         }
         System.out.println();
      }

   }
   
   public void setCurCard()
   {
      curCard = 0;
   }
   
   public void shuffle()
   {
      setDeck();
   }
   
   public Card deal()
   {
      curCard++;
      return deck[curCard-1];
   }
   
}