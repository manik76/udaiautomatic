/*
      Project: Udai V2
      Date:    April, 2013, Wednesday  8:53 AM IST
      Scope:   Centralised in-memory database
      Uses:    *.uda
*/

import java.io.*;
import java.util.Random;

public class ReadGraphicsData  
{

GraphicData gd;

Random random;



//public final String strconfig = "design1.uda";

int [] red = {1,255, 128, 27, 94, 12, 79, 138, 38, 169};
int [] green = {1,255, 128, 46, 37, 80, 77, 21, 135, 177};
int [] blue = {1,255, 128, 216, 13, 14, 13, 151, 140, 1};

void ReadGraphicsData()
{

}


public void ReadData()
{
 
int count1=0;
int count2=0;
int count3=0;

int warppatterncount = 0, warppatternrowcount = 0, warppatternlengthcount1 = 0, 
	warppatternlengthcount2 = 0;

int weftpatterncount = 0, weftpatternrowcount = 0, weftpatternlengthcount1 = 0, 
	weftpatternlengthcount2 = 0;


random = new Random();

warppatterncount = Math.abs(random.nextInt()) % 10 + 1;

warppatternrowcount = Math.abs(random.nextInt()) % 10 + 1;

warppatternlengthcount1 = Math.abs(random.nextInt()) % 5 + 1;

warppatternlengthcount2 = Math.abs(random.nextInt()) % 5 + 1;

weftpatterncount = Math.abs(random.nextInt()) % 10 + 1;

weftpatternrowcount = Math.abs(random.nextInt()) % 10 + 1;

weftpatternlengthcount1 = Math.abs(random.nextInt()) % 5 + 1;

weftpatternlengthcount2 = Math.abs(random.nextInt()) % 5 + 1;

System.out.println(warppatterncount + " " + warppatternrowcount + " " + warppatternlengthcount1 
	+ " " + warppatternlengthcount2);

System.out.println(weftpatterncount + " " + weftpatternrowcount + " " + weftpatternlengthcount1 
	+ " " + weftpatternlengthcount2);

gd.clearall();

gd.numberofwarpyarns = 72;

gd.numberofweftyarns = 72;


for(count2=0; count2 < 10;count2++)
{
gd.warpyarn[count2] = (int)Math.pow(2, (count2 + 1));
System.out.println(" yarn " + gd.warpyarn[count2]);
}

gd.warpyarn[count2+1] = 0;


for(count2=0; count2 < 10;count2++)
{
gd.warpcolorred[count2] = red[count2];
gd.warpcolorgreen[count2] = green[count2];
gd.warpcolorblue[count2] = blue[count2];
System.out.println(gd.warpcolorred[count2]+ " " + gd.warpcolorgreen[count2]+ " " + gd.warpcolorblue[count2]+"\n");
}

gd.warpcolorred[count2+1]=0;
gd.warpcolorgreen[count2+1]=0;
gd.warpcolorblue[count2+1]=0;

for(count2=0;count2 < warppatterncount;count2++)
for(count3=0;count3 < warppatternrowcount;count3+=2)
{
gd.warppatterncolor[count2][count3] = (Math.abs(random.nextInt()) % 10) + 1;
gd.warppatternyarn[count2][count3+1] = (Math.abs(random.nextInt()) % 10) + 1;

System.out.println("color, yarn , count " + count2 + " " +
gd.warppatterncolor[count2][count3]+ "  " + 
gd.warppatternyarn[count2][count3+1]
);
}


gd.warppatterncolor[count2][count3+1]=0;
gd.warppatternyarn[count2][count3+1+1]=0;
gd.warppatterncolor[count2+1][0]=0;
gd.warppatternyarn[count2+1][0]=0;

for(count2=0; count2 < warppatternlengthcount1; count2++,count1++)
{
gd.warpdesignpatterncount[count2][0] = (Math.abs(random.nextInt()) % 200) + 1; 

System.out.println(" patterncount " +
	gd.warpdesignpatterncount[count2][0]
	);
for(count3=1; count3 < warppatternlengthcount2; count3++)
{
gd.warpdesignpattern[count2][count3] = (Math.abs(random.nextInt()) % warppatterncount) + 1; 
System.out.println(" pattern " +
	gd.warpdesignpattern[count2][count3]
	);
}
}

gd.warpdesignpattern[count2][count3+1]=0;
gd.warpdesignpatterncount[count2+1][0]=0;

for(count2=0; count2 < 10;count2++)
{
gd.weftyarn[count2] = (int)Math.pow(2, (count2 + 1));
System.out.println(" yarn " + gd.weftyarn[count2]);
}

gd.weftyarn[count2+1] = 0;

for(count2=0; count2 < 10;count2++)
{
gd.weftcolorred[count2] = red[count2];
gd.weftcolorgreen[count2] = green[count2];
gd.weftcolorblue[count2] = blue[count2];
System.out.println(gd.weftcolorred[count2]+ " " + gd.weftcolorgreen[count2]+ " " + gd.weftcolorblue[count2]+"\n");
}

gd.weftcolorred[count2+1]=0;
gd.weftcolorgreen[count2+1]=0;
gd.weftcolorblue[count2+1]=0;

for(count2=0; count2 < weftpatterncount ;count2++,count1++)
for(count3=0; count3 < weftpatternrowcount ;count3+=2)
{
gd.weftpatterncolor[count2][count3] = (Math.abs(random.nextInt()) % 10) + 1;
gd.weftpatternyarn[count2][count3+1] = (Math.abs(random.nextInt()) % 10) + 1;
System.out.println( "color, yarn count " + count2 + " " +
gd.weftpatterncolor[count2][count3]+ "  " + 
gd.weftpatternyarn[count2][count3+1]
);

}

gd.weftpatterncolor[count2][count3+1]=0;
gd.weftpatternyarn[count2][count3+1+1]=0;
gd.weftpatterncolor[count2+1][0]=0;
gd.weftpatternyarn[count2+1][0]=0;

for(count2=0; count2 < weftpatternlengthcount1;count2++,count1++)
{
gd.weftdesignpatterncount[count2][0] = (Math.abs(random.nextInt()) % 200) + 1;
System.out.println("pattern count "+
	gd.weftdesignpatterncount[count2][0]
	);

for(count3=1; count3 < weftpatternlengthcount2; count3++)
{
gd.weftdesignpattern[count2][count3] = (Math.abs(random.nextInt()) % weftpatterncount) + 1;
System.out.println(" pattern "+
	gd.weftdesignpattern[count2][count3]
	);

}
}

gd.weftdesignpattern[count2][count3+1]=0;
gd.weftdesignpatterncount[count2+1][0]=0;

}

}
