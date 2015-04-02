package eecs285.proj3.leeyutsu;
import java.io.File;
import java.io.FileFilter;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;

public class WheelSpace {
	private static final int NUM_WHEEL_SPACES = 24;
	File [] fileList;
    File myDir = null;
    ImageIcon Image;
    int i;
    WheelSpace wheelSpaces[];
    //ctor to get wheelspace
    public WheelSpace(int spaceValue,ImageIcon icon)
    {
    i=spaceValue;
    Image=icon;
    }

    //Allocate array for number of spaces, which is set to a constant
    //for now as opposed to being able to change run-to-run
    public WheelSpace(){
    wheelSpaces = new WheelSpace[NUM_WHEEL_SPACES];
    try
    {
      myDir = new File(getClass().getClassLoader().getResource(
                                      "eecs285/proj3/leeyutsu/images").toURI());
    }
    catch (URISyntaxException uriExcep)
    {
      System.out.println("Caught a URI syntax exception");
      System.exit(4); //Just bail for simplicity in this project
    }

    //Loop from 1 to the number of spaces expected, so we can look
    //for files named <spaceNumber>_<value>.jpg.  Note: Space numbers
    //in image filenames are 1-based, NOT 0-based.
    for (i = 1; i <= NUM_WHEEL_SPACES; i++)
    {
      //Get a listing of files named appropriately for an image
      //for wheel space #i.  There should only be one, and this
      //will be checked below.
      fileList = myDir.listFiles(new WheelSpaceImageFilter(i));

      if (fileList.length == 1)
      {
        //System.out.println("Space: " + i + " img: " + fileList[0] +
        //        " val: " + WheelSpaceImageFilter.getSpaceValue(fileList[0]));
        //Index starts at 0, space numbers start at 1 -- hence the "- 1"
        wheelSpaces[i - 1] = new WheelSpace(
                              WheelSpaceImageFilter.getSpaceValue(fileList[0]),
                              new ImageIcon(fileList[0].toString()));
      }
      else
      {
        System.out.println("ERROR: Invalid number of images for space: " + i);
        System.out.println("       Expected 1, but found " + fileList.length);
      }
    }

}
    private static class WheelSpaceImageFilter implements FileFilter
    {
      private static final String IMAGE_EXTENSION = "jpg";
	String prefix;  //The prefix of the filename we're looking
                      //for - what comes before the first underscore

      WheelSpaceImageFilter(int inPref)
      {
        //Sets the prefix member to string version of space number
        prefix = new Integer(inPref).toString();
      }

      //Test whether the file provided should be accepted by our
      //file filter. In the FileFilter interface.
      public boolean accept(File fname)
      {
        boolean isAccepted = false;

        //Accepted if matched "<prefix>_<...>.jpg" where IMAGE_EXTENSION
        //is assumed to be "jpg" for this example
        if (fname.getName().startsWith(prefix + "_") &&
            fname.getName().endsWith("." + IMAGE_EXTENSION))
        {
          isAccepted = true;
        }

        return (isAccepted);
      }

      //Parses the provided filename to determine the dollar value
      //associated with this wheel space image's filename.
      public static int getSpaceValue(File fname)
      {
       int i=fname.toString().lastIndexOf(".");
       int j=fname.toString().lastIndexOf("_");
       if((fname.toString().substring(j+1,i)).equals("loseATurn"))
       {
    	   return -1;
       }
       else if (fname.toString().substring(j+1,i).equals("bankrupt"))
       {
    	   return -2;
       }
       else
       {
    	   return Integer.valueOf(fname.toString().substring(j+1,i)).intValue();
       }
      }

}
    ImageIcon getImage(int paramInt)
    {
    	return wheelSpaces[paramInt].Image;
    }
    int getValue(int index)
    {
    	return wheelSpaces[index].i;
    }

}
