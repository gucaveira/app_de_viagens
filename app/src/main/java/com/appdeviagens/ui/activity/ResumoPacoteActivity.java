package com.appdeviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import java.math.BigDecimal;

class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "São Paulo", 2,
                new BigDecimal("243.99"));
        mostrarLocol(pacote);
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

    private void mostrarLocol(Pacote pacoteSaoPaulo) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());
    }
}