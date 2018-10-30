package bar.appbarbottom.justtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstTest extends Fragment implements View.OnClickListener {
Button this1,this0;
TextView question;
ImageView imageView;
private int value;
private int point=0;

    public FirstTest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_first_test, container, false);
        question = view.findViewById(R.id.question);
        imageView = view.findViewById(R.id.imageView);
        this0 = view.findViewById(R.id.this0);
        this1 = view.findViewById(R.id.this1);
        this0.setOnClickListener(this);
        this1.setOnClickListener(this);
        imageView.setImageResource(R.drawable.mozg);


        testQuestion();
        return view;
    }


    public void testQuestion(){
        if (point==0){
            question.setText("Просто нажми на какую-нибудь кнопку и поехали .");
        }
        if (point==1){
            question.setText("Какая фамилия написана неправильно?");
            this0.setText("Тункцеров");
            this1.setText("К'тунцеров");
        }
        if (point==2){
            question.setText("Уффф ладно, хватит на сегодня тестов  ");
            this0.setText("Прибавить нолик)00");
            this1.setText("Прибавить единичку");
        }
        if (point==3){

            question.setText("Счет: "+value+"/3"+"\nти довн)00");
            this0.setText("Вернуться в главное меню");
            this1.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.this0:
                if (point==3){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new  MainFragment())
                            .commit();
                }else {
                    point++;
                    testQuestion();
                }
                break;

                case R.id.this1:
                point++;
                value++;
                testQuestion();
                break;

        }
    }
}
