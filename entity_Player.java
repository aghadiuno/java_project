package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Alpha.Animation;
import Alpha.Assets;
import Alpha.Handler;

public class entity_Player extends entity_Creature{
	
	
	private Animation animDown, animLeft, animRight, animUp;
	
	public entity_Player(Handler handler, float x, float y) {
		super(handler, x, y, entity_Creature.default_creature_width, entity_Creature.default_creature_height);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}
	
	public void tick() {
		
		/*
		if(game.getKeyManager().up)
			y -=3;
		if(game.getKeyManager().down)
			y +=3;
		if(game.getKeyManager().left)
			x-=3;
		if(game.getKeyManager().right)
			x+=3;	
		*/
		
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		getInput();
		move();
		handler.getgamecamera().centerOnEntity(this);
		
	}
	
	private void getInput(){
		xmove = 0;
		ymove = 0;
		
		if(handler.getKeyManager().up)
			ymove = -speed;
		if(handler.getKeyManager().down)
			ymove = speed;
		if(handler.getKeyManager().left)
			xmove = -speed;
		if(handler.getKeyManager().right)
			xmove = speed;
	}

	public void render(Graphics gr) {
		//gr.drawImage(Assets.land, 0,0, null);
		gr.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getgamecamera().getxOffset()), (int)(y - handler.getgamecamera().getyOffset()), null);
		//gr.drawImage(Assets.cobblestone, 0, 0, null);
		//cobble stone
		//gr.drawImage(Assets.hardstone, 50,50, null);	
		//hard stone
		
		//gr.drawImage(Assets.enemy, (int)x,(int)y, null);
		//gr.setColor(Color.red);
		//gr.fillRect((int)(x + bounds.x - handler.getgamecamera().getxOffset()), 
				//(int)(y + bounds.y - handler.getgamecamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xmove < 0){
			return animLeft.getCurrentFrame();
		}else if(xmove > 0){
			return animRight.getCurrentFrame();
		}else if(ymove < 0){
			return animUp.getCurrentFrame();
		}else if(ymove > 0){
			return animDown.getCurrentFrame();
		}else{
			return Assets.clapper;
		}
	}
}
