package com.example.myapplication.ui.aluno;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ListaAlunosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AlunoAdapter adapter;
    private ArrayList<String> Alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lista de Alunos");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Alunos = extras.getStringArrayList("BUNDLE");
            setupList(Alunos);
        }
    }

    private void setupList(ArrayList<String> Alunos) {
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAlunos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlunoAdapter(Alunos);
        recyclerView.setAdapter(adapter);
    }
}