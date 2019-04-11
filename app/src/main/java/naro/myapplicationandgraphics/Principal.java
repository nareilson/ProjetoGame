package naro.myapplicationandgraphics;

import android.os.Bundle;

import naro.myapplicationandgraphics.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {

    CenaAbertura abertura;
    CenaMenu menu;
    CenaCreditos creditos;
    TelaPrincialGame gamePrincipal;
    GameOFF gameOff;
    Configuracao configuracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Inicializando o motor Grafico ()

        init(this, false);
        abertura = new CenaAbertura(getGameManager());
        menu = new CenaMenu(getGameManager());
        creditos = new CenaCreditos(getGameManager());
        gamePrincipal = new TelaPrincialGame(getGameManager());
        gameOff = new GameOFF(getGameManager());
        configuracao = new Configuracao(getGameManager());


        //Ordem da Lista de cenas, a lista incia do indice 0 sendo pocionadas de acordo com suas insercao
        getGameManager().addScene(abertura);
        getGameManager().addScene(menu);
        getGameManager().addScene(creditos);
        getGameManager().addScene(gamePrincipal);
        getGameManager().addScene(gameOff);
        getGameManager().addScene(configuracao);


    }
}
