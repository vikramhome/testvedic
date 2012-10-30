/**
 * 
 */
package com.vedic.maths;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Badrinath
 *
 */
public class SelectRule extends Activity{
	
	Button tryOnce;
	TextView header,ruletext;
	Typeface type;
	Spinner rulemethods;
	ArrayList<String> text;
	int decideVal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectrule);
		text= new ArrayList<String>();
		text.add("Method 1- Dasham Dhani");
		text.add("Method 2 - AstaVakra");
		
		ruletext=(TextView)findViewById(R.id.ruletext);
		
		  header=(TextView)findViewById(R.id.header);
	        type=Typeface.createFromAsset(getAssets(), "SAMARN__.TTF");
	        header.setTypeface(type);
		
		tryOnce=(Button)findViewById(R.id.tryOnce);
		tryOnce.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent enterIntent= new Intent(SelectRule.this,Rules.class);
				enterIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				enterIntent.putExtra("decideVal", decideVal);
				startActivity(enterIntent);
				
			}
		});
		
		rulemethods=(Spinner)findViewById(R.id.rulemethods);
		rulemethods.setAdapter(new SpinClassAdapter(SelectRule.this,R.layout.spinner, text));
		
		rulemethods.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

	        
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				//System.out.println("Class Type"+parent.getItemAtPosition(position).toString());
				//selectedClasstype=parent.getItemAtPosition(position).toString();
						if (position == 0) {
							ruletext.setVisibility(View.VISIBLE);
							ruletext.setTextColor(Color.BLACK);
							ruletext.setPadding(10, 0, 0, 0);
							ruletext.setText("\tThis method is popularly known as Dhasham Dhani."
									+ "This was formulated in 1600 BC by Rishi Dhasham.\n\tThis method needs two input whose last digits sum is 10 and other digits are same."
									+ "Eg: 623 & 627");
							  type=Typeface.createFromAsset(getAssets(), "SCHLBKBI.TTF");
							  ruletext.setTypeface(type);
							decideVal=position+1;
						}
						if (position == 1) {
							ruletext.setVisibility(View.VISIBLE);
							ruletext.setTextColor(Color.BLACK);
							ruletext.setPadding(10, 0, 0, 0);
							ruletext.setText("\tThis method is popularly known as AstaVakra."
									+ "This was formulated in 1799 BC by Rishi Chirayu.\n\tThis method needs two input which are closer to multiples of 10."
									+ "Eg: 98 & 97");
							type=Typeface.createFromAsset(getAssets(), "SCHLBKBI.TTF");
							  ruletext.setTypeface(type);
							decideVal=position+1;
						}
				
			}

		
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        });

		
	}
	
	 public class SpinClassAdapter extends ArrayAdapter<List> {

		    public SpinClassAdapter(Context context, int textViewResourceId,
		            List objects) {
		        super(context, textViewResourceId, objects);
		        // TODO Auto-generated constructor stub
		    }

		   
		    public View getDropDownView(int position, View convertView,
		            ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }

		    public View getView(int position, View convertView, ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }

		    public View getCustomView(int position, View convertView,
		            ViewGroup parent) {

		        LayoutInflater inflater = getLayoutInflater();
		        View row = inflater.inflate(R.layout.spinner, parent, false);
		        TextView label = (TextView) row.findViewById(R.id.rul);
		    
		       label.setText(text.get(position));
		       type=Typeface.createFromAsset(getAssets(), "SCHLBKBI.TTF");
				  ruletext.setTypeface(type);
		       // label.setTypeface(type);
		        return row;
		    }
		}   

}
