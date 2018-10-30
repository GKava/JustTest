package bar.appbarbottom.justtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
Button test1;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        test1 = view.findViewById(R.id.test1);
        test1.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test1:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FirstTest())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
