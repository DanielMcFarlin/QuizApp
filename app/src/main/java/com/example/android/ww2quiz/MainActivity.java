package com.example.android.ww2quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //------------Variables Used/Declarations--------------------------
    // Initializing the score to 0
    public int score = 0;

    public String summaryMessageAns1 = "\n" + "Question1 - Nothing Entered Yet!";
    public String summaryMessageAns2 = "\n" + "Question2 - Nothing Entered Yet!";
    public String summaryMessageAns3 = "\n" + "Question3 - Nothing Entered Yet!";
    public String summaryMessageAns4 = "\n" + "Question4 - Nothing Entered Yet!";
    public String summaryMessageAns5 = "\n" + "Question5 - Nothing Entered Yet!";

    // Initializing the summary message to an empty string
    public String summaryMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void question1Click(View v) {
        //-----------------------------QUESTION 1----------------------//
        // Checks 1st question for correct answer and gives points to score

        String correctAnswer1msg = getString(R.string.correctAnswer1msg);
        String wrongAnswer1msg = getString(R.string.wrongAnswer1msg);
        switch (v.getId()) {
            case R.id.Q1_Ans1_Radio:
                summaryMessageAns1 = "\n" + correctAnswer1msg;
                if (score < 1) {
                    score += 1;
                }
                Toast.makeText(this, summaryMessageAns1, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Q1_Ans2_Radio:
                summaryMessageAns1 = "\n" + wrongAnswer1msg;
                Toast.makeText(this, summaryMessageAns1, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Q1_Ans3_Radio:
                summaryMessageAns1 = "\n" + wrongAnswer1msg;
                Toast.makeText(this, summaryMessageAns1, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Q1_Ans4_Radio:
                summaryMessageAns1 = "\n" + wrongAnswer1msg;
                Toast.makeText(this, summaryMessageAns1, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void question2Click(View v) {
        //-----------------------------QUESTION 2----------------------//
        // Declares Question 2 messages for both wrong and correct answers
        String correctAnswer2msg = getString(R.string.correctAnswer2msg);
        String wrongAnswer2msg = getString(R.string.wrongAnswer2msg);

        switch (v.getId()) {
            case R.id.Q2_Ans1_Radio:
                summaryMessageAns2 = "\n" + wrongAnswer2msg;
                Toast.makeText(this, summaryMessageAns2, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Q2_Ans2_Radio:
                summaryMessageAns2 = "\n" + wrongAnswer2msg;
                Toast.makeText(this, summaryMessageAns2, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Q2_Ans3_Radio:
                summaryMessageAns2 = "\n" + correctAnswer2msg;
                Toast.makeText(this, summaryMessageAns2, Toast.LENGTH_SHORT).show();
                if (score < 2) {
                    score += 1;
                }
                break;

            case R.id.Q2_Ans4_Radio:
                summaryMessageAns2 = "\n" + wrongAnswer2msg;
                Toast.makeText(this, summaryMessageAns2, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void question3Click(View v) {
        //-----------------------------QUESTION 3----------------------//

        // Declares Question 3 messages for both wrong and correct answers
        String correctAnswer3msg = getString(R.string.correctAnswer3msg);
        String wrongAnswer3msg = getString(R.string.wrongAnswer3msg);
        String halfwayThere3msg = getString(R.string.halfwayThere3msg);

        // "Score is:" Appears when the submit button is clicked
        TextView scoreAppears = (TextView) findViewById(R.id.score_text);
        scoreAppears.setVisibility((View.VISIBLE));


        // Checks to see if Q3A1 is checked
        CheckBox Q3Answer1 = (CheckBox) findViewById(R.id.Q3_Ans1_CheckBox);
        boolean Q3A1Checked = Q3Answer1.isChecked();

        // Checks to see if Q3A2 is checked
        CheckBox Q3Answer2 = (CheckBox) findViewById(R.id.Q3_Ans2_CheckBox);
        boolean Q3A2Checked = Q3Answer2.isChecked();

        // Checks to see if Q3A3 is checked
        CheckBox Q3Answer3 = (CheckBox) findViewById(R.id.Q3_Ans3_CheckBox);
        boolean Q3A3Checked = Q3Answer3.isChecked();

        // Checks to see if Q3A4 is checked
        CheckBox Q3Answer4 = (CheckBox) findViewById(R.id.Q3_Ans4_CheckBox);
        boolean Q3A4Checked = Q3Answer4.isChecked();

        // If Answer is Correct then display message and add point to score
        if (Q3A1Checked && Q3A3Checked && !Q3A2Checked && !Q3A4Checked) {
            summaryMessageAns3 = "\n" + correctAnswer3msg;
            if (score < 3) {
                score += 1;
            }
            Toast.makeText(this, summaryMessageAns3, Toast.LENGTH_SHORT).show();
        } else if (Q3A1Checked || Q3A3Checked && !Q3A2Checked && !Q3A4Checked) {
            summaryMessageAns3 = "\n" + halfwayThere3msg;
            Toast.makeText(this, summaryMessageAns3, Toast.LENGTH_SHORT).show();
        }
        // If nothing is checked then don't display any message or add any points
        else if (!Q3A1Checked && !Q3A3Checked && !Q3A2Checked && !Q3A4Checked) {
            summaryMessageAns3 = "";
            Toast.makeText(this, summaryMessageAns3, Toast.LENGTH_SHORT).show();
        }

        // If they check the wrong answer then display wrongAnswer3msg
        else {
            summaryMessageAns3 = "\n" + wrongAnswer3msg;
            Toast.makeText(this, summaryMessageAns3, Toast.LENGTH_SHORT).show();
        }

    }

    public void question4Click(View v) {
        //-----------------------------QUESTION 4----------------------//
        // Declares Question 4 messages for both wrong and correct answers
        String correctAnswer4msg = getString(R.string.correctAnswer4msg);
        String wrongAnswer4msg = getString(R.string.wrongAnswer4msg);

        // Locate and links EditText for Question 4 Here
        EditText Q4Answer = (EditText) findViewById(R.id.Q4_Entry_EditText);

        // Stores the TextInput as a string to be checked with correct answer
        String Q4Guess = Q4Answer.getText().toString();

        // Stores correct answer as a string variable
        String Q4correctAns = getString(R.string.Q4_Answer);
        //if the guess equals the correct answer then display the msg and add points to score
        if (Q4Guess.equalsIgnoreCase(Q4correctAns)) {
            summaryMessageAns4 = "\n" + correctAnswer4msg;
            if (score < 4) {
                score += 1;
            }
            Toast.makeText(this, summaryMessageAns4, Toast.LENGTH_SHORT).show();
        }
        // If nothing is entered, don't display any message or add points
        else if (Q4Guess.equals("")) {
            Toast.makeText(this, summaryMessageAns4, Toast.LENGTH_SHORT).show();
        }
        // If the wrong answer is typed in, display wrongAnswermsg
        else {
            summaryMessageAns4 = "\n" + wrongAnswer4msg;
            Toast.makeText(this, summaryMessageAns4, Toast.LENGTH_SHORT).show();
        }
    }

    public void question5Click(View v) {

        //-----------------------------QUESTION 5----------------------//
        // Declares Question 5 messages for both wrong and correct answers
        String correctAnswer5msg = getString(R.string.correctAnswer5msg);
        String wrongAnswer5msg = getString(R.string.wrongAnswer5msg);

        // Locate and links EditText for Question 4 Here
        EditText Q5Answer = (EditText) findViewById(R.id.Q5_Entry_EditText);

        // Stores the TextInput as a string to be checked with correct answer
        String Q5Guess = Q5Answer.getText().toString();

        // Stores correct answer as a string variable
        String Q5correctAns = getString(R.string.Q5_Answer);
        // If the guess == the correct answer then display the msg and add points to score
        if (Q5Guess.equalsIgnoreCase(Q5correctAns)) {
            summaryMessageAns5 = "\n" + correctAnswer5msg;
            if (score < 5) {
                score += 1;
            }
            Toast.makeText(this, summaryMessageAns5, Toast.LENGTH_SHORT).show();
        }
        // If nothing is guessed, then don't display any message
        else if (Q5Guess.equals("")) {
            Toast.makeText(this, summaryMessageAns5, Toast.LENGTH_SHORT).show();
            // If the wrong answer is typed in, display wrongAnswer5msg
        } else {
            summaryMessageAns5 = "\n" + wrongAnswer5msg;
            Toast.makeText(this, summaryMessageAns5, Toast.LENGTH_SHORT).show();
        }
    }


    // This method is called when submit button is clicked.
    public void submitClick(View v) {
        //Puts all the summaries together to create one overall summary for submission
        summaryMessage = summaryMessageAns1.concat(summaryMessageAns2).concat(summaryMessageAns3).concat(summaryMessageAns4).concat(summaryMessageAns5);

        //------------------------------Overall Summary Toast----------------------//
        displaySummary(summaryMessage);
        displayScore(score);
        clear(summaryMessage, score);

    }


    // Method that clears out Summary and Score
    private void clear(String summary, int score) {
        if (summary == null) {
            return;
        }
        this.summaryMessage = " ";
        this.score = 0;
    }


    //  Method To display the score in the right location
    private void displayScore(int numberRight) {
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText("" + numberRight);
    }

    // Method to display the Summary
    private void displaySummary(String summary) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_message);
        summaryTextView.setText("" + summary);
    }
}
