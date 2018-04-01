import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Controller implements MouseListener {
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
		int col = (e.getX() / (TicTacToe.WIDTH / 3));
		int row = (e.getY() / (TicTacToe.HEIGHT / 3));
		if(model.makeMove(row, col, currentPlayer)) {
			if(model.checkWin(row, col, currentPlayer)) {
				view.showWin();
			}
			if(model.checkDraw()) {
				view.showDraw();
			}
		switchPlayers();
		view.repaint();
		}
		computerPlayer();
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

}
