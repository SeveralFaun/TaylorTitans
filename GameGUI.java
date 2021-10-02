/*
 * Taylor Titans GUI 
 * Zaid Alsadoon, Jiacheng Liu
 * February 14, 2020
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class GameGUI extends Canvas implements Runnable {
	
	private Thread thread;
	public boolean running = false;
	private Handler handler;
	private HUD hud;
	private Menu menu;
	private ModeSelect modeSelect;
	private CharSelect charSelect;

	
	public STATE gameState = STATE.Menu;
	
	public static void main(String[] args) {
		new GameGUI();
	}

	public GameGUI() {
		handler = new Handler();
		new Window(1280, 720, "Taylor Titans", this);
		menu = new Menu(this, handler);
		modeSelect = new ModeSelect(this, handler);
		charSelect = new CharSelect(this, handler);
		this.addKeyListener(new KeyInput(handler));
		this.addKeyListener(menu);
		this.addMouseListener(modeSelect);
		hud = new HUD();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
	    double amountOfTicks = 60.0;
	    double ns = 1000000000 / amountOfTicks;
	    double delta = 0;
	    long timer = System.currentTimeMillis();
	    int frames = 0;
	    while(running)
	    {
	    	long now = System.nanoTime();
	    	delta += (now - lastTime) / ns;
	        lastTime = now;
	        while(delta >=1)
	        {
	        	tick();
	            delta--;
	        }
	        if(running)
	        	render();
	        frames++;
	       if(System.currentTimeMillis() - timer > 1000)
	       {
	    	   timer += 1000;
	           System.out.println("FPS: "+ frames);
	           frames = 0;
	       }
	    }
	    stop();
	}

	private void tick() {
		handler.tick();
		if(gameState == STATE.Game)
		{
		hud.tick();
		}
	}

	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		g.setColor(new Color(249, 183, 242));
		g.fillRect(0, 0, 1280, 720);
		
		handler.render(g);
		if(gameState == STATE.Menu)
		{
			menu.render(g);
		}
		if(gameState == STATE.ModeSelect)
		{
			modeSelect.render(g);
		}
		if(gameState == STATE.CharSelect)
		{
			charSelect.render(g);
		}
		if(gameState == STATE.Game)
		{
			hud.render(g);
		} 
		
		g.dispose();
		buffer.show();
		
	}
	

	
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

}
