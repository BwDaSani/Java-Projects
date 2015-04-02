
public class LocationClass {
	double xVal;
	double yVal;
	
  public LocationClass()
  {
	  xVal=0;
	  yVal=0;
  }
  public LocationClass(double inX, double inY)
  {
	  xVal=inX;
	  yVal=inY;
  }
  public String toString()
  {
	  return "("+xVal+", "+yVal+")";
  }
  public void  adjustX(double amount)
  {
	  xVal=xVal+amount;
  }
  public void adjustY(double amount)
  {
	  yVal=yVal+amount;
  }
  
}
