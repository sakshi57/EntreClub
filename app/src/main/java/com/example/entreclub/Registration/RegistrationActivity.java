package com.example.entreclub.Registration;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.entreclub.R;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView t1;
    private DatePickerDialog datePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    //private Button b;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String selectedGender;
    String firstname,lastname,emailid,password,contact,dob,city,cpassword,pw_hash;


    private EditText editTextfirstname,editTextlastname,editTextemailid,editTextcontact,editTextpassword,editTextcity,editTextcpassword;
    int year,mont,date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_personal_info);


        editTextfirstname = findViewById(R.id.editText12);
        editTextlastname = findViewById(R.id.editText13);
        editTextemailid = findViewById(R.id.editText5);
        editTextcontact = findViewById(R.id.editText6);
        editTextpassword = findViewById(R.id.editText8);
      //  editTextdob = findViewById(R.id.editText10);
        editTextcity = findViewById(R.id.editText11);
        editTextcpassword = findViewById(R.id.editText9);

        findViewById(R.id.btnNext).setOnClickListener(this);
        findViewById(R.id.editText10).setOnClickListener(this);
       t1 = (TextView) findViewById(R.id.editText10);
      t1.setOnClickListener(this);
        radioGroup = findViewById(R.id.rg);

     //  t1= ( TextView) findViewById(R.id.editText10);
      //  b=(Button)findViewById(R.id.btnNext);

        Calendar cal = Calendar.getInstance();
         year=cal.get(Calendar.YEAR);
         mont=cal.get(Calendar.MONTH);
         date=cal.get(Calendar.DAY_OF_MONTH);

    }

        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegistrationActivity.this, businessInfo.class);
                startActivity(i);
            }
        });*/

    /*    t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mont=cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog d=new DatePickerDialog(
                        RegistrationActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,mont,date
                );
                d.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                d.show();
            }
        });*/

   /*     mDateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;

                String date=dayOfMonth+"/"+month+"/"+year;
                t1.setText(date);
            }
        };

*/

        public void checkButton(View v){
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);
            selectedGender = (String) radioButton.getText();
           // Toast.makeText(this, "Button : " + radioButton.getText(),Toast.LENGTH_SHORT).show();
        }

        private boolean userSignup(){

            firstname = editTextfirstname.getText().toString().trim();
            lastname = editTextlastname.getText().toString().trim();
            emailid = editTextemailid.getText().toString().trim();
            contact = editTextcontact.getText().toString().trim();
            password = editTextpassword.getText().toString().trim();
            dob = t1.getText().toString().trim();
            city = editTextcity.getText().toString().trim();
            cpassword = editTextcpassword.getText().toString().trim();


             pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());



//            if(firstname.isEmpty()){
//                editTextfirstname.setError("Firstname required!");
//                editTextfirstname.requestFocus();
//                return false;
//            }
//
//            if(lastname.isEmpty()){
//                editTextlastname.setError("Lastname required!");
//                editTextlastname.requestFocus();
//                return false;
//             }
//
//            if(emailid.isEmpty()){
//                editTextemailid.setError("Email id is required!");
//                editTextemailid.requestFocus();
//                return false;
//            }
//
//             if(!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()){
//                 editTextemailid.setError("Please enter a valid mail id!");
//                 editTextemailid.requestFocus();
//                 return false;
//             }
//
//            if(contact.isEmpty()){
//                editTextcontact.setError("Contact required!");
//                editTextcontact.requestFocus();
//                return false;
//            }
//
//            if(password.isEmpty()){
//                editTextpassword.setError("Password required!");
//                editTextpassword.requestFocus();
//                return false;
//            }
//
//            if(password.length() < 7){
//                editTextpassword.setError("Password must be atleast 7 characters long!");
//                editTextpassword.requestFocus();
//                return false;
//            }
//
//            if(!password.equals(cpassword)){
//                editTextcpassword.setError("Passwords do not match!");
//                editTextcpassword.requestFocus();
//                return false;
//            }
//            if(dob.isEmpty()){
//                t1.setError("Birthdate is required!");
//                t1.requestFocus();
//                return false;
//            }
//
//            if(city.isEmpty()){
//                editTextcity.setError("City required!");
//                editTextcity.requestFocus();
//                return false;
//            }
//
 return true;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {



            case R.id.btnNext:
               // if(userSignup()) {
                    Intent i = new Intent(RegistrationActivity.this, businessInfo.class);

//                    Bundle extras = new Bundle();
//                    extras.putString("fname", firstname);
//                    extras.putString("lname", lastname);
//                    extras.putString("mail", emailid);
//                    extras.putString("phone", contact);
//                    extras.putString("pass", pw_hash);
//                    extras.putString("birthdate", dob);
//                    extras.putString("gender", selectedGender);
//                    extras.putString("residential", city);
//                    i.putExtras(extras);

                    startActivity(i);
              //  }
                break;




            case R.id.editText10:

              /*  Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mont=cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DAY_OF_MONTH);
*/
                DatePickerDialog d=new DatePickerDialog(
                        RegistrationActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,mont,date
                );
                d.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                d.show();


                mDateSetListener =new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;

                        String date = dayOfMonth + "-" + month + "-" + year;
                        t1.setText(date);
                    }
                };
                break;





        }

    }
}