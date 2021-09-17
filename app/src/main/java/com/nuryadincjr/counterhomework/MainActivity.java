package com.nuryadincjr.counterhomework;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.counterhomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCount.setOnClickListener(view -> {
            count = Integer.parseInt(binding.txtCounter.getText().toString());
            count += 1;

            binding.txtCounter.setText(String.valueOf(count));
        });

        //01 retrieve the saved Bundle from onCreate
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");

            binding.txtCounter.setText(count);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(this, "Saved count is " +
                binding.txtCounter.getText().toString(), Toast.LENGTH_SHORT).show();

        outState.putString("count", String.valueOf(binding.txtCounter.getText()));
    }

    //02 retrieve the saved Bundle, called after onStart()
//    @Override
//    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
//            String count = savedInstanceState.getString("count");
//
//            binding.txtCounter.setText(count);
//        }
//    }
}