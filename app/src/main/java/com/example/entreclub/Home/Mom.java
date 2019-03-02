package com.example.entreclub.Home;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entreclub.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class Mom extends AppCompatActivity {
    private FirebaseFirestore db;
    String event_id="GxWn6t74SvKa4HtvK8er";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mom);
        db = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        //Date t;
        //pass event_id in Intent from the parent activity
     //   event_id= extras.get("event_id").toString();

       /* db.collection("Events")
       /* db.collection("Events")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                String doc_id_String = document.getId().toString();
                                if(doc_id_String.equals(event_id))
                                {
                                    TextView temp =  (TextView)findViewById(R.id.event_name);
                                    temp.setText(document.getString("Title"));
                                    Timestamp t = document.getTimestamp("Date");
                                    temp =  (TextView)findViewById(R.id.date);
                                    temp.setText(t.toDate().toString());
                                    break;
                                }
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        }
                        else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });*/
        //SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //Toast.makeText(MainActivity.this," rveryday" ,Toast.LENGTH_LONG).show();

        DocumentReference rf = db.collection("Events").document(event_id);
        rf.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    TextView temp =  (TextView)findViewById(R.id.event_name);
                    temp.setText(documentSnapshot.get("Title").toString());
                    temp =  (TextView)findViewById(R.id.date);
                    temp.setText(documentSnapshot.get("Date").toString());
                }
            }
        });


    }


    public void saveMom(View v)
    {
        EditText desc_decision= (EditText) findViewById(R.id.desc_decision);
        EditText desc_remarks= (EditText) findViewById(R.id.desc_remarks);
        EditText desc_amend= (EditText) findViewById(R.id.desc_amend);
        EditText desc_future_scope= (EditText) findViewById(R.id.desc_future_scope);
        //Toast.makeText(MainActivity.this,"Remarks " + desc_remarks.getText().toString().trim(),Toast.LENGTH_LONG).show();
        db  = FirebaseFirestore.getInstance();
        Map<String,Object> datatoSave = new HashMap<String, Object>();
        datatoSave.put("Decisions made",desc_decision.getText().toString().trim());
        datatoSave.put("Future Scope",desc_future_scope.getText().toString().trim());
        datatoSave.put("Amendments",desc_amend.getText().toString().trim());
        datatoSave.put("Remarks",desc_remarks.getText().toString().trim());

        db.collection("Events").document("1")
                .set(datatoSave, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void documentReference) {
                        Toast.makeText(Mom.this,"Mom added successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Mom.this,"lol fail dyna",Toast.LENGTH_LONG).show();
                    }
                });
        TextView temp =  (TextView)findViewById(R.id.desc_decision);
        temp.setText("");
        temp = (TextView)findViewById(R.id.desc_future_scope);
        temp.setText("");
        temp = (TextView)findViewById(R.id.desc_amend);
        temp.setText("");
        temp = (TextView)findViewById(R.id.desc_remarks);
        temp.setText("");

    }




}








