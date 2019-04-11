package naro.myapplicationandgraphics;


import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSoundManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;
import naro.myapplicationandgraphics.AndGraph.AGTimer;


//Calsse que Representa um cena ou contexto da aplicacao
public class CenaAbertura extends AGScene
{

    AGTimer tempo = null;
    AGSprite pacFantasma = null;

    //Contrutor da classe que recebe como parametro um agente
    public CenaAbertura(AGGameManager gameManager)
    {
        super(gameManager);
    }

    
    @Override
    public void init() 
    {
        tempo = new AGTimer(3000);

        //Carrgando som
        AGSoundManager.vrMusic.loadMusic("musica.mp3",true);
        AGSoundManager.vrMusic.play();

        //Parametros 1 caminho da imagaem, N. de colunas, N. de Linhas
        pacFantasma = createSprite(R.mipmap.pacman,1,1);
        //Dimecionando a a imagem de acordo com o tamanho da tela por porcentagem
        pacFantasma.setScreenPercent(40,30);
        //Poscionando a imagem no centro da tela
        pacFantasma.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        pacFantasma.vrPosition.setY(AGScreenManager.iScreenHeight/2);
     //Chamado toda vez que a cena for ativada... sempre que a cena for exibida  
        
        setSceneBackgroundColor(1,1,0);
    }

    @Override
    public void restart() 
    {
        //Chamado apos o retorno de um interrupcao

    }

    @Override
    public void stop() 
    {
        //Chamado quando um interrupção ocorrer

    }

    @Override
    public void loop() 
    {
        //Atualizando o obejto tempo
        tempo.update();

        //testar o tempo
        if (tempo.isTimeEnded())
        {
            //chamar a proxima cena, nesse caso a cena Menu
            vrGameManager.setCurrentScene(1);

        }
        //Chamado N vezes por segundo (onDrawFrame)

    }
}

