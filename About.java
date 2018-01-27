/*
       Project:  Udai V1.2
       Date:     May 15, 2009, Friday, 8:53 AM IST
       Scope:    Displays About Dialog
*/

import java.awt.*;
import java.io.*;

public class About extends Frame{


About()
{
    setTitle("About");
}

public void paint(Graphics g)
{

  g.setFont(new Font("TimesNewRoman",Font.BOLD,24));
  setBackground(Color.gray);
  g.setColor(Color.orange);
  g.drawString("Udai V1.2",40,100);//3 row adjustment
  g.setColor(Color.green);
  g.drawString("Project TexCAD",40,150);

}


public boolean handleEvent(Event evt){

 if(evt.id == Event.WINDOW_DESTROY)
    {
          hide();
    }
 return super.handleEvent(evt);
}
}





