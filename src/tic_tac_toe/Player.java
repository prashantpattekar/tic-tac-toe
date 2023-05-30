package tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

abstract public class Player {
	
	String name;
	char mark;
	
	abstract void  makeMOve(); 
	
	boolean isValidMove(int row, int col) {
		if(row >= 0 && row <= 2 &&
			col >=0 && col <=2) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
	
}


class HumanPlayer extends Player{
	
	public HumanPlayer(String name, char mark) {
		this.name  = name;
		this.mark = mark;
	}

	@Override
	void makeMOve() {
		Scanner scan = new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("enter the row and col");
			row = scan.nextInt();
			col = scan.nextInt();
		}while(!isValidMove(row, col));
		
		
		TicTacToe.placeMark(row, col, mark);
	}
	
}

class AIPlayer extends Player{
	
	public AIPlayer(String name, char mark) {
		this.name=name;
		this.mark=mark;
	}

	@Override
	void makeMOve() {

//		Scanner scan = new Scanner(System.in);
		int row;
		int col;
		do {
			Random r = new Random();
			row = r.nextInt(3);
			col = r.nextInt(3);
			if(isValidMove(row, col)==false) {
				System.out.println("invalid move");
			}
		}while(!isValidMove(row, col));
		
		TicTacToe.placeMark(row, col, mark);
	}
	
}
