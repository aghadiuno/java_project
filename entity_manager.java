package Entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import Alpha.Handler;

public class entity_manager {
	private Handler handler;
	private entity_Player player;
	private ArrayList<Entity> entities;
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
				return -1;
			}
			return 1;
		}
	};
	
	
	public entity_manager(Handler handler, entity_Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		
		
		addEntity(player);
	}
	
	public void tick(){
		for(int i =0;i<entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics gr){
		for(Entity e: entities){
				e.render(gr);
			}
	}

	
	public void addEntity(Entity e){
		entities.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public entity_Player getPlayer() {
		return player;
	}

	public void setPlayer(entity_Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
