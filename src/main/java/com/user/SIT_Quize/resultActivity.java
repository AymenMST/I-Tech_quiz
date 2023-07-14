package com.user.SIT_Quize;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 2/14/2019.
 */
public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        Button button = (Button) findViewById(R.id.button);
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        //SharedPreferences settings = getSharedPreferences("SIT_Quiz", Context.MODE_PRIVATE);
        //int totalScore = settings.getInt("totalScore", 0);
        //totalScore +=score;

        resultLabel.setText(score + " / 50");


        //totalScoreLabel.setText("Total Score: "+totalScore);


        //Update total score
        // SharedPreferences.Editor editor = settings.edit();
        //editor.putInt("totalScore", totalScore);
        //editor.commit();
    }

    public void close(View view) {
        finish();
    }
}
