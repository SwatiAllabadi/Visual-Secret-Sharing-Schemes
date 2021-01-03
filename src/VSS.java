/* <applet code = "VSS.java"  width=1300  height=1300></applet> */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VSS extends JFrame
{
	
	JButton dis1,dis2,dis3,en,dec;
	JLabel lbldis1,lbldis2,lbldis3,lblen1,lblen2,lblen3,lbldec1,lbldec2,lbldec3;
	
	
	
	public VSS()
	{
		setLayout(null);
		
		
		dis1 = new JButton("Input 1");
		add(dis1);
		VSSTab t = new VSSTab(this);
		dis1.addActionListener(t);
		dis1.setBounds(0,0,100,30);
		
		dis2 = new JButton("Input 2");
		add(dis2);
		dis2.addActionListener(t);
		dis2.setBounds(0,60,100,30);
		
		dis3 = new JButton("Input 3");
		add(dis3);
		dis3.addActionListener(t);
		dis3.setBounds(0,120,100,30);
		
		en = new JButton("Encryption");
		add(en);
		en.addActionListener(t);
		en.setBounds(0,180,100,30);
		
		dec =new JButton("Decryption");
		add(dec);
		dec.addActionListener(t);
		dec.setBounds(0,240,100,30);
		
		lbldis1 =new JLabel("Input Label 1");
		lbldis2 =new JLabel("Input Label 2");
		lbldis3 =new JLabel("Input Label 3");
		lblen1 = new JLabel("Encrypted Label 1");
		lblen2 = new JLabel("Encrypted Label 2");
		lblen3 = new JLabel("Encrypted Label 3");
		lbldec1 = new JLabel("Decrypted Label 1");
		lbldec2 = new JLabel("Decrypted Label 2");
		lbldec3 = new JLabel("Decrypted Label 3");
		
		add(lbldis1);
		add(lbldis2);
		add(lbldis3);
		add(lblen1);
		add(lblen2);
		add(lblen3);
		add(lbldec1);
		add(lbldec2);
		add(lbldec3);
		
		
		lbldis1.setBounds(120,0,200,200);
		lbldis2.setBounds(400,0,200,200);
		lbldis3.setBounds(680,0,200,200);
		
		lblen1.setBounds(120,300,200,200);
		lblen2.setBounds(400,300,200,200);
		lblen3.setBounds(680,300,200,200);
		
		lbldec1.setBounds(960,0,200,200);
		lbldec2.setBounds(960,220,200,200);
		lbldec3.setBounds(960,440,200,200);
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new VSS();
	}
	
}
		
		