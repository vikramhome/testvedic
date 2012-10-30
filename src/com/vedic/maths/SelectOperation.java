/**
 * 
 */
package com.vedic.maths;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Badrinath
 *
 */
public class SelectOperation extends Activity{
	
	Button add,subtract,multiply,divide;
	Typeface type;
	TextView header;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		
		header=(TextView)findViewById(R.id.header);
		 type=Typeface.createFromAsset(getAssets(), "SAMARN__.TTF");
		 header.setText("Vedic Maths");
	     header.setTypeface(type);
		
		add=(Button)findViewById(R.id.add);
		subtract=(Button)findViewById(R.id.sub);
		multiply=(Button)findViewById(R.id.multiply);
		divide=(Button)findViewById(R.id.divide);
		
		multiply.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.multiply){
					Animation shake = AnimationUtils.loadAnimation(SelectOperation.this, R.anim.shake); 
					findViewById(R.id.multiply).startAnimation(shake);
					
				Toast.makeText(SelectOperation.this, "Hold On !!!", Toast.LENGTH_LONG).show();
				new Handler().postDelayed(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						Intent enterIntent= new Intent(SelectOperation.this,SelectRule.class);
						enterIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(enterIntent);
					}
				}, 1000);
				
				}
				
			}
		});
		
		add.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.add){
					Animation shake = AnimationUtils.loadAnimation(SelectOperation.this, R.anim.shake); 
					findViewById(R.id.add).startAnimation(shake);
					
				Toast.makeText(SelectOperation.this, "Hold On !!!", Toast.LENGTH_LONG).show();
				new Handler().postDelayed(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						Intent enterIntent= new Intent(SelectOperation.this,SelectRule.class);
						enterIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(enterIntent);
					}
				}, 1000);
				
				}
				
			}
		});
		
		subtract.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.sub){
					Animation shake = AnimationUtils.loadAnimation(SelectOperation.this, R.anim.shake); 
					findViewById(R.id.sub).startAnimation(shake);
					
				Toast.makeText(SelectOperation.this, "Hold On !!!", Toast.LENGTH_LONG).show();
				new Handler().postDelayed(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						Intent enterIntent= new Intent(SelectOperation.this,SelectRule.class);
						enterIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(enterIntent);
					}
				}, 1000);
				
				}
				
			}
		});
		
		divide.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.divide){
					Animation shake = AnimationUtils.loadAnimation(SelectOperation.this, R.anim.shake); 
					findViewById(R.id.divide).startAnimation(shake);
					
				Toast.makeText(SelectOperation.this, "Hold On !!!", Toast.LENGTH_LONG).show();
				new Handler().postDelayed(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						Intent enterIntent= new Intent(SelectOperation.this,SelectRule.class);
						enterIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(enterIntent);
					}
				}, 1000);
				
				}
				
			}
		});
		
		
	}

}
