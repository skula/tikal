package com.skula.tikal.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.tikal.R;

public class BoardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new BoardView(this));
	}
}
