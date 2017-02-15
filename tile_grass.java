package Tile;

import Alpha.Assets;

public class tile_grass extends Tile {

	
	public tile_grass(int id){
		super(Assets.grass,id);
	}
	
	
	@Override
	public boolean isSolid(){
		return false;
	}
}
