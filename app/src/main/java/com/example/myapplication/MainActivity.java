package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.ui.aluno.AlunosActivity;
import com.example.myapplication.ui.professor.ProfessoresActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAlunos;
    private Button btnProfessores;
    private Button btnCursos;
    private Button btnMaterias;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Main");

        btnAlunos = findViewById(R.id.btnAlunos);
        btnAlunos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AlunosActivity.class);
            startActivity(intent);
        });

        btnProfessores = findViewById(R.id.btnProfessores);
        btnProfessores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProfessoresActivity.class);
            startActivity(intent);
        });

        btnCursos = findViewById(R.id.btnCursos);
        btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CursosActivity.class);
                startActivity(intent);
            }
        });

        btnMaterias = findViewById(R.id.btnMaterias);
        btnMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MateriasActivity.class);
                startActivity(intent);
            }
        });

    }
}