package graphics;

public interface IDrawable {
	
	public final static String PICTURE_PATH = "...";
	public void loadmages(String nm);
	public void drawObject(Graphics g);
	public String getColor();

}
