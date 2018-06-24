package clock.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class ClockLabel extends JLabel implements ActionListener {
	 
	  String type;
	  SimpleDateFormat sdf;
	  Date date;
	  Calendar calendar;
	  int hour = 0;
	  int minute = 0;
	  int second = 0;
	 
	  public ClockLabel(String type) {
		 date = new Date();
		 calendar = Calendar.getInstance();
	    this.type = type;
	    setForeground(Color.green);
	    //setOpaque(true);
	    //setBackground(Color.blue);
	    switch (type) {
	      case "date" : sdf = new SimpleDateFormat("  MMMM dd yyyy");
	                    setFont(new Font("sans-serif", Font.PLAIN, 15));
	                    setHorizontalAlignment(SwingConstants.LEFT);
	                    break;
	      case "time" : sdf = new SimpleDateFormat("HH:mm:ss");
	                    setFont(new Font("Times New Roman", Font.PLAIN, 150));
	                    setHorizontalAlignment(SwingConstants.CENTER);
	                    break;
	      case "day"  : sdf = new SimpleDateFormat("EEEE  ");
	                    setFont(new Font("sans-serif", Font.PLAIN, 15));
	                    setHorizontalAlignment(SwingConstants.RIGHT);
	                    break;
	      default     : sdf = new SimpleDateFormat();
	                    break;
	    }
	 
	    Timer t = new Timer(1000, this);
	    t.start();
	    System.out.println("UI Thread name " + Thread.currentThread().getName());
	  }
	  @Override
	  public void actionPerformed(ActionEvent ae) {
	    setText(sdf.format(adjustTime(new Date(),hour,minute,second)));
	  }
	  public  Date adjustTime(Date date, int hour, int minute , int second) {    
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + hour);  
	        cal.set(Calendar.MINUTE,cal.get(Calendar.MINUTE) + minute);  
	        cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + second);  
	        cal.set(Calendar.MILLISECOND, 0);  
	        return cal.getTime(); 
	    }
	}
