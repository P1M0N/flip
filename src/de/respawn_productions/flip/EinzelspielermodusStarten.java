package de.respawn_productions.flip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EinzelspielermodusStarten extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.einzelspielermodus);

		final FileInputStream inputStream;
		final InputStreamReader str;
		final TextView test = (TextView) findViewById(R.id.test);

		try {
			inputStream = openFileInput("test.txt");
			str = new InputStreamReader(inputStream);

			char[] inputBuffer = new char[100];

			str.read(inputBuffer);

			String readString = new String(inputBuffer);
			test.setText(readString);
		} catch (Exception e) {
			test.setText(e.getMessage());
		}



		

		
	}
}
