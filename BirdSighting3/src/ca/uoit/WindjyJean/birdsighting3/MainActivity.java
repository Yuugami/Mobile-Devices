package ca.uoit.WindjyJean.birdsighting3;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity 
{
	ArrayList<Sighting> sightings;
	EditDetail myEditDetail;
	SimpleList mySimpleList = new SimpleList();
	DetailFragment myDetailFragment;
	
	public void onBirdClicked(int position) 
	{ 
		myDetailFragment.displayDetail(position); 
	} 
	
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        sightings = new ArrayList<Sighting>(); 
        
        sightings.add(new Sighting("Pigeon", "everywhere","An ugly bird")); 
        sightings.add(new Sighting("Robin", "back yard", "The early bird gets the worm")); 
        sightings.add(new Sighting("Akshay", "AC Centre", "Let's play ball")); 
        
        setContentView(R.layout.activity_main);
        myDetailFragment = new DetailFragment(); 
        FragmentTransaction transaction = getFragmentManager().beginTransaction(); 
        transaction.replace(R.id.detail_fragment, myDetailFragment); 
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NewApi")
	@Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
		/// Handle presses on the action bar items 
    	switch (item.getItemId()) 
    	{ 
    	case R.id.add_item: 
    		myEditDetail = new EditDetail(); 
    		FragmentTransaction transaction = getFragmentManager().beginTransaction(); 
    		transaction.replace(R.id.detail_fragment, myEditDetail); 
    		transaction.commit(); 
    		return true; 
    	default: 
    		return super.onOptionsItemSelected(item); 
    	} 
    }
    
    @SuppressLint("NewApi")
	public void editCancel() 
    { 
    	FragmentTransaction transaction = getFragmentManager().beginTransaction(); 
    	transaction.replace(R.id.detail_fragment, myDetailFragment); 
    	transaction.commit(); 
    	myDetailFragment.displayDetail(0); 
    } 

    @SuppressLint("NewApi")
	public void editDone(Sighting sighting) 
    { 
    	mySimpleList.addSighting(sighting);
    	FragmentTransaction transaction = getFragmentManager().beginTransaction(); 
    	transaction.replace(R.id.detail_fragment, myDetailFragment); 
    	transaction.commit(); 
    }
}