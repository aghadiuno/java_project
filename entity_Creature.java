package Entity;

import java.awt.Graphics;

import Alpha.Handler;
import Tile.Tile;

public class entity_Creature extends Entity{
	public static final int default_health = 10;
	public static final float default_speed = 1.0f;
	
	public static final int default_creature_width = 55;
	public static final int default_creature_height = 67;
	
	protected int health;
	protected float speed;
	
	protected float xmove,ymove;
	
	
	public entity_Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y,width,height);
		health = default_health;
		speed = default_speed;
		
		xmove = 0;
		ymove = 0;
		
	}

	public void moveX(){
		if(xmove > 0){//moving right
			int tx = (int) (x + xmove + bounds.x + bounds.width)/ Tile.tile_width;
			if(!collisionWithTile(tx,(int)(y + bounds.y)/Tile.tile_height)
					&& !collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.tile_height)){
				x+= xmove;
			}else{
				x = tx * Tile.tile_width - bounds.x  - bounds.width -1;
			}
		}else if(xmove < 0){//moving left
			int tx = (int) (x + xmove + bounds.x)/ Tile.tile_width;
			if(!collisionWithTile(tx,(int)(y + bounds.y)/Tile.tile_height)
					&& !collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.tile_height)){
				x+= xmove;
			}else{
				x = tx * Tile.tile_width + Tile.tile_width - bounds.x;
			}
		}
	}
	public void moveY(){
		if (ymove < 0){//up
			int ty = (int)(y + ymove + bounds.y)/ Tile.tile_height;
			
			if(!collisionWithTile((int)(x + bounds.x)/ Tile.tile_width, ty) 
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/ Tile.tile_width, ty)){
				y+= ymove;
			}else{
				y = ty* Tile.tile_height + Tile.tile_height - bounds.y;
			}
		}else if (ymove >0){//down
			int ty = (int)(y + ymove + bounds.y + bounds.height)/ Tile.tile_height;
			
			if(!collisionWithTile((int)(x + bounds.x)/ Tile.tile_width, ty) 
					&& !collisionWithTile((int)(x + bounds.x + bounds.height)/ Tile.tile_width, ty)){
				y+= ymove;
			}else{
				y = ty * Tile.tile_height - bounds.y - bounds.height -1;
			}
		}
	}
	
	public void move(){
		if(!checkEntityCollisions(xmove,0f)){
			moveX();
		}
		if(!checkEntityCollisions(0f,ymove)){
			moveY();
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	
	
	public float getXmove() {
		return xmove;
	}










	public void setXmove(float xmove) {
		this.xmove = xmove;
	}










	public float getYmove() {
		return ymove;
	}










	public void setYmove(float ymove) {
		this.ymove = ymove;
	}










	public int getHealth() {
		return health;
	}










	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics gr) {
		// TODO Auto-generated method stub
		
	}

}
