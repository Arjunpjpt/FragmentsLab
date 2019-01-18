package arjun92.tcss450.uw.edu.fragmentslab;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {


    // push test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.frame_main_container) != null) {
                getSupportFragmentManager().beginTransaction() .add(R.id.frame_main_container, new FirstFragment()) .commit();
            }
        }

    }

    @Override
    public void onFragmentInteraction(int color) {
        Log.d("ACTIVITY", "Red: " + Color.red(color) + " Green: " + Color.green(color) +
                " Blue: " + Color.blue(color));
        ColorFragment colorFragment;

        colorFragment = (ColorFragment) getSupportFragmentManager(). findFragmentById(R.id.fragment_main_color);
        if(colorFragment!= null) { colorFragment.updateContent(color);
        } else {

            colorFragment = new ColorFragment();

            Bundle args = new Bundle();
            args.putSerializable(getString(R.string.all_color_key), color);
            colorFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction().replace(R.id.frame_main_container, colorFragment).addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }
    }
}
