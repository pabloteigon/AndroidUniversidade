package com.example.myapplication.ui.professor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.ui.aluno.ListaAlunosActivity;

import java.util.ArrayList;

public class ProfessoresActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnCadastrarProfessor;
    private Button btnListaProfessores;
    private EditText etNomeProfessor;
    private ArrayList<String> Professores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);

        insereProfessoresNaLista();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Professores");

        etNomeProfessor = findViewById(R.id.etNomeProfessor);

        btnCadastrarProfessor = findViewById(R.id.btnCadastrarProfessor);
        btnCadastrarProfessor.setOnClickListener(view -> {
            //Pega o texto que foi digitado no EditText e atribue a uma variável
            String nome = etNomeProfessor.getText().toString();
            //Verifica se o texto não é vazio
            if (nome.length() == 0) {
                //Mostra mensagem do tipo Toast com mensagem de erro
                Toast.makeText(this, "Deu erro!", Toast.LENGTH_LONG).show();
            } else {
                //Adicionao o texto digitado na lista Alunos com o add
                Professores.add(nome);
                //Mostra mensagem do tipo Toast com mesagem de sucesso
                Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                //Limpa o EditText
                etNomeProfessor.setText("");
            }
        });

        btnListaProfessores = findViewById(R.id.btnListaProfessores);
        btnListaProfessores.setOnClickListener(view -> {
            Intent intent = new Intent(ProfessoresActivity.this, ListaProfessoresActivity.class);
            //Envia através da intent um argumento do tipo ArrayList
            intent.putExtra("BUNDLE", Professores);
            startActivity(intent);
        });
    }

    private void insereProfessoresNaLista() {
        // Criando alguns alunos
        Professores.add("Pedro");
        Professores.add("João");
        Professores.add("Bruna");
        Professores.add("Laura");
        Professores.add("Jorge");
    }
}