package Game;

import java.awt.Graphics;

import Alpha.Handler;
import Alpha.Utils;
import Entity.entity_Player;
import Entity.entity_manager;
import Tile.Tile;
import Tile.tile_Tree;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	//entities
	private entity_manager em;
	//
	private int[][] tiles;

	public World(Handler handler, String path){
		this.handler = handler;
		em = new entity_manager(handler, new entity_Player(handler,100,100));
		em.addEntity(new tile_Tree(handler, 170, 430));
		em.addEntity(new tile_Tree(handler, 2, 430));

		
		loadWorld(path);
		
		em.getPlayer().setX(spawnX);
		em.getPlayer().setY(spawnY);
		
	}
	
	public entity_manager getEm() {
		return em;
	}

	public void setEm(entity_manager em) {
		this.em = em;
	}

	public void tick(){
		em.tick();
		
	}
	
	public void render(Graphics gr){
		int xStart = (int)Math.max(0,handler.getgamecamera().getxOffset()/ Tile.tile_width);
		int xEnd = (int) Math.min(width, (handler.getgamecamera().getxOffset()+handler.getWidth())/ Tile.tile_width+1);
		int yStart = (int)Math.max(0,handler.getgamecamera().getyOffset()/ Tile.tile_height);
		int yEnd = (int) Math.min(height, (handler.getgamecamera().getyOffset()+handler.getHeight())/ Tile.tile_height+1);
		
		for(int y=yStart; y<yEnd;y++){
			for(int x = xStart; x< xEnd; x++){
				getTile(x,y).render(gr, (int)(x*Tile.tile_width - handler.getgamecamera().getxOffset()),(int) (y*Tile.tile_height - handler.getgamecamera().getyOffset()));
				//sized the tiles to the screen
			}
		}
		em.render(gr);
	}
	
	public Tile getTile(int x, int y){
		
		if(x<0 || y< 0 || x>=width || y>=height){
			return Tile.grass;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.hardstone;
		return t;
	}
	
	private void loadWorld(String path) {
		/*
		
		width = 10;
		height = 10;
		
		tiles = new int[width][height];
		
		for(int x=0; x<width;x++){
			for(int y = 0; y< height; y++){
				tiles[x][y] = 1;
			}
		}
		*/
		String file = Utils.load_file_asString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0;y<height;y++){
			for(int x = 0; x<width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width) +4]);
			}
		}
		
		
		
	}
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
