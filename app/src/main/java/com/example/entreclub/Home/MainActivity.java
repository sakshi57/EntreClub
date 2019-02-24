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
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entreclub.Api;
import com.example.entreclub.R;
import com.example.entreclub.Registration.RegistrationActivity;
import com.example.entreclub.signInClient;

import org.mindrot.jbcrypt.BCrypt;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    TextView tNewUser;
    LinearLayout l;
  //  Button b;

    private EditText editTextMail;
    private  EditText editTextPass;
    private String emailid;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tNewUser=(TextView)findViewById(R.id.newUser);
        l=(LinearLayout)findViewById(R.id.LayoutInput);

        editTextMail = findViewById(R.id.mail);
        editTextPass = findViewById(R.id.pass);

        findViewById(R.id.login).setOnClickListener(this);
      //  b = (Button)findViewById(R.id.login) ;
       // b.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
              //  Intent i = new Intent(MainActivity.this,HomeActivity.class);
               // startActivity(i);
          //  }
     //   });
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


    public void userLogin(){
            emailid = editTextMail.getText().toString().trim();
            password = editTextPass.getText().toString().trim();

        if(emailid.isEmpty()){
            editTextMail.setError("Email id is required!");
            editTextMail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()){
            editTextMail.setError("Please enter a valid mail id!");
            editTextMail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPass.setError("Password required!");
            editTextPass.requestFocus();
            return;
        }

        if(password.length() < 7){
            editTextPass.setError("Password must be atleast 7 characters long!");
            editTextPass.requestFocus();
            return;
        }



        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://172.20.10.3:8080/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Api userClient =  retrofit.create(Api.class);

        Call<signInClient> call = userClient.signInUser(emailid);


        call.enqueue(new Callback<signInClient>() {
            @Override
            public void onResponse(Call<signInClient> call, Response<signInClient> response) {

                if(BCrypt.checkpw(password,response.body().getPassword())){
                   Toast.makeText(MainActivity.this,"Logged in successfully!",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
               }
               else
                {
                    Toast.makeText(MainActivity.this,"Incorrect Email or Password!",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<signInClient> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed! Please check your internet connection!",Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.login:
                userLogin();
                break;
        }

    }
}
