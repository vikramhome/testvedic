package com.vedic.maths;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class VedicMaths extends Activity {
    /** Called when the activity is first created. */
	
	TextView header;
	Typeface type;
	Button multiply;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        header=(TextView)findViewById(R.id.header);
        type=Typeface.createFromAsset(getAssets(), "SCHLBKBI.TTF");
        header.setTypeface(type);
        
        multiply=(Button)findViewById(R.id.multiply);
        multiply.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent rulesIntent= new Intent(VedicMaths.this,Rules.class);
				rulesIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(rulesIntent);
			}
		});
        
        
        
    }
}