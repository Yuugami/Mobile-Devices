package ca.uoit.WindjyJean.birdsighting3;

import java.text.DateFormat;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class DetailFragment extends Fragment 
{
	ArrayList<Sighting> sightings; 
	Activity myActivity;
	int arrayIndex;

	TextView view1;
	TextView view2; 
	TextView view3; 
	TextView view4; 

	static DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,  
			DateFormat.SHORT);
	
	public void displayDetail(int p) 
	{ 
		Sighting sighting;
		sighting = sightings.get(p);
		view1.setText(sighting.bird);
		view2.setText(df.format(sighting.when)); 
		view3.setText(sighting.location); 
		view4.setText(sighting.description);
		arrayIndex = p;
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
		Sighting sighting; 
	    sighting = sightings.get(arrayIndex);
		view1.setText(sighting.bird);
		view2.setText(df.format(sighting.when)); 
		view3.setText(sighting.location); 
		view4.setText(sighting.description);
		return view; 
	} 
}
