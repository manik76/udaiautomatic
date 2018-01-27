/*
    Project: Udai V1.4
    Date:    May 19, 2009, Tuesday 8:56 AM IST
    Module:  UdaiApp
    Scope:   Display Logic 
*/



import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class DisplayWarpWeft extends JFrame implements Runnable
{


private Dimension area;
private JPanel drawingpane;

GraphicData gd;

int index = 0;


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


DisplayWarpWeft()
{

setTitle("WarpWeft");

setSize(1024,768);

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


public void savewarpweft()
{

        int width = 3600;
        int height = 3600;
    
        // Create a buffered image in which to draw
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
        // Create a graphics contents on the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

draw(g2d);
    
        // Graphics context no longer needed so dispose it
        g2d.dispose();

		index++;
    
try {
        // Save as PNG
        File file = new File("warpweftimage"+index+".png");
        ImageIO.write(bufferedImage, "png", file);
    
        // Save as JPEG
      //  file = new File("warpweftimage.jpg");
      //  ImageIO.write(bufferedImage, "jpg", file);
    } catch (IOException e) {
    }        
    
}


public void run()
{

 show();

 for(;;)
 {
if(gd.saveflag[2] != 0)
{
gd.saveflag[2]=0;
savewarpweft();
}

        try{Thread.sleep(10000);}
        catch(InterruptedException e){}
//        repaint();
 }
}

public void stop()
{
  Thread th = new Thread(this);
  th.stop();
}

//public void paint(Graphics g)
public void draw(Graphics g)
{


     int dpcount = 0,count1 = 0, widthorheight =0, red =0, green=0,blue=0;
     int x1=0,y1=0,x2=0,y2=0,flag=1;
     int x3=0,y3=0,x4=0,y4=0,flag1=1;
     int xleft=0, yleft=0, width=0, height=0, temp1=0;
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

                                                               

                                   
for(int count5 =0; count5 < widthorheight; count5++)
                                   { 
                                        if(flag == 0)
                                        { 
                                             g.drawLine(x1, y1, 50*gd.numberofweftyarns, y2);
                                             flag = 1; 
                                        }
                                        else 
                                        { 
                                             flag = 0; 

                                        } 
                                        y1++;
                                        y2++;   

}
}
}
}
}    


              for(int count2 = 0; gd.warpdesignpatterncount[count2][0]!=0;count2++)
              {
//System.out.println("Step 1 innerloop "+ gd.warpdesignpatterncount[count2][0]+" "+ count2);
for(int pcount=0;pcount<gd.warpdesignpatterncount[count2][0];pcount++)
{
                   for(int count3 = 1; gd.warpdesignpattern[count2][count3] != 0;count3++)
                   {
//System.out.println("Step 2 innerloop "+ gd.warpdesignpattern[count2][count3]+" "+ count3);
                        for(int count4 = 0; gd.warppatterncolor[gd.warpdesignpattern[count2][count3]-1][count4] != 0;count4+=2)
                        {

                              temp =(double) gd.warpyarn[gd.warppatternyarn[gd.warpdesignpattern[count2][count3]-1][count4+1]-1] * gd.zoomscale;
widthorheight=(int)temp;

                              red=gd.warpcolorred[gd.warppatterncolor[gd.warpdesignpattern[count2][count3]-1][count4]-1];
                              green=gd.warpcolorgreen[gd.warppatterncolor[gd.warpdesignpattern[count2][count3]-1][count4]-1];
                              blue=gd.warpcolorblue[gd.warppatterncolor[gd.warpdesignpattern[count2][count3]-1][count4]-1];
                              g.setColor(new Color(red,green,blue));


                                   for(int count5 =0; count5 < widthorheight; count5++)
                                   { 
                                        if(flag1 == 0)
                                        { 
                                             g.drawLine(x3, y3, x4, 50*gd.numberofwarpyarns);
                                             flag1 = 1; 
                                            
                                        }
                                        else 
                                        { 
                                             flag1 = 0; 
                                        } 
                                        x3++;
                                        x4++;                                    


                                   } 



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