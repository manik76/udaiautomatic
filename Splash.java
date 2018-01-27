/*
       Project:  Udai V1.1
       Date:     May 10, 2009, Sunday, 8:53 AM IST
       Scope:    Displays About Dialog
*/

import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class Splash extends Frame implements Runnable{

Image img1;

Splash()
{
setTitle("Splash");
img1 = getImage("udaisplash1.gif",this);
setSize(300,240);
setVisible(true);

}

public void run()
{
    show();
    for(;;)
    {
        try{Thread.sleep(5000);}
        catch(InterruptedException e){;}
        break;
    }
    hide();

}

public static Image getImage(String name, Component cmp)
{
  Image img = null;
  URLClassLoader urlLoader = (URLClassLoader)cmp.getClass().getClassLoader();
  URL fileLoc  = urlLoader.findResource(name);
  img = cmp.getToolkit().createImage(fileLoc);
  return img;
}

public void paint(Graphics g)
{
   g.drawImage(img1,0,20,this);
}

public static void main(String arg[])
{
Thread sh = new Thread(new Splash());
sh.start();
sh.stop();

}



}





