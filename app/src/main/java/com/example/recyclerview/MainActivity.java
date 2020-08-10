package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,email,phone;
    Button submit;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        submit = findViewById(R.id.submit);
        reference = FirebaseDatabase.getInstance().getReference().child("users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    Toast.makeText(MainActivity.this, "Please enter valid email address ", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(phone.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please enter your phone", Toast.LENGTH_SHORT).show();
                }
                else
                   submit();
            }
        });
    }

    private void submit() {
        HashMap map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("email", email.getText().toString());
        map.put("phone", phone.getText().toString());
        reference.push()
                .setValue(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "User Information Submitted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Userlist.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to submit please check info.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

     /*   item_list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        manager = new LinearLayoutManager(this);
        adaptor_class = new Adaptor_class(this, item_list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptor_class);

        item_list.add(new Model_class("1st Title", "1st description"));
        item_list.add(new Model_class("2nd Title", "2nd description"));
        item_list.add(new Model_class("3rd Title", "3rd description"));
        item_list.add(new Model_class("4th Title", "4th description"));
        item_list.add(new Model_class("5th Title", "5th description"));
        item_list.add(new Model_class("1st Title", "1st description"));
        item_list.add(new Model_class("2nd Title", "2nd description"));
        item_list.add(new Model_class("3rd Title", "3rd description"));
        item_list.add(new Model_class("4th Title", "4th description"));
        item_list.add(new Model_class("5th Title", "5th description"));
        item_list.add(new Model_class("1st Title", "1st description"));
        item_list.add(new Model_class("2nd Title", "2nd description"));
        item_list.add(new Model_class("3rd Title", "3rd description"));
        item_list.add(new Model_class("4th Title", "4th description"));
        item_list.add(new Model_class("5th Title", "5th description"));
*/