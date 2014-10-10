package com.hartman.firstapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.widget.DrawerLayout;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button button = (Button) findViewById(R.id.Calculate);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EditText V0x = (EditText) findViewById(R.id.InputInitVelX);
				EditText V0y = (EditText) findViewById(R.id.InputInitVelY);
				EditText Ax = (EditText) findViewById(R.id.InputAccX);
				EditText Ay = (EditText) findViewById(R.id.InputAccY);
				EditText Vfx = (EditText) findViewById(R.id.InputFinalVelX);
				EditText Vfy = (EditText) findViewById(R.id.InputFinalVelY);
				EditText Tx = (EditText) findViewById(R.id.InputTimeX);
				EditText Ty = (EditText) findViewById(R.id.InputTimeY);
				EditText Dx = (EditText) findViewById(R.id.InputDX);
				EditText Dy = (EditText) findViewById(R.id.InputDY);
				double V0xD = Double.valueOf(V0x.getText().toString());
				double V0yD = Double.valueOf(V0y.getText().toString());
				double AxD = Double.valueOf(Ax.getText().toString());
				double AyD = Double.valueOf(Ay.getText().toString());
				double VfxD = Double.valueOf(Vfx.getText().toString());
				double VfyD = Double.valueOf(Vfy.getText().toString());
				double TxD = Double.valueOf(Tx.getText().toString());
				double TyD = Double.valueOf(Ty.getText().toString());
				double DxD = Double.valueOf(Dx.getText().toString());
				double DyD = Double.valueOf(Dy.getText().toString());
				if (Ty.getText().toString() == null){
					if ()
				}
					if (Tx.getText() != null && Ty.getText() == null
							|| Tx.getText() == null && Ty.getText() != null) {
						TxD = TyD;
						String TxS = String.valueOf(TxD);
						String TyS = String.valueOf(TyD);
						Tx.setText(TxS);
						Ty.setText(TyS);
					}
				if (V0y.getText().toString() != null
						&& Ay.getText().toString() != null
						&& Ty.getText().toString() != null
						&& Dy.getText().toString() == null) {
					DyD = V0yD * TyD + (0.5 * AyD) * Math.pow(TyD, 2);
					String DyS = String.valueOf(DyD);
					Dy.setText(DyS);
				}
			}
		});
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
