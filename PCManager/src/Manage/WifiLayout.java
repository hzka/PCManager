package Manage;
/*
 * 配置、开启、关闭WiFi。
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Period;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WifiLayout extends JFrame{
	
	JTextField jtf1 = new JTextField("WiFi呀");
	JTextField jtf2 = new JTextField("hzk12345");
	
	public WifiLayout(){
	this.setTitle("PC Manager");
	
	this.setSize(600,200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new GridLayout(2,4,20,20));

	JLabel jl1 = new JLabel("PC Manager",JLabel.CENTER);
	Font font = new Font(Font.DIALOG, Font.PLAIN, 25);
    jl1.setFont(font);
	
	JLabel jl2 = new JLabel("WiFi名:");
	JLabel jl3 = new JLabel("WiFi密码:");
	Font font1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	jl2.setFont(font1);jl3.setFont(font1);
	
	JButton jb1= new JButton("配置WiFi");
	JButton jb2 = new JButton("开启WiFi");
	JButton jb3 = new JButton("关闭WiFi");
	JButton jb4 = new JButton("返回上层");
	jb1.setFont(font1);jb2.setFont(font1);
	jb3.setFont(font1);jb4.setFont(font1);
	jtf1.setFont(font1);jtf2.setFont(font1);
	
    p2.add(jl2);p2.add(jtf1);p2.add(jl3);p2.add(jtf2);
    p2.add(jb1);p2.add(jb2);p2.add(jb3);p2.add(jb4);
    
    p1.add(jl1,BorderLayout.NORTH);
    p1.add(p2,BorderLayout.CENTER);

	add(p1);
	
	this.setLocationRelativeTo(null);
	this.setResizable(false);//不能移动
	this.setVisible(true);
	jb1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String UserName = jtf1.getText().toString();
			String UserPassword = jtf2.getText().toString();
			
			String string1="cmd /c";
        	String string2="netsh wlan set hostednetwork mode=allow ssid=";
        	String string3=" key=";
        	string1=string1+UserName+string3+UserPassword;    
            try {
            	Runtime rt1=Runtime.getRuntime();
				Process AllocateWiFi=rt1.exec(string1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	});
	
	jb2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String string1="cmd /c";
        	String string2="netsh wlan start hostednetwork";
        	string1+=string2;    
            try {
            	Runtime rt1=Runtime.getRuntime();
				Process StartWiFi=rt1.exec(string1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	jb3.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String string1="cmd /c";
        	String string2="netsh wlan stop hostednetwork";
        	string1+=string2;    
            try {
            	Runtime rt1=Runtime.getRuntime();
				Process CloseWiFi=rt1.exec(string1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	jb4.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			WifiLayout.this.dispose();
			new ManageLayout();
		}
	});
}}
