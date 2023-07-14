package com.user.SIT_Quize;

/**
 * Created by User on 2/14/2019.
 */
public class Questions {

    // These are the placeholders for the question resource id and the correct answer
    private int mQuestionID;
    private int mAnswer;
    private int mChoices;

    // This is the constructor that will be called when a new quiz question is created.
    public Questions(int questionResourceID, int correctAnswer) {
        mQuestionID = questionResourceID;
        mAnswer = correctAnswer;
    }

    // This method gives us access to info stored in the (private) question id.
    public int getQuestionID() {
        return mQuestionID;
    }

    // This method gives us access to info stored in the (private) mAnswer.
    public int isAnswer() {
        return mAnswer;
    }


//    public void setQuestionID(int questionID) {
//        mQuestionID = questionID;
//    }

//    public void setAnswer(boolean answer) {
//        mAnswer = answer;
//    }
}
