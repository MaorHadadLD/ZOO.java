package graphics;

import java.awt.Graphics;

public interface IDrawable {
	
	public final static String PICTURE_PATH = "C://Users//maorh//git//ZOO.java//Zoo//src//graphics//";
	public void loadmages(String nm);
	public void drawObject(Graphics g);
	public String getColor();
	

}
