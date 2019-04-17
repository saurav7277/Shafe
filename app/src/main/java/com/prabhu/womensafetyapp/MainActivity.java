package com.prabhu.womensafetyapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteDatabase db;
		db=openOrCreateDatabase("NumDB", Context.MODE_PRIVATE, null);
		//Toast.makeText(getApplicationContext(), "db created",Toast.LENGTH_LONG).show();
		db.execSQL("CREATE TABLE IF NOT EXISTS details(name VARCHAR,number VARCHAR);");
		Intent i_startservice=new Intent(MainActivity.this,BgService.class);
		startService(i_startservice);
	}

	
	public void register(View v) {
		Intent i_register=new Intent(MainActivity.this,Register.class);
		startActivity(i_register);
		
	}
	
public void display_no(View v) {
	Intent i_view=new Intent(MainActivity.this,Display.class);
	startActivity(i_view);
		
	}

public void instruct(View v) {	
	Intent i_help=new Intent(MainActivity.this,Instructions.class);
    startActivity(i_help);
}

public void verify(View v) {	
	Intent i_verify=new Intent(MainActivity.this,Verify.class);
    startActivity(i_verify);
}
public void onDestroy()
{
	super.onDestroy();
	finish();
}
}