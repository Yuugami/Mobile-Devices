package ca.uoitWindjyJean.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
{
	Button plus, minus, multiply, divide;
	TextView result;
	EditText num1, num2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        plus = (Button)findViewById(R.id.button1);
        minus = (Button)findViewById(R.id.button2);
        multiply = (Button)findViewById(R.id.button3);
        divide = (Button)findViewById(R.id.button4);
        
        num1 = (EditText)findViewById(R.id.editText1);
        num2 = (EditText)findViewById(R.id.editText2);
        
        result = (TextView)findViewById(R.id.textView3);
        
        plus.setOnClickListener(new View.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				try
				{
					double n1 = Double.parseDouble(num1.getText().toString());
					double n2 = Double.parseDouble(num2.getText().toString());
					double sum = n1+n2;
					result.setText(""+sum);
				}
				catch(Exception e)
				{
					
				}
			}
		});
        
        minus.setOnClickListener(new View.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				try
				{
					double n1 = Double.parseDouble(num1.getText().toString());
					double n2 = Double.parseDouble(num2.getText().toString());
					double sum = n1-n2;
					result.setText(""+sum);
				}
				catch(Exception e)
				{
					
				}
			}
		});
        
        multiply.setOnClickListener(new View.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				try
				{
					double n1 = Double.parseDouble(num1.getText().toString());
					double n2 = Double.parseDouble(num2.getText().toString());
					double sum = n1*n2;
					result.setText(""+sum);
				}
				catch(Exception e)
				{
					
				}
			}
		});
        
        divide.setOnClickListener(new View.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				try
				{
					double n1 = Double.parseDouble(num1.getText().toString());
					double n2 = Double.parseDouble(num2.getText().toString());
					double sum = n1/n2;
					result.setText(""+sum);
				}
				catch(Exception e)
				{
					
				}
			}
		});
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
