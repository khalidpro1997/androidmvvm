package com.example.androidmvvm.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmvvm.util.MyModel;

public class AppVIewModel extends ViewModel {

    //4 LiveData
//    LiveData<String> liveData; not use
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();


    //3. Connecting ViewModel with database. - (Model).
    private MyModel getAppFromDatabase(){
        return new MyModel("MVVM tutorial",90000,10);

        //LiveData vs MutableLiveData.
        //Mutable:we can post and set the live data.
    }

    //5- connecting viewmodel with MainActivity.
    public void getAppName(){
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }
}
