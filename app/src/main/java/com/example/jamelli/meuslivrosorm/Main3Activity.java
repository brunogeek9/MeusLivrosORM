package com.example.jamelli.meuslivrosorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orm.SugarContext;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {

    private int cont;
    private ArrayList<Livro> livros = new ArrayList<>();
    @BindView(R.id.button5) Button bnt_voltar;
    @BindView(R.id.button6) Button bnt_proximo;

    @BindView(R.id.textView9) TextView tv_titulo;
    @BindView(R.id.textView10) TextView tv_autor;
    @BindView(R.id.textView11) TextView tv_ano;
    @BindView(R.id.textView12) TextView tv_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SugarContext.init(this);
        ButterKnife.bind(this);
        cont = 0;
        livros = (ArrayList<Livro>) Livro.listAll(Livro.class);

        if(livros.size() == 0) {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED,intent);
            finish();
        }else{
            exibir(cont);
        }

    }

    public void exibir(int x){
        tv_titulo.setText(livros.get(x).getTitulo());
        tv_autor.setText(livros.get(x).getAutor());
        tv_ano.setText(String.valueOf(livros.get(x).getAno()));
        tv_nota.setText(String.valueOf(livros.get(x).getNota()));
    }

    @OnClick(R.id.button5)
    public void anterior(){
        if(cont < 1){
            bnt_voltar.setEnabled(false);
        }else{
            bnt_proximo.setEnabled(true);
            cont--;
            exibir(cont);
        }
    }

    @OnClick(R.id.button6)
    public void proximo(){
        if(cont >= livros.size()-1){
            bnt_proximo.setEnabled(false);
        }else{
            bnt_voltar.setEnabled(true);
            cont++;
            exibir(cont);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }

}
