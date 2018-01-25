package by.it_academy.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_everest, false, R.string.answer_everest),
            new Question(R.string.question_australia, true, R.string.answer_australia),
            new Question(R.string.question_japaneses, false, R.string.answer_japaneses),
            new Question(R.string.question_northcorea, true, R.string.answer_northcorea),
            new Question(R.string.question_huama, true, R.string.answer_huama),
            new Question(R.string.question_golden, false, R.string.answer_golden),
            new Question(R.string.question_rio, true, R.string.answer_rio),
            new Question(R.string.question_france, true, R.string.answer_france),
            new Question(R.string.question_london, false, R.string.answer_london),
            new Question(R.string.question_coffee, false, R.string.answer_cofee),
            new Question(R.string.question_rususa, true, R.string.answer_russia),
            new Question(R.string.question_chill, false, R.string.answer_chill),
    };
    private int mCurrentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mNextButton = findViewById(R.id.next_button);



        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        checkAnswer(true);
                        answerTheQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                answerTheQuestion();
            }
        });



        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex==mQuestions.length-1){
                    mCurrentIndex = 0;
                }else mCurrentIndex++;
                updateQuestion();
            }
        });

    }

    private void updateQuestion(){
        int question = mQuestions[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void answerTheQuestion(){
        Toast answer = new Toast(this);
        answer.setGravity(Gravity.TOP, Gravity.AXIS_PULL_BEFORE, Gravity.AXIS_PULL_BEFORE);
        answer.makeText(QuizActivity.this, mQuestions[mCurrentIndex].getAnswerId(),
                Toast.LENGTH_LONG).show();
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean rightAnswer = mQuestions[mCurrentIndex].isAnswerTrue();

        int messageResID = 0;

        if(userPressedTrue == rightAnswer){
            messageResID = R.string.correct_toast;
        }else {
            messageResID = R.string.incorrect_toast;
        }
        Toast.makeText(this,
                messageResID,
                Toast.LENGTH_SHORT).show();
    }
}
