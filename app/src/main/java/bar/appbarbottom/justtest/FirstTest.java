package bar.appbarbottom.justtest;


import android.graphics.Point;
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
import java.util.List;
import java.util.Random;
import static bar.appbarbottom.justtest.AllQuestions.getLastMonth;

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
    List<AllQuestions> allQuestions = getLastMonth();

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

        testQuestion(0);

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

    // проверяем является ли ответ правильным, в параметрах передаем номер кнопки
    // и сравниваем с WinInt из коллекции, если совпадает то ответ верный
    public void checkWinners(int answer){
        if (point==0 & allQuestions.get(0).getWinInt()==answer ){
            value++;
        }
        if (point==1 & allQuestions.get(1).getWinInt()==answer ){
            value++;
        }
        if (point==2 & allQuestions.get(2).getWinInt()==answer ){
            value++;
        }
        if (point==3 & allQuestions.get(3).getWinInt()==answer ){
            value++;
        }
        if (point==4 & allQuestions.get(4).getWinInt()==answer ){
            value++;
        }
        if (point==5 & allQuestions.get(5).getWinInt()==answer ){
            value++;
        }
        if (point==6 & allQuestions.get(6).getWinInt()==answer ){
            value++;
        }
        if (point==7 & allQuestions.get(7).getWinInt()==answer ){
            value++;
        }
        if (point==8 & allQuestions.get(8).getWinInt()==answer ){
            value++;
        }
        if (point==9 & allQuestions.get(9).getWinInt()==answer ){
            value++;
        }
        if (point==10 & allQuestions.get(10).getWinInt()==answer ){
            value++;
        }
        if (point==11 & allQuestions.get(11).getWinInt()==answer ){
            value++;
        }
        if (point==12 & allQuestions.get(12).getWinInt()==answer ){
            value++;
        }

    }

    public void testQuestion(int intPoint){
            question.setText(allQuestions.get(intPoint).getQuestionsName());
            this1.setText(allQuestions.get(intPoint).getThis1());
            this2.setText(allQuestions.get(intPoint).getThis2());
            this3.setText(allQuestions.get(intPoint).getThis3());
            this4.setText(allQuestions.get(intPoint).getThis4());

        if (point==12){
            if  (value <= 5) {
                rating = "ну ты лох";
            }
            if (value >= 6 && value <= 10){
                rating = "средне";
            }
            if (value >= 11 && value <= 15){
                rating = "шаришь";
            }
            question.setText("Правильных ответов: "+value+" из 15"+"\n"+ rating);
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
                if (point==12){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new  MainFragment())
                            .commit();
                }else {
                    checkWinners(1);
                    point++;
                    testQuestion(point);
                }
                break;

                case R.id.this2:
                    checkWinners(2);
                point++;
                testQuestion(point);
                break;

            case R.id.this3:
                checkWinners(3);
                point++;
                testQuestion(point);
                break;

            case R.id.this4:
                checkWinners(4);
                point++;
                testQuestion(point);
                break;
        }
    }
}
