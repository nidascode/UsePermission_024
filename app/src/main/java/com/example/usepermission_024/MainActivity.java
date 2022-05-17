package com.example.usepermission_024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void use_bt_action(View v){
        if(checkSelfPermission("com.example.dangerousactivity.MY_DANG_PERM") != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{"com.example.sectionc_024_MyPermission"}, 1);
        }
        else
        {
            Intent intent = new Intent();
            intent.setAction("com.example.sectionc_024_MyPermission");
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 1:
                Intent intent = new Intent();
                intent.setAction("com.example.sectionc_024_MyPermission");
                startActivity(intent);

        }
    }
}