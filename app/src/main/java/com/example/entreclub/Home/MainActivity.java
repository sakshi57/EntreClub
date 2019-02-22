package com.example.entreclub.Home;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.entreclub.R;
import com.example.entreclub.Registration.RegistrationActivity;

public class MainActivity extends AppCompatActivity {
    TextView tNewUser;
    LinearLayout l;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tNewUser=(TextView)findViewById(R.id.newUser);
        l=(LinearLayout)findViewById(R.id.LayoutInput);

        b = (Button)findViewById(R.id.login) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        l.setBackgroundColor(Color.rgb(255,255,255));
        String text="New User? Sign Up";
        SpannableString ss=new SpannableString(text);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent i=new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                String col="#446fcd";
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor(col));
            }
        };

        ss.setSpan(clickableSpan,10,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tNewUser.setText(ss);
        tNewUser.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
