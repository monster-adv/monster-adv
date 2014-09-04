package com.example.digitalsignage;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;



public class MainActivity extends ActionBarActivity {

	private Intent intent;
	private EditText edtTextAddress;
	private Button btnConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // implement
        edtTextAddress = (EditText) findViewById(R.id.edtTextAddress);
        btnConnect = (Button) findViewById(R.id.Connect);
     
        btnConnect.setOnClickListener(buttonConnectOnClickListener);
    }

    OnClickListener buttonConnectOnClickListener = new OnClickListener() {
        public void onClick(View arg0) {
        	intent = new Intent(getApplicationContext(), DigitalSignageTask.class);
        	intent.putExtra("IP", edtTextAddress.getText().toString());
        	startActivity(intent);
        }
    };
}
