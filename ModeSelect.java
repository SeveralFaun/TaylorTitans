import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModeSelect extends MouseAdapter {

	private GameGUI game;
	private Handler handler;
	
	public ModeSelect(GameGUI game, Handler handler)
	{
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 100, 100, 100, 100) && game.gameState == STATE.ModeSelect) {
			game.gameState = STATE.CharSelect;
			handler.addObject(new Selector1(50, 50, ID.Selector1, handler));
			handler.addObject(new Selector2(100, 100, ID.Selector2, handler));
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(237, 237, 237));
		g.drawRect(100, 100, 100, 100);
	}
}
