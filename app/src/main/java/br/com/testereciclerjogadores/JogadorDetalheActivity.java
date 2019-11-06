package br.com.testereciclerjogadores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.testereciclerjogadores.model.Jogador;

public class JogadorDetalheActivity extends AppCompatActivity {

    private ImageView fotoImageView;
    private TextView clubeTextView;
    private TextView nomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador_detalhe);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Jogador jogador = (Jogador) bundle.getSerializable("JOGADOR");

        fotoImageView = findViewById(R.id.foto_jogador_image_view);
        clubeTextView = findViewById(R.id.clube_jogador_text_view);
        nomeTextView = findViewById(R.id.nome_jogador_text_view);

        Picasso.get().load(jogador.getFoto()).into(fotoImageView);
        nomeTextView.setText("NOME: " + jogador.getNome());
        clubeTextView.setText("CLUBE: " + jogador.getClube());









    }


}
