package com.example.dmitriyk_project1;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
public class Profile extends AppCompatActivity {
    private TextView txtVN;
    private TextView txtVDO;
    private ImageView imVA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);
        txtVN = findViewById(R.id.txtVN);
        txtVDO = findViewById(R.id.txtVDO);
        imVA = findViewById(R.id.imVA);
        }

}