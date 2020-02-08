package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view){

        EditText iE = findViewById(R.id.editText);
        EditText iP = findViewById(R.id.editText2);
        EditText tE = findViewById(R.id.editText3);
        EditText tP = findViewById(R.id.editText4);
        EditText mE = findViewById(R.id.editText5);
        EditText mP = findViewById(R.id.editText6);
        EditText fE = findViewById(R.id.editText7);
        EditText fP = findViewById(R.id.editText8);
        TextView output = findViewById(R.id.textOutput);

        double iE2 = Double.parseDouble(iE.getText().toString());
        double iP2 = Double.parseDouble(iP.getText().toString());
        double tE2 = Double.parseDouble(tE.getText().toString());
        double tP2 = Double.parseDouble(tP.getText().toString());
        double mE2 = Double.parseDouble(mE.getText().toString());
        double mP2 = Double.parseDouble(mP.getText().toString());
        double fE2 = Double.parseDouble(fE.getText().toString());
        double fP2 = Double.parseDouble(fP.getText().toString());

        double i = Divide(iE2,iP2);
        double t = Divide(tE2,tP2);
        double m = Divide(mE2,mP2);
        double f = Divide(fE2,fP2);

        output.setText(Grade(Calc(i,t,m,f)));
        iE.setText("0");
        iP.setText("0");
        tE.setText("0");
        tP.setText("0");
        mE.setText("0");
        mP.setText("0");
        fE.setText("0");
        fP.setText("0");
    }

    public double Calc(double i, double t, double m, double f){
        int fW = 20;
        int mW = 30;
        int iW = 20;
        int tW = 30;

        if(i == -1)
            iW = 0;
        if(t == -1)
            tW = 0;
        if(m == -1)
            mW = 0;
        if(f == -1)
            fW = 0;

        if (i == -1 && t==-1 && m==-1 && f==-1){
            return 0;
        }
        return (i*iW + t*tW + m*mW + f*fW)/(fW+mW+iW+tW);

    }

    public double Divide(double e, double p){
        try{
            double i;
            if(e == 0 && p == 0){
                return -1;
            }
            else if(p > 0){
               i = (e/p) * 100;
               return i;
            }
            return -1;
        }
        catch(IllegalArgumentException ex){
            Toast.makeText(MainActivity.this,"Can't divide by zero",Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    public String Grade(double f){
        DecimalFormat FORMAT = new DecimalFormat("#.##");

        if(f >= 90){
            return "A " + FORMAT.format(f);
        }
        else if(f >= 80){
            return "B " + FORMAT.format(f);
        }
        else if(f >= 70){
            return "C " + FORMAT.format(f);
        }
        else if(f >= 60){
            return "D " + FORMAT.format(f);
        }
        else{
            return "F " + FORMAT.format(f);
        }
    }





}
