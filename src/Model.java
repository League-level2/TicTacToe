
public class Model {
	int[][] board = new int[3][3];

	boolean makeMove(int r, int c, int player) {
		if (board[r][c] == 0) {
			board[r][c] = player;
			return true;
		} else {
			return false;
		}
	}

}
