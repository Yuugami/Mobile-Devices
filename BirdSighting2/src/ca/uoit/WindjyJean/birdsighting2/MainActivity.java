package ca.uoit.WindjyJean.birdsighting2;

import java.text.DateFormat;
import java.util.Date;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity 
{
	Sighting [] sightings = {
			new Sighting ("Pigeon", "Everywhere", "An Ugly Bird"),
			new Sighting ("Robin", "Back Yard", "The Early Bird Gets the worm"),
			new Sighting("Blue Jay", "AC Centre", "Let's play ball")
	};
	
	public void onBirdClicked(int position) 
	{ 
		myDetailFragment.displayDetail(position); 
	} 
	
	DetailFragment myDetailFragment;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
