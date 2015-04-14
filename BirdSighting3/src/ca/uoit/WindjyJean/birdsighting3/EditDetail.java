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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class EditDetail extends Fragment 
{
	ArrayList<Sighting> sightings; 
	Activity myActivity; 

	TextView view1, view2, view3;
	Button cancel, done;
	//EditText editText1, editText2, editText3;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{ 
		View view; 
		view = inflater.inflate(R.layout.edit_view, container, false); 
		
		myActivity = getActivity(); 
		sightings = ((MainActivity) myActivity).sightings; 
		view1 = (EditText) view.findViewById(R.id.editText1); 
		view2 = (EditText) view.findViewById(R.id.editText2); 
		view3 = (EditText) view.findViewById(R.id.editText3); 
		
		cancel = (Button) view.findViewById(R.id.button1); 
		cancel.setOnClickListener(myCancelListener); 
		done = (Button) view.findViewById(R.id.button2); 
		done.setOnClickListener(myDoneListener);
		
		return view;  
	}
	
	private OnClickListener myDoneListener = new OnClickListener() 
	{ 
		public void onClick(View view) 
		{ 
			Sighting sighting = new Sighting(view1.getText().toString(),
					view2.getText().toString(),
					view3.getText().toString()); 
			
			sightings.add(sighting);
			((MainActivity) myActivity).editCancel();
		} 
	}; 
	   
	   
	private OnClickListener myCancelListener = new OnClickListener() 
	{ 
		public void onClick(View view) 
		{
			((MainActivity) myActivity).editCancel(); 
		} 
	};
}
