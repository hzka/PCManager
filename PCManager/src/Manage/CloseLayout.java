package Manage;
/*
 * 关机类，定时关机。
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class CloseLayout extends JFrame{
	
	JTextField jtf1 = new JTextField(4);
	JTextField jtf2 = new JTextField(4);
   
	JLabel jl6 = new JLabel("");
	Font font = new Font(Font.DIALOG, Font.PLAIN, 25);
	Font font1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	/*
	 * 利用线程进行计时，将数据用构造函数传入，然后run函数进行计算时间。
	 */
	public class Countdown extends Thread{
		private int TotalSeconds,TotalSeconds1,TotalMinutes,TotalHours;
		
		public Countdown(int TotalSeconds) {
			// TODO Auto-generated constructor stub
			this.TotalSeconds = TotalSeconds;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(TotalSeconds >= 0){
				TotalHours = TotalSeconds / 3600;
				TotalMinutes = (TotalSeconds % 3600) / 60;
				TotalSeconds1 = (TotalSeconds % 3600) % 60;
				jl6.setText(TotalHours+"时"+TotalMinutes+"分"+TotalSeconds1+"秒");
	            jl6.setFont(font1);
			try {	
				Thread.sleep(1000);
				TotalSeconds--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    }
			}
	}
	/*
	 * 构造函数。实现总体布局，开机关机按钮，返回按钮。
	 */
	public CloseLayout(){
        this.setTitle("PC Manager");
		
		this.setSize(600,251);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new GridLayout(1,2,20,20));
		JPanel p4 = new JPanel(new GridLayout(2,1,20,20));
		JPanel p5 = new JPanel(new FlowLayout());
		
		JLabel jl1 = new JLabel("PC Manager",JLabel.CENTER);
		JLabel jl2 = new JLabel("设定电脑关机时间：");
		JLabel jl3 = new JLabel(":",JLabel.CENTER);
		JLabel jl5 = new JLabel("距离关机还有：");
		
	
		
	    jl1.setFont(font);jl2.setFont(font1);jl3.setFont(font1);jtf1.setFont(font1);jtf2.setFont(font1);
	    jl5.setFont(font1);
	    
	    JButton jb1=new JButton("定时关机");
	    JButton jb2=new JButton("停止关机");
	    JButton jb3 = new JButton("返回上层");
	    jb1.setFont(font1);jb2.setFont(font1);jb3.setFont(font1);
	    jtf1.setText("00");jtf2.setText("00");
	    jtf1.setHorizontalAlignment(JTextField.RIGHT);
	    jtf2.setHorizontalAlignment(JTextField.RIGHT);
	    p2.add(jl2);p2.add(jtf1);p2.add(jl3); p2.add(jtf2);
	    p3.add(jb1);p3.add(jb2);p3.add(jb3);
	    p1.add(jl1,BorderLayout.NORTH);
	    p4.add(p2);p4.add(p3);
	    p1.add(p4,BorderLayout.CENTER);
	    p5.add(jl5);p5.add(jl6);
	    p1.add(p5,BorderLayout.SOUTH);
	    
	    add(p1);
	    
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				  try {
					    Calendar now = Calendar.getInstance(); 
						int hour = now.get(Calendar.HOUR_OF_DAY);
						int minute = now.get(Calendar.MINUTE);
						int second = now.get(Calendar.SECOND);
						System.out.println(hour+":"+minute+":"+second);
						
					    int hourDead = Integer.parseInt(jtf1.getText().toString());
					    int minuteDead=Integer.parseInt(jtf2.getText().toString());
					    
					    int ResultHour,ResultMinute,ResultSecond;
					    int TotalSeconds;
					    
					    if(hourDead >= hour && minuteDead >= minute ){
					    	ResultHour = hourDead - hour;
					    }
					    else{
					    	ResultHour = 24 - hour + hourDead;
					    }
					    ResultMinute = minuteDead - minute;
					    ResultSecond = 0 -second;
					    
					    TotalSeconds = ResultHour * 3600 +ResultMinute * 60 +ResultSecond;
					    
					    Thread thread1 = new Countdown(TotalSeconds);
					    thread1.start();
					    
					    String TotSeconds2 = " "+TotalSeconds;
						String string1="cmd /c";
			        	String string2="shutdown -s -t";
			        	string1 = string1 + string2 + TotSeconds2;
			            
			            try {
			            	Runtime rt1=Runtime.getRuntime();
							Process ShutDown=rt1.exec(string1);
							jtf1.setEnabled(false);
							jtf2.setEnabled(false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//			            jl6.setText(TotalHour+"时"+TotalMinute+"分"+TotalSeconds1+"秒");
//			            jl6.setFont(font1);
				}
			}
			
		);
		jb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  try {
				
						String string1="cmd /c";
			        	String string2="shutdown -a";
			        	string1+=string2;
			            Runtime rt1=Runtime.getRuntime();
			            Process StopShutdown=rt1.exec(string1);
			            jtf1.setEnabled(true);
						jtf2.setEnabled(true);
			          } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		);
		
		jb3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CloseLayout.this.dispose();
				new ManageLayout();
			}
		});
    }
}
