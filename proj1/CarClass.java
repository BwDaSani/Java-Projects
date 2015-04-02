
public class CarClass {
	String brand;
	String plate;
	LocationClass location;
	double speed;
	char direction;
	
	public CarClass(String inBrand, String inPlate)
	{
		brand=inBrand;
		plate=inPlate;
		location=new LocationClass();
		speed=0;
		direction='N';
	}
	public boolean adjustSpeed (double adjustment)
	{
		boolean bool;
		if (speed+adjustment>100 || speed+adjustment<0)
		{
			bool=false;
			return bool;
		}
		else
		{
			speed=speed+adjustment;
			bool=true;
			return bool;
		}
	}
	public void turnRight()
	{
		if (direction=='N')
		{
			direction='E';
		}
		else if (direction=='E')
		{
			direction='S';
		}
		else if (direction=='S')
		{
			direction='W';
		}
		else
		{
			direction='N';
		}
	}
	public void turnLeft()
	{
		if (direction=='N')
		{
			direction='W';
		}
		else if (direction=='E')
		{
			direction='N';
		}
		else if (direction=='S')
		{
			direction='E';
		}
		else
		{
			direction='S';
		}
	}
	
	public String toString()
	{
		String dfull;
		if (direction=='N')
		{
			dfull="NORTH";
		}
		else if (direction=='E')
		{
			dfull="EAST";
		}
		else if (direction=='S')
		{
			dfull="SOUTH";
		}
		else
		{
			dfull="WEST";
		}
		return brand+" plate: "+	plate +" loc: "+location.toString()+" dir: "+dfull+" speed: "+speed;
	}
	public void advance(double time)
	{
		if (time<=0)
		{
			
		}
		else
		{
			if (direction=='N')
			{
				location.adjustY(time*speed);
			}
			else if (direction=='E')
			{
				location.adjustX(time*speed);
			}
			else if (direction=='S')
			{
				location.adjustY(-(time*speed));
			}
			else
			{
				location.adjustX(-(time*speed));
			}
				
		}
	}
}
