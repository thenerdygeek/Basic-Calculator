package com.example.android.calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        String str="",main="",all="";
        String sign;
        int a=0,b=0;

        public void reset(View view)
        {
            str="";
            main="";
            all="";
            a=0;
            b=0;
            displayMessage(all);
            displayResult(main);
        }
        public void zero(View view)
        {
            str+="0";
            main+="0";
            displayMessage(main);
        }
        public void one(View view)
        {
            str+="1";
            main+="1";
            displayMessage(main);
        }
        public void two(View view)
        {
            str+="2";
            main+="2";
            displayMessage(main);
        }
        public void three(View view)
        {

            str+="3";
            main+="3";
            displayMessage(main);
        }
        public void four(View view)
        {
            str+="4";
            main+="4";
            displayMessage(main);
        }
        public void five(View view)
        {
            str+="5";
            main+="5";
            displayMessage(main);
        }
        public void six(View view)
        {
            str+="6";
            main+="6";
            displayMessage(main);
        }
        public void seven(View view)
        {
            str+="7";
            main+="7";
            displayMessage(main);
        }
        public void eight(View view)
        {
            str+="8";
            main+="8";
            displayMessage(main);
        }
        public void nine(View view)
        {
            str+="9";
            main+="9";
            displayMessage(main);
        }
        public void del(View view)
        {
            if (str.length() > 0) {
                str = str.substring(0, str.length()-1);
                main = main.substring(0, main.length()-1);
                displayMessage(main);
            }
            else if(sign.length()!=0&&str.length()==0)
            {
                main=main.substring(0,main.length()-1);
                sign="";
                str=main;
                displayMessage(main);
            }

        }
        public void add(View view)
        {
            try
            {
                a = Integer.parseInt(str);
                sign = "+";
                str = "";
                main+=sign;
                displayMessage(main);
            }
            catch (Exception e)
            {
                displayMessage(main);
            }
        }
        public void sub(View view)
        {
            try
            {
                if (str.length() == 0) {
                    str += "-";
                    main += "-";
                    displayMessage(main);
                } else {
                    a = Integer.parseInt(str);
                    sign = "-";
                    str = "";
                    main += sign;
                    displayMessage(main);
                }
            }
            catch (Exception e)
            {
                displayMessage(main);
            }

        }
        public void mul(View view)
        {
            try
            {
                a = Integer.parseInt(str);
                sign = "*";
                str = "";
                main += sign;
                displayMessage(main);
            }
            catch (Exception e)
            {
                displayMessage(main);
            }
        }
        public void div(View view)
        {
            try
            {
                a = Integer.parseInt(str);
                sign = "/";
                str = "";
                main += sign;
                displayMessage(main);
            }
            catch (Exception e)
            {
                displayMessage(main);
            }
        }
        public void result(View view)
        {
            float x= 0;
            b= Integer.parseInt(str);
            switch(sign)
            {
                case "+":
                    x =a+b;
                    break;
                case "-":
                    x =a-b;
                    break;
                case "*":
                    x =a*b;
                    break;
                case "/":
                    x =(float) a/b;
                    break;
                default:

            }
            main+=" = "+Float.toString(x);
            all+=main+"\n";
            displayResult(all);
            displayResultitalic(Float.toString(x));
            main="";
            a=0;
            b=0;
            sign="";
            str="";
        }
        private void displayMessage(String message) {
            TextView textView = (TextView) findViewById(R.id.text2_view);
            textView.setPadding(pixels(64), pixels(32), 0, 0);
            textView.setTypeface(null, Typeface.NORMAL);
            textView.setText(message);
        }
        private void displayResult(String message) {
            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textView.setText(message);
        }
        private void displayResultitalic(String message) {
            TextView textView = (TextView) findViewById(R.id.text2_view);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            textView.setPadding(pixels(128), pixels(32), 0, 0);
            textView.setText(message);
        }
        private int pixels(int sizeInDp)
        {
            float scale = getResources().getDisplayMetrics().density;
            int dpAsPixels = (int) (sizeInDp*scale + 0.5f);
            return dpAsPixels;
        }

    }
