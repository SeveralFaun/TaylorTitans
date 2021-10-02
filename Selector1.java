import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Selector1 extends GameObject {
	
	Handler handler;

	public Selector1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = GameGUI.clamp(x, 0, 1280);
		y = GameGUI.clamp(y, 0, 720);
		collision();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			//if(tempObject.getId() == ID.Player2)
			//{
			//	if(getBounds().intersects(tempObject.getBounds()))
			//	{
		
			//	}

		//	}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x,  y, 32, 32);
	}


}
