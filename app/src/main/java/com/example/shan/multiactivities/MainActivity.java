package com.example.shan.multiactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int evenCounter = 0;
    private TextView textView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ActivityEvent", "onCreate called");

        textView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);

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


    public void openActivity(View view){
        Intent intent = new Intent(MainActivity.this,
                SecondActivity.class);
        intent.putExtra("lastActivity",
                mEditText.getText().toString());

        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            Toast.makeText(MainActivity.this,
                    data.getStringExtra("LastActivity"),
                    Toast.LENGTH_LONG).show();
        }
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
