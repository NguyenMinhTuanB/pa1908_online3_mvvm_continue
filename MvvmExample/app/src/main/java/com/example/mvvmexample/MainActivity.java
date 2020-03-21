package com.example.mvvmexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.mvvmexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new LoginViewModel());
        binding.executePendingBindings();
    }

    @BindingAdapter({"toastMess"})
    public static void runMe(View view, String message) {
        if (message != null) {
            Toast.makeText(view.getContext(), message + "TUan", Toast.LENGTH_SHORT).show();
        }
    }
}
