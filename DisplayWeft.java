/*
    Project: Udai V1.4
    Date:    May 18, 2009, Tuesday 8:56 AM IST
    Module:  UdaiApp
    Scope:   Display Logic 
    Programmer: Er. K. Manigandan
*/




import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class DisplayWeft extends JFrame implements Runnable
{

private Dimension area;
private JPanel drawingpane;

GraphicData gd;


public class DrawingPane extends JPanel implements MouseListener
{

DrawingPane()
{

addMouseListener(this);

}

protected void paintComponent(Graphics g)
{

super.paintComponent(g);

draw(g);

}

public void mouseReleased(MouseEvent e) {

System.out.println("Mouse Released");

}

public void mouseClicked(MouseEvent e){
System.out.println("Mouse Clicked");
}

public void mouseEntered(MouseEvent e){}

public void mouseExited(MouseEvent e){}

public void mousePressed(MouseEvent e){
System.out.println("Mouse pressed");
}


}


DisplayWeft()
{

setTitle("Weft");

setSize(800,600);

DrawingPane drawingpane = new DrawingPane();

JComponent newContentPane = new DrawingPane();

newContentPane.setOpaque(true); //content panes must be opaque

setContentPane(newContentPane);

JScrollPane scroller = new JScrollPane(drawingpane);

scroller.setPreferredSize(new Dimension(500, 500));

Rectangle rect = new Rectangle(0, 0, 10,10);



add(scroller, BorderLayout.CENTER);
drawingpane.scrollRectToVisible(rect);

drawingpane.setPreferredSize(new Dimension(4000,4000));
            
drawingpane.revalidate();

pack();

setVisible(true);

}


public void saveweft()
{

        int width = 1600;
        int height =1200;
    
        // Create a buffered image in which to draw
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
        // Create a graphics contents on the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

draw(g2d);
    
        // Graphics context no longer needed so dispose it
        g2d.dispose();
    
try {
        // Save as PNG
        File file = new File("weftimage.png");
        ImageIO.write(bufferedImage, "png", file);
    
        // Save as JPEG
        file = new File("weftimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);
    } catch (IOException e) {
    }        
    
}



public void run()
{


 show();
 for(;;)
 {

if(gd.saveflag[1] != 0)
{
gd.saveflag[1]=0;
saveweft();
}

        try{Thread.sleep(10000);}
        catch(InterruptedException e){}
        repaint();
 }
}

public void stop()
{
  Thread th = new Thread(this);
  th.stop();
}


public void draw(Graphics g)
{

     int dpcount = 0,count1 = 0, widthorheight =0, red =0, green=0,blue=0;
     int x1=0,y1=0,x2=0,y2=0,flag=1;
     int xleft=0, yleft=0, width=0, height=0;
     Color c = new Color(0,0,0);
double temp=0;
              for(int count2 = 0; gd.weftdesignpatterncount[count2][0]!=0;count2++)
              {
for(int pcount=0;pcount<gd.weftdesignpatterncount[count2][0];pcount++)
{
                   for(int count3 = 1; gd.weftdesignpattern[count2][count3] != 0;count3++)
                   {
                        for(int count4 = 0; gd.weftpatterncolor[gd.weftdesignpattern[count2][count3]-1][count4] != 0;count4+=2)
                        {

                              temp =(double) gd.weftyarn[gd.weftpatternyarn[gd.weftdesignpattern[count2][count3]-1][count4+1]-1] * gd.zoomscale;

                     widthorheight=(int)temp;

                              red=gd.weftcolorred[gd.weftpatterncolor[gd.weftdesignpattern[count2][count3]-1][count4]-1];
                              green=gd.weftcolorgreen[gd.weftpatterncolor[gd.weftdesignpattern[count2][count3]-1][count4]-1];
                              blue=gd.weftcolorblue[gd.weftpatterncolor[gd.weftdesignpattern[count2][count3]-1][count4]-1];
                              g.setColor(new Color(red,green,blue));
System.out.println("count design pattern yarn color" +gd.weftdesignpatterncount[count2][0]+" "+
gd.weftdesignpattern[count2][count3]+" "+
gd.weftpatternyarn[gd.weftdesignpattern[count2][count3]-1][count4+1]+" "+
 widthorheight+ " "+red+ " "+green+ " "+blue);                              
                                   g.fillRect(xleft, yleft, 50*gd.numberofweftyarns,widthorheight);
                                   yleft = yleft + widthorheight;



                        }


                   }

               }    
              }

}


public boolean handleEvent(Event evt)
{

 if(evt.id == Event.WINDOW_DESTROY)
             {
                     hide();
                     this.stop();
             } 
 return super.handleEvent(evt);
 }

}