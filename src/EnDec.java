import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.*;


public class EnDec
{

	
	public static  Image img1,imgen2,imgen3,;
	static int[] pixels,pixs1,pixs2,check;
	static int p,x,w,h,q,r,ck;
	static int a[][][],s1[][][],s2[][][],re[][][];
	
	
	public static Image[] encrypt(Image image, Naor s)
	{	
	
		try
		{
			
			MediaTracker t= new MediaTracker(s);
			t.addImage(image,0);
			t.waitForID(0);
			w=image.getWidth(null);
			h=image.getHeight(null);
			System.out.println(w);
			System.out.println(h);
			pixels= new int [w*h];
			pixs1= new int [4*w*h];
			pixs2= new int [4*w*h];
			
			PixelGrabber pg= new PixelGrabber (image,0,0,w,h,pixels,0,w);
			pg.grabPixels();
		}
		
		catch(InterruptedException e)
		{
			System.out.println("Interrupted");
			
		}
		
		x=0;
		a=new int[4][h][w];
		s1=new int[4][2*h][2*w];
	    s2=new int[4][2*h][2*w];
	    re=new int[4][2*h][2*w];
		check = new int[w*h];
		ck =0;
		
		
		for(int k=0;k<h;k++)
		{
			for(int l=0;l<w;l++)
			{
				p=pixels[x];
				a[1][k][l]=0xff & (p >> 16);
				
				a[2][k][l]=0xff & (p >> 8);
				
				a[3][k][l]=0xff & (p);
				check[ck] =a[3][k][l];
				ck++;
				if(a[1][k][l]<128) 
				{
				a[1][k][l]=100;
				a[2][k][l]=100;
				a[3][k][l]=100;
				}
				else 
				{
				a[1][k][l]=0;
				a[2][k][l]=0;
				a[3][k][l]=0;
				}
				x++;
			}
		}
		
		
		int r1;
		Random rand=new Random();
		for (int i=1;i<h;i++)
		{
	    for (int j=1;j<w;j++)
	    {
	         r1 = rand.nextInt(5)+1;
	         if(a[1][i][j]== 0)
	         {
	             switch (r1)
	             {
	                 case 1:
	                     s1[1][2*i-1][2*j-1]= 0;
	                     s1[1][2*i-1][2*j]=0;
	                     s1[1][2*i][2*j-1]= 100;
	                     s1[1][2*i][2*j]=100;
	                     s2[1][2*i-1][2*j-1]= 100;
	                     s2[1][2*i-1][2*j]=100;
	                     s2[1][2*i][2*j-1]= 0;
	                     s2[1][2*i][2*j]=0;
	                     break;
	                     case 2:
	                     s1[1][2*i-1][2*j-1]= 100;
	                     s1[1][2*i-1][2*j]=0;
	                     s1[1][2*i][2*j-1]= 100;
	                     s1[1][2*i][2*j]=0;
	                     s2[1][2*i-1][2*j-1]= 0;
	                     s2[1][2*i-1][2*j]=100;
	                     s2[1][2*i][2*j-1]= 0;
	                     s2[1][2*i][2*j]=100;
	                     break;
	                   case 3:
	                     
	                     s1[1][2*i-1][2*j-1]= 100;
	                     s1[1][2*i-1][2*j]=100;
	                     s1[1][2*i][2*j-1]= 0;
	                     s1[1][2*i][2*j]=0;
	                     s2[1][2*i-1][2*j-1]= 0;
	                     s2[1][2*i-1][2*j]=0;
	                     s2[1][2*i][2*j-1]= 100;
	                     s2[1][2*i][2*j]=100;
	                     break;
	                 case 4:
	                     
	                 s1[1][2*i-1][2*j-1]= 0;
                     s1[1][2*i-1][2*j]=100;
                     s1[1][2*i][2*j-1]= 0;
                     s1[1][2*i][2*j]=100;
                     s2[1][2*i-1][2*j-1]= 100;
                     s2[1][2*i-1][2*j]=0;
                     s2[1][2*i][2*j-1]= 100;
                     s2[1][2*i][2*j]=0;
                     break;
	                 case 5:
	                     
	                 s1[1][2*i-1][2*j-1]= 0;
                     s1[1][2*i-1][2*j]=100;
                     s1[1][2*i][2*j-1]= 100;
                     s1[1][2*i][2*j]=0;
                     s2[1][2*i-1][2*j-1]= 100;
                     s2[1][2*i-1][2*j]=0;
                     s2[1][2*i][2*j-1]= 0;
                     s2[1][2*i][2*j]=100;
                     break;
	                 case 6:
	                     
	                 s1[1][2*i-1][2*j-1]= 100;
                     s1[1][2*i-1][2*j]=0;
                     s1[1][2*i][2*j-1]= 100;
                     s1[1][2*i][2*j]=0;
                     s2[1][2*i-1][2*j-1]= 0;
                     s2[1][2*i-1][2*j]=100;
                     s2[1][2*i][2*j-1]= 0;
                     s2[1][2*i][2*j]=100;
                     break;
	             }
	           }
	        
	         if(a[1][i][j]== 100)
	         {
	             
	             switch (r1)
	             {
	                 case 1:
	                     s1[1][2*i-1][2*j-1]= 0;
	                     s1[1][2*i-1][2*j]=0;
	                     s1[1][2*i][2*j-1]= 100;
	                     s1[1][2*i][2*j]=100;
	                     s2[1][2*i-1][2*j-1]= 0;
	                     s2[1][2*i-1][2*j]=0;
	                     s2[1][2*i][2*j-1]= 100;
	                     s2[1][2*i][2*j]=100;
	                     break;
	                     case 2:
	                     s1[1][2*i-1][2*j-1]= 100;
	                     s1[1][2*i-1][2*j]=0;
	                     s1[1][2*i][2*j-1]= 100;
	                     s1[1][2*i][2*j]=0;
	                     s2[1][2*i-1][2*j-1]= 100;
	                     s2[1][2*i-1][2*j]=0;
	                     s2[1][2*i][2*j-1]= 100;
	                     s2[1][2*i][2*j]=0;
	                     break;
	                  case 3:
	                     
	                     s1[1][2*i-1][2*j-1]= 100;
	                     s1[1][2*i-1][2*j]=100;
	                     s1[1][2*i][2*j-1]= 0;
	                     s1[1][2*i][2*j]=0;
	                     s2[1][2*i-1][2*j-1]= 100;
	                     s2[1][2*i-1][2*j]=100;
	                     s2[1][2*i][2*j-1]= 0;
	                     s2[1][2*i][2*j]=0;
	                     break;
	                 case 4:
	                     
	                 s1[1][2*i-1][2*j-1]= 0;
                     s1[1][2*i-1][2*j]=100;
                     s1[1][2*i][2*j-1]= 0;
                     s1[1][2*i][2*j]=100;
                     s2[1][2*i-1][2*j-1]= 0;
                     s2[1][2*i-1][2*j]=100;
                     s2[1][2*i][2*j-1]= 0;
                     s2[1][2*i][2*j]=100;
                     break;
	                 case 5:
	                
	                 s1[1][2*i-1][2*j-1]= 0;
                     s1[1][2*i-1][2*j]=100;
                     s1[1][2*i][2*j-1]= 100;
                     s1[1][2*i][2*j]=0;
                     s2[1][2*i-1][2*j-1]= 0;
                     s2[1][2*i-1][2*j]=100;
                     s2[1][2*i][2*j-1]= 100;
                     s2[1][2*i][2*j]=0;
                     break;
	                 case 6:
	                     
	                 s1[1][2*i-1][2*j-1]= 100;
                     s1[1][2*i-1][2*j]=0;
                     s1[1][2*i][2*j-1]= 100;
                     s1[1][2*i][2*j]=0;
                     s2[1][2*i-1][2*j-1]= 100;
                     s2[1][2*i-1][2*j]=0;
                     s2[1][2*i][2*j-1]=100;
                     s2[1][2*i][2*j]=0;
                     break;
	             }
	           }
	    
	    }
		
		}
		for (int i=0;i<2*h;i++)
		{
			for(int j=0;j<2*w;j++)
			{ 
				if(s1[1][i][j]==0)
				{
					pixs1[q++]=0;
				}
				if(s1[1][i][j]==100)
				{
					pixs1[q++]=-999999999;
				}
				
				if(s2[1][i][j]==0)
				{
					pixs2[r++]=0;
				}
				if(s2[1][i][j]==100)
				{
					pixs2[r++]=-999999999;
				}
			}
		}
		imgen2 = s.createImage(new MemoryImageSource(2*w,2*h,pixs1,0,2*w));
		imgen3 = s.createImage(new MemoryImageSource(2*w,2*h,pixs2,0,2*w));
		return new Image[]{imgen2,imgen3};
		
		
	}
	
	
	public static Image decrypt(Naor s)
	{
		for (int i=0;i<2*h;i++)
		{
			for(int j=0;j<2*w;j++)
			{ 
				re[1][i][j]=s1[1][i][j]+s2[1][i][j];
				
							
			}
		}
		q=0;
		r=0;
		
		for (int i=0;i<2*h;i++)
		{
			for(int j=0;j<2*w;j++)
			{ 		
				
				
				if(re[1][i][j]==200 | re[1][i][j]==0)
				{
				re[1][i][j]=0;
				}
				//System.out.println(re[1][i][j]);
				if (re[1][i][j]==100 )
					re[1][i][j]=-8254325;
			}
		}
			
		
		
		
		int i=0;
		int pixel[] = new int[4*w*h];
		
		for(int y=0;y<2*h;y++)
		{
			for( x=0;x<2*w;x++)
			{
				int r=re[1][y][x] &0xff;
				int g=r;
				int b=g;
				pixel[i++]=(255 << 24) | (r << 16) | (g << 8) | b;
				
			
			}
		}
		
		img1 = s.createImage(new MemoryImageSource(2*w,2*h,pixel,0,2*w));	
		return img1;
		
		
	}
}