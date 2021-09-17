package com.nuryadincjr.counterhomework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView viewConter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        viewConter = (TextView) findViewById(R.id.txtCounter);
        editText = (EditText) findViewById(R.id.inpEditText);
        button = (Button) findViewById(R.id.btnCount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(viewConter.getText().toString());
                count += 1;

                viewConter.setText(String.valueOf(count));
            }
        });

        //01 retrieve the saved Bundle from onCreate
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");

            if (viewConter != null)
                viewConter.setText(count);

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(this, "Saved count is " +
                viewConter.getText().toString(), Toast.LENGTH_SHORT).show();

        outState.putString("count", String.valueOf(viewConter.getText()));
    }

    //02 retrieve the saved Bundle, called after onStart()
//    @Override
//    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
//            String count = savedInstanceState.getString("count");
//
//            if (count != null)
//                viewConter.setText(count);
//
//        }
//    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }


}