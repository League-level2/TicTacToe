import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener{
	Model model;
	View view;
	int player = 1;
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int col = (e.getX()/(TicTacToe.WIDTH/3));
		int row =(e.getY()/(TicTacToe.HEIGHT/3));
		model.makeMove(row, col, 1);
		player ++;
		player = player%2;
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
