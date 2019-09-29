package com.example.thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
   Button bt_open;
   Spinner spinner;
   TextView tv_content;
   String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt_open=(Button)findViewById(R.id.buttonOpen);
        tv_content=(TextView)findViewById(R.id.textViewContent);
        spinner=(Spinner)findViewById(R.id.spinner);
        Intent intent=getIntent();
        final ArrayList<String>list=(ArrayList<String>) intent.getSerializableExtra("ds");
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                x=list.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                String line=null;
                try {
                    FileInputStream fin=openFileInput(x);
                    BufferedReader br=new BufferedReader(new InputStreamReader(fin));
                    while((line=br.readLine())!=null)
                    {
                        buffer.append(line+"\n");
                        tv_content.setText(buffer.toString());
                    }
                }
                catch (Exception e)
                {

                }
            }
        });
    }
}
