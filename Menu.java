import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends KeyAdapter {
	
	private GameGUI game;
	private Handler handler;
	
	public Menu(GameGUI game, Handler handler)
	{
		this.game = game;
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_X && game.gameState == STATE.Menu)
		{
			game.gameState = STATE.ModeSelect;
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(249, 183, 242));
		g.fillRect(0, 0, 1280, 720);
		g.setColor(new Color(237, 237, 237));
		g.setFont(new Font("Consolas", Font.BOLD, 35));
		g.drawString("Press 'X' to Start", 465, 525);
	}
	
}
