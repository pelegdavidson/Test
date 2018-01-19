package com.example.peleg.text1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ChangeActivity extends Activity {
    TextView tva;
    String t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        tva = findViewById(R.id.tvanswer);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tva.setText(data.getStringExtra("origin"));
        t = data.getStringExtra("origin");

        }

    public void sendMessage2(View v) {
        Intent intent = new Intent (this, MainActivity.class);
        TextView tva = (TextView) findViewById(R.id.tvanswer);
        String s1 = tva.getText().toString();
        intent.putExtra("Changed", s1);
        setResult(RESULT_OK,intent);
        finish();
    }
    public void toCap(View v){
        tva.setText(tva.getText().toString().toUpperCase());
    }
    public void tolow(View v){
        tva.setText(tva.getText().toString().toLowerCase());
    }
    public void toOrigin(View v){
        tva.setText(t);
    }

}
