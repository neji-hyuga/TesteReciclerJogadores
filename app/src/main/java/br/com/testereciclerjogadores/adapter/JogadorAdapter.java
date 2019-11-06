package br.com.testereciclerjogadores.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.testereciclerjogadores.R;
import br.com.testereciclerjogadores.interfaces.JogadorListener;
import br.com.testereciclerjogadores.model.Jogador;

public class JogadorAdapter extends RecyclerView.Adapter<JogadorAdapter.ViewHolder>{

    private List<Jogador> listaJogadores;
    private JogadorListener jogadorListener;

    public JogadorAdapter(List<Jogador> listaJogadores, JogadorListener jogadorListener) {
        this.listaJogadores = listaJogadores;
        this.jogadorListener = jogadorListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jogador_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Jogador jogador = listaJogadores.get(i);
        viewHolder.bindJogador(jogador);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadorListener.onJogadorClicado(jogador);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaJogadores.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImageView;
        private TextView nomeTextView;
        private TextView clubeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImageView = itemView.findViewById(R.id.foto_image_view);
            nomeTextView = itemView.findViewById(R.id.nome_text_view);
            clubeTextView = itemView.findViewById(R.id.clube_text_view);
        }

        public void bindJogador(Jogador jogador){
            nomeTextView.setText(jogador.getNome());
            clubeTextView.setText(jogador.getClube());
            Picasso.get().load(jogador.getFoto()).into(fotoImageView);
        }
    }
    }
