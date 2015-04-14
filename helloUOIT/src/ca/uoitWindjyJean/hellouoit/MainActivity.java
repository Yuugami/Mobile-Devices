package ca.uoitWindjyJean.hellouoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	public final static String USER_NAME = "user name";
	
	public String field = "name";
	public final String fieldKey = "fieldKey"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(DisplayMessage.nameKey != null)
        {
        	TextView label = (TextView) findViewById(R.id.editText1);
        	TextView label1 = (TextView) findViewById(R.id.defaultTextView);
        	label.setText(DisplayMessage.nameKey);
        	label1.setText(DisplayMessage.newGreeting + DisplayMessage.nameKey);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
    	outState.putString(fieldKey, field);
    	super.onSaveInstanceState(outState);
    }
    
    public void sendMessage(View view)
    {
    	Intent intent = new Intent(this, DisplayMessage.class);
    	EditText nameText = (EditText) findViewById(R.id.editText1);
    	String name = nameText.getText().toString();
    	intent.putExtra(USER_NAME, name);
    	startActivity(intent);
    }
}
