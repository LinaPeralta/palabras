import processing.core.PApplet;

public class word 
{
	private int posX, posY;
	private String value;
	boolean isActive;
	private int r, g, b;
	
	public word(int posX, int posY, String value) 
	{
		this.posX = posX;
        this.posY = posY;
        this.value = value;

        isActive = false;
        
        r = 0;
        g = 0;
        b = 0;
	}
	
	public void paint(PApplet app)
	{
		app.fill(r, g, b);
		app.text(value, posX, posY);
		posY++;
	}
	
	public int getPosX() 
	{
		return posX;
	}
	
	public int getPosY() 
	{
		return posY;
	}
	
	public void setPosX(int posX) 
	{
		this.posX = posX;
	}
	
	public void setPosY(int posY) 
	{
		this.posY = posY;
	}
	
	public void setActive(boolean active) 
	{
		this.isActive = active;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public int getR() {
		return r;
	}
	
	public int getG() {
		return g;
	}
	
	public int getB() {
		return b;
	}
	
	public void setR(int r) {
		this.r = r;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	
}
