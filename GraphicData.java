/*
    Project: Udai V1.4
    Date:    May 18, 2009, Tuesday 8:56 AM IST
    Module:  UdaiApp
    Scope:   Data details 
*/

public class GraphicData
{

public static int saveflag[] = {0,0,0};

public static int numberofwarpyarns=72;
public static int numberofweftyarns=72;

public static int warpyarn[] = new int[50];

public static int warpcolorred[] = new int[50];
public static int warpcolorgreen[] = new int[50];
public static int warpcolorblue[] = new int[50];

public static int warppatterncolor[][] = new int[50][50];
public static int warppatternyarn[][] = new int[50][50];

public static int warpdesignpatterncount[][] = new int[50][50];
public static int warpdesignpattern[][] = new int[50][50];

public static int weftyarn[] = new int[50];

public static int weftcolorred[] = new int[50];
public static int weftcolorgreen[] = new int[50];
public static int weftcolorblue[] = new int[50];

public static int weftpatterncolor[][] = new int[50][50];
public static int weftpatternyarn[][] = new int[50][50];

public static int weftdesignpatterncount[][] = new int[50][50];
public static int weftdesignpattern[][] = new int[50][50];

public static double zoomscale = 1.0;


public GraphicData()
{
}

public  static void clearall()
{

 numberofwarpyarns=72;
 numberofweftyarns=72;


clearcolour();

for(int col = 0;col<50;col++)
{

 warpyarn[col] = 0;

 weftyarn[col] = 0;
}


for(int row = 0;row<50;row++)
{
for(int col = 0;col<50;col++)
{

 warppatterncolor[row][col] = 0;
 warppatternyarn[row][col] = 0;

 warpdesignpatterncount[row][col] = 0;
 warpdesignpattern[row][col] = 


 weftpatterncolor[row][col] = 0;
 weftpatternyarn[row][col] = 0;

 weftdesignpatterncount[row][col] = 0;
 weftdesignpattern[row][col] = 0;
}
}


zoomscale = 1.0;


}

public static void clearcolour()
{
for(int col = 0;col<50;col++)
{

 weftcolorred[col] = 0;
 weftcolorgreen[col] = 0;
 weftcolorblue[col] = 0;

 warpcolorred[col] = 0;
 warpcolorgreen[col] = 0;
 warpcolorblue[col] = 0;
}

}


}
