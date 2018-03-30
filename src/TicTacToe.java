import javax.swing.JFrame;

public class TicTacToe {
	public static final int WIDTH =500;
	public static final int HEIGHT = 500;
	JFrame gameWindow = new JFrame();
	public static void main(String[] args) {
		new TicTacToe();
	}
	public TicTacToe() {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		gameWindow.setSize(WIDTH, HEIGHT);
		gameWindow.add(view);
		gameWindow.setVisible(true);
		view.repaint();
		view.addMouseListener(controller);
	}
}
