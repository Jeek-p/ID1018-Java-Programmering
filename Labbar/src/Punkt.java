
public class Punkt 
{
	private String namn;
	private int x;
	private int y;
	
	public Punkt (String namn, int x, int y)
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}
	
	public String toString ()
	{
		String s = this.namn + "(" + this.x + "," + this.y + ")";
		return s;
	}
	
	public String getNamn ()
	{
		return namn;
	}
	
	public int getX ()
	{
		return x;
	}
	
	public int getY ()
	{
		return y;
	}
	
	public double avstånd (Punkt p)
	{
		double	d = 0;
		
		d = Math.sqrt ((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
		
		return d;
	}
	
	public void setX (int x)
	{
		this.x = x;
	}
	
	public void setY (int y)
	{
		this.y = y;
	}
	
	
	public Punkt (Punkt p)
	{
		this.namn = p.getNamn();
		this.x = p.getX();
		this.y = p.getY();
	}
}
