package com.user.SIT_Quize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 2/16/2019.
 */

public class NameActivity extends AppCompatActivity {

    public Intent intent;
    public Button btn;
    public EditText edt;
    public String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        btn = (Button) findViewById(R.id.button);
        edt = (EditText) findViewById(R.id.editText);
        intent = new Intent(getApplicationContext(), MainActivity.class);


    }

    public void start(View view) {

        playerName = edt.getText() + "";
        if (playerName.isEmpty()) {
        } else {
            intent.putExtra("playerName", playerName);
            startActivity(intent);
        }
    }
}
