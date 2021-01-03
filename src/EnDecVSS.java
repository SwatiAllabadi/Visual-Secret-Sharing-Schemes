import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.*;

public class EnDecVSS
{

	private static Image im1,im2,im3;
	static Image encrypt1,encrypt2,encrypt3;
	static int w,h,w1,h1,i,j,r,r2,x,p1,q1;
	static int[] pix1,pix2,pix3,pixx1,pixx2,pixx3;
	static int[][] a,temp,b,c,ck1,ck2,ck3;
	
	static int sum1,sum2,sum3;
	static int[] pixe1,pixe2,pixe3;
	static int[][] de1,de2,de3,temp1;
	static Image decrypt1,decrypt2,decrypt3;
	
	public static Image[] encrypt(Image im1, Image im2, Image im3, VSS s)
	{
	
		try
		{	
			
			
			MediaTracker t1 = new MediaTracker(s);
			MediaTracker t2 = new MediaTracker(s);
			MediaTracker t3 = new MediaTracker(s);
			t1.addImage(im1,0);
			t1.waitForID(0);
			t2.addImage(im2,0);
			t2.waitForID(0);
			t3.addImage(im3,0);
			t3.waitForID(0);
			w1=im1.getWidth(null);
			h1 = im1.getHeight(null);
			System.out.println(w1);
			pix1 = new int[w1*h1];
			pix2 = new int[w1*h1];
			pix3 = new int[w1*h1];
			PixelGrabber pg1 = new PixelGrabber(im1,0,0,w1,h1,pix1,0,w1);
			pg1.grabPixels();
			PixelGrabber pg2 = new PixelGrabber(im2,0,0,w1,h1,pix2,0,w1);
			pg2.grabPixels();
			PixelGrabber pg3 = new PixelGrabber(im3,0,0,w1,h1,pix3,0,w1);
			pg3.grabPixels();
		}
		
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		ck1 = new int[h1][w1];
		ck2 = new int[h1][w1];
		ck3 = new int[h1][w1];
		a = new int[2*h1][2*w1];
		temp = new int[2*h1][2*w1];
		b = new int[2*h1][2*w1];
		c = new int[2*h1][2*w1];
		
		
		x=0;
		for(i=0;i<h1;i++)
		{
			for(j=0;j<w1;j++)
			{
				p1=pix1[x];
				q1=0xff & p1;
				ck1[i][j]=q1;
				
				
				if(ck1[i][j] >128)
					ck1[i][j]=0; 
					
				else
					ck1[i][j] = 1; 
					
				
				
				p1=pix2[x];
				q1=0xff & p1;
				ck2[i][j]=q1;
				
				
				if(ck2[i][j] >128)
					ck2[i][j]=0; 
				else
					ck2[i][j] = 1; 
					
				
						
				p1=pix3[x];
				q1=0xff & p1;
				ck3[i][j]=q1;
						
				
				if(ck3[i][j] >128)
					ck3[i][j]=0; 
				else
					ck3[i][j] = 1; 
					
				x++;
				
			}
		}
		Random rand = new Random();
		for(i=1;i<h1;i++)
		{
			for(j=1;j<w1;j++)
			{
				r=rand.nextInt(4)+1;
				if(ck1[i][j]==0 && ck2[i][j] == 0 && ck3[i][j] ==0)
				{
					switch(r)
					{	
						case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 0;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 0;
							break;
							
						}
					}
					else if(ck1[i][j]==0 && ck2[i][j] ==0 && ck3[i][j] == 1)
					{	
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 0;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
					}
				}
				else if(ck1[i][j] == 0 && ck2[i][j] ==1 && ck3[i][j] ==0)
				{
					switch(r)
					{
						case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						}
					}
					else if(ck1[i][j] ==1 && ck2[i][j] ==0 && ck3[i][j] ==0)
					{
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						}
					}
					else if(ck1[i][j] ==1 &&  ck2[i][j] ==1 && ck3[i][j] ==1)
					{
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
						}
					}
					else if(ck1[i][j]==0 && ck2[i][j] ==1 && ck3[i][j] ==1)
					{
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						}
					}
					else if(ck1[i][j]==1 && ck2[i][j]==0 && ck3[i][j]==1)
					{
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 0;
							break;
						}
					}
					else if(ck1[i][j] ==1 && ck2[i][j] ==1 && ck3[i][j] ==0)
					{
						switch(r)
						{
							case 1: 	
							a[2*i-1][2*j-1] = 1;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 1;
							break;
							
						case 2: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 1;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 0;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 0;
							temp[2*i -1][2*j] = 1;
							temp[2*i][2*j] = 0;
							break;
							
						case 3: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 0;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 1;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 0;
							break;
						
						case 4: 	
							a[2*i-1][2*j-1] = 0;
							a[2*i][2*j -1] = 0;
							a[2*i -1][2*j] = 1;
							a[2*i][2*j] = 1;
							temp[2*i-1][2*j-1] = 0;
							temp[2*i][2*j -1] = 1;
							temp[2*i -1][2*j] = 0;
							temp[2*i][2*j] = 1;
							break;
							
						}
					}
				}
			}
			Random rand2 = new Random();		
			for(i=0;i<2*h1;i++)
			{
				for(j=0;j<2*w1;j++)
				{
					r2 = rand2.nextInt(2)+1;
					if(temp[i][j] == 0)
					{
						switch(r2)
						{
							case 1:
							b[i][j] = 1;
							c[i][j]=1;
							break;
										
							case 2:
							b[i][j] = 0;
							c[i][j]=0;
							break;
						}
					}
					if(temp[i][j] == 1)
					{
						switch(r2)
						{
							case 1:
								b[i][j] = 1;
								c[i][j]=0;
								
								break;
										
							case 2:
								b[i][j] = 0;
								c[i][j]=1;
								break;
						}
					}	
				}
			}
			pixx1 = new int[4*w1*h1];
			pixx2 = new int[4*w1*h1];
			pixx3 = new int[4*w1*h1];
			x=0;
			for(i=0;i<2*h1;i++)
			{
				for(j=0;j<2*w1;j++)
				{
					if(a[i][j]==1)
						pixx1[x]=-999999999;
					else
						pixx1[x]=0;
										
					if(b[i][j]==1)
						
						pixx2[x]=-999999999;
					else
						pixx2[x]=0;
						
						
					if(c[i][j]==1)
						pixx3[x]= -999999999;
					else
						pixx3[x]=0;
						
					x++;
						
					
				}
			}
			encrypt1= s.createImage(new MemoryImageSource(2*w1,2*h1,pixx1,0,2*w1));
			encrypt2= s.createImage(new MemoryImageSource(2*w1,2*h1,pixx2,0,2*w1));
			encrypt3= s.createImage(new MemoryImageSource(2*w1,2*h1,pixx3,0,2*w1));
			
			return new Image[]{encrypt1,encrypt2,encrypt3};
	}
	
	
	public static Image[] decrypt(VSS s)
	{
		temp1 = new int[2*h1][2*w1];
			for(i=0;i<2*h1;i++)
			{
				for(j=0;j<2*w1;j++)
				{	
					if((b[i][j] + c[i][j] ==0) || (b[i][j] + c[i][j] ==2))
						temp1[i][j] =0;
					else if(b[i][j] + c[i][j] ==1)
						temp1[i][j] =1;
						

				}
			}
			de1= new int[2*h1][2*w1];
			de2= new int[2*h1][2*w1];
			de3= new int[2*h1][2*w1];
			
			x=0;
			for(i=1;i<h1;i++)
			{	
				for(j=1;j<w1;j++)
				{
					sum1=0;
					if((a[2*i-1][2*j-1] + temp1[2*i-1][2*j-1])>0)
						sum1++;
					if(a[2*i-1][2*j] + temp1[2*i-1][2*j]>0)
						sum1++;
					if(a[2*i][2*j-1] + temp1[2*i][2*j-1]>0)
						sum1++;
					if(a[2*i][2*j] + temp1[2*i][2*j]>0)
						sum1++;
					if(sum1>2)
					{
						de1[2*i-1][2*j-1]=1;
						de1[2*i-1][2*j]=1;
						de1[2*i][2*j-1]=1;
						de1[2*i][2*j]=1;
					}
					else 
					{	
						de1[2*i-1][2*j-1]=0;
						de1[2*i-1][2*j]=0;
						de1[2*i][2*j-1]=0;
						de1[2*i][2*j]=0;
					}
					
					sum2=0;
					if(a[2*i][2*j-1] + temp1[2*i-1][2*j-1]>0)
						sum2++;
					if(a[2*i-1][2*j-1] + temp1[2*i-1][2*j]>0)
						sum2++;
					if(a[2*i][2*j] + temp1[2*i][2*j-1]>0)
						sum2++;
					if(a[2*i-1][2*j] + temp1[2*i][2*j]>0)
						sum2++;
					if(sum2>2)
					{
						de2[2*i-1][2*j-1]=1;
						de2[2*i-1][2*j]=1;
						de2[2*i][2*j-1]=1;
						de2[2*i][2*j]=1;
					}
					else 
					{	
						de2[2*i-1][2*j-1]=0;
						de2[2*i-1][2*j]=0;
						de2[2*i][2*j-1]=0;
						de2[2*i][2*j]=0;
					}
					
					sum3=0;
					if(a[2*i-1][2*j] + temp1[2*i-1][2*j-1]>0)
						sum3++;
					if(a[2*i][2*j] + temp1[2*i-1][2*j]>0)
						sum3++;
					if(a[2*i-1][2*j-1] + temp1[2*i][2*j-1]>0)
						sum3++;
					if(a[2*i][2*j-1] + temp1[2*i][2*j]>0)
						sum3++;
					if(sum3>2)
					{
						de3[2*i-1][2*j-1]=1;
						de3[2*i-1][2*j]=1;
						de3[2*i][2*j-1]=1;
						de3[2*i][2*j]=1;
					}
					else 
					{	
						de3[2*i-1][2*j-1]=0;
						de3[2*i-1][2*j]=0;
						de3[2*i][2*j-1]=0;
						de3[2*i][2*j]=0;
					}
					x++;
				}
			}
			pixe1 = new int[4*w1*h1];
			pixe2 = new int[4*w1*h1];
			pixe3 = new int[4*w1*h1];
			x=0;
			for(i=0;i<2*h1;i++)
			{
				for(j=0;j<2*w1;j++)
				{
					if(de1[i][j]==1)
						pixe1[x]=-999999999;
					else
						pixe1[x]=0;
						
					if(de2[i][j]==1)
						pixe2[x]=-999999999;
					else
						pixe2[x]=0;
						
					if(de3[i][j]==1)
						pixe3[x]=-999999999;
					else
						pixe3[x]=0;
						
					x++;
				}
			}
			
			decrypt1= s.createImage(new MemoryImageSource(2*w1,2*h1,pixe1,0,2*w1));
			decrypt2 = s.createImage(new MemoryImageSource(2*w1,2*h1,pixe2,0,2*w1));
			decrypt3 = s.createImage(new MemoryImageSource(2*w1,2*h1,pixe3,0,2*w1));
			
			return new Image[]{decrypt1,decrypt2,decrypt3};
		}
	}