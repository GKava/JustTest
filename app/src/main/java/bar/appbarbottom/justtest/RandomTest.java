package bar.appbarbottom.justtest;


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
    private  int f0;
    private  int f1;
    private  int f2;
    private  int f3;
    private  int f4;
    List<AllQuestions> allQuestions = getAllQuestions();
    public RandomTest() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_random_test, container, false);
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

             Random random = new Random();
             f0=random.nextInt(7);
             f1=random.nextInt(7);
             f2=random.nextInt(7);
             f3=random.nextInt(7);
             f4=random.nextInt(7);

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
                if (point==5){
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
                rating = "побольше среднего";
            }
            if (value==4){
                rating = "ну так";
            }
            if (value==5){
                rating = "шаришь";
            }

            question.setText("Счет: "+value+"/5"+"\n"+ rating);
            this1.setText("Вернуться в главное меню");
            this2.setVisibility(View.GONE);
            this3.setVisibility(View.GONE);
            this4.setVisibility(View.GONE);
        }
    }

}