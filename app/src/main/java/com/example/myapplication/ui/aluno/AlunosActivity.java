package com.example.myapplication.ui.aluno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.model.Aluno;

import java.util.ArrayList;

public class AlunosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnCadastrarAluno;
    private Button btnListaAlunos;
    private EditText etNomeAluno;
    private EditText etIdAluno;
    private ArrayList<Aluno> Alunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        insereAlunosNaLista();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Alunos");

        etNomeAluno = findViewById(R.id.etNomeAluno);
        etIdAluno = findViewById(R.id.etIdAluno);

        btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno);
        btnCadastrarAluno.setOnClickListener(view -> {
            //Pega o texto que foi digitado no EditText e atribue a uma variável
            String nome = etNomeAluno.getText().toString();
            String id = etIdAluno.getText().toString();
            //Verifica se o texto não é vazio
            if (nome.length() == 0 || id.length() == 0) {
                //Mostra mensagem do tipo Toast com mensagem de erro
                Toast.makeText(this, "Deu erro!", Toast.LENGTH_LONG).show();
            } else {
                //Adicionao o texto digitado na lista Alunos com o add
                Alunos.add(new Aluno(id, nome));
                //Mostra mensagem do tipo Toast com mesagem de sucesso
                Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                //Limpa o EditText
                etNomeAluno.setText("");
            }
        });

        btnListaAlunos = findViewById(R.id.btnListaAlunos);
        btnListaAlunos.setOnClickListener(view -> {
            Intent intent = new Intent(AlunosActivity.this, ListaAlunosActivity.class);
            //Envia através da intent um argumento do tipo ArrayList
            intent.putExtra("BUNDLE", Alunos);
            startActivity(intent);
        });
    }

    private void insereAlunosNaLista() {
        // Criando alguns alunos
        Alunos.add(new Aluno("1", "Pedro"));
        Alunos.add(new Aluno("2", "João"));
        Alunos.add(new Aluno("4", "Bruna"));
        Alunos.add(new Aluno("3", "Laura"));
        Alunos.add(new Aluno("44", "Jorge"));
    }
}