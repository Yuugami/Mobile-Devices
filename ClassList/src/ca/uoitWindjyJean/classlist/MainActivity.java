package ca.uoitWindjyJean.classlist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.text.DateFormat;

public class MainActivity extends ActionBarActivity 
{
	Sighting [] sightings = {
			new Sighting ("Pigeon", "Everywhere", "An Ugly Bird"),
			new Sighting ("Robin", "Back Yard", "The Early Bird Gets the worm"),
			new Sighting("Blue Jay", "AC Centre", "Let's play ball")
	};
	//private final String[] courses = {"CSCI 1030", "CSCI 1040", "CSCI 2000", 
	//		"CSCI 2050", "CSCI 3010", "CSCI 3020", "CSCI 3040", "CSCI 3055", 
	//		"CSCI 3090", "CSCI 4100", "CSCI 4160"};
	
	String[] courseNames = {"Intro to Comp Sci with C++", "Intro to Comp Sci with Python", 
    		"Practical Computing for Scientists", "Computer Architecture",
    		"Simulation and Modeling", "Operating Systems", "System Analysis and Design",
    		"Programming Languages", "Scientific Visualization and Computer Graphics",
    		"Mobile Devices", "Interactive Media"};
	
	private OnItemClickListener myMessageClickedHandler = new OnItemClickListener() 
	{
		 public void onItemClick(AdapterView parent, View v, int position, long id) 
		 {
			CheckedTextView cell = (CheckedTextView) v;
			Toast.makeText(getApplicationContext(), courseNames[position], Toast.LENGTH_SHORT).show();
			cell.toggle(); 
		 }
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //String[] courseNames = {"Intro to Comp Sci with C++", "CSCI1040", 
        //		"Practical Computing for Scientists"};
        
        ListView listView = (ListView)findViewById(R.id.listView1);
        
        ArrayAdapter<Sighting> adapter = new ArrayAdapter<Sighting>(this, 
        		android.R.layout.simple_list_item_multiple_choice, 
        		sightings);
        
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(myMessageClickedHandler);
        
//        listView.setOnItemClickListener(new OnItemClickListener()
//        {
//        	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3)
//        	{
//        		Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//        	}
//        });
        
        Toast.makeText(getApplicationContext(), "CLEEK", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NewApi") @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
    	ListView listView = (ListView) findViewById(R.id.listView1);
    	
    	Toast toast = Toast.makeText(this,
    			String.valueOf(listView.getCheckedItemCount()),
    			Toast.LENGTH_LONG);
    	toast.show();
    	
    	return true;
    }
}

class Sighting
{
	public String bird;
	public Date when;
	public String location;
	public String description;
	
	static DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
	
	public Sighting(String Bird, String Location, String Description)
	{
		bird = Bird;
		location = Location;
		description = Description;
		when = new Date();
	}
	
	@Override
	public String toString()
	{
		return bird + ": " + df.format(when);
	}
}
