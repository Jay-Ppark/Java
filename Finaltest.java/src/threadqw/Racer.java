package threadqw;

public class Racer implements Runnable {

	public static String winner;
	public void race(){
			for(int distance=1;distance<=100;distance++){
			System.out.println("Distance Covered by "+Thread.currentThread().getName()+ "is:"+distance +"meters");
			//Check if race is complete if some one has already won
			boolean isRaceWon = this.isRaceWon(distance);
			if(isRaceWon){
				break;
			}
		}
	}

	private boolean isRaceWon(int totalDistanceCovered){
		boolean isRaceWon =  false;
		if((Racer.winner==null )&&(totalDistanceCovered==100)){
				String winnerName = Thread.currentThread().getName();
				Racer.winner = winnerName; //setting the winner name
				System.out.println("Winner is :"+Racer.winner);
				isRaceWon = true;
			}else if(Racer.winner==null){
			isRaceWon = false;
			}else if(Racer.winner!=null){
				isRaceWon = true;
			}
		return isRaceWon;
		}

	@Override
	public void run() {
		this.race();

	}

}
