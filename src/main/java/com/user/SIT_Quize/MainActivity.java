package com.user.SIT_Quize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static android.widget.Toast.makeText;

/**
 * Created by User on 2/14/2019.
 */
public class MainActivity extends Activity {
    private TextView countLabel;
    private ProgressBar mProgressBar;
    private TextView questionLabel;
    private TextView quizTimer;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    public CountDownTimer mCountDownTimer;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    static final private int QUIZ_COUNT = 50;
    static final long START_TIME_IN_MILIS = 120000;
    private long mTimeLeftinMillis = START_TIME_IN_MILIS;
    int PROGRESS_BAR_INCREMENT = 100 / QUIZ_COUNT;


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftinMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftinMillis = millisUntilFinished;
                quizTimer.setText("Time: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                quizTimer.setText("DONE!");
                Intent intent = new Intent(getApplicationContext(), resultActivity.class);
                mProgressBar.setProgress(0);
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                startActivity(intent);

            }
        }.start();

    }

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData[][] = {

            //{"Question", "right answer", "choicea", "choiceb", "choicec"}
            {"Combien y a-t-il de touches sur un clavier d’ordinateur portable ?", "100", "80", "120"},
            {"Parmi les 10 plus riches personnes du monde, combien d’entre eux sont informaticiens ?", "4", "Aucun", "10"},
            {"Linux est basé sur le noyau UNIX, mais en quelle année a-t-il été crée ?", "en 1991", "en 1995", "en 1981"},
            {"Comment s’appelait l’ancêtre d’internet ?", "Arpanet", "Intranet", "Extranet"},
            {"Qu’est-ce qu’un Spyware ?", "un logiciel espion ", "un antivirus ", "un jeux"},
            {"Qui contrôle internet ?", "Personne", "Donald Trump", "les informaticiens du pentagone"},
            {"Combien y a-t-il d’octet dans 4Ko ?", "4000", "4096", "400"},
            {"Qu’est ce que Mozilla Firefox ?", "un navigateur web ", "un serveur web", "une association"},
            {"Que signifie les trois lettres ‘WWW’ en informatique ?", "World Wide Web", "Web World Widget", "World Wide Wireless"},
            {"Qui est le créateur de Facebook ?", "Mark Zuckerberg", "Tom Hanks", "Steve Jobs"},
            {"Que signifie HTTP ?", "HyperText Transfer Protocol", "HyperTranslate Text Protocol", "HyperTransfert Text Protocol "},
            {"Le langage JAVA est langage ", "Semi-compilé", "Interprété", "Compilé"},
            {"Quel est le Protocol utilisé pour le partage des fichiers ?", "FTP", "SMTP", "HTTP"},
//Geography
            {"Quelle est la capitale du Canada ?", "Ottawa", "Toronto", "St.Johns"},
            {"Quelle est la capitale de l’Australie ?", "Canberra", "Sydney", "Melbourne"},
            {"Quelle est la capitale du Brésil ? ", "Brasilia", "Sao Paulo", "Rio de Janeiro"},
            {"La quelle de ces mers n’existe pas ?", "La mer marron ", "la mer noire", "la mer jaune"},
            {"Où se situe la ville de Meknès ?", "Maroc", "Tunisie", "Mauritanie"},
            {"Où se situe la ville de Mossoul ?", "Iraq", "Syrie", "Iran"},
            {"Quelle est la capitale de la Hongrie ?", "Budapest", "Zagreb", "Minsk"},
            {"Où se situent les chutes de Niagara  ?", "Canada", "Mexique", "Brésil"},
            {"Où se situe la ville de Dar Es Salam ?", "Tanzanie", "Mali", "Maroc"},
            {"Où se situe la forêt noire ?", "Allemagne", "Zimbabwe", "Brésil"},
            {"Quelle est la capitale de la Croitie ?", "Zagreb", "Belgrade", "Budapest"},
            {"Quelle est la capitale de la Serbie ?", "Belgrade", "Zagreb ", "Vinus"},
            {"Quel est le pays organisateur de la coupe du monde 2010 ? ", "Afrique du sud ", "Brésil", "Allemagne"},
            {"Où se trouve la statue du Christ Rédempteur ?", "Rio de Janeiro", "Paris ", "New York"},
            {"Quel est le plus haut sommet en Algérie ?", "Tahat", "Lalla Khedidja", "Djebel Chélia "},
            {"Quelle est la capitale de l’Inde ?", "New Delhi", "Bombay", "Calcutta"},
            {"Quelle est la capitale de la Suisse ?", "Berne", "Zurich", "Genève"},
            {"Quelle est la capitale de la Nouvelle-Zélande ? ", "Wellington", "Auckland", "Christchurch"},
            {"Quelle est la capitale de la turquie ?", "Ankara", "Istanbul", "Izmir"},
            {"Quel est le plus long cours d’eau en Algérie ?", "Chelif", "Béni Haroun", "Tafna"},

            //Sience
            {"Que signifie-le N dans ADN ?", "Nucléique", "Nucléotide", "Nucléaire"},
            {"Quels sont les mammifères pouvant voler ?", "Chauves souris ", "Ecureuils volants", "Koala"},
            {"Quel est le symbole chimique du fer ?", "Fe", "Fr", "F"},
            {"Quel est le symbole chimique de l’Azote ?", "N", "Na", "As"},
            {"Le quel de ces vaccins est administré contre la tuberculose ?", "b.c.g", "b.g.c.d", "r.o.r"},
            {"Quelle est la température d’ébullition de l’eau ?", "100°c", "0°c", "-100°c"},
            {"Quel métal est très solide ?", "le cuivre", "le fer", "l’aluminium"},
            {"Que représente 23m³ en litre ?", "23L", "230L", "0.023L"},
            {"Comment s’appelle l’étude de l’espace ?", "l’astronomie", "l’astrologie", "la gastronomie"},
            {"A quelle température l’eau gèle ?", "0°c", "-5°c", "-10°c"},
            {"Quelle est la source d’énergie pour la cellule ?", "Mitochondrie ", "Réticulum endoplasmique", "Golgi"},
            {"Où se trouve l’aorte ?", "Cœur ", "Poumon", "Foie"},
            {"Combien de chromosomes possède l’homme ?", "46", "23", "47"},
            {"Comment appelle-t-on les saignements de nez ?", "Epistaxis", "Epiphyse", "Epididyme"},
            {"A l’automne, les feuilles tombent parce que ", "Elles manquent de lumière", "Elles s’adaptent au froid hivernal", "L’attraction de la terre est plus forte "},
            {"Qui a découvert le vaccin contre la rage ?", "Louis Pasteur", "Edward Jenner", "Philippe Maupas"},
            {"Comment s’appelle la science qui étudie les oiseaux ?", "L’ornithologie", "La zoologie ", "La biologie "},
            {"Qui a inventé l’imprimerie ?", "Gutenberg", "Volt", "Newton"},
            {"Quel muscle de la cuisse porte le même nom qu’un métier ?", "Couturier", "Dentellier", "Coutelier"},
            {"Le gaz est il naturellement odorant ?", "non, on lui rajoute une odeur ", "on ne sait pas", "oui, il a déjà une odeur "},
   //Culture génerale
            {"Quel est le plus grand pays du monde ?", "La Russie", "Canada", "La chine"},
            {"Quel est le plus grand océan du monde ?", "Pacifique", "Indien", "Atlantique"},
            {"Quel fleuve passe par paris ?", "La Seine", "La Garonne", "La Loire"},
            {"Où se trouve l’Espagne par rapport à la France ?", "Au sud", "A l’ouest ", "Au nord "},
            {"Où se trouve l’Espagne par rapport à l'Algerie ?", "Au nord", "A l’ouest ", "Au sud"},
            {"Si on mélange du bleu et du rouge, on obtient :", "Du violet", "Du jaune", "Du vert"},
            {"Qui a écrit ‘les misérables’ ?", "Victor Hugo", "Molière", "William Shakespeare"},
            {"Quel pays a remporté la coupe du monde 2014 ?", "Allemagne", "Argentine", "l’Espagne"},
            {"Quelle pièce est absolument à protéger dans un jeu d’échec ?", "Le roi", "Le chevalier", "La reine"},
            {"Qui est pour moi, le frère du cousin de mon fils ?", "Mon neveu", "Mon oncle", "Mon cousin"},
            {"لماذا يتم رش الطائرة بالماء؟", "للترحيب بالطائرة بعد أول رحلة لها", "لتنظيف الطائرة", "لتخفيض حرارة المحرك"},
            {"Quelle théorie doit-on à Isaac Newton ?", "La théorie de la gravitation universelle", "La théorie universelle des ensembles ", "La théorie atomique"},
            {"Quelle est la plus grande planète du système solaire ?", "Jupiter", "Mars", "La terre"},
            {"Quelle est la maladie neurologique qui provoque des tremblements ?", "Parkinson", "Henderson", "Henderson"},
            {"Où est né Mozart ?", "Salzbourg", "Turin", "Vienne"},
            {"Quel pays a remporté la coupe du monde 2006 ?", "Italie", "France", "Espagne"},
            {"De combien d'états sont composés Les États-Unis ?", "50", "52", "48"},



    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.question_text_view);
        quizTimer = (TextView) findViewById(R.id.timer);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        answerButton1 = (Button) findViewById(R.id.answer1);
        answerButton2 = (Button) findViewById(R.id.answer2);
        answerButton3 = (Button) findViewById(R.id.answer3);

        startTimer();


        //create quizArray from quizData

        for (int i = 0; i < quizData.length; i++) {

            //Prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Country
            tmpArray.add(quizData[i][1]); //Right Answer
            tmpArray.add(quizData[i][2]); //Choice1
            tmpArray.add(quizData[i][3]); //Choice2

            //Add tmpArray to quizArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    public void showNextQuiz() {

        //Update quizCountLabel
        countLabel.setText("Q" + quizCount);
        //Generate random number between 0 and(quizArray size -1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set quetion and right answer.
        //Array format as above;
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        //remove "Question" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        //set choices
        answerButton1.setText(quiz.get(0));
        answerButton2.setText(quiz.get(1));
        answerButton3.setText(quiz.get(2));

        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {

        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {

            //correct!
            alertTitle = "Correct";
            rightAnswerCount++;
        } else {
            //wrong
            alertTitle = "Wrong";
        }
//alert handler
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override

            //function handles the button click
            public void onClick(DialogInterface dialogInterface, int i) {

                //if all question 20 has been reached, launch the RESULTS page.
                if (quizCount == QUIZ_COUNT) {
                    //show Result
                    Intent intent = new Intent(getApplicationContext(), resultActivity.class);
                    mProgressBar.setProgress(0);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                } else {
                    quizCount++;
                    mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}


