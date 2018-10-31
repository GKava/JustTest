package bar.appbarbottom.justtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstTest extends Fragment implements View.OnClickListener {
    Button this1,this2,this3,this4;
    TextView question;
    ImageView imageView;
    private int value;
    private int point=0;
    private InterstitialAd mInterstitialAd;
    private String rating;
    public FirstTest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_first_test, container, false);
        question = view.findViewById(R.id.question);
        imageView = view.findViewById(R.id.imageView);
        this1 = view.findViewById(R.id.this1);
        this2 = view.findViewById(R.id.this2);
        this3 = view.findViewById(R.id.this3);
        this4 = view.findViewById(R.id.this4);
        this1.setOnClickListener(this);
        this2.setOnClickListener(this);
        this3.setOnClickListener(this);
        this4.setOnClickListener(this);
        imageView.setImageResource(R.drawable.mozg);
        testQuestion();

        MobileAds.initialize(getActivity(),
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        return view;
    }

    public void viewAds() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void testQuestion(){
        if (point==0){
            question.setText("На какой вопрос ученые из до сих пор не нашли ответа ?");
            this1.setText("Есть ли жизнь на марсе ?");
            this2.setText("Существует ли бог ?");
            this3.setText("Чи да ?");
            this4.setText("В чем смысл жизни ?");
        }
        if (point==1){
            question.setText("Что опаснее всего для монитора ?");
            this1.setText("Скачок напряжения");
            this2.setText("Моль");
            this3.setText("Вода");
            this4.setText("Пез**ки пришедшие в гости");
        }
        if (point==2){
            question.setText("Кто  обокрал Фараона в октябре ?");
            this1.setText("Государств");
            this2.setText("Друзья");
            this3.setText("Школьник");
            this4.setText("Девушка");
        }
        if (point==3){
            if (value==0){
                rating = "просто ухади";
            }
            if (value==1){
                rating = "ну ты лох";
            }
            if (value==2){
                rating = "средне";
            }
            if (value==3){
                rating = "шаришь";
            }
            question.setText("Счет: "+value+"/3"+"\n"+ rating);
            this1.setText("Вернуться в главное меню");
            this2.setVisibility(View.GONE);
            this3.setVisibility(View.GONE);
            this4.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.this1:
                if (point==3){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new  MainFragment())
                            .commit();
                }else {
                    point++;
                    testQuestion();
                }
                break;

                case R.id.this2:
                    if (point==1){
                        value++;
                    }
                point++;
                testQuestion();
                break;

            case R.id.this3:
                if (point==0 | point==2){
                    value++;

                }
                point++;
                testQuestion();
                break;

            case R.id.this4:


                point++;
                testQuestion();
                break;
        }
    }
}
