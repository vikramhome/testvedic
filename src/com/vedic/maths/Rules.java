/**
 * 
 */
package com.vedic.maths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Badrinath
 *
 */
public class Rules extends Activity{
	
	Button submit,next;
	EditText fno,sno;
	RelativeLayout mainLayout;
	String fNumber,sNumber;
	int nextVal,backVal;
	Map<Integer, List<String>> maps;
	TextView rules;
	int decideVal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rules);
		nextVal=2;
		backVal=1;
		
		
		try {
			decideVal=this.getIntent().getExtras().getInt("decideVal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mainLayout=(RelativeLayout)findViewById(R.id.mainLayout);
		
		//rules=(TextView)findViewById(R.id.rules);
		
		fno=(EditText)findViewById(R.id.fno);
		fNumber=fno.getText().toString();
		
		sno=(EditText)findViewById(R.id.sno);
		sNumber=sno.getText().toString();
		
		
		next=(Button)findViewById(R.id.next);
		
		submit=(Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//counter++;
				fNumber=fno.getText().toString();
				sNumber=sno.getText().toString();
				if (fNumber.length() == 0 || Integer.parseInt(fNumber) == 0) {
					Toast.makeText(Rules.this, "Please Enter First Number Correctly",
							Toast.LENGTH_LONG).show();
				}

				if (sNumber.length() == 0 || Integer.parseInt(sNumber) == 0) {
					Toast.makeText(Rules.this, "Please Enter Second Number Correctly",
							Toast.LENGTH_LONG).show();
				} else {
					Map<String,Object> status =Multiplication.checkRules(fNumber,sNumber,decideVal);
					if((Boolean) status.get("flag")){
					Intent resIntent = new Intent(Rules.this, ResultPage.class);
					resIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					resIntent.putExtra("fno", fNumber);
					resIntent.putExtra("sno", sNumber);
					resIntent.putExtra("decideVal", decideVal);
					startActivity(resIntent);
					}else{
						String message=(String) status.get("error");
						Toast.makeText(Rules.this,message,
								Toast.LENGTH_LONG).show();
					}
				}
				
			} 
		});
		
	}
	
	
	
	
	OnClickListener nextRule = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			mainLayout.removeAllViews();
			
			RelativeLayout rel = new RelativeLayout(Rules.this);
			//rel.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);

			TextView rules= new TextView(Rules.this);
			rules.setTextColor(Color.BLACK);
			rules.setId(1);
			rules.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			
			Map<Integer, List<String>> maps = new HashMap<Integer, List<String>>();
			maps = Multiplication.method1(fNumber, sNumber);
			List<String> str = maps.get(1);
			rules.setText(Utils.getCombineString(str));
			
			//rules.setText("\n\tStep 2 :\n\n\t"+Multiplication.method1(fNumber,sNumber));
			
			Button next= new Button(Rules.this);
			next.setText("Next");
			next.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			params.addRule(RelativeLayout.BELOW,1);
			rel.addView(rules);
			rel.addView(next,params);
			
			//next.setOnClickListener(nextRule);
			mainLayout.addView(rel);
		}
		
	};

}
