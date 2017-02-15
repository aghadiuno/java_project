package Tile;

import Alpha.Assets;

public class tile_hardstone extends Tile{

	
	public tile_hardstone(int id){
		super(Assets.hardstone,id);
	}
	
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
