package com.example.androidmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidmvvm.R;
import com.example.androidmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    Button btn;
//    TextView textView;

    //6- Connecting MainActivity with viewmodel and listening to livedata.
    AppVIewModel appVIewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appVIewModel.getAppName();
            }
        });


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                appVIewModel.getAppName();
//            }
//        });


        //instead of using deprecated methods.
        appVIewModel = new ViewModelProvider(this).get(AppVIewModel.class);

        //7- Listening and observing the changes to live data.
        appVIewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //Any changed in the live data do this.
//                textView.setText(s);
                binding.textView.setText(s);
            }
        });
    }


    //MVVM
    // We need to make connection "Binding" - Viewmodel
    // 1- implementing the dependency of ViewModel
    // 2- Creating ViewModel Class
}