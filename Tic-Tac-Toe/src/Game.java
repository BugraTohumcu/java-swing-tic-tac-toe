import java.awt.Color;

public class Game {
	
	 static String playerXSymbol = "X";
	 static String playerOSymbol = "O";
	 
	  static int playerXScore = 0;
	  static int playerOScore = 0;

	private static int turnCounter =0;
	static String turnText="'s turn" ;
	
	public static void placeSymbol(int place) {
		
		if(turnCounter%2==0) {
			TicTacToeApp.buttons[place].setText(playerXSymbol);
			TicTacToeApp.turnLabel.setText(playerOSymbol+turnText);
		}
		
		else {
			TicTacToeApp.buttons[place].setText(playerOSymbol);
			TicTacToeApp.turnLabel.setText(playerXSymbol+turnText);
		}
		
		turnCounter++;

	}
	
	public static void increaseScore(int winner) {
		
		if(TicTacToeApp.buttons[winner].getText()==playerXSymbol) 
		TicTacToeApp.scoreLabel.setText("Score: " + ++playerXScore +" - "+ playerOScore);

		else TicTacToeApp.scoreLabel.setText("Score: " + playerXScore +" - "+ ++playerOScore);
		
		
	}
	
	
	public static void endGame(int winner) {
		
		for(int i = 0; i < TicTacToeApp.numberOfButtons; i++) {
			TicTacToeApp.buttons[i].setEnabled(false);
		}
		
		TicTacToeApp.turnLabel.setText("Congratulations, winner is " + TicTacToeApp.buttons[winner].getText());
		
	}
	
	
	
	public static void resetGame() {
		for(int i  = 0; i < 9 ; i++) {
			TicTacToeApp.buttons[i].setBackground(Color.white);
			TicTacToeApp.buttons[i].setText("");
			TicTacToeApp.buttons[i].setEnabled(true);
			turnCounter=0;
		}
		TicTacToeApp.turnLabel.setText("");
	}
	
	public static void highlightWinnerCells(int x ,int y , int z) {
		
		TicTacToeApp.buttons[x].setBackground(Color.green);
		TicTacToeApp.buttons[y].setBackground(Color.green);
		TicTacToeApp.buttons[z].setBackground(Color.green);
	}
	
	
	private static boolean checkWinningCondition(int[] positions) {
	    String symbol = TicTacToeApp.buttons[positions[0]].getText();

	    if (symbol.isEmpty()) {
	    	return false;
	    }
	    for (int pos : positions) {
	        if (!TicTacToeApp.buttons[pos].getText().equals(symbol)) {
	        	return false; 
	        }
	    }
	    return true;
	}

	public static void checkForWinner() {
	    int[][] winningCombinations = {
	            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Rows
	            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columns
	            {0, 4, 8}, {2, 4, 6}              // Diagonals
	    };

	    for (int[] combination : winningCombinations) {
	        if (checkWinningCondition(combination)) {
	        	highlightWinnerCells(combination[0], combination[1], combination[2]);
	        	increaseScore(combination[0]);
	            endGame(combination[0]);
	            return;
	        }
	    }
	}

			
			
		
	}


