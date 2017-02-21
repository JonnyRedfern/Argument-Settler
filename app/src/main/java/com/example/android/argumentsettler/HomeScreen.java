package com.example.android.argumentsettler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //the on click function for the start button
    public void nextScreen(View v)
    {
        EditText edit = (EditText) findViewById(R.id.target_number);
        Editable editable = edit.getText();
        //if there is text in the input line
        if(editable.toString() != null) {
            //check to see that the user input was an integer if not let them know that they need to try again
            try {
                int userInput = Integer.parseInt(editable.toString());
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("userInput", userInput);
                startActivity(intent);
            }catch(NumberFormatException e) {
                Button b = (Button)findViewById(R.id.start__button);
                b.setTextSize(10);
                b.setText("That was not a number.");
            }
        }

    }
}
