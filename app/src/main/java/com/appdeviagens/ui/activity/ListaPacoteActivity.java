package com.appdeviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appdeviagens.R;
import com.appdeviagens.dao.PacoteDao;
import com.appdeviagens.model.Pacote;
import com.appdeviagens.ui.adapter.ListaPacoteAdapter;

import java.util.List;

public class ListaPacoteActivity extends AppCompatActivity {

    public static final String TITULO_BAR = "Pacotes";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_BAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDao().lista();
listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes, this));
    }
}
