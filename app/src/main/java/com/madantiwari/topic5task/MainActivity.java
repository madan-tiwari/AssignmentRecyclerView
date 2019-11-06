package com.madantiwari.topic5task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.madantiwari.topic5task.adapter.DataAdapter;
import com.madantiwari.topic5task.model.Values;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List list = new ArrayList();
    EditText etName, etAge;
    RadioButton rdoMale, rdoFemale, rdoOthers;
    Button btnSave;
    RecyclerView recycler;
    Spinner spnImage;
    private String Bands[] = {
            "Pink Floyd",
            "Tool",
            "Opeth",
            "Guns and Roses",
            "Dream Theather",
            "Avenged Sevenfold"
    };
    private String gender;
    private int image;
    List<Values> valuesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etEnterName);
        etAge = findViewById(R.id.etEnterAge);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoOthers = findViewById(R.id.rdoOthers);
        btnSave = findViewById(R.id.btnSave);
        spnImage = findViewById(R.id.spinnerImage);
        recycler = findViewById(R.id.recycler);

        DataAdapter dataAdapter = new DataAdapter(this, list);
        recycler.setAdapter(dataAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                Bands
        );

        spnImage.setAdapter(arrayAdapter);

        spnImage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spnImage.getSelectedItem().toString().equals("Pink Floyd")) {
                    image = R.drawable.pinkfloyd;
                } else if (spnImage.getSelectedItem().toString().equals("Tool")) {
                    image = R.drawable.tool;
                } else if (spnImage.getSelectedItem().toString().equals("Opeth")) {
                    image = R.drawable.opeth;
                } else if (spnImage.getSelectedItem().toString().equals("Guns and Roses")) {
                    image = R.drawable.gnr;
                } else if (spnImage.getSelectedItem().toString().equals("Dream Theather")) {
                    image = R.drawable.dreamthea;
                } else if (spnImage.getSelectedItem().toString().equals("Avenged Sevenfold")) {
                    image = R.drawable.a7x;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rdoMale.setOnClickListener(this);
        rdoFemale.setOnClickListener(this);
        rdoOthers.setOnClickListener(this);
        btnSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rdoMale:
                gender = "Male";
                break;
            case R.id.rdoFemale:
                gender = "Female";
                break;
            case R.id.rdoOthers:
                gender = "Others";
                break;
            case R.id.btnSave:
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    etName.setError("please enter name");
                }
                if (TextUtils.isEmpty(etAge.getText().toString())) {
                    etAge.setError("please enter Age");
                } else {

                    valuesList.add(new Values(etName.getText().toString(), etAge.getText().toString(), gender, image));
                    DataAdapter dataAdapter = new DataAdapter(this, valuesList);
                    recycler.setAdapter(dataAdapter);
                    recycler.setLayoutManager(new LinearLayoutManager(this));
                    etName.getText().clear();
                    etAge.getText().clear();
                    rdoMale.setSelected(false);
                    rdoFemale.setSelected(false);
                    rdoOthers.setSelected(false);
                }
                break;

        }

    }
}