
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Wuchen extends JFrame
{
	JButton dis1,dis2,en,dec;
	JLabel lbldis1,lbldis2,lblen1,lblen2,lbldec1,lbldec2;
	
	public Wuchen()
	{
		
		setLayout(null);
		
		dis1 = new JButton("Input 1");
		add(dis1);
		WuTab t = new WuTab(this);
		dis1.addActionListener(t);
		dis1.setBounds(0,0,100,30);
		
		dis2 = new JButton("Input 2");
		add(dis2);
		dis2.addActionListener(t);
		dis2.setBounds(0,60,100,30);
		
		en = new JButton("Encryption");
		add(en);
		en.addActionListener(t);
		en.setBounds(0,120,100,30);
		
		dec =new JButton("Decryption");
		add(dec);
		dec.addActionListener(t);
		dec.setBounds(0,180,100,30);
		
		lbldis1 =new JLabel("Input Label 1");
		lbldis2 =new JLabel("Input Label 2");
		lblen1 = new JLabel("Encrypted Label 1");
		lblen2 = new JLabel("Encrypted Label 2");
		lbldec1 = new JLabel("Decrypted Label 1");
		lbldec2 = new JLabel("Decrypted Label 2");
		
		add(lbldis1);
		add(lbldis2);
		add(lblen1);
		add(lblen2);
		add(lbldec1);
		add(lbldec2);
		
		lbldis1.setBounds(120,0,250,250);
		lbldis2.setBounds(400,0,250,250);
		
		lblen1.setBounds(120,300,250,250);
		lblen2.setBounds(400,300,250,250);
		
		lbldec1.setBounds(700,150,250,250);
		lbldec2.setBounds(700,450,250,250);
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	public static void main(String args[])
	{
	
		new Wuchen();
	}
}
			