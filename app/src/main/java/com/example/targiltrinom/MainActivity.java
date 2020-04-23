package com.example.targiltrinom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
   EditText et1,et2,et3;
   final String Plus = "%2B";
    String start = "https://www.google.com/search?q=";
    String trinom = "A*x%5E2Bx-C";
    String end = "&oq=2*&aqs=chrome.0.69i59j69i57j0l6.2526j0j7&sourceid=chrome&ie=UTF-8";
    String link;
   WebView wv ;
   double a=0,b=0,c=0;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        wv = (WebView) findViewById(R.id.wv);
        String st1 = et1.getText().toString();
        String st2 = et2.getText().toString();
        String st3 = et3.getText().toString();
        while ((a != 0) && (st1!=null) &&(st2!=null)&&(st3!=null)) {
            a = Double.parseDouble(st1);
            b = Double.parseDouble(st2);
            c = Double.parseDouble(st3);
            trinom.replace("A",st1);
            if (b > 0) {
                trinom.replace("B", Plus + st2);
            } else {
                trinom.replace("B",st2);
            }
            if (c > 0) {
                trinom.replace("C", Plus +st3);
            } else {
                trinom.replace("C",st3);
            }
            wv.setWebViewClient(new MyWebViewClinet());
        }
    }

    public void load(View view){
        link= start+trinom+end;
        wv.loadUrl(link);
    }

    private class MyWebViewClinet extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView View,String url) {
            View.loadUrl(url);
            return true;
        }

        }
    }

