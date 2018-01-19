package com.example.peleg.text1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    EditText edt;
    Button bt;
    TextView tvcnt;
    final int REGISTERCODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        bt = (Button) findViewById(R.id.bt1);
        edt = (EditText) findViewById(R.id.fieldFirstOpinion);
        tvcnt = findViewById(R.id.tv1Cnt);
        ((EditText) findViewById(R.id.fieldFirstOpinion)).addTextChangedListener(new tw());
        tvcnt.setText(getString(R.string.cnt)+edt.getText().length());

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                String s1 = edt.getText().toString();
                Intent i = new Intent(MainActivity.this, ChangeActivity.class);
                i.putExtra("origin", s1);
                setResult(RESULT_OK, i);
                startActivityForResult(i, REGISTERCODE);
            }
        });
    }
    private class tw implements TextWatcher {

        public tw() {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tvcnt.setText(getString(R.string.cnt)+edt.getText().length());
            if (edt.getText().length() == 0) {
                edt.setEnabled(false);
            } else
                edt.setEnabled(true);
            if (edt.getText().length() == 150 || edt.getText().length() > 150) {
                Toast.makeText(MainActivity.this , getString(R.string.toast), Toast.LENGTH_LONG).show();
            }
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {}
    };
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("Answer",edt.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null) {
           edt.setText((String) savedInstanceState.getString("Answer"));

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTERCODE && resultCode == RESULT_OK){
            edt.setText(data.getStringExtra("Changed"));
        }
    }
}

