package com.example.android.servicemediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startServiceBT;
    Button stopServiceBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startServiceBT = (Button) findViewById(R.id.start_bt);
        startServiceBT.setOnClickListener(this);
        stopServiceBT = (Button) findViewById(R.id.stop_bt);
        stopServiceBT.setOnClickListener(this);
    }

    private Intent getServiceIntent(){

        return new Intent(this,PlayMusic.class);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_bt:
                startService(getServiceIntent());
                break;
            case R.id.stop_bt:
                stopService(getServiceIntent());
                break;
            default:
                return;

        }
    }
}
