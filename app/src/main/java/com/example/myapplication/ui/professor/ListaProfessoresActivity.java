package com.example.myapplication.ui.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.ui.aluno.AlunoAdapter;

import java.util.ArrayList;

public class ListaProfessoresActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ProfessorAdapter adapter;
    private ArrayList<String> Professores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_professores);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lista de Professores");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Professores = extras.getStringArrayList("BUNDLE");
            setupList(Professores);
        }
    }

    private void setupList(ArrayList<String> Alunos) {
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvProfessores);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProfessorAdapter(Alunos);
        recyclerView.setAdapter(adapter);
    }
}