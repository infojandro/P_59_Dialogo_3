package com.example.alu.p_59_dialogo_3;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MiDialogo.MiDialogoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DialogFragment miDialogo= new MiDialogo();
        miDialogo.show(getFragmentManager(),"miDialogo");
    }

    @Override
    public void onDialogPositiveClick(String devuelto) {
        TextView textView=findViewById(R.id.textView);
        textView.setText(devuelto);
    }
}
