package com.example.jamelli.meuslivrosorm;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    static final int tela1 = 1;
    @BindView(R.id.button)
    protected Button bnt_cad;

    @BindView(R.id.button2)
    protected Button bnt_list;

    @BindView(R.id.tela)
    protected ConstraintLayout tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bnt_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,tela1);
            }
        });

        bnt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });

    }

    public void callSnack(String message){
        Snackbar snackbar = Snackbar
                .make(tela, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == tela1){
            if(resultCode == RESULT_OK)
                callSnack("CADASTRO REALIZADO COM SUCESSO!!");
            else if(resultCode == RESULT_CANCELED)
                callSnack("VC CANCELOU A OPERAÇÃO!!");
        }
    }
}
