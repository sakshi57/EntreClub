package com.example.entreclub.Registration;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.entreclub.R;
import com.example.entreclub.utils.RecyclerViewAdapterCheck;

import java.util.ArrayList;

public class businessInfo extends Activity {

   // String s=new String();
    String firstname,lastname,emailid,password,contact,dob,city,gender;
    String company,position,description;
    private EditText editTextcompany,editTextposition,editTextdescription;
    ArrayList<String> haves = new ArrayList<String>();
    CheckBox checkBox;
    LinearLayout lm;
    //private ArrayList<String> tags = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_info);
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        String services[] = {"Sakshi", "Nikhil", "Shruti", "Vedang", "Sagar", "Anuj", "Mallika"};
        // String des[] = {"Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API that allows developers to plug in to almost any network stack. By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug in to Google's Volley project or Square's OkHttp library instead.", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ", "By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug "};
        recycler_view.setAdapter(new RecyclerViewAdapterCheck(services));

//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//        firstname = extras.getString("fname");
//        lastname = extras.getString("lname");
//        emailid = extras.getString("mail");
//        contact = extras.getString("phone");
//        password = extras.getString("pass");
//        dob = extras.getString("birthdate");
//        city = extras.getString("residential");
//        gender = extras.getString("gender");
//
////        editTextcompany = findViewById(R.id.editText);
////        editTextposition = findViewById(R.id.editText2);
////        editTextdescription = findViewById(R.id.editText4);
////
////        findViewById(R.id.buttonSignup).setOnClickListener(this);
////        lm = (LinearLayout)findViewById(R.id.linearMain);
//
//
//
//       Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("http://192.168.43.44:8080/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        Api api = retrofit.create(Api.class);
//
//        Call<List<getTags>> call = api.tags();
//
//        call.enqueue(new Callback<List<getTags>>() {
//            @Override
//            public void onResponse(Call<List<getTags>> call, Response<List<getTags>> response) {
//
//                    List<getTags> list = response.body();
//                    makeCheckboxes(list);
//            }
//
//            @Override
//            public void onFailure(Call<List<getTags>> call, Throwable t) {
//
//
//                Toast.makeText(businessInfo.this,t.getMessage(),Toast.LENGTH_LONG).show();
//
//
//            }
//        });
//
//    }
//
//    public void makeCheckboxes(List<getTags> list){
//
//
//        for (int i = 0; i < list.size(); i++) {
//            checkBox = new CheckBox(this);
//            checkBox.setId(i);
//            checkBox.setText(list.get(i).getTitle());
//            lm.addView(checkBox);
//
//
//        }
//
//    }
//
//
//
//        public void selectItem(View v) {
//
//        boolean checked = ((CheckBox) v).isChecked();
//        CheckBox obj = (CheckBox) v;
//        String temp = obj.getText().toString();
//
//        if (checked)
//            haves.add(temp);
//        else
//            haves.remove(temp);
//
//    }
//
//
//
//        public void userSignup(){
//
//         company = editTextcompany.getText().toString().trim();
//         position = editTextposition.getText().toString().trim();
//         description = editTextdescription.getText().toString().trim();
//
//            if(company.isEmpty()){
//                editTextcompany.setError("Company required!");
//                editTextcompany.requestFocus();
//                return;
//            }
//
//            if(position.isEmpty()){
//                editTextposition.setError("Position in the company required!");
//                editTextposition.requestFocus();
//                return;
//            }
//
//            if(description.isEmpty()){
//                editTextdescription.setError("Please provide profile description!");
//                editTextdescription.requestFocus();
//                return;
//            }
//
//                    RetrofitClient user = new RetrofitClient(
//                            firstname,lastname,emailid,password,dob,contact,
//                            city,gender,company,position,description,haves
//                    );
//
//                        sendNetworkRequest(user);
//
//            }
//
//
//
//
//        public void sendNetworkRequest(RetrofitClient user) {
//
//            //create Retrofit instance
//
//            Retrofit.Builder builder = new Retrofit.Builder()
//                    .baseUrl("http://192.168.0.102:8080/")
//                    .addConverterFactory(GsonConverterFactory.create());
//
//            Retrofit retrofit = builder.build();
//
//            Api userClient =  retrofit.create(Api.class);
//            Call<RetrofitClient> call = userClient.registerUser(user);
//
//
//            call.enqueue(new Callback<RetrofitClient>() {
//                @Override
//                public void onResponse(Call<RetrofitClient> call, Response<RetrofitClient> response) {
//
//                    Toast.makeText(businessInfo.this,"User with email id : "+response.body().getId() + " registered successfully!",Toast.LENGTH_LONG).show();
//
//                }
//
//                @Override
//                public void onFailure(Call<RetrofitClient> call, Throwable t) {
//                    Toast.makeText(businessInfo.this,"Failed to register User!",Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//
//
//    @Override
//    public void onClick(View v) {
//        switch(v.getId()){
//
//            case R.id.buttonSignup:
//                userSignup();
//                break;
//        }
//

    }

}



