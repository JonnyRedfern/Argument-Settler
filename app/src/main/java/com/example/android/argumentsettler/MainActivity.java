
package com.example.android.argumentsettler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int team1Count;
    int team2Count;
    int goal;
    boolean won;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("userInput", 0);
        team1Count = 0;
        team2Count = 0;
        goal = intValue;
        won = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void incrimentTeam1(View v)
    {
        team1Count++;
        team1Show(team1Count);

    }

    public void incrimentTeam2(View v)
    {
        team2Count++;
        team2Show(team2Count);

    }

    //called every time player 1's button is clicked
    private void team1Show(int num) {
        Button tempButton = (Button) findViewById(R.id.team_1_button);
        Button tempButton2 = (Button)findViewById(R.id.team_2_button);
        //if player 1 wins
        if (team1Count == goal && !won)
        {
            playAgain("Player 1 wins.");
        }
       else if(team1Count < goal && team2Count < goal && !won){
            String temp = num + "";
            tempButton.setText(temp);
        }
    }

    //called every time player 2's button is clicked
    private void team2Show(int num)
    {
        Button tempButton = (Button) findViewById(R.id.team_2_button);
        Button tempButton2 = (Button)findViewById(R.id.team_1_button);
        //if player 2 wins
        if (team2Count == goal && !won)
        {
            playAgain("Player 2 wins.");
        }
       else if(team1Count < goal && team2Count < goal) {
            String temp = num+"";
            tempButton.setText(temp);
        }
    }

    //takes user to next screen where winner is announced and the option to play again is presented
    public void playAgain(String input)
    {
        Intent intent = new Intent(this,PlayAgain.class);
        intent.putExtra("winner",input);
        startActivity(intent);
    }



}
