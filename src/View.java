import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel {
	int[][] board;
	Graphics g;
	Font font = new Font("Ariel", Font.BOLD, 230);
	public static final int MENU_STATE = 0;
	public static final int GAME_STATE = 1;
	public static final int END_STATE = 2;
	int currentState = GAME_STATE;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g = g;
		g.setFont(font);
		if (currentState == MENU_STATE) {

		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		}
	}

	private void drawGameState(Graphics g) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				// draw board
				drawBoard(row, col);
				if (board[row][col] == 1) {
					// Draw O's
					drawO(row, col);
				} else if (board[row][col] == 2) {
					// Draw X's
					drawX(row, col);
				}
			}
		}
	}

	void drawBoard(int i, int j) {
		g.drawRect(i * TicTacToe.WIDTH / 3, j * TicTacToe.HEIGHT / 3, TicTacToe.WIDTH / 3, TicTacToe.HEIGHT / 3);
	}

	void drawO(int row, int col) {
		g.drawOval(col * TicTacToe.WIDTH / 3, row * TicTacToe.HEIGHT / 3, TicTacToe.WIDTH / 3, TicTacToe.HEIGHT / 3);
	}

	void drawX(int row, int col) {
		g.drawLine(col * TicTacToe.WIDTH / 3, row * TicTacToe.HEIGHT / 3, (col + 1) * TicTacToe.WIDTH / 3,
				(row + 1) * TicTacToe.HEIGHT / 3);
		g.drawLine(col * TicTacToe.WIDTH / 3 + TicTacToe.WIDTH / 3, row * TicTacToe.HEIGHT / 3,
				col * TicTacToe.WIDTH / 3, (row) * TicTacToe.HEIGHT / 3 + TicTacToe.HEIGHT / 3);

	}

	void setBoard(int[][] board) {
		this.board = board;
	}

	void showWin() {
		JOptionPane.showMessageDialog(null, "You won!");
		System.exit(0);
	}
	void showDraw() {
		JOptionPane.showMessageDialog(null, "Draw!!");
		System.exit(0);
	}
}
