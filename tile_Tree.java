package Tile;

import java.awt.Graphics;

import Alpha.Assets;
import Alpha.Handler;
import Entity.entity_static;

public class tile_Tree extends entity_static{

	public tile_Tree(Handler handler, float x, float y) {
		super(handler,x,y,Tile.tile_width*4, Tile.tile_height*4);
		
		bounds.x = 60;
		bounds.y = (int)(height / 1.5f);
		bounds.width = width/2;
		bounds.height = (int)(height - height / 1.5f);
		
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics gr) {
		gr.drawImage(Assets.tree1, (int)(x-handler.getgamecamera().getxOffset()) ,(int)(y - handler.getgamecamera().getyOffset()), width, height,null);
	}
	
	
	
}
