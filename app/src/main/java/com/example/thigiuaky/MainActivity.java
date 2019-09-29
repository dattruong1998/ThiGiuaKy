package com.example.thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import Entities.Person;

public class MainActivity extends AppCompatActivity {
    EditText ed_HoTen,ed_Luong,ed_Ma,ed_File;
   RadioButton rd_Nam,rd_Nu;
   Button bt_Xem,bt_Luu;
   ArrayList<String>list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_HoTen=(EditText)findViewById(R.id.editTextHoTen);
        ed_Ma=(EditText)findViewById(R.id.editTextMa);
        ed_Luong=(EditText)findViewById(R.id.editTextLuong);
        ed_File=(EditText)findViewById(R.id.editTextFile);
        rd_Nam=(RadioButton)findViewById(R.id.radioNam);
        rd_Nu=(RadioButton)findViewById(R.id.radioNu);
        bt_Xem=(Button)findViewById(R.id.buttonXem);
        bt_Luu=(Button)findViewById(R.id.buttonLuu);
        bt_Xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("ds",list);
                startActivity(intent);

            }
        });
        bt_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename=ed_File.getText().toString();
                Person p=null;
                list.add(filename);
                try {
                    FileOutputStream fout=openFileOutput(filename, Context.MODE_PRIVATE);

                    if(rd_Nam.isChecked()) {
                        p= new Person(ed_Ma.getText().toString(),"nam",ed_HoTen.getText().toString(),Integer.parseInt(ed_Luong.getText().toString()));
                    }
                    if(rd_Nu.isChecked()) {
                         p = new Person(ed_Ma.getText().toString(),"nu",ed_HoTen.getText().toString(),Integer.parseInt(ed_Luong.getText().toString()));
                    }
                    fout.write(p.toString().getBytes());
                    fout.close();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Loi luu file", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
