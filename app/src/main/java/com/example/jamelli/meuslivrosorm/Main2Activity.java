package com.example.jamelli.meuslivrosorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.orm.SugarContext;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.button3) Button bntSalvar;
    @BindView(R.id.button4) Button bntCancelar;

    @BindView(R.id.editText) EditText titulo;
    @BindView(R.id.editText2) EditText autor;
    @BindView(R.id.editText3) EditText ano;
    @BindView(R.id.ratingBar) RatingBar nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SugarContext.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);



        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo_ = titulo.getText().toString();
                String autor_ = autor.getText().toString();
                int ano_ = Integer.valueOf(ano.getText().toString());
                float nota_ = nota.getRating();
                Livro livro = new Livro(titulo_,autor_,ano_,nota_);

                livro.save(livro);

                Log.i("salvo",livro.toString());
                Intent i = new Intent();
                setResult(RESULT_OK,i);
                finish();
            }
        });

        bntCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                setResult(RESULT_CANCELED,i);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}

