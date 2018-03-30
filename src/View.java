import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel{
	Graphics g;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawBoard(g);
	}
	private void drawBoard(Graphics g) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.drawRect(i* TicTacToe.WIDTH/3, j*TicTacToe.HEIGHT/3, TicTacToe.WIDTH/3, TicTacToe.HEIGHT/3);
			}
		}
	}
	void makeMove(int r, int c, String player) {
		g.drawString(player, r*TicTacToe.HEIGHT/3, c);
	}
	
}
