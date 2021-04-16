package com.example.swagers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    private Button login;
    private TextView register2,help;
    private ImageView back;
    private EditText useret,passet;

    private String Username = "Vedha";
    private String Password = "12";

    //boolean isValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        useret = findViewById(R.id.editTextTextPersonName);
        passet = findViewById(R.id.editTextTextPassword);



        login = findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = useret.getText().toString();
                String inputPassword = passet.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) //logical OR
                {
                    Toast.makeText(MainActivity4.this," Please Enter UserName And Password! ",Toast.LENGTH_SHORT).show();

                }else {
                        if(Username.equals(inputName))
                        {
                            if (Password.equals(inputPassword))
                            {
                                Toast.makeText(MainActivity4.this," Login Success! ",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                                startActivity(intent);
                            }else
                            {
                                Toast.makeText(MainActivity4.this," Incorrect Password! ",Toast.LENGTH_SHORT).show();
                            }
                        }else
                        {
                            isUser(inputName,inputPassword);
                        }

                    /*isValid = validate(inputName,inputPassword);

                    if (!isValid)// logical NOT
                    {
                        Toast.makeText(MainActivity4.this," Incorrect! ",Toast.LENGTH_SHORT).show();

                    }else
                    {
                        Toast.makeText(MainActivity4.this," Login Success! ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                        startActivity(intent);
                    }*/

                    }
                    }

        });

        register2 = findViewById(R.id.textView17);
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);
            }
        });


        help = findViewById(R.id.needhelptv1);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity6.class);
                startActivity(intent);
            }
        });

    }

     /*private Boolean validate (String name ,String password){
        if (name.equals(Username) && password.equals(Password))// logical AND
        {
            return true;
        }

        return false;

    }*/

     private void isUser(final String name1 , final String password1){
         DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

         Query checkUser = reference.orderByChild("userName").equalTo(name1);

         checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if (snapshot.exists()){
                     String passwordFromDB = snapshot.child(name1).child("password").getValue(String.class);
                     if (passwordFromDB.equals(password1)){
                         Toast.makeText(MainActivity4.this," Login Success! ",Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                         startActivity(intent);
                     }else {
                         Toast.makeText(MainActivity4.this," Incorrect Password! ",Toast.LENGTH_SHORT).show();
                     }
                 }else {
                     Toast.makeText(MainActivity4.this," No userExists! ",Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });
     }
}