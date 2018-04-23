import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel {
	int[][] board;
	Graphics g;
	Font titleFont = new Font("Ariel", Font.BOLD, 40);
	Font textFont = new Font("Ariel", Font.BOLD, 30);
	public GameState gameState = GameState.MENU;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g = g;
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, WIDTH, HEIGHT);
		if (gameState == GameState.MENU) {
			drawMenuState(g);
		} else if (gameState == GameState.PLAY) {
			drawGameState(g);
		} else {
			drawEndState(g);
		}
	}
	
	private void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Tic Tac Toe", 125, 75);
		g.setFont(textFont);
		g.drawString("Press enter to play", 95, 180);
	}

	private void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
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
	
	private void drawEndState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("Game end", 125, 75);
		g.setFont(textFont);
		g.drawString("Press enter to go back to the menu", 95, 180);
	}
	
	public void setCurrentState(GameState gameState) {
		this.gameState = gameState;
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
