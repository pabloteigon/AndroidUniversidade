package com.example.myapplication.ui.aluno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AlunosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnCadastrarAluno;
    private Button btnListaAlunos;
    private EditText etNomeAluno;
    private ArrayList<String> Alunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        // Criando alguns alunos
        Alunos.add("Pedro");
        Alunos.add("João");
        Alunos.add("Bruna");
        Alunos.add("Laura");
        Alunos.add("Jorge");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Alunos");

        etNomeAluno = findViewById(R.id.etNomeAluno);

        btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno);
        btnCadastrarAluno.setOnClickListener(view -> {
            String nome = etNomeAluno.getText().toString();
            if (nome.length() == 0) {
                Toast.makeText(this, "Deu erro!", Toast.LENGTH_LONG).show();
            } else {
                Alunos.add(nome);
                Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                etNomeAluno.setText("");
            }
        });

        btnListaAlunos = findViewById(R.id.btnListaAlunos);
        btnListaAlunos.setOnClickListener(view -> {
            Intent intent = new Intent(AlunosActivity.this, ListaAlunosActivity.class);
            intent.putExtra("BUNDLE", Alunos);
            startActivity(intent);
        });
    }
}