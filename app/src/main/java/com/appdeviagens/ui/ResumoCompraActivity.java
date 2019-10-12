package com.appdeviagens.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appdeviagens.R;
import com.appdeviagens.model.Pacote;
import com.appdeviagens.util.DataUtil;
import com.appdeviagens.util.MoedaUtil;
import com.appdeviagens.util.ResourceUtil;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String RESUMO_DA_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(RESUMO_DA_COMPRA);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarData(pacote);
        mostrarPreco(pacote);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String periodoEmTexto = DataUtil.periodEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
