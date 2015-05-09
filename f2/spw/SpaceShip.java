package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;    //try catch
import java.awt.Image;        //picture
import javax.imageio.ImageIO;  
import java.io.File;

public class SpaceShip extends Sprite{

	int step = 8;
	private Image space;
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		try{
               space = ImageIO.read(new File("C:\\Users\\Sithinon\\Documents\\spw\\f2\\img\\piv3.png"));
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(space ,x ,y ,width+15,height+10,null);	
	}

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}

}
