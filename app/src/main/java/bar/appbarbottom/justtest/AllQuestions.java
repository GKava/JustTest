package bar.appbarbottom.justtest;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions {
    public String getQuestionsName() {
        return questionsName;
    }

    public void setQuestionsName(String questionsName) {
        this.questionsName = questionsName;
    }

    public int getWinInt() {
        return winInt;
    }

    public void setWinInt(int winInt) {
        this.winInt = winInt;
    }

    private String questionsName;
    private String this1;
    private String this2;
    private String this3;
    private String this4;
    private int winInt;


    public AllQuestions(String questionsName,String this1, String this2, String this3, String this4,int winInt) {
        this.questionsName = questionsName;
        this.this1 = this1;
        this.this2 = this2;
        this.this3 = this3;
        this.this4 = this4;
        this.winInt = winInt;
    }

    public String getThis1() {

        return this1;
    }

    public void setThis1(String this1) {
        this.this1 = this1;
    }

    public String getThis2() {
        return this2;
    }

    public void setThis2(String this2) {
        this.this2 = this2;
    }

    public String getThis3() {
        return this3;
    }

    public void setThis3(String this3) {
        this.this3 = this3;
    }

    public String getThis4() {
        return this4;
    }

    public void setThis4(String this4) {
        this.this4 = this4;
    }
    public static List<AllQuestions> getLastMonth(){
        ArrayList<AllQuestions> itemQuestions = new ArrayList<>();
//0-20
        itemQuestions.add(new AllQuestions("На какой вопрос ученые из до сих пор не нашли ответа ?","Есть ли жизнь на марсе ?","Существует ли бог ?","Чи да ?","В чем смысл жизни ?",3));
        itemQuestions.add(new AllQuestions("Что опаснее всего для монитора ?","Скачок напряжения","Моль","Вода","Пез**ки пришедшие в гости",2));
        itemQuestions.add(new AllQuestions("Кто  обокрал Фараона в октябре ?","Государств","Друзья","Школьник","Девушка",3));

        itemQuestions.add(new AllQuestions("","","","","",1));



        return itemQuestions;
    }
    public static List<AllQuestions> getAllQuestions(){
    ArrayList<AllQuestions> itemQuestions = new ArrayList<>();
    //0-6
    itemQuestions.add(new AllQuestions("Чего хочет этот парень ? ","Оливье","Арбуз","Тушенки","Все вышеперечисленное ",4));
    itemQuestions.add(new AllQuestions("Самый ненавистное животное  в Эльдорадо ?","Мыш которая  кродеться","Люди слушающие музыку через колонку ","Крыса","Моль",3));
    itemQuestions.add(new AllQuestions("Как называют устаревший мем?","Гусли","Скрипка","Боян","Гитара",3));
    itemQuestions.add(new AllQuestions("Традиционный русский напиток","Кумыс","Квас","Руссиано","Боярышник",4));
    itemQuestions.add(new AllQuestions("Кто основал Питер ?","Путин","Петр I ","Шрек","Сталин",3));
    itemQuestions.add(new AllQuestions("Сколько уважающая себя девушка пьет на вписке ? ","Немного","Чуть-чуть","Стаканчик","На донышке",4));
    itemQuestions.add(new AllQuestions("Кто такой мистер Дудец? ","Собака ","Крыса","Скелет ","Ютубер",3));
//7-9
    itemQuestions.add(new AllQuestions("На какой вопрос ученые из до сих пор не нашли ответа ?","Есть ли жизнь на марсе ?","Существует ли бог ?","Чи да ?","В чем смысл жизни ?",3));
    itemQuestions.add(new AllQuestions("Что опаснее всего для монитора ?","Скачок напряжения","Моль","Вода","Пез**ки пришедшие в гости",2));
    itemQuestions.add(new AllQuestions("Кто  обокрал Фараона в октябре ?","Государств","Друзья","Школьник","Девушка",3));

    itemQuestions.add(new AllQuestions("","","","","",1));



    return itemQuestions;
}


}
