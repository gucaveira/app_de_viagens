package com.appdeviagens.ui.activity;

import android.content.Intent;
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

import static com.appdeviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicalizaCampos(pacote);
        }
    }

    private void inicalizaCampos(Pacote pacote) {
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarData(pacote);
        mostrarPreco(pacote);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        String periodoEmTexto = DataUtil.periodEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}
