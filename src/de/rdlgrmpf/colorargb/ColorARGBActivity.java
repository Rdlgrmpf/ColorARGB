package de.rdlgrmpf.colorargb;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ColorARGBActivity extends Activity {
	EditText textAlpha;
	EditText textR;
	EditText textG;
	EditText textB;
	EditText output;

	Button buttonDoIt;

	int alpha;
	int r;
	int g;
	int b;

	InputFilter[] filterNumbers;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		filterNumbers = new InputFilter[] { new InputFilterMinMax(0, 255) };

		textAlpha = (EditText) findViewById(R.id.editText1);
		textR = (EditText) findViewById(R.id.editText2);
		textG = (EditText) findViewById(R.id.editText3);
		textB = (EditText) findViewById(R.id.editText4);
		output = (EditText) findViewById(R.id.editText5);

		buttonDoIt = (Button) findViewById(R.id.buttonDoIt);

		textAlpha.setFilters(filterNumbers);
		textR.setFilters(filterNumbers);
		textG.setFilters(filterNumbers);
		textB.setFilters(filterNumbers);

		alpha = 255;
		r = 255;
		g = 255;
		b = 255;

		buttonDoIt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				alpha = Integer.parseInt(textAlpha.getText().toString());
				r = Integer.parseInt(textR.getText().toString());
				g = Integer.parseInt(textG.getText().toString());
				b = Integer.parseInt(textB.getText().toString());

				int color = Color.argb(alpha, r, g, b);
				output.setTextColor(color);
				output.setText("#" + Integer.toHexString(color));

			}

		});
	}
}