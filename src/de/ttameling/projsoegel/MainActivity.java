package de.ttameling.projsoegel;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final SimpleDateFormat DATE_FORMAT =
		    new SimpleDateFormat("dd/MM/yy HH:mm");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    final Handler handler = new Handler();                                                      
	     super.onCreate(savedInstanceState);                                                        
	     setContentView(R.layout.activity_main);                                                    
	     final TextView textview = new TextView(this);                                              
	     Timer timer = new Timer();                                                                  
	     timer.scheduleAtFixedRate(new TimerTask() {                                                
	         @Override                                                                              
	         public void run() {                                                                    
	             handler.post(new Runnable() {                                                      
	                 private Object currentDateTimeString;
					private Object myString;

					public void run() {    
	                	 Calendar cal   = Calendar.getInstance();      
	                	 Calendar today = Calendar.getInstance();

	                	 cal.set(Calendar.HOUR, 00);                                                                              
	                	 cal.set(Calendar.MINUTE, 00);                                                                            
	                	 cal.set(Calendar.SECOND, 00);                                                                            
	                	 cal.set(Calendar.DATE, 26);                                                                              
	                	 cal.set(Calendar.MONTH, 07);                                                                              
	                	 cal.set(Calendar.YEAR, 2014); 
	                	 cal.set(Calendar.DAY_OF_YEAR, 207);

	                	 long difference = cal.getTimeInMillis() - today.getTimeInMillis();

	                	 long tage       = difference / 3600 / 1000 / 24;
	                	 long stunden  = 23 - today.get(Calendar.HOUR_OF_DAY);
	                	 long minuten  = 59 - today.get(Calendar.MINUTE);
	                	 long sekunden = 59 - today.get(Calendar.SECOND); 

	                	 String strMillisek = Long.toString(difference);
                         String strTage     = Long.toString(tage);
                         String strStunden  = Long.toString(stunden % 24);
                         String strMinuten  = Long.toString(minuten % 60);
                         String strSekunden = Long.toString(sekunden % 60);
	                	 //	    String hello = (String) DateFormat.format((CharSequence) myString, difference);                    
                         //     String currentDateTimeString = (String) cal.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();                      
                 	    TextView textTage  = (TextView) findViewById(R.id.textTage);
                	    if (textTage != null)
                	    {
                		    textTage.setTextSize(30);
                		    textTage.setText(strTage);
//                		    setContentView(textTage);
                	    }

                 	    TextView textStunden  = (TextView) findViewById(R.id.textStunden);
                	    if (textStunden != null)
                	    {
                		    textStunden.setTextSize(30);
                		    textStunden.setText(strStunden);
                	    }

               	    TextView textMinuten  = (TextView) findViewById(R.id.textMinuten);
              	    if (textMinuten != null)
                	    {
                		    textMinuten.setTextSize(30);
                		    textMinuten.setText(strMinuten);
                	    }

                 	    TextView textSekunden  = (TextView) findViewById(R.id.textSekunden);
                	    if (textSekunden != null)
                	    {
                	    	textSekunden.setGravity(Gravity.CENTER);
                		    textSekunden.setTextSize(30);
                		    textSekunden.setText(strSekunden);
                	    }
                	    
                 	    TextView textMillisek  = (TextView) findViewById(R.id.textMillisek);
                	    if (textMillisek != null)
                	    {
                	    	textMillisek.setGravity(Gravity.CENTER);
                	    	textMillisek.setTextSize(30);
                	    	textMillisek.setText(strMillisek);
                	    }
	                 }                                                                              
	             });                                                                                
	         }                                                                                      
	     },1000,1000);                                                                             
	                    	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
