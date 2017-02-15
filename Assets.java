package Alpha;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage clapper, land, enemy, grass, hardstone, 
									maria, test, tree1, tree2;
	
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	private static final int width = 58, height = 67;
	
	public static void init(){
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/char_Malcom_Mortel.png"));
		//SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/minimalistmountain.jpg"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/blonde_elite.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/tile_sheet.jpg"));
		SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/textures/char_Maria_Mortel.png"));
		SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage("/textures/set_of_trees.png"));
		
		clapper = sheet1.crop(0, height*2, width, height);
		
		
		//land = sheet2.crop(300, 150, 300, 300);
		enemy = sheet3.crop(57,303,width,height);
		grass = sheet4.crop(30, 128, 30, 30);
		hardstone = sheet4.crop(193, 3, 30, 30);
		maria = sheet5.crop(55, 70, width, height);
		
		tree1 = sheet6.crop(186, 0, 186, height+200);//Fall Tree
		tree2 = sheet6.crop(0, 0, 186, height+200);//Summer Tree
		
		//test = sheet1.crop(width*2 + 4, height*9 -21, width, height);
		
		
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
 		
		player_down[0] = sheet1.crop(width*2 + 15, height*10 -21, width, height);
		player_down[1] = sheet1.crop(width*6 + 40, height*10 -21, width, height);
		//player_down[2] = sheet1.crop(0+5, height*10 -21, width, height);
		
		player_up[0] = sheet1.crop(width*2 +11 , height*8 -21, width, height);
		player_up[1] = sheet1.crop(width*6 + 37, height*8 -21, width, height);
		//player_up[2] = sheet1.crop(0, height*8 -21, width, height);
		
		player_left[0] = sheet1.crop(width*1 + 4, height*9 -21, width, height);
		//player_left[1] = sheet1.crop(width*2 + 7, height*9 -21, width, height);
		player_left[1] = sheet1.crop(width*5 + 30, height*9 -21, width, height);
		
		player_right[0] = sheet1.crop(width*1 + 4, height*11 -21, width, height);
		player_right[1] = sheet1.crop(width*5 + 30, height*11 -21, width, height);
		//player_right[2] = sheet1.crop(width*1 + 4, height*11 -21, width, height);
		//player_right[3] = sheet1.crop(0, height*11 -21, width, height);
		
	}
}
