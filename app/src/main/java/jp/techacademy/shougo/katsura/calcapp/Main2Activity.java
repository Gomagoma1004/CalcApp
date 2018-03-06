package jp.techacademy.shougo.katsura.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("VALUE1");
        String value2 = intent.getStringExtra("VALUE2");
        String value3 = intent.getStringExtra("VALUE3");

        Double getint1;
        Double getint2;

        try {
            getint1 = Double.parseDouble(value1);
            getint2 = Double.parseDouble(value2);

        } catch (NumberFormatException e) {
            showAlertDialog();
            return;
        }


        TextView textView = (TextView) findViewById(R.id.textView);

        if (value3.equals("+")) {
            textView.setText(String.valueOf(getint1 + getint2));
        } else if (value3.equals("-")) {
            textView.setText(String.valueOf(getint1 - getint2));
        } else if (value3.equals("*")) {
            textView.setText(String.valueOf(getint1 * getint2));
        } else if ((value3.equals("%")) && (getint2 == 0)) {
            showAlertDialog2();
            return;
        } else {
            textView.setText(String.valueOf(getint1 / getint2));
        }




    }

    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("数字を入れてください！");
        alertDialogBuilder.setMessage("文字以外のものは使うことができません.");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("それな",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("それま？",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showAlertDialog2() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("ゼロで割るとか正気ですか？");
        alertDialogBuilder.setMessage("小学校で習ったやんけ。");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("おけ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("わり",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
