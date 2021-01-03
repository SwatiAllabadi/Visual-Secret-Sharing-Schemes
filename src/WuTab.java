import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class  WuTab implements ActionListener
{
	Wuchen a;
	
	WuTab(Wuchen b)
	{
		 a = b;
	 }
	 
	 public void actionPerformed(ActionEvent ae)
	 {
		Object ob = ae.getSource();
		
		if(ob==a.dis1)
		{
			JFileChooser f = new JFileChooser("e:\\project");
			f.showOpenDialog(a);
			a.lbldis1.setIcon(new ImageIcon(f.getSelectedFile().getAbsolutePath()));
		}
		
		if(ob==a.dis2)
		{
			JFileChooser f = new JFileChooser();
			f.showOpenDialog(a);
			a.lbldis2.setIcon(new ImageIcon(f.getSelectedFile().getAbsolutePath()));
		}
		
		if(ob ==a.en)
		{
			Image[] images = EnDecWuChen.encrypt(((ImageIcon)a.lbldis1.getIcon()).getImage(),((ImageIcon)a.lbldis2.getIcon()).getImage(), a);
			a.lblen1.setIcon(new ImageIcon(images[0].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
			a.lblen2.setIcon(new ImageIcon(images[1].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
		}
		
		if(ob ==a.dec)
		{
			Image[] images = EnDecWuChen.decrypt(a);
			a.lbldec1.setIcon(new ImageIcon(images[0].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
			a.lbldec2.setIcon(new ImageIcon(images[1].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
		}
	}
}
