import java.util.*;

class Guesser
{
	int guessNum;
	
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number between 1 to 10");
		guessNum=scan.nextInt();
		if(guessNum <1 || guessNum >10) {
			System.out.println("Out of range.");
			guessNum();
		}		
		return guessNum;
	}


}

class Player
{
	int guessNum;
	
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player kindly guess the number between 1 to 10");
		guessNum=scan.nextInt();
		if(guessNum <1 || guessNum >10) {
			System.out.println("Out of range ");
			guessNum();
		}	
		return guessNum;
	}
}

class Umpire
{
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	static boolean reguessPlayer1 = false;
	static boolean reguessPlayer2 = false;
	static boolean reguessPlayer3 = false;
	
	void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNum();
	}
	void collectNumFromPlayers()
	{
		Player p1=new Player();
		Player p2=new Player();
		Player p3=new Player();
		if(reguessPlayer1 == false)
		numFromPlayer1=p1.guessNum();
		if(reguessPlayer2 == false)
		numFromPlayer2=p2.guessNum();
		if(reguessPlayer3 == false)
		numFromPlayer3=p3.guessNum();
	}
	void compare()
	{
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
			{
				System.out.println("Game tied between player1,play2 and player3. Game will continue");				
				reMatch();
				
			}
			else if(numFromGuesser==numFromPlayer2 )
			{
				System.out.println("Game tied between player1 and play2. Game will continue");
				reguessPlayer3 = true;
				reMatch();
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Game tied between player1 and player3. Game will continue");
				reguessPlayer2 = true;
				reMatch();
			}
			else
			{
			System.out.println("Player 1 won the game");
			}
		}
		else if(numFromGuesser==numFromPlayer2)
		{
			if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Game tied between play2 and player3. Game will continue");
				reguessPlayer1 = true;
				
				reMatch();
				
			}
			else
			{
			System.out.println("Player 2 won the game");
			}
		}
		else if(numFromGuesser==numFromPlayer3)
		{
			
			System.out.println("Player 3 won the game");
		}
		else
		{
			System.out.println("Game lost Try Again!");
		}
		
	}
	private void reMatch() {
		
		Umpire u=new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayers();
		u.compare();
		
	}
	
}


public class LaunchGame {

	public static void main(String[] args) {
		
			Umpire u=new Umpire();
			u.collectNumFromGuesser();
			u.collectNumFromPlayers();
			u.compare();

	}

}
