import java.awt.Dimension;

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
		view.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		Controller controller = new Controller(model, view);
		controller.updateView();
		gameWindow.add(view);
		gameWindow.setVisible(true);
		gameWindow.pack();
		view.repaint();
		view.addMouseListener(controller);
		gameWindow.addKeyListener(controller);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
