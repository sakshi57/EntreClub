package com.example.entreclub.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.entreclub.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AskHave extends AppCompatActivity {

    Intent i;
    EditText e1,e2;
    Button btn;
    String type;
    RadioGroup radioGroup;
    RadioButton rb;
    FirebaseFirestore db;
    DocumentReference documentReference;
    FirebaseUser user;
    String current_user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);
        db= FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        current_user_id = user.getEmail();
        i=getIntent();
        final String eventId=i.getStringExtra("ID");
        documentReference=db.collection("Events").document(eventId).collection("asks").document(current_user_id);
        e1=(EditText) findViewById(R.id.email);
        btn=(Button)findViewById(R.id.btn_submit);
        e2=(EditText)findViewById(R.id.description);
        radioGroup=findViewById(R.id.rbtn);
        Toast.makeText(getApplicationContext(),eventId,Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioid = radioGroup.getCheckedRadioButtonId();
                                       rb = findViewById(radioid);
                                       type = (String) rb.getText();
                                       Toast.makeText(getApplicationContext(), type, Toast.LENGTH_LONG).show();

                                       String desc = e2.getText().toString();
//                String mail=e1.getText().toString();
////                AddNeeds a=new AddNeeds(type,desc,mail);
//
//                                       documentReference.set(desc).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                           @Override
//                                           public void onSuccess(Void aVoid) {
//
//                                           }
//                                       });


                if(type.equals("Ask")) {
                    Map<String, Object> entrepreneur = new HashMap<>();
                    entrepreneur.put("Description", desc);
                    db.collection("Events").document(eventId).collection("asks").document(current_user_id).set(entrepreneur).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Ask Saved!",Toast.LENGTH_SHORT);

                        }
                    });
                }

                else{
                    Map<String, Object> entrepreneur = new HashMap<>();
                    entrepreneur.put("Description", desc);
                    db.collection("Events").document(eventId).collection("haves").document(current_user_id).set(entrepreneur)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Toast.makeText(getApplicationContext(),"Have Saved!",Toast.LENGTH_SHORT);

                                }
                            });
                }





            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//                                   @Override
//                                   public void onClick(View v) {
//                                       int radioid = radioGroup.getCheckedRadioButtonId();
//                                       rb = findViewById(radioid);
//                                       type = (String) rb.getText();
//                                       Toast.makeText(getApplicationContext(), type, Toast.LENGTH_LONG).show();
//
//                                       String desc = e2.getText().toString();
////                String mail=e1.getText().toString();
////                AddNeeds a=new AddNeeds(type,desc,mail);
//
//                                       documentReference.set(desc).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                           @Override
//                                           public void onSuccess(Void aVoid) {
//
//                                           }
//                                       });
//                                   }
//
//                               }
    }
}



//                CollectionReference dbProducts = db.collection("UpdateEventInfo");
//
//                dbProducts.add(a).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(getApplicationContext(),"Data addded succesfully",Toast.LENGTH_LONG).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });

//            }
//        });

//
//            }
//
//        }
//    }
//}
