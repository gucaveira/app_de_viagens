package com.appdeviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appdeviagens.R;
import com.appdeviagens.model.Pacote;
import com.appdeviagens.util.DataUtil;
import com.appdeviagens.util.DiasUtil;
import com.appdeviagens.util.MoedaUtil;
import com.appdeviagens.util.ResourceUtil;

import static com.appdeviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            incializaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this,
                PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void incializaCampos(Pacote pacote) {
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarDias(pacote);
        mostrarPreco(pacote);
        mostrarData(pacote);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormadadaViagem = DataUtil.periodEmTexto(pacote.getDias());
        data.setText(dataFormadadaViagem);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);

    }

    private void mostrarDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diaEmTextos = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diaEmTextos);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView image = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        image.setImageDrawable(drawableDoPacote);
    }

    private void mostrarLocal(Pacote pacoteSaoPaulo) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());
    }
}