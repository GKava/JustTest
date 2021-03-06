package bar.appbarbottom.justtest;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    public static final String APP_PREFERENCES_COINS= "coins";
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences mSettings;
    int coins;
    Button test1,randomTest,hardTest;
    TextView txtCoins;
    StartTest startTest = new StartTest();
    private int chooseTest;
    Bundle bundle = new Bundle();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COINS, coins);
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COINS)) {
            coins = mSettings.getInt(APP_PREFERENCES_COINS, 0);
        }
        String coinsString = String.valueOf(coins);
        txtCoins.setText(" "+coinsString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        test1 = view.findViewById(R.id.test1);
        hardTest = view.findViewById(R.id.hardTest);
        txtCoins = view.findViewById(R.id.txtCoins);
        randomTest = view.findViewById(R.id.randomTest);
        test1.setOnClickListener(this);
        randomTest.setOnClickListener(this);
        hardTest.setOnClickListener(this);
        // Inflate the layout for this fragment

        Drawable img = getResources().getDrawable(R.drawable.ic_monetization_on_black_24dp);
        img.setBounds(0, 0, 100, 100);
        txtCoins.setCompoundDrawables(img, null, null, null);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test1:
                chooseTest=1;
                bundle.putInt("tag", chooseTest);
                startTest.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, startTest)
                       // .addToBackStack(null)
                        .commit();
                break;
            case R.id.randomTest:
                chooseTest=2;
                bundle.putInt("tag", chooseTest);
                startTest.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, startTest)
                        //.addToBackStack(null)
                        .commit();
                break;
            case R.id.hardTest:
                chooseTest=3;
                bundle.putInt("tag", chooseTest);
                startTest.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, startTest)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
