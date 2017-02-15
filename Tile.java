package Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tiles = new Tile[256];
	public static Tile hardstone = new tile_hardstone(0);
	public static Tile grass = new tile_grass(1);
	
	
	public static final int tile_width = 30;
	public static final int tile_height = 30;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture , int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	
	public int getId(){
		return id;
	}
	
	
	public boolean isSolid(){
		return true;
	}
	
	
	public void tick(){
		
	}
	public void render(Graphics gr, int x, int y){
		gr.drawImage(texture, x, y, tile_width, tile_height,null);
	}
	



}
