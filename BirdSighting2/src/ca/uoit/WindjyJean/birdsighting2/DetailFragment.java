package ca.uoit.WindjyJean.birdsighting2;

import java.text.DateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment 
{
	Sighting [] sightings; 
	Activity myActivity; 

	TextView view1;
	TextView view2; 
	TextView view3; 
	TextView view4; 

	static DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,  
			DateFormat.SHORT);
	
	public void displayDetail(int p) 
	{ 
	      view1.setText(sightings[p].bird); 
	      view2.setText(df.format(sightings[p].when)); 
	      view3.setText(sightings[p].location); 
	      view4.setText(sightings[p].description); 
	} 
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{ 
		View view; 
		view = inflater.inflate(R.layout.detail_view, container, false); 
		myActivity = getActivity(); 
		sightings = ((MainActivity) myActivity).sightings; 
		((MainActivity)myActivity).myDetailFragment = this; 
		view1 = (TextView) view.findViewById(R.id.textView1); 
		view2 = (TextView) view.findViewById(R.id.textView2); 
		view3 = (TextView) view.findViewById(R.id.textView3); 
		view4 = (TextView) view.findViewById(R.id.textView4); 
		view1.setText(sightings[0].bird); 
		view2.setText(df.format(sightings[0].when)); 
		view3.setText(sightings[0].location); 
		view4.setText(sightings[0].description); 
		return view; 
	} 
}
