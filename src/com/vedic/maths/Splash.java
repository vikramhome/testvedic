/**
 * 
 */
package com.vedic.maths;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author Badrinath
 *
 */
public class Splash extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpage);
		
		 new Handler().postDelayed(new Runnable() {
	            public void run() {
	                Intent mainIntent = new Intent(Splash.this,SelectOperation.class);
	                startActivity(mainIntent);
	               finish();
	            }
	        }, 1000);
	    }

}
