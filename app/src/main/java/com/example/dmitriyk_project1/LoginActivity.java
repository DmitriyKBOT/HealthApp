package com.example.dmitriyk_project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button bt_sign_up_in;
    private Button bt_sign_in_in;
    private EditText edTEma;
    private EditText edTPass;
    // создание аунтификации
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создание firebase auntification
        mAuth = FirebaseAuth.getInstance();

        //привязка кнопок
        bt_sign_up_in = findViewById(R.id.bt_sign_up_in);
        bt_sign_in_in = findViewById(R.id.bt_sign_in_in);
        edTEma = findViewById(R.id.edTEma);
        edTPass = findViewById(R.id.edTPass);
        //вешаем слушателя на кнопку отвечающую за переход на registration_main
        bt_sign_up_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //перемещение на новую активность, тоесть на регистрацию
                Intent intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);
            }
        });
        //кнопка отвечающая за вход и переход на profile_main
        bt_sign_in_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Если в registration_mainесли пользователь ввёл не все данные
                if (edTEma.getText().toString().isEmpty() || edTPass.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Не все данные введены", Toast.LENGTH_LONG).show();
                }
                else{
                    //сверяем данные с auntification и выполняем переход на profile_main
                    mAuth.signInWithEmailAndPassword(edTEma.getText().toString(), edTPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(LoginActivity.this, Profile.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, "You have some errors", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}