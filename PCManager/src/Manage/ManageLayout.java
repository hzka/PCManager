package Manage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManageLayout extends JFrame{
	public ManageLayout(){
		this.setTitle("PC Manager");
		
		this.setSize(600,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new GridLayout(1,2,20,20));
		
		JLabel jl1 = new JLabel("PC Manager",JLabel.CENTER);

		Font font = new Font(Font.DIALOG, Font.PLAIN, 25);
	    jl1.setFont(font);
	    
		JButton jb1= new JButton("开启WiFi"); 
		jb1.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		JButton jb2 = new JButton("定时关机");
		jb2.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		
		p2.add(jb1);
		p2.add(jb2);
		
		p1.add(jl1,BorderLayout.NORTH);
		p1.add(p2,BorderLayout.CENTER);
		add(p1);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ManageLayout.this.dispose();
				new WifiLayout();
			}
			
		});
		
		jb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ManageLayout.this.dispose();
				new CloseLayout();
			}
			
		});
	
	}

}
