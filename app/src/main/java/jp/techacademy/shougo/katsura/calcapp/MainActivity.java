package jp.techacademy.shougo.katsura.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int value1;
    public int value2;

    EditText mEditText;
    EditText xEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.buttontasu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI_PARTS", "ボタンをタップしました");
            }
        });

        Button buttontasu = (Button) findViewById(R.id.buttontasu);
        Button buttonhiku = (Button) findViewById(R.id.buttonhiku);
        Button buttonkakeru = (Button) findViewById(R.id.buttonkakeru);
        Button buttonwaru = (Button) findViewById(R.id.buttonwaru);

        buttontasu.setOnClickListener(this);
        buttonhiku.setOnClickListener(this);
        buttonkakeru.setOnClickListener(this);
        buttonwaru.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.edittext1);
        xEditText = (EditText) findViewById(R.id.edittext2);
    }

    @Override
    public void onClick(View v) {
        String str1 = mEditText.getText().toString();
        String str2 = xEditText.getText().toString();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("VALUE1", str1);
        intent.putExtra("VALUE2", str2);

        if (v.getId() == R.id.buttontasu) {
            intent.putExtra("VALUE3", "+");
        } else if (v.getId() == R.id.buttonhiku) {
            intent.putExtra("VALUE3", "-");
        } else if (v.getId() == R.id.buttonkakeru) {
            intent.putExtra("VALUE3", "*");
        } else if (v.getId() == R.id.buttonwaru) {
            intent.putExtra("VALUE3", "%");
        }


        startActivity(intent);
    }

}
