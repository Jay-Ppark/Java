
import java.util.Scanner;

public class Test
{
   public static void main(String[] args)
   {
      Deck deck1 = new Deck();
      deck1.getDeck();
      System.out.println(deck1.deal().toString());
      System.out.println(deck1.deal().toString());
   }
}