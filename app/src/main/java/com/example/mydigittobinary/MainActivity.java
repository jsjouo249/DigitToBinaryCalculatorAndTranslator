package com.example.mydigittobinary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView number1;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        number1 = findViewById(R.id.number1);
        result = findViewById(R.id.result);
    }

    public void add(View v){
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        number1.setText(Double.toString(n1 + n2 ) );
    }

    public void minus(View v){
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        number1.setText(Double.toString(n1 - n2 ) );
    }

    public void multi(View v){
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        number1.setText(Double.toString(n1 * n2 ) );
    }

    public void divide(View v){
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        if( num2.getText().toString().equals("0") )
        {
            number1.setText("나누는 수가 0이 아닌 다른 수를 입력해 주세요.");
        }
        else
            number1.setText(Double.toString(n1 / n2 ) );
    }


    public void translation(View v){

        double inputNum = Double.parseDouble( number1.getText().toString() );
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();

        if( inputNum >= 0 ) {
            int intNum = (int) (inputNum / 1);
            ArrayList<Integer> IntBinary = new ArrayList();

            while (intNum != 0) {
                IntBinary.add(intNum % 2);
                intNum = intNum / 2;
            }

            double doubleNum = inputNum % 1;

            ArrayList<Integer> DoubleBinary = new ArrayList();

            if (doubleNum != 0) {
                while (doubleNum != 1) {
                    doubleNum *= 2;

                    if (doubleNum >= 1)
                        DoubleBinary.add(1);
                    else
                        DoubleBinary.add(0);

                    if (doubleNum > 1)
                        doubleNum -= 1;
                }
            }
            if (IntBinary.size() == 0)
                one.append("0");
            else
                for (int j = IntBinary.size() - 1; j >= 0; j--)
                    one.append(IntBinary.get(j));

            if (inputNum % 1 != 0)
                one.append(".");

            for (int j = 0; j < DoubleBinary.size(); j++)
                two.append(DoubleBinary.get(j));

            result.setText(one.append(two));

            IntBinary.clear();
            DoubleBinary.clear();
        }
        else
            result.setText( one.append("0미만의 수를 입력하셨습니다. 0이하는 구현이 되지 않았습니다. 죄송합니다") );
    }


}
