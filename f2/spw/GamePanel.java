package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.io.IOException;    //try catch
import java.awt.Image;        //picture
import javax.imageio.ImageIO;  
import java.io.File;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private Image pic1;

	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		//big.setBackground(Color.BLUE);
		
		try {
			
			pic1 = ImageIO.read(new File("C:\\Users\\Sithinon\\Documents\\spw\\f2\\img\\piv.jpg"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
	
	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		big.drawImage(pic1,0, 0,600,650,this);
		big.setColor(Color.RED);
	    big.drawString(String.format("%08d", reporter.getScore()), 320, 20);
		big.drawString(String.format("Level = %d", reporter.getLevel()), 20, 20);

		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
