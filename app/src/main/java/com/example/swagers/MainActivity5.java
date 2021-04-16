package com.example.swagers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity {

    private ImageView back;
    private Button register2;
    private TextView help;
    private EditText email,username,teamName,password;
    FirebaseDatabase rootNode;//database
    DatabaseReference reference;//nodes in database eg:user in database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        email = findViewById(R.id.editTextTextEmailAddress2);
        username = findViewById(R.id.editTextTextPersonName3);
        teamName = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextTextPassword2);


        register2 = findViewById(R.id.registerbtn2);
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String Email = email.getText().toString();
                String UserName = username.getText().toString();
                String TeamName = teamName.getText().toString();
                String PassWord = password.getText().toString();


                UserHelperClass helperClass = new UserHelperClass( Email, UserName, TeamName, PassWord);
                reference.child(UserName).setValue(helperClass);

                Intent intent = new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
            }
        });


        help = findViewById(R.id.helptv2);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this,MainActivity6.class);
                startActivity(intent);
            }
        });


        back = findViewById(R.id.backbtn2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
            }
        });


    }
}