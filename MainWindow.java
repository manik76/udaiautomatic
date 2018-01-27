/*

    Project: Udai V1.2
    Date:    May 10,2009, Sunday, 8:53 AM IST
    Scope:   Display Menus and Activate Each Window
    Uses:    GraphicData, DisplayWarpWeft,
             Help, About
*/



import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class MainWindow extends Frame implements Runnable{

MenuBar mbar = new MenuBar();

Menu     file            = new Menu("File");
MenuItem new1             = new MenuItem("New");
MenuItem open            = new MenuItem("Open Design");
MenuItem load             = new MenuItem("Change Colour");
MenuItem save             = new MenuItem("Save");
MenuItem print             = new MenuItem("Print");
MenuItem exit            = new MenuItem("Exit");

Menu     show            = new Menu("Display");
MenuItem warp            = new MenuItem("Warp");
MenuItem weft            = new MenuItem("Weft");
MenuItem warpweft        = new MenuItem("Warp Weft");

Menu     zoom            = new Menu("Zoom");
MenuItem quarterx        = new MenuItem("QuarterX");
MenuItem halfx           = new MenuItem("HalfX");
MenuItem x1x              = new MenuItem("1X");
MenuItem x2x              = new MenuItem("2X");
MenuItem x3x              = new MenuItem("3X");


Menu     help            = new Menu("Help");
MenuItem tutorials            = new MenuItem("Tutorials");
MenuItem about            = new MenuItem("About");

public GraphicData gd;

ReadGraphicsData rd;
String filename ="design1.uda";
Boolean stopflag = false;

Thread thwarp, thweft, thwarpweft;

Help hlp;
About abt;

final JFileChooser fc = new JFileChooser();

MainWindow(){

     rd = new ReadGraphicsData();
     mbar.add(file);
     mbar.add(show);
     mbar.add(zoom);
     mbar.add(help);
     file.add(new1);
     file.add(open);
     file.add(load);
     file.add(save);
     file.add(print);
     file.add(exit);
     show.add(warp);
     show.add(weft);
     show.add(warpweft);
     zoom.add(quarterx);
     zoom.add(halfx);
     zoom.add(x1x);
     zoom.add(x2x);
     zoom.add(x3x);
     help.add(tutorials);
     help.add(about);

     setMenuBar(mbar);
     setSize(1024,768);
}

public void run()
{
 show();     
 for(;;)
      {
	try{Thread.sleep(1000);}	         
	catch(InterruptedException e){}
      }
}

public void paint(Graphics g)
{

     setBackground(Color.gray);
     setTitle("Udai");
    
}


public boolean action(Event evt, Object arg){
     String label = (String)arg;
     if(evt.target instanceof MenuItem)
        {
           if(label.equals("New"))
             {
               
             }
           if(label.equals("Print"))
             {
               
             }
           if(label.equals("Save"))
             {
               gd.saveflag[0] = 1;
gd.saveflag[1] = 1;
gd.saveflag[2] = 1;
             }
           if(label.equals("Change Colour"))
             {
/*                   int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filename=file.getName();
        } else {
            filename="color.col";
}
rd.changecolour(filename);
*/               
             }

           if(label.equals("Open Design"))
             {
/*                   int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filename=file.getName();
        } else {
            filename="design1.uda";
}
*/
 
            DisplayWarpWeft dww = new DisplayWarpWeft();   
            for(int count2 = 0; count2 < 100000; count2++)
				 {
                    rd.ReadData();
					dww.savewarpweft();
				 }
             }

           if(label.equals("Exit"))
             {
                 hide();
                 System.exit(0);
             }
           if(label.equals("Warp"))
             {

Thread thwarp = new Thread(new DisplayWarp());
thwarp.start();
System.out.println("warp");
              
             }

           if(label.equals("Weft"))
             {
Thread thweft = new Thread(new DisplayWeft());
thweft.start();
System.out.println("weft");
             }
           if(label.equals("Warp Weft"))
             {
Thread thwarpweft = new Thread(new DisplayWarpWeft());
thwarpweft.start();
System.out.println("warp weft");
             }

           if(label.equals("QuarterX"))
             {
System.out.println("QuarterX");               
gd.zoomscale = 0.25;
             }

           if(label.equals("HalfX"))
             {
System.out.println("HalfX");               
gd.zoomscale = 0.5;
             }

           if(label.equals("1X"))
             {
System.out.println("1X");               
gd.zoomscale = 1.0;
              
             }
           if(label.equals("2X"))
             {
System.out.println("2X");               
gd.zoomscale = 2.0;
              
             }

           if(label.equals("3X"))
             {
System.out.println("QuarterX");               
gd.zoomscale = 3.0;
              
             }

           if(label.equals("Tutorials"))
             {
hlp = new Help();
hlp.show();               
             }

           if(label.equals("About"))
             {
                   abt = new About();
                   abt.setSize(300,200);
                   abt.show();
              
             }



        }
        return true;
}

public boolean handleEvent(Event evt){

      if(evt.id == Event.WINDOW_DESTROY)
             {
                hide();
                System.exit(0);
             }
      return super.handleEvent(evt);
}

}
