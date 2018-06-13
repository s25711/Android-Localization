package com.developer.localization_android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Resources resources;
    TextView sign_in_text;
    EditText input_email,input_password;
    AppCompatButton btn_login;
    TextView link_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in=getIntent();
        String language=in.getStringExtra("res");

        bindView();

        if (language.contains("punjabi")){
            resources=CommonClas.getLocaleStringResource(new Locale("pu"),MainActivity.this);
            setTextOnFields(resources);
        }else if (language.contains("English")){
            resources=CommonClas.getLocaleStringResource(new Locale("en"),MainActivity.this);
            setTextOnFields(resources);
        }else if (language.contains("Tamil")){
            resources=CommonClas.getLocaleStringResource(new Locale("ta"),MainActivity.this);
            setTextOnFields(resources);
        }else if (language.contains("French")){
                resources=CommonClas.getLocaleStringResource(new Locale("fr"),MainActivity.this);
            setTextOnFields(resources);
        }else if (language.contains("Hindi")){
            resources=CommonClas.getLocaleStringResource(new Locale("hi"),MainActivity.this);
            setTextOnFields(resources);
        }

    }

    private void bindView(){
        sign_in_text=findViewById(R.id.sign_in_text);
        input_email=findViewById(R.id.input_email);
        input_password=findViewById(R.id.input_password);
        btn_login=findViewById(R.id.btn_login);
        link_signup=findViewById(R.id.link_signup);

    }

    private void setTextOnFields(Resources resources){
        getSupportActionBar().setTitle(resources.getString(R.string.signin));
        sign_in_text.setText(resources.getString(R.string.signin));
        input_email.setHint(resources.getString(R.string.email_hint));
        input_password.setHint(resources.getString(R.string.password_hint));
        btn_login.setText(resources.getString(R.string.signin));
        link_signup.setText(resources.getString(R.string.sign_up_link_text));
    }



}
