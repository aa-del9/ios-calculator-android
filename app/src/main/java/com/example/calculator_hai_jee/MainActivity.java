package com.example.calculator_hai_jee;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView input,output,operator;
    boolean add=false,dot=false,sub=false,mul=false,div=false,plsmns=false,term=false
            ,solved=false;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_AC,button_del, button_Dot,button_plsmns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.button0);
        button_1 = (Button) findViewById(R.id.button1);
        button_2 = (Button) findViewById(R.id.button2);
        button_3 = (Button) findViewById(R.id.button3);
        button_4 = (Button) findViewById(R.id.button4);
        button_5 = (Button) findViewById(R.id.button5);
        button_6 = (Button) findViewById(R.id.button6);
        button_7 = (Button) findViewById(R.id.button7);
        button_8 = (Button) findViewById(R.id.button8);
        button_9 = (Button) findViewById(R.id.button9);
        button_Dot = (Button) findViewById(R.id.button_dot);
        button_Add = (Button) findViewById(R.id.button_add);
        button_Sub = (Button) findViewById(R.id.button_sub);
        button_Mul = (Button) findViewById(R.id.button_multi);
        button_Div = (Button) findViewById(R.id.button_divide);
        button_AC = (Button) findViewById(R.id.button_clear);
        button_Equ = (Button) findViewById(R.id.button_equal);
        button_del = (Button) findViewById(R.id.button_del);
        button_plsmns = (Button) findViewById(R.id.button_plsmns);
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        operator=(TextView) findViewById(R.id.operator);

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "0");
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot) {
                    input.setText(input.getText() + "");
                }
                else {
                    input.setText(input.getText() + ".");
                    dot = true;
                }
            }
        });
        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator.getText().toString()==""){
                    input.setText("");
                operator.setText("");
                output.setText("");
                add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;}
                double ans=0.0;
                if(!TextUtils.isEmpty(input.getText().toString())) {
                    if (add) {
                        ans = Double.parseDouble(output.getText().toString()) + Double.parseDouble(input.getText().toString());
                    } else if (sub) {
                        ans = Double.parseDouble(output.getText().toString()) - Double.parseDouble(input.getText().toString());
                    } else if (mul) {
                        ans = Double.parseDouble(output.getText().toString()) * Double.parseDouble(input.getText().toString());
                    } else if (div) {
                        if (Double.parseDouble(input.getText().toString()) != 0.0)
                            ans = Double.parseDouble(output.getText().toString()) / Double.parseDouble(input.getText().toString());
                        else {
                            output.setText(output.getText().toString() + operator.getText() + input.getText());
                            operator.setText("");
                            input.setText("Math Error");
                            term = true;
                            add = false;
                            sub = false;
                            mul = false;
                            div = false;
                            plsmns = false;
                            solved = true;
                        }

                    }
                    if (!term) {
                        output.setText(output.getText().toString() + operator.getText() + input.getText());
                        operator.setText("");
                        DecimalFormat decimalFormat = new DecimalFormat("#.#########");
                        String result = decimalFormat.format(ans);
                        if(result.indexOf('.')!=-1)//answer is not int
                            dot=true;
                        else
                            dot=false;
                        input.setText(result);
                        add = false;
                        sub = false;
                        mul = false;
                        div = false;
                        plsmns = false;
                        term = false;
                        solved = true;
                    }
                }
            }
        });
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!solved) {
                    if (TextUtils.isEmpty(output.getText().toString())) {
                        output.setText(input.getText() + "");
                        operator.setText("+");
                        input.setText("");
                        add = true;
                        dot = false;
                        solved = false;
                    } else if (operator.getText().toString() != "+")
                        operator.setText("+");
                }
                else if(!term){
                    output.setText(input.getText() + "");
                    operator.setText("+");
                    input.setText("");
                    add = true;
                    dot = false;
                    solved = false;}
                else{
                    input.setText("");
                    operator.setText("");
                    output.setText("");
                    add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;
                }
                }


            });
        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!solved) {
                    if (TextUtils.isEmpty(output.getText().toString())) {
                        output.setText(input.getText() + "");
                        operator.setText("-");
                        input.setText("");
                        sub = true;
                        dot = false;
                        solved = false;
                    } else if (operator.getText().toString() != "-")
                        operator.setText("-");
                }
                else if(!term){
                    output.setText(input.getText() + "");
                operator.setText("-");
                input.setText("");
                sub = true;
                dot = false;
                solved = false;}
                else{
                    input.setText("");
                    operator.setText("");
                    output.setText("");
                    add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;
                }
            }
        });
        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!solved) {
                    if (TextUtils.isEmpty(output.getText().toString())) {
                        output.setText(input.getText() + "");
                        operator.setText("x");
                        input.setText("");
                        mul = true;
                        dot = false;
                        solved = false;
                    } else if (operator.getText().toString() != "x")
                        operator.setText("x");
                }
                else if(!term){
                    output.setText(input.getText() + "");
                operator.setText("x");
                input.setText("");
                mul = true;
                dot = false;
                solved = false;}
                else{
                    input.setText("");
                    operator.setText("");
                    output.setText("");
                    add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;
                }
            }
        });
        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!solved) {
                    if (TextUtils.isEmpty(output.getText().toString())) {
                        output.setText(input.getText() + "");
                        operator.setText("÷");
                        input.setText("");
                        div = true;
                        dot = false;
                        solved = false;
                    } else if (operator.getText().toString() != "÷")
                        operator.setText("+");
                }
                else if(!term){
                    output.setText(input.getText() + "");
                operator.setText("÷");
                input.setText("");
                div = true;
                dot = false;
                solved = false;}
                else{
                    input.setText("");
                    operator.setText("");
                    output.setText("");
                    add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;
                }
            }
        });
        button_plsmns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plsmns){
                    input.setText(input.getText().toString().substring(1,input.getText().toString().length()));
                    plsmns=false;}
                else{
                    input.setText("-"+input.getText());
                    plsmns=true;}
            }
        });
        button_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                operator.setText("");
                output.setText("");
                add=false;sub=false;mul=false;div=false;plsmns=false;term=false;dot=false;solved=false;
            }
        });
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(input.getText().toString())&&!solved) {
                    if(input.getText().toString().charAt(input.getText().toString().length()-1)=='.')
                        dot=false;
                    String temp=input.getText().toString();
                    input.setText(temp.substring(0,temp.length()-1));

            }
            }
        });
    }
}