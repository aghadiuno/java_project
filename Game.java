package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Alpha.Assets;
import Alpha.Display;
import Alpha.Handler;
import Alpha.MouseManager;
import Alpha.SpriteSheet;
import Alpha.key_Manager;

public class Game implements Runnable {
	
	private Display display;
	public String title;
	private int width;
	private int height;
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics gr;
	
	public State gameState;
	public State menuState;
	
	
	private BufferedImage testImage;
	private BufferedImage test;
	private SpriteSheet sheet;
	
	private key_Manager KM;
	private MouseManager mousemanager;
	
	private GameCamera gamecamera;
	
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		KM = new key_Manager();
		mousemanager = new MouseManager();
	}
	 
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(KM);
		display.getFrame().addMouseListener(mousemanager);
		display.getFrame().addMouseMotionListener(mousemanager);
		display.getCanvas().addMouseListener(mousemanager);
		display.getCanvas().addMouseMotionListener(mousemanager);

		Assets.init();
		
		handler = new Handler(this);
		gamecamera = new GameCamera(handler, 0,0);
		
		gameState = new state_Game(handler);
		menuState = new state_Menu(handler);
		State.setState(menuState);
		
		//testImage = ImageLoader.loadImage("/textures/background.png");
		//test = ImageLoader.loadImage("/textures/minimalistmountain.jpg");
		//sheet = new SpriteSheet(test);
	}
	
	private void tick(){
		KM.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		gr = bs.getDrawGraphics();
		gr.clearRect(0,0,width,height);
		
		if(State.getState() != null){
			State.getState().render(gr);
		}
		
		//Draw Start
		
		
		//gr.drawImage(testImage, 0, 0, 300, 300, null);
		
		//gr.drawImage(Assets.land,0,0,300,300, null);****BACKGROUND
		//gr.drawImage(sheet.crop(300, 150, 300, 300), 0, 0, 300,300,null);
		//gr.drawImage(Assets.clapper,m,0,50,60, null);
		
		//Moves Across screen quickly;
		
		//gr.drawImage(Assets.clapper,0,0,50,60, null);****PLAYER
		//Normal clapper chilling on screen
		/*
		gr.setColor(Color.red);
		gr.fillRect(10, 50, 50, 70);
		gr.setColor(Color.BLACK);
		gr.fillRect(60, 50, 50, 70);
		 */
	
		//End Draw
		
		bs.show();
		gr.dispose();
	}
	
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta+= (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;

			
			
			if(delta >= 1){
				tick();
				ticks++;
				delta--;
				render();
			}
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks );
				ticks = 0;
				timer = 0;
			}
		}
	}
	
	public key_Manager getKeyManager(){
		return KM;
	}
	
	public MouseManager getMouseManager(){
		return mousemanager;
	}
	public GameCamera getgamecamera(){
		return gamecamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	public synchronized void start(){
		if(running)
			return;	
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
