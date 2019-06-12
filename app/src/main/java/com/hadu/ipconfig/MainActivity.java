package com.hadu.ipconfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String CONFIG_EXTRA = "com.ktakilat.loan.IPConfigReceiver";

    private Button mReleaseBtn;
    private Button mPreReleaseBtn;
    private Button mTestIpBtn;
    private Button mCustomIpBtn;
    private EditText mCustomIpEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReleaseBtn = findViewById(R.id.release_ip_btn);
        mPreReleaseBtn = findViewById(R.id.pre_release_ip_btn);
        mTestIpBtn = findViewById(R.id.test_ip_btn);
        mCustomIpBtn = findViewById(R.id.custom_ip_btn);
        mCustomIpEt = findViewById(R.id.custom_ip_et);

        mReleaseBtn.setOnClickListener(this);
        mPreReleaseBtn.setOnClickListener(this);
        mTestIpBtn.setOnClickListener(this);
        mCustomIpBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction("com.ktakilat.loan.ipConfig");
        switch (v.getId()){
            case R.id.release_ip_btn:
                intent.putExtra(CONFIG_EXTRA, "https://battlefront.danacepat.com");
                break;
            case R.id.pre_release_ip_btn:
                intent.putExtra(CONFIG_EXTRA, "http://bt-java.fastuang.top");
                break;
            case R.id.test_ip_btn:
                intent.putExtra(CONFIG_EXTRA, "http://battlefront.fastuang.top");
                break;
            case R.id.custom_ip_btn:
                intent.putExtra(CONFIG_EXTRA, mCustomIpEt.getText().toString());
                break;
        }
        sendBroadcast(intent);
    }
}
