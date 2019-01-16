package arjun92.tcss450.uw.edu.fragmentslab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {
//test change

    public ColorFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            int color = getArguments().getInt(getString(R.string.all_color_key));
            updateContent(color); }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }
    public void updateContent(int color) {
        TextView tv = getActivity().findViewById(R.id.text_color_label);
        tv.setTextColor(color); }

    }
