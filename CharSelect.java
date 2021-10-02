import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CharSelect {
	
	private GameGUI game;
	private Handler handler;
	
	public CharSelect(GameGUI game, Handler handler)
	{
		this.game = game;
		this.handler = handler;
	}
	
	//handler.addObject(new Player1(50, 50, ID.Player1, handler));
	//handler.addObject(new Player2(100, 100, ID.Player2, handler));
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(237, 237, 237));
		g.drawRect(100, 100, 100, 100);
	}
}

