import java.awt.Canvas;
import javax.swing.JFrame;

public class Window extends Canvas{

	public Window(int width, int height, String title, GameGUI game) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
