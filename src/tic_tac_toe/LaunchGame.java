package tic_tac_toe;

public class LaunchGame{
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		
		
		HumanPlayer p1 = new HumanPlayer("bob", 'x');
//		HumanPlayer p2 = new HumanPlayer("pp", 'o');
		AIPlayer p2 = new AIPlayer("AI", 'o');
		
		Player cp;
		cp = p1;
		
		while(true) {
			
			System.out.println(cp.name+" turn");
			cp.makeMOve();
			TicTacToe.dispBoard();
			if(TicTacToe.checkColWin() || TicTacToe.checkDigWin() || 
				TicTacToe.checkRowWin()) {
				System.out.println(cp.name+" has won");
				break;
			}
			else if(TicTacToe.checkDraw()) {
				System.out.println("Game is draw");
				break;
			}
			else {
				
				if(cp == p1) {
					cp = p2;
				}
				else {
					cp = p1;
				}
			}
		}
	}
}








