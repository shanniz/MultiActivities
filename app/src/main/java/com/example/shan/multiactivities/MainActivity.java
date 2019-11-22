package com.example.shan.multiactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int evenCounter = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ActivityEvent", "onCreate called");

        textView = findViewById(R.id.textView);
        if(savedInstanceState!=null){
            evenCounter = Integer.valueOf(
                            savedInstanceState.get("countIndex").toString());

            textView.setText( String.valueOf(evenCounter));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countIndex" , evenCounter);
    }

    public void updateCounter(View view){
        evenCounter+=2;
        textView.setText( String.valueOf(evenCounter));
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.d("ActivityEvent", "onStart called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("ActivityEvent", "onStop called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ActivityEvent", "onDestroy called");
    }
}
