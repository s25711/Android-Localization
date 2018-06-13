package com.developer.localization_android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class SelectLocalizationActivity extends AppCompatActivity {
    Spinner mSelectLanguage;
    Button mNext;

    Resources resources;

    String spinnerArray[]={"English","Tamil","French","Hindi","punjabi"};
    String lcoaleArray[]={"en","ta","fr","hi","pu"};

    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_localization);
        mSelectLanguage=findViewById(R.id.selectLanguage);
        mNext=findViewById(R.id.btnNext);

        getSupportActionBar().setTitle(getResources().getString(R.string.activity_name));


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        mSelectLanguage.setAdapter(spinnerArrayAdapter);

        mSelectLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resources= CommonClas.getLocaleStringResource(new Locale(lcoaleArray[i]),SelectLocalizationActivity.this);
                getSupportActionBar().setTitle(resources.getString(R.string.activity_name));

                language=spinnerArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectLocalizationActivity.this,MainActivity.class).putExtra("res", language));
            }
        });
    }



}
