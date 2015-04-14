package ca.uoit.WindjyJean.birdsighting2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleList extends Fragment 
{
	Sighting [] sightings; 
	Activity myActivity;
	
	private OnItemClickListener sightingSelected = new OnItemClickListener() 
	{ 
		public void onItemClick(AdapterView parent, View v, int position, long id) 
		{ 
			((MainActivity)myActivity).onBirdClicked(position); 
		} 
	}; 
	  
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{ 
		View view; 
		view = inflater.inflate(R.layout.sighting_list, container, false); 
		myActivity = getActivity(); 
		sightings = ((MainActivity) myActivity).sightings; 
		ArrayAdapter<Sighting> adapter = new ArrayAdapter<Sighting>(myActivity, 
				android.R.layout.simple_list_item_1, sightings); 

		ListView listView = (ListView)view.findViewById(R.id.listView1); 
		listView.setAdapter(adapter); 
		listView.setOnItemClickListener(sightingSelected); 
		return view; 
	}
}
