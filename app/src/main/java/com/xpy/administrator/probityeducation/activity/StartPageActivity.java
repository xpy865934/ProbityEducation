package com.xpy.administrator.probityeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.xpy.administrator.probityeducation.R;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(StartPageActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.gradient_in,R.anim.gradient_out);
                StartPageActivity.this.finish();
            }
        },2000);
    }
}
