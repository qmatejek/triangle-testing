public class Point 
{
	private double xCoord;
	private double yCoord;

	public Point(){}

	public Point(double x, double y)
	{
		xCoord = x;
		yCoord = y;
	}
	
	public void setX(double x)
	{
		xCoord = x;
	}
	
	public void setY(double y)
	{
		yCoord = y;
	}
	
	public double getX()
	{
		return xCoord;
	}
	
	public double getY()
	{
		return yCoord;
	}
	
	
}
