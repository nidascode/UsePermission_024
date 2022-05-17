package com.example.usepermission_024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
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