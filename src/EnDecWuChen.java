import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.*;

public class EnDecWuChen
{
	private static Image image1, image2;
	public static Image img1,encrypt1,encrypt2;
	static Image decrypt1,decrypt2;
	static int w,h,w1,h1,w2,h2,x,y,p1,q,q1,p2,q2,r,i,j,r1,ck,de,de2,sum,sum2,z,z2,t;
	static int[] pixels1,pixels2,pixs1,pixs2,pixx1,pixx2,check;
	static int[][] a1,a2;
	static int[][][] s1,s2,re,re2;
	
	public static Image[] encrypt(Image image1, Image image2, Wuchen s)
	{
		try
		{
		
		
			MediaTracker t1= new MediaTracker(s);
			t1.addImage(image1,0);
			t1.waitForID(0);
			MediaTracker t2= new MediaTracker(s);
			t2.addImage(image2,0);
			t2.waitForID(0);
			w1= image1.getWidth(null);
			h1= image1.getHeight(null);
			check = new int[w1*h1];
			pixels1 = new int[w1*h1];
			pixels2 = new int[w1*h1];
			PixelGrabber pg1 = new PixelGrabber(image1,0,0,w1,h1,pixels1,0,w1);
			PixelGrabber pg2 = new PixelGrabber(image2,0,0,w1,h1,pixels2,0,w1);
			pg1.grabPixels();
			pg2.grabPixels();
			
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		a1= new int[h1][w1];
		a2= new int[h1][w1];
		x=0;
		for(i=0;i<h1;i++)
		{
			for(j=0;j<w1;j++)
			{
				p1=pixels1[x];
				q1=0xff & (p1>>8);
				a1[i][j]=q1;
				check[ck]=a1[i][j];
				ck++;
				if(a1[i][j]>128)
				{
					a1[i][j]=1;
					
				}
				else
				{
					a1[i][j]=0;
				}
				p2=pixels2[x];
				q2=0xff & (p2>>8);
				a2[i][j]=q2;
				if(a2[i][j]>128)
				{
					a2[i][j]=1;
				}
				else
				{
					a2[i][j]=0;
				}
				x++;
				
			}
		}
		Random rand = new Random();
		s1 = new int[2][2*h1][2*w1];
		s2 = new int[2][2*h1][2*w1];
		for(i=1;i<h1;i++)
		{
			for(j=1;j<w1;j++)
			{
				r1=rand.nextInt(4)+1;
				if(a1[i][j]==0 && a2[i][j]==0)
				{
					switch(r1)
					{
						case 1:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=1;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=0;
							break;
	                     case 2:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=1;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=1;
							break;
	                    case 3:
							s1[1][2*i-1][2*j-1]= 1;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=1;
							break;
						case 4:
	                     
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 1;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=0;
							break;	
					}
				}
				else if(a1[i][j]==0 && a2[i][j]==1)
				{
					switch(r1)
					{
						case 1:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=1;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=0;
							break;
	                     case 2:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=1;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=0;
							break;
	                    case 3:
							s1[1][2*i-1][2*j-1]= 1;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=1;
							break;
						case 4:
	                     
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 1;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=1;
							break;	
					}
				}
				else if(a1[i][j]==1 && a2[i][j]==0)
				{
					switch(r1)
					{
						case 1:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=1;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=1;
							break;
	                     case 2:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=1;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=1;
							break;
	                    case 3:
							s1[1][2*i-1][2*j-1]= 1;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=0;
							break;
						case 4:
	                     
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 1;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=0;
							break;	
					}
				}
				if(a1[i][j]==1 && a2[i][j]==1)
				{
					switch(r1)
					{
						case 1:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=1;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=1;
							break;
	                     case 2:
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=1;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=1;
							s2[1][2*i][2*j-1]= 0;
							s2[1][2*i][2*j]=0;
							break;
	                    case 3:
							s1[1][2*i-1][2*j-1]= 1;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 0;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 1;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=0;
							break;
						case 4:
	                     
							s1[1][2*i-1][2*j-1]= 0;
							s1[1][2*i-1][2*j]=0;
							s1[1][2*i][2*j-1]= 1;
							s1[1][2*i][2*j]=0;
							s2[1][2*i-1][2*j-1]= 0;
							s2[1][2*i-1][2*j]=0;
							s2[1][2*i][2*j-1]= 1;
							s2[1][2*i][2*j]=1;
							break;	
					}
				}
			}
		}
		

		pixs1 = new int[4*w1*h1];
		pixs2 = new int[4*w1*h1];
		q=0;
		r=0;
		for (i=0;i<2*h1;i++)
		{
			for(j=0;j<2*w1;j++)
			{ 
				if(s1[1][i][j]==1)
				{
					pixs1[q++]=0;
				}
				else if(s1[1][i][j]==0)
				{
					pixs1[q++]=-999999999;
				}
				
				if(s2[1][i][j]==1)
				{
					pixs2[r++]=0;
				}
				if(s2[1][i][j]==0)
				{
					pixs2[r++]=-999999999;
				}
				
			}
		}
		encrypt1 = s.createImage(new MemoryImageSource(2*w1,2*h1,pixs1,0,2*w1));
		encrypt2 = s.createImage(new MemoryImageSource(2*w1,2*h1,pixs2,0,2*w1));		
		return new Image[]{encrypt1,encrypt2};
	}	
	public static Image[] decrypt(Wuchen s)
	{
		re = new int[2][2*h1][2*w1];
			re2 = new int[2][2*h1][2*w1];
			pixx1 = new int[4*w1*h1];
			pixx2 = new int[4*w1*h1];
			z=0;
			for(i=1;i<h1;i++)
			{
				for(j=1;j<w1;j++)
				{	
					sum =0;
					de =s1[1][2*i-1][2*j-1]+s2[1][2*i-1][2*j-1];
					if(de==2)
						sum++;
					de =s1[1][2*i-1][2*j]+s2[1][2*i-1][2*j];
					if(de==2)
						sum++;
					de =s1[1][2*i][2*j-1]+s2[1][2*i][2*j-1];
					if(de==2)
						sum++;
					de =s1[1][2*i][2*j]+s2[1][2*i][2*j];
					if(de==2)
						sum++;
						
						
					sum2 = 0;
					de2 = s1[1][2*i-1][2*j]+s2[1][2*i-1][2*j-1];
					if(de2==2)
						sum2++;
					de2 =s1[1][2*i][2*j]+s2[1][2*i-1][2*j];
					if(de2==2)
						sum2++;
					de2 =s1[1][2*i-1][2*j-1]+s2[1][2*i][2*j-1];
					if(de2==2)
						sum2++;
					de2 =s1[1][2*i][2*j-1]+s2[1][2*i][2*j];
					if(de==2)
						sum2++;
					
					
					if(sum>0)
					{
						re[1][2*i-1][2*j-1]=1;
						
						re[1][2*i-1][2*j]=1;
						
						re[1][2*i][2*j-1]=1;
						
						re[1][2*i][2*j]=1;
						
					}
					else
					{
						re[1][2*i-1][2*j-1]=0;
					
						re[1][2*i-1][2*j]=0;
					
						re[1][2*i][2*j-1]=0;
						
						re[1][2*i][2*j]=0;
						
					}
					
					
					if(sum2>0)
					{
						re2[1][2*i-1][2*j-1]=1;
						re2[1][2*i-1][2*j]=1;
						re2[1][2*i][2*j-1]=1;
						re2[1][2*i][2*j]=1;
					}
					else
					{
						re2[1][2*i-1][2*j-1]=0;
						re2[1][2*i-1][2*j]=0;
						re2[1][2*i][2*j-1]=0;
						re2[1][2*i][2*j]=0;

					}
				}
			}
			z=0;
			z2=0;
			for(i=0;i<2*h1;i++)
			{
				for(j=0;j<2*w1;j++)
				{
					if(re[1][i][j]==0)
						pixx1[z++]=-999999999;
					else
						pixx1[z++]=0;
						
					if(re2[1][i][j]==0)
						pixx2[z2++]=-999999999;
					else
						pixx2[z2++]=0;
				}
			}
			
		decrypt1 = s.createImage(new MemoryImageSource(2*w1,2*h1,pixx1,0,2*w1));
		decrypt2 = s.createImage(new MemoryImageSource(2*w1, 2*h1, pixx2,0,2*w1));
		return new Image[]{decrypt1,decrypt2};
	
	}
}
	