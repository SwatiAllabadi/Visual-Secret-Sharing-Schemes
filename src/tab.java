import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class  tab implements ActionListener
{
	Naor a;
	
	tab(Naor b)
	{
		a= b;
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		if(ob==a.dis)
		{
			JFileChooser f = new JFileChooser("e:\\project");
			f.showOpenDialog(a);
			a.lbldis.setIcon(new ImageIcon(f.getSelectedFile().getAbsolutePath()));
		}
		if(ob ==a.en)
		{
			Image[] images = EnDec.encrypt(((ImageIcon)a.lbldis.getIcon()).getImage(), a);
			a.lblen1.setIcon(new ImageIcon(images[0].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
			a.lblen2.setIcon(new ImageIcon(images[1].getScaledInstance(250,250,Image.SCALE_SMOOTH)));
		}
		if(ob ==a.dec)
		{
			
			a.lbldec.setIcon(new ImageIcon(EnDec.decrypt(a).getScaledInstance(250,250,Image.SCALE_SMOOTH)));
		}
	}
}
			
			
		