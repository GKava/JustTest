package bar.appbarbottom.justtest;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static bar.appbarbottom.justtest.MainFragment.APP_PREFERENCES;
import static bar.appbarbottom.justtest.MainFragment.APP_PREFERENCES_COINS;


/**
 * A simple {@link Fragment} subclass.
 */
    public class StartTest extends Fragment implements View.OnClickListener {

    SharedPreferences mSettings;
    TextView txtCoins;
    Button start, back;
    ImageView helpView;
    private int coins;
    private int chooseTest;
    String title,content;

    public StartTest() {
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
        txtCoins.setText(" " + coinsString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_test, container, false);
        start = view.findViewById(R.id.start);
        back = view.findViewById(R.id.back);
        helpView = view.findViewById(R.id.helpView);
        helpView.setOnClickListener(this);
        start.setOnClickListener(this);
        back.setOnClickListener(this);
        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        txtCoins = view.findViewById(R.id.txtCoins);
        Drawable img = getResources().getDrawable(R.drawable.ic_monetization_on_black_24dp);
        img.setBounds(0, 0, 100, 100);
        txtCoins.setCompoundDrawables(img, null, null, null);


        Bundle bundle = getArguments();
        if (bundle != null) {
            chooseTest = bundle.getInt("tag");
        }

        return view;

    }
    public void showToast(int toastNumber){
        Toast toast = Toast.makeText(getActivity(),
                "Необходимо "+toastNumber+" монет чтобы начать тест.", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:

                if (chooseTest == 1) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new FirstTest())
                            .commit();
                }

                if (chooseTest == 2) {
                    if (coins<1){
                        showToast(1);
                    } else {
                        coins=coins-1;
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new RandomTest())
                                .commit();
                    }
                }
                break;
            case R.id.back:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new MainFragment())
                        .commit();
                break;

            case R.id.helpView:
                if (chooseTest == 1) {
                title= "Тест месяца";
                content= "описание теста месяца";
                }

                if (chooseTest == 2) {
                    title= "Рандомный тест";
                    content= "описание рандомного теста ";
                }

                createRateDialog(title, content);
                break;
        }
    }
    private void createRateDialog(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setNegativeButton("ЗАКРЫТЬ",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                });
        builder.setPositiveButton("",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                });
        builder.show();
    }
}