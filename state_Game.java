package Game;

import java.awt.Graphics;

import Alpha.Handler;
import Entity.entity_Player;
import Tile.tile_Tree;

public class state_Game extends State{
	private entity_Player player;
	private World world;
	private tile_Tree tree;
	
	
	
	public state_Game(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	
		
		
		
	}
	
	@Override
	public void tick() {
		world.tick();;
		
		
		
		
	}

	@Override
	public void render(Graphics gr) {
		//gr.drawImage(Assets.land, 0, 0, 300,300,null);
		world.render(gr);
		
		//Tile.tiles[0].render(gr, 0, 0);
	}
	
}
