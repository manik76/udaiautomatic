/*
    Project: Udai V1.1
    Date:    May 10, 2009, Sunday 8:56 AM IST
    Module:  UdaiApp
    Scope:   Starting class for the package from which
             ui module is started as a separate
             thread 
*/



import java.awt.*;

public class UdaiApp{

Thread thmainwindow, thsplash;

UdaiApp()
{

  Thread thsplash = new Thread(new Splash());
  thsplash.start();

  Thread thmainwindow = new Thread(new MainWindow());
  thmainwindow.start();

  
}

public static void main(String args[])
{

     UdaiApp udaiapp = new UdaiApp();
    
}

}