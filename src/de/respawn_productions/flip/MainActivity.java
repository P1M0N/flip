package de.respawn_productions.flip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button Einzelspieler = (Button) findViewById(R.id.Einzelspieler);
		final Button Mehrspieler = (Button) findViewById(R.id.Mehrspieler);

		try {
			writeFile();
		} catch (Exception e) {
			Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		final OnClickListener ClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.Einzelspieler:
					Intent Einzelspieler = new Intent(MainActivity.this, EinzelspielermodusStarten.class);
					startActivity(Einzelspieler);	
					break;
				case R.id.Mehrspieler:
					Intent Mehrspieler = new Intent(MainActivity.this, MehrspielermodusStarten.class);
					startActivity(Mehrspieler);	
					break;

				default:
					break;
				}
							
			}
		};


		Einzelspieler.setOnClickListener(ClickListener);
		Mehrspieler.setOnClickListener(ClickListener);

	}

	public int writeFile() throws FileNotFoundException {
		String filename = "test.txt";
		String string = "Level1;Level2;Level3;Level4";

		FileOutputStream outputStream;
		FileInputStream inputStream = openFileInput("test.txt");
		InputStreamReader str = new InputStreamReader(inputStream);

		try {
			outputStream = openFileOutput(filename, MainActivity.MODE_PRIVATE);
			outputStream.write(string.getBytes());
			outputStream.close();
		} catch (Exception e) {
			Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
		}

		return 1;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
