package Game;

import java.awt.Color;
import java.awt.Graphics;

import Alpha.Handler;

public class state_Menu extends State {

	
	public state_Menu(Handler handler){
		super(handler);
	}
	
	@Override
	public void tick() {
		
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()){
			State.setState(handler.getGame().gameState);
		}
		/*
		System.out.println(handler.getMouseManager().getMouseX()
				+ " " + handler.getMouseManager().getMouseY()  );
		*/
	}

	@Override
	public void render(Graphics gr) {
			gr.setColor(Color.MAGENTA);
			
			gr.fillRect(handler.getMouseManager().getMouseX(), 
					handler.getMouseManager().getMouseY(), 
						8, 8);
	}

}
