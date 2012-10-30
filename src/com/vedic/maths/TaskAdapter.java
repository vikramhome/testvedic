/**
 * 
 */
package com.vedic.maths;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * @author Badrinath
 *
 */
public class TaskAdapter extends BaseAdapter{
	
	private Context mContext;
	private LayoutInflater mInflater;
	private int [] id = {R.drawable.plus,R.drawable.subtract,R.drawable.multiply,R.drawable.divide};
	ImageView txt;

	public TaskAdapter(Context c) {
		// TODO Auto-generated constructor stub
		mContext=c;
		 mInflater = LayoutInflater.from(c);
	}
	

	public int getCount() {
		return id.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.task, parent, false);
			txt = (ImageView) convertView.findViewById(R.id.taskimage);

			txt.setImageResource(id[position]);
			if (position == 2) {
				txt.setPadding(0, 70, 0, 0);
				txt.setImageResource(id[position]);
			}
			if (position == 3) {
				txt.setPadding(0, 50, 0, 0);
				txt.setImageResource(id[position]);
			}
		}
		return convertView;
	}

}