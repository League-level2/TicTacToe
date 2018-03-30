import javax.swing.JOptionPane;

public class Model {
	int[][] board = new int[3][3];

	boolean makeMove(int r, int c, int player) {
		if (board[r][c] == 0) {
			board[r][c] = player;
			printBoard();
			checkWin( r, c, player);
			return true;
		} else {
			return false;
		}
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void checkWin(int r , int c, int player) {
		int countRow = 0;
		int countCol = 0;
		int countDiagonalLeft = 0;
		int countDiagonalRight = 0;
		
		for(int i = 0; i < 3; i++){
			if(board[r][i]== player){
				countCol++;
			} 
			if(board[i][c]==player){
				countRow++;
			}
			if(board[i][i] == player){
				countDiagonalLeft++;
			}
			if(board[i][2-i] == player){
				countDiagonalRight++;
			}			
		}
		if(countRow >= 3 || countCol >= 3 || countDiagonalRight >= 3|| countDiagonalLeft >= 3){
			JOptionPane.showMessageDialog(null, "YOU WON");
		}
	}
	
	

}
