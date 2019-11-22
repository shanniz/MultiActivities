package com.example.shan.multiactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String lastActivity = getIntent().getStringExtra("lastActivity");
        Toast.makeText(SecondActivity.this,
                lastActivity, Toast.LENGTH_LONG).show();
    }

    public void closeActivity(View view){
        Intent intent = new Intent();
        intent.putExtra("LastActivity", "SecondActivity");

        setResult(RESULT_OK, intent);

        finish();
    }
}
