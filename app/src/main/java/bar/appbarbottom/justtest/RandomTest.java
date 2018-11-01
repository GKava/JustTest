package bar.appbarbottom.justtest;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.InterstitialAd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static bar.appbarbottom.justtest.AllQuestions.getAllQuestions;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomTest extends Fragment implements View.OnClickListener{
    Button this1,this2,this3,this4;
    TextView question;
    ImageView imageView;
    private int value;
    private int point=0;
    private InterstitialAd mInterstitialAd;
    private String rating;
    private  int f0=0;
    private  int f1=1;
    private  int f2=2;
    private  int f3=3;
    private  int f4=4;
    private  int f5=5;
    private  int f6=6;
    private  int f7=7;
    private  int f8=8;
    private  int f9=9;
    private  int f10=10;
    private  int f11=11;
    private  int f12=12;
    private  int f13=12;
    List<AllQuestions> allQuestions = getAllQuestions();

    public static final String APP_PREFERENCES_COINS= "coins";
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences mSettings;
    int coins;

    public RandomTest() {

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

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_random_test, container, false);
            mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
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
            Collections.shuffle(allQuestions);
            testQuestion();
            return view;
    }

    public void checkWinners(int answer){
                if (point==0 & allQuestions.get(f0).getWinInt()==answer ){
                    value++;
                }
                if (point==1 & allQuestions.get(f1).getWinInt()==answer ){
                    value++;
                }
                if (point==2 & allQuestions.get(f2).getWinInt()==answer ){
                    value++;
                }
                if (point==3 & allQuestions.get(f3).getWinInt()==answer ){
                    value++;
                }
                if (point==4 & allQuestions.get(f4).getWinInt()==answer ){
                    value++;
                }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.this1:
                if (point==11){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new  MainFragment())
                            .commit();
                }else {
                    checkWinners(1);
                    point++;
                    testQuestion();
                }
                break;

            case R.id.this2:
                checkWinners(2);
                point++;
                testQuestion();
                break;

            case R.id.this3:
                checkWinners(3);
                point++;
                testQuestion();
                break;

            case R.id.this4:
                checkWinners(4);
                point++;
                testQuestion();
                break;

        }
    }
    public void testQuestion(){
        if (point==0){
            question.setText(allQuestions.get(f0).getQuestionsName());
            this1.setText(allQuestions.get(f0).getThis1());
            this2.setText(allQuestions.get(f0).getThis2());
            this3.setText(allQuestions.get(f0).getThis3());
            this4.setText(allQuestions.get(f0).getThis4());
        }
        if (point==1){
            question.setText(allQuestions.get(f1).getQuestionsName());
            this1.setText(allQuestions.get(f1).getThis1());
            this2.setText(allQuestions.get(f1).getThis2());
            this3.setText(allQuestions.get(f1).getThis3());
            this4.setText(allQuestions.get(f1).getThis4());
        }
        if (point==2){
            question.setText(allQuestions.get(f2).getQuestionsName());
            this1.setText(allQuestions.get(f2).getThis1());
            this2.setText(allQuestions.get(f2).getThis2());
            this3.setText(allQuestions.get(f2).getThis3());
            this4.setText(allQuestions.get(f2).getThis4());
        }
        if (point==3){
            question.setText(allQuestions.get(f3).getQuestionsName());
            this1.setText(allQuestions.get(f3).getThis1());
            this2.setText(allQuestions.get(f3).getThis2());
            this3.setText(allQuestions.get(f3).getThis3());
            this4.setText(allQuestions.get(f3).getThis4());
        }
        if (point==4){
            question.setText(allQuestions.get(f4).getQuestionsName());
            this1.setText(allQuestions.get(f4).getThis1());
            this2.setText(allQuestions.get(f4).getThis2());
            this3.setText(allQuestions.get(f4).getThis3());
            this4.setText(allQuestions.get(f4).getThis4());
        }
        if (point==5){
            question.setText(allQuestions.get(f5).getQuestionsName());
            this1.setText(allQuestions.get(f5).getThis1());
            this2.setText(allQuestions.get(f5).getThis2());
            this3.setText(allQuestions.get(f5).getThis3());
            this4.setText(allQuestions.get(f5).getThis4());
        }
        if (point==6){
            question.setText(allQuestions.get(f6).getQuestionsName());
            this1.setText(allQuestions.get(f6).getThis1());
            this2.setText(allQuestions.get(f6).getThis2());
            this3.setText(allQuestions.get(f6).getThis3());
            this4.setText(allQuestions.get(f6).getThis4());
        }
        if (point==7){
            question.setText(allQuestions.get(f7).getQuestionsName());
            this1.setText(allQuestions.get(f7).getThis1());
            this2.setText(allQuestions.get(f7).getThis2());
            this3.setText(allQuestions.get(f7).getThis3());
            this4.setText(allQuestions.get(f7).getThis4());
        }
        if (point==8){
            question.setText(allQuestions.get(f8).getQuestionsName());
            this1.setText(allQuestions.get(f8).getThis1());
            this2.setText(allQuestions.get(f8).getThis2());
            this3.setText(allQuestions.get(f8).getThis3());
            this4.setText(allQuestions.get(f8).getThis4());
        }
        if (point==9){
            question.setText(allQuestions.get(f9).getQuestionsName());
            this1.setText(allQuestions.get(f9).getThis1());
            this2.setText(allQuestions.get(f9).getThis2());
            this3.setText(allQuestions.get(f9).getThis3());
            this4.setText(allQuestions.get(f9).getThis4());
        }
      if (point==10){
            question.setText(allQuestions.get(f10).getQuestionsName());
            this1.setText(allQuestions.get(f10).getThis1());
            this3.setText(allQuestions.get(f10).getThis3());
            this4.setText(allQuestions.get(f10).getThis4());
        }
      /*    if (point==11){
            question.setText(allQuestions.get(f11).getQuestionsName());
            this1.setText(allQuestions.get(f11).getThis1());
            this2.setText(allQuestions.get(f11).getThis2());
            this3.setText(allQuestions.get(f11).getThis3());
            this4.setText(allQuestions.get(f11).getThis4());
        }
        if (point==12){
            question.setText(allQuestions.get(f12).getQuestionsName());
            this1.setText(allQuestions.get(f12).getThis1());
            this2.setText(allQuestions.get(f12).getThis2());
            this3.setText(allQuestions.get(f12).getThis3());
            this4.setText(allQuestions.get(f12).getThis4());
        }
        if (point==13){
            question.setText(allQuestions.get(f13).getQuestionsName());
            this1.setText(allQuestions.get(f13).getThis1());
            this2.setText(allQuestions.get(f13).getThis2());
            this3.setText(allQuestions.get(f13).getThis3());
            this4.setText(allQuestions.get(f13).getThis4());
        }
        */

        if (point==11){
            if (value <= 5){
                rating = "просто ухади";
                coins=coins+1;
            }
            if (value >= 6 && value <= 10){
                rating = "ну ты лох";
            }
            if (value >= 11 && value <= 15){
                rating = "средне";
            }
            if (value >= 17 && value <= 19){
                rating = "побольше среднего";
                coins=coins+1;

            }
            if (value == 20){
                rating = "побольше среднего";
                coins=coins+3;

            }
            question.setText("Правильных ответов: "+value+" из 11"+"\n"+ rating);
            this1.setText("Вернуться в главное меню");
            this2.setVisibility(View.GONE);
            this3.setVisibility(View.GONE);
            this4.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
