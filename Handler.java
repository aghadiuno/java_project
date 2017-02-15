package Alpha;

import java.awt.Rectangle;

import javax.net.ssl.KeyManager;

import Game.Game;
import Game.GameCamera;
import Game.World;

public class Handler {
	private Game game;
	private World world;
	protected Rectangle bounds;
	
	public Game getGame() {
		return game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public GameCamera getgamecamera(){
		return game.getgamecamera();
	}
	
	public key_Manager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Handler(Game game){
		this.game = game;
	}
}
