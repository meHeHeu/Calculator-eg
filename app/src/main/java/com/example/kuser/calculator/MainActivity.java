package com.example.kuser.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.MapContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView output_field;
    private EditText input_field;

    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button0;
    private Button ButtonEq;
    private Button ButtonCl;
    private Button ButtonPlus;
    private Button ButtonMinus;
    private Button ButtonSpace;
    private Button ButtonBckSpace;
    private Button ButtonMultip;
    private Button ButtonDiv;
    //    private Button ButtonMod;
    private Button ButtonExp;
//    private Button ButtonFac;
//    private Button ButtonOBracket;
//    private Button ButtonCBracket;

    JexlEngine jexl;
    JexlContext jexlContext;
    //Expression e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output_field = (TextView)findViewById(R.id.output_field);
        input_field = (EditText)findViewById(R.id.input_field);

        Button7 = (Button)findViewById(R.id.button7);
        Button7.setOnClickListener((View.OnClickListener) this);
        Button8 = (Button)findViewById(R.id.button8);
        Button8.setOnClickListener((View.OnClickListener) this);
        Button9 = (Button)findViewById(R.id.button9);
        Button9.setOnClickListener((View.OnClickListener) this);
        Button4 = (Button)findViewById(R.id.button4);
        Button4.setOnClickListener((View.OnClickListener) this);
        Button5 = (Button)findViewById(R.id.button5);
        Button5.setOnClickListener((View.OnClickListener) this);
        Button6 = (Button)findViewById(R.id.button6);
        Button6.setOnClickListener((View.OnClickListener) this);
        Button1 = (Button)findViewById(R.id.button1);
        Button1.setOnClickListener((View.OnClickListener) this);
        Button2 = (Button)findViewById(R.id.button2);
        Button2.setOnClickListener((View.OnClickListener) this);
        Button3 = (Button)findViewById(R.id.button3);
        Button3.setOnClickListener((View.OnClickListener) this);
        Button0 = (Button)findViewById(R.id.button0);
        Button0.setOnClickListener((View.OnClickListener) this);
        ButtonEq = (Button)findViewById(R.id.buttonEq);
        ButtonEq.setOnClickListener((View.OnClickListener) this);
        ButtonCl = (Button)findViewById(R.id.buttonCl);
        ButtonCl.setOnClickListener((View.OnClickListener) this);
        ButtonPlus = (Button)findViewById(R.id.buttonPlus);
        ButtonPlus.setOnClickListener((View.OnClickListener) this);
        ButtonMinus = (Button)findViewById(R.id.buttonMinus);
        ButtonMinus.setOnClickListener((View.OnClickListener) this);
        ButtonSpace = (Button)findViewById(R.id.buttonSpace);
        ButtonSpace.setOnClickListener((View.OnClickListener) this);
        ButtonBckSpace = (Button)findViewById(R.id.buttonBckSpace);
        ButtonBckSpace.setOnClickListener((View.OnClickListener) this);
        ButtonMultip = (Button)findViewById(R.id.buttonMultip);
        ButtonMultip.setOnClickListener((View.OnClickListener) this);
        ButtonDiv = (Button)findViewById(R.id.buttonDiv);
        ButtonDiv.setOnClickListener((View.OnClickListener) this);
//        ButtonMod = (Button)findViewById(R.id.buttonMod);
//        ButtonMod.setOnClickListener((View.OnClickListener) this);
        ButtonExp = (Button)findViewById(R.id.buttonExp);
        ButtonExp.setOnClickListener((View.OnClickListener) this);
//        ButtonFac = (Button)findViewById(R.id.buttonFac);
//        ButtonFac.setOnClickListener((View.OnClickListener) this);
//        ButtonOBracket = (Button)findViewById(R.id.buttonOBracket);
//        ButtonOBracket.setOnClickListener((View.OnClickListener) this);
//        ButtonCBracket = (Button)findViewById(R.id.buttonCBracket);
//        ButtonCBracket.setOnClickListener((View.OnClickListener) this);

        jexl = new JexlEngine ();
        jexlContext = new MapContext();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ButtonEq.getId())
            //output_field.setText(rpn.eval (input_field.getText().toString()));
            output_field.setText(jexl.createExpression (input_field.getText().toString()).evaluate(jexlContext).toString());
        else if (v.getId() == ButtonCl.getId()) {
            input_field.setText("");
        }
        else if (v.getId() == ButtonSpace.getId()) {
            input_field.append(" ");
        }
        else if (v.getId() == ButtonBckSpace.getId()) {
            String text = input_field.getText().toString();
            input_field.setText(text.substring(0, text.length() - 1));
        }
        else {
            input_field.append(((Button)v).getText());
        }
        Log.i(DISPLAY_SERVICE, "Button clicked : " + v.getId());
    }
}
