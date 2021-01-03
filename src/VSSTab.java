import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class  VSSTab implements ActionListener
{
	VSS a;
	
	VSSTab(VSS b)
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
		
		if(ob==a.dis3)
		{
			JFileChooser f = new JFileChooser();
			f.showOpenDialog(a);
			a.lbldis3.setIcon(new ImageIcon(f.getSelectedFile().getAbsolutePath()));
		}
		
		if(ob ==a.en)
		{
			Image[] images = EnDecVSS.encrypt(((ImageIcon)a.lbldis1.getIcon()).getImage(),((ImageIcon)a.lbldis2.getIcon()).getImage(),((ImageIcon)a.lbldis3.getIcon()).getImage(), a);
			a.lblen1.setIcon(new ImageIcon(images[0].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
			a.lblen2.setIcon(new ImageIcon(images[1].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
			a.lblen3.setIcon(new ImageIcon(images[2].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
		}
		
		if(ob ==a.dec)
		{
			Image[] images = EnDecVSS.decrypt(a);
			a.lbldec1.setIcon(new ImageIcon(images[0].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
			a.lbldec3.setIcon(new ImageIcon(images[1].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
			a.lbldec2.setIcon(new ImageIcon(images[2].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
		}
	}
}

		
