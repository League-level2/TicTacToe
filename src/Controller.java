import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Controller implements MouseListener, KeyListener {
	Model model;
	View view;
	static final int PLAYER1 = 1;
	static final int PLAYER2 = 2;
	int currentPlayer = PLAYER1;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	void updateView() {
		int[][] board = model.getBoard();
		view.setBoard(board);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (view.gameState == GameState.PLAY) {
			int col = (e.getX() / (TicTacToe.WIDTH / 3));
			int row = (e.getY() / (TicTacToe.HEIGHT / 3));
			if(model.makeMove(row, col, currentPlayer)) {
//				if(model.checkWin(row, col, currentPlayer)) {
//					view.showWin();
//				}
//				if(model.checkDraw()) {
//					view.showDraw();
//				}
				if (model.checkWin(row, col, currentPlayer) || model.checkDraw()) {
					view.setCurrentState(GameState.END);
					view.repaint();
					model.resetBoard();
					//updateView();
				}
			switchPlayers();
			view.repaint();
			}
			computerPlayer();
		}
	}

	void computerPlayer(){
		while(model.makeMove(new Random().nextInt(3), new Random().nextInt(3), currentPlayer)==false) {
			
			}
		switchPlayers();
	
	}
	
	void switchPlayers() {
		if(currentPlayer == PLAYER1) {
			currentPlayer = PLAYER2;
		} else {
			currentPlayer = PLAYER1;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (view.gameState == GameState.MENU) {
				view.setCurrentState(GameState.PLAY);
				view.repaint();
			} else if (view.gameState == GameState.END) {
				view.setCurrentState(GameState.MENU);
				view.repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
