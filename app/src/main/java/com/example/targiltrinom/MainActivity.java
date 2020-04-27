package com.example.targiltrinom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    final String Plus = "%2B";
    String start = "https://www.google.com/search?sxsrf=ALeKk03_Ue9wbkhqMT9R5heidaeZm6E0jQ%3A1587986652875&ei=3MCmXo2ANcLAgweS4Y74Bw&q=";
    String trinom = "Ax%5E2BxC";
    String end = "&gs_lcp=CgZwc3ktYWIQAzIFCAAQywEyBQgAEMsBMgUIABDLATIECAAQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjoGCAAQBxAeOgQIIxAnOgcIIxDqAhAnOgYIIxAnEBM6AggAOgUIABCDAToHCAAQChDLAVC_5ChYk6UpYLGnKWgBcAB4AIABvAGIAfsLkgEEMC4xMZgBAKABAaoBB2d3cy13aXqwAQo&sclient=psy-ab&ved=0ahUKEwiN3uiiv4jpAhVC4OAKHZKwA38Q4dUDCAw&uact=5";
    String times = "*";
    String link;
    String st1,st2,st3;
    WebView wv;
    double a = 0, b = 0, c = 0;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
         wv = (WebView) findViewById(R.id.wv);
         st1 = et1.getText().toString();
         st2 = et2.getText().toString();
         st3 = et3.getText().toString();
         wv.getSettings().setJavaScriptEnabled(true);
         wv.setWebViewClient(new MyWebViewClinet());
    }

    public void load(View view) {
        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        st3 = et3.getText().toString();
        if ((st1!="")&&(st2!="")&&(st3!="")&&(st1 != "-0") && (st1 != "0")) {
            a = parseDouble(st1);
            b = parseDouble(st2);
            c = parseDouble(st3);
            if ((a > 0)&&(a!=1))
                trinom = trinom.replace("A", st1);
            else if(a!=1){
                trinom = trinom.replace("A", st1 + times);
            }
            else{
                trinom=trinom.substring(1);
            }
            if (b > 0) {
                trinom = trinom.replace("B", Plus + st2);
            } else {
                trinom = trinom.replace("B", st2);
            }
            if (c > 0) {
                trinom = trinom.replace("C", Plus + st3);
            } else {
                trinom = trinom.replace("C", st3);
            }
            link = start + trinom + end;
        }
        else {
            Toast.makeText(this,"please enter numbers" ,Toast.LENGTH_SHORT).show();
        }
        wv.loadUrl(link);
    }

    public void restart(View view) {
        et1.setText("enter a");
        et2.setText("enter b");
        et3.setText("enter c");
        a = 0;
        b = 0;
        c = 0;
        link = "";
        st1="";
        st2="";
        st3="";
    }

    private class MyWebViewClinet extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView View, String url) {
            View.loadUrl(url);
            return true;
        }

    }
}



