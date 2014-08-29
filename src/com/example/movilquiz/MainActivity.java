package com.example.movilquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageButton mTrueButton;
	private ImageButton mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private TextView mScoreTextView;
	private trueFalse[] mQuestionBank =new trueFalse[]{
			new trueFalse(R.string.question_1,true),
			new trueFalse(R.string.question_2,false),
			new trueFalse(R.string.question_3,false),
			new trueFalse(R.string.question_4,false),
			new trueFalse(R.string.question_5,true),
			new trueFalse(R.string.question_6,true),
			new trueFalse(R.string.question_7,false),
			new trueFalse(R.string.question_8,true),
			new trueFalse(R.string.question_9,false),
			new trueFalse(R.string.question_10,true),
			new trueFalse(R.string.question_11,false),
			new trueFalse(R.string.question_12,false),
			new trueFalse(R.string.question_13,true),
			new trueFalse(R.string.question_14,true),
			new trueFalse(R.string.question_text,false),
			
	};
	private int  mCurrentIndex=0;
	public int currentScore=0;
	public int ran=(int)(Math.random()*15 + 1);
	public int count=0;
	int messageResId=0;
	int src=0;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
		int question=mQuestionBank[ran].getmQuestion();
		String enteroString = Integer.toString(currentScore);
		mQuestionTextView.setText(question);
		
		mScoreTextView=(TextView)findViewById(R.id.score_text_view2);
		mScoreTextView.setText(enteroString);
		mTrueButton=(ImageButton)findViewById(R.id.true_button);
		
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();				
				checkAnswer(true);
				mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
				int question=mQuestionBank[mCurrentIndex].getmQuestion();
				String enteroString = Integer.toString(currentScore);
				count=count+1;
				mQuestionTextView.setText(question);
				mScoreTextView.setText(enteroString);
				if(count==9){
					
					currentScore=0;
					
					count=0;
				}
				
			}
		});
		mNextButton=(Button)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
				int question=mQuestionBank[mCurrentIndex].getmQuestion();
				String enteroString = Integer.toString(currentScore);
				mQuestionTextView.setText(question);
				mScoreTextView.setText(enteroString);
				count=count+1;
				
				if(count==9){
					
					currentScore=0;
					
					count=0;
				}
				
			}
		});
		mFalseButton=(ImageButton)findViewById(R.id.false_button);	
		mFalseButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
				mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
				int question=mQuestionBank[mCurrentIndex].getmQuestion();
				String enteroString = Integer.toString(currentScore);
				mQuestionTextView.setText(question);
				mScoreTextView.setText(enteroString);
				count=count+1;
				if(count==9){
					
					currentScore=0;
					
					count=0;
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}
	private void checkAnswer(boolean userPressedTrue){
		boolean answerIsTrue=mQuestionBank[mCurrentIndex].ismTrueQuestion();
		
		if(userPressedTrue==answerIsTrue){
			messageResId=R.string.correct_toast;
			currentScore=(currentScore+1);
			
		}else{
			messageResId=R.string.incorrect_toast;
		}
		
		
		Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
		
		}


}

