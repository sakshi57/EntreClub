package com.example.entreclub.Registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.entreclub.Api;
import com.example.entreclub.R;
import com.example.entreclub.RetrofitClient;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class businessInfo extends Activity implements View.OnClickListener {

   // String s=new String();
    String firstname,lastname,emailid,password,contact,dob,city,gender;
    String company,position,description;
    private EditText editTextcompany,editTextposition,editTextdescription;
    ArrayList<String> haves = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_info);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        firstname = extras.getString("fname");
        lastname = extras.getString("lname");
        emailid = extras.getString("mail");
        contact = extras.getString("phone");
        password = extras.getString("pass");
        dob = extras.getString("birthdate");
        city = extras.getString("residential");
        gender = extras.getString("gender");

        editTextcompany = findViewById(R.id.editText);
        editTextposition = findViewById(R.id.editText2);
        editTextdescription = findViewById(R.id.editText4);

        findViewById(R.id.buttonSignup).setOnClickListener(this);

        //Toast.makeText(this, "values :  " +firstname,Toast.LENGTH_SHORT).show();

    }

    public void selectItem(View v) {

        boolean checked = ((CheckBox) v).isChecked();
        CheckBox obj = (CheckBox) v;
        String temp = obj.getText().toString();

        if (checked)
            haves.add(temp);
        else
            haves.remove(temp);

    }

       // Toast.makeText(this,temp,Toast.LENGTH_SHORT).show();

        /*

        switch (v.getId()) {
            case R.id.have_CC:
                if (checked)
                    haves.add("CC");
                else
                    haves.remove("CC");

                break;

            case R.id.have_CN:
                if (checked)
                    haves.add("CN");
                else
                    haves.remove("CN");

                break;

            case R.id.have_DAA:
                if (checked)
                    haves.add("DAA");
                else
                    haves.remove("DAA");

                break;


            case R.id.have_DSF:
                if (checked)
                    haves.add("DSF");
                else
                    haves.remove("DSF");

                break;


            case R.id.have_SP:
                if (checked)
                    haves.add("SP");
                else
                    haves.remove("SP");

                break;

            case R.id.have_OS:
                if (checked)
                    haves.add("OS");
                else
                    haves.remove("OS");

                break;


        }

    }*/

        public void userSignup(){

         company = editTextcompany.getText().toString().trim();
         position = editTextposition.getText().toString().trim();
         description = editTextdescription.getText().toString().trim();

            if(company.isEmpty()){
                editTextcompany.setError("Company required!");
                editTextcompany.requestFocus();
                return;
            }

            if(position.isEmpty()){
                editTextposition.setError("Position in the company required!");
                editTextposition.requestFocus();
                return;
            }

            if(description.isEmpty()){
                editTextdescription.setError("Please provide profile description!");
                editTextdescription.requestFocus();
                return;
            }

                    RetrofitClient user = new RetrofitClient(
                            firstname,lastname,emailid,password,dob,contact,
                            city,gender,company,position,description,haves
                    );

                        sendNetworkRequest(user);

            }




        public void sendNetworkRequest(RetrofitClient user) {

            //create Retrofit instance

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.102:8080/")
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            Api userClient =  retrofit.create(Api.class);
            Call<RetrofitClient> call = userClient.registerUser(user);


            call.enqueue(new Callback<RetrofitClient>() {
                @Override
                public void onResponse(Call<RetrofitClient> call, Response<RetrofitClient> response) {

                    Toast.makeText(businessInfo.this,"User with email id : "+response.body().getId() + " registered successfully!",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<RetrofitClient> call, Throwable t) {
                    Toast.makeText(businessInfo.this,"Failed to register User!",Toast.LENGTH_LONG).show();
                }
            });
        }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.buttonSignup:
                userSignup();
                break;
        }


    }

}



