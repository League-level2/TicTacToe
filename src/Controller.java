import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {
	Model model;
	View view;
	int turn = 0;

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
		int player = turn + 1;
		if(model.makeMove(row, col, player)) {
		turn++;
		turn = turn % 2;
		}
		view.repaint();
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
