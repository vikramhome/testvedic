/**
 * 
 */
package com.vedic.maths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Badrinath
 *
 */
public class ResultPage extends Activity {
	
	String fno,sno;
	Map<Integer, List<String>> maps;
	TextView rules;
	Button next,prev;
	int nextVal,preVal;
	Typeface type;
	int decideVal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultpage);
		
		 type=Typeface.createFromAsset(getAssets(), "SCHLBKBI.TTF");
	       
		 try {
				decideVal=this.getIntent().getExtras().getInt("decideVal");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		nextVal=2;
		preVal=0;
		
		rules=(TextView)findViewById(R.id.rules);
		next=(Button)findViewById(R.id.next);
		prev=(Button)findViewById(R.id.prev);
		
		if(null!=this.getIntent().getExtras().get("fno")){
			fno=this.getIntent().getExtras().get("fno").toString();
		}
		
		if(null!=this.getIntent().getExtras().get("sno")){
			sno=this.getIntent().getExtras().get("sno").toString();
		}
		
		maps = new HashMap<Integer, List<String>>();
		maps = Multiplication.callMultiplication(fno,sno,decideVal);
		
		List<String> str = maps.get(1);
		rules.setText(Utils.getCombineString(str));
		 rules.setTypeface(type);
		
		next.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				List<String> str = maps.get(nextVal);
				nextVal=nextVal+1;
				preVal=preVal+1;
				rules.setText(Utils.getCombineString(str));
				 rules.setTypeface(type);
				
				if(maps.get(nextVal)==null){
					next.setVisibility(View.GONE);
				}
			}
		});
		
		prev.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				next.setVisibility(View.VISIBLE);
				
				if (preVal == 0) {
					Intent enterDetail = new Intent(ResultPage.this,
							Rules.class);
					enterDetail.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(enterDetail);
				} else {
					List<String> str = maps.get(preVal);
					// nextVal=nextVal+1;
					preVal = preVal - 1;
					nextVal = nextVal - 1;
					rules.setText(Utils.getCombineString(str));
					 rules.setTypeface(type);
				}
			}
		});
	}

}
