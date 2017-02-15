package Game;

import Alpha.Handler;
import Entity.Entity;
import Tile.Tile;

public class GameCamera {
	private float xOffset, yOffset;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		
		this.yOffset = yOffset;
	}
	
	
	public void checkBlanckSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() 
				* Tile.tile_width - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() 
					* Tile.tile_width - handler.getWidth();
			
		}
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() 
				* Tile.tile_width - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() 
					* Tile.tile_width - handler.getHeight();
		}
	}

	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() /2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight() /2 + e.getHeight()/2;
		checkBlanckSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlanckSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}