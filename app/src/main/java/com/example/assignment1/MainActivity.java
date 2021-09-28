package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String tag = "Assignment1";

    Button oneBut, twoBut, threeBut, fourBut, fiveBut, sixBut, sevenBut, eightBut, nineBut, zeroBut;
    Button plusBut, minusBut, multiBut, divideBut, equalBut, clearBut;
    Button historyBut;
    TextView rText, historyText;
    Boolean historySwitch = false;

    private Calculator myCalc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rText = (TextView) findViewById(R.id.valueText);
        historyText = (TextView) findViewById(R.id.historyText);

        plusBut = (Button) findViewById(R.id.plusOp);
        minusBut = (Button) findViewById(R.id.minusOp);
        multiBut = (Button) findViewById(R.id.multiOp);
        divideBut = (Button) findViewById(R.id.divisionOp);
        equalBut = (Button) findViewById(R.id.equalOp);
        clearBut = (Button) findViewById(R.id.clearB);

        oneBut = (Button) findViewById(R.id.oneN);
        twoBut = (Button) findViewById(R.id.twoN);
        threeBut = (Button) findViewById(R.id.threeN);
        fourBut = (Button) findViewById(R.id.fourN);
        fiveBut = (Button) findViewById(R.id.fiveN);
        sixBut = (Button) findViewById(R.id.sixN);
        sevenBut = (Button) findViewById(R.id.sevenN);
        eightBut = (Button) findViewById(R.id.eightN);
        nineBut = (Button) findViewById(R.id.nineN);
        zeroBut = (Button) findViewById(R.id.zeroN);

        historyBut = (Button) findViewById(R.id.advance);

        plusBut.setOnClickListener(this);
        minusBut.setOnClickListener(this);
        multiBut.setOnClickListener(this);
        divideBut.setOnClickListener(this);
        equalBut.setOnClickListener(this);
        clearBut.setOnClickListener(this);

        oneBut.setOnClickListener(this);
        twoBut.setOnClickListener(this);
        threeBut.setOnClickListener(this);
        fourBut.setOnClickListener(this);
        fiveBut.setOnClickListener(this);
        sixBut.setOnClickListener(this);
        sevenBut.setOnClickListener(this);
        eightBut.setOnClickListener(this);
        nineBut.setOnClickListener(this);
        zeroBut.setOnClickListener(this);

        historyBut.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    @Override
    public void onClick(View view) {
        String text = rText.getText().toString();
        String op = ((Button)view).getText().toString();
        switch (op) {
            case "1":
                rText.setText(text + "1 ");
                break;
            case "2":
                rText.setText(text + "2 ");
                break;
            case "3":
                rText.setText(text + "3 ");
                break;
            case "4":
                rText.setText(text + "4 ");
                break;
            case "5":
                rText.setText(text + "5 ");
                break;
            case "6":
                rText.setText(text + "6 ");
                break;
            case "7":
                rText.setText(text + "7 ");
                break;
            case "8":
                rText.setText(text + "8 ");
                break;
            case "9":
                rText.setText(text + "9 ");
                break;
            case "0":
                rText.setText(text + "0 ");
                break;
            case "+":
                rText.setText(text + "+ ");
                break;
            case "-":
                rText.setText(text + "- ");
                break;
            case "*":
                rText.setText(text + "* ");
                break;
            case "/":
                rText.setText(text + "/ ");
                break;
            case "=":
                rText.setText(text + "= ");
                prepareForCalc(view);
                break;
            case "c":
                rText.setText("");
                break;
            default:
                if(!historySwitch)
                {
                    historySwitch = true;
                    ((Button)view).setText("STANDARD - NO HISTORY");
                }
                else
                {
                    historySwitch = false;
                    ((Button)view).setText("ADVANCE - WITH HISTORY");
                    historyText.setText("");
                }
                break;

        }
    }

    void prepareForCalc(View view) {
        String text = rText.getText().toString();
        String hText = historyText.getText().toString();
        myCalc.push(text);
        Integer result = myCalc.calculate();
        rText.setText(text + result.toString());
        if(historySwitch)
        {
            historyText.setText(hText + rText.getText().toString() + "\n");
        }

    }

}