import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health1 = 100, health2 = 100;
	
	public void tick() {
		
		health1 = GameGUI.clamp(health1, 0, 100);
		health2 = GameGUI.clamp(health2, 0, 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 600, 32);
		g.fillRect(655, 15, 600, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, health1*6, 32);
		g.fillRect(655, 15, health2*6, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 600, 32);
		g.drawRect(655, 15, 600, 32);
	}

}
