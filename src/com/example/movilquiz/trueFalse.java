package com.example.movilquiz;

public class trueFalse {
private int mQuestion;
private boolean mTrueQuestion;

public trueFalse(int question,boolean trueQuestion){
	mQuestion=question;
	mTrueQuestion=trueQuestion;
}
public int getmQuestion() {
	return mQuestion;
}
public void setmQuestion(int mQuestion) {
	this.mQuestion = mQuestion;
}
public boolean ismTrueQuestion() {
	return mTrueQuestion;
}
public void setmTrueQuestion(boolean mTrueQuestion) {
	this.mTrueQuestion = mTrueQuestion;
}


}