/* <applet code="Naor.java" width=1300 height=1300></applet> */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Naor extends JFrame 
{
	
	JButton dis,en,dec;
	JLabel lbldis,lblen1,lblen2,lbldec;
	

	public  Naor() 
	{
		setLayout(null);
		
		dis = new JButton("Input");
		add(dis);
		tab t=new tab(this);
		dis.addActionListener(t);
		dis.setBounds(0,0,100,30);
		
		en = new JButton("Encryption");
		add(en);
		en.addActionListener(t);
		en.setBounds(0,60,100,30);
		
		
		dec = new JButton("Decryption");
		add(dec);
		dec.addActionListener(t);
		dec.setBounds(0,120,100,30);
		
		lbldis =new JLabel("Input Label");
		lblen1 = new JLabel("Encrypted Label 1");
		lblen2 = new JLabel("Encrypted Label 2");
		lbldec = new JLabel("Decrypted Label");
		add(lbldis);
		add(lblen1);
		add(lblen2);
		add(lbldec);
		lbldis.setBounds(120,0,250,250);
		lblen1.setBounds(120,300,250,250);
		lblen2.setBounds(400,300,250,250);
		lbldec.setBounds(400,0,250,250);
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		
		
		
		
		
	}
	public static void main(String args[])
	{
		new Naor();
	}
	
	
}