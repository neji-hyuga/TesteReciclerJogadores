package br.com.testereciclerjogadores;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.testereciclerjogadores.interfaces.CriarJogadorListener;
import br.com.testereciclerjogadores.model.Jogador;


/**
 * A simple {@link Fragment} subclass.
 */
public class CriarJogadorFragment extends Fragment {

    private Button botaoCriar;
    private TextInputEditText nomeNovoJogador;
    private TextInputEditText clubeNovoJogador;
    CriarJogadorListener listener;


    public CriarJogadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_criar_jogador, container, false);

        botaoCriar = view.findViewById(R.id.criar_botao_id);
        nomeNovoJogador = view.findViewById(R.id.nome_novo_jogador_edit_text);
        clubeNovoJogador = view.findViewById(R.id.clube_novo_jogador_edit_text);

        botaoCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Jogador jogador = new Jogador();
                jogador.setNome(nomeNovoJogador.getEditableText().toString());
                jogador.setClube(clubeNovoJogador.getEditableText().toString());

                listener.criarJogadorNovo(jogador);




            }
        });


        return view;
    }

}
