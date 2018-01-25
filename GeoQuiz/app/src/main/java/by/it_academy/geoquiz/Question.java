package by.it_academy.geoquiz;

/**
 * Created by kasarevich on 25.01.2018.
 */

public class Question {
    private int mTextResId;
    private int mAnswerId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue, int answerId) {
        mTextResId = textResId;
        mAnswerId = answerId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getAnswerId() {
        return mAnswerId;
    }

    public void setAnswerId(int answerId) {
        mAnswerId = answerId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
