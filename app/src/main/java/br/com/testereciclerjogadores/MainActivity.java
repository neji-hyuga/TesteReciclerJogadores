package br.com.testereciclerjogadores;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.testereciclerjogadores.adapter.JogadorAdapter;
import br.com.testereciclerjogadores.interfaces.CriarJogadorListener;
import br.com.testereciclerjogadores.interfaces.JogadorListener;
import br.com.testereciclerjogadores.model.Jogador;

public class MainActivity extends AppCompatActivity implements JogadorListener, CriarJogadorListener {

    private CriarJogadorFragment fragment;
    private JogadorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                fragment = new CriarJogadorFragment();
                transaction.add(R.id.container_id,fragment);
                transaction.commit();
            }
        });


        List<Jogador> listaJogador = new ArrayList<>();
        Jogador jogador1 = new Jogador();
        jogador1.setNome("Pablo Aimar");
        jogador1.setClube("River Plate");
        jogador1.setFoto("https://p2.trrsf.com/image/fget/cf/460/0/images.terra.com/2015/07/15/aimar-river-foto-divulgacaolanima2015062402221.jpg");
        listaJogador.add(jogador1);

        Jogador jogador2 = new Jogador();
        jogador2.setNome("Juan Riquelme");
        jogador2.setClube("Boca Juniors");
        jogador2.setFoto("https://www.gazetaesportiva.com/wp-content/uploads/imagem/2016/12/31/riquelme.jpg");
        listaJogador.add(jogador2);

        Jogador jogador3 = new Jogador();
        jogador3.setNome("Diego Milito");
        jogador3.setClube("C.A Racing");
        jogador3.setFoto("https://cdn.foxsports.com.br/sites/foxsports-br/files/img/scaled/630x/notes/materia/racing-milito-comemora-640x480-getty.jpg");
        listaJogador.add(jogador3);

        Jogador jogador4 = new Jogador();
        jogador4.setNome("Kun Aguero");
        jogador4.setClube("Independiente");
        jogador4.setFoto("https://trivela.com.br/wp-content/uploads/2015/12/kun.jpg");
        listaJogador.add(jogador4);

        Jogador jogador5 = new Jogador();
        jogador5.setNome("Diego Forlán");
        jogador5.setClube("Peñarol");
        jogador5.setFoto("https://imagenes.montevideo.com.uy/imgnoticias/201508/_W933_80/516468.jpg");
        listaJogador.add(jogador5);

        listaJogador.add(jogador5);
        listaJogador.add(jogador4);
        listaJogador.add(jogador3);
        listaJogador.add(jogador2);
        listaJogador.add(jogador1);
        listaJogador.add(jogador5);

        JogadorAdapter jogadorAdapter = new JogadorAdapter(listaJogador, this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        RecyclerView recyclerView = findViewById(R.id.jogador_recycler_view);
        recyclerView.setAdapter(jogadorAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onJogadorClicado(Jogador jogador) {
        Intent intent = new Intent(this, JogadorDetalheActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("JOGADOR", jogador);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void criarJogadorNovo(Jogador jogador) {

    }
}
