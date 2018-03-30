import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class View extends JPanel {
	int[][] board;
	Font font = new Font("Ariel", Font.BOLD, 230);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(font);
		drawBoard(g);
	}

	private void drawBoard(Graphics g) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.drawRect(i * TicTacToe.WIDTH / 3, j * TicTacToe.HEIGHT / 3, TicTacToe.WIDTH / 3,
						TicTacToe.HEIGHT / 3);
				if (board[i][j] == 1) {
					g.drawOval(j * TicTacToe.WIDTH / 3, i * TicTacToe.HEIGHT / 3, TicTacToe.WIDTH / 3,
							TicTacToe.HEIGHT / 3);
				} else if (board[i][j] == 2) {
					g.drawString("X", j * TicTacToe.WIDTH / 3, i * TicTacToe.HEIGHT / 3 + TicTacToe.HEIGHT / 3);
				}
			}
		}
	}

	void setBoard(int[][] board) {
		this.board = board;
	}

}
