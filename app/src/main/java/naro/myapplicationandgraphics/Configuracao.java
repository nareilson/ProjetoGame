package naro.myapplicationandgraphics;

import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGInputManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSoundManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;

public class Configuracao extends AGScene {

    AGSprite botao_musica;
    AGSprite botao_play_musica;
    AGSoundManager musica;
    AGSprite botao_sair;
    AGSprite engrenagem;

    boolean off;

    Configuracao(AGGameManager gameManager){
        super(gameManager);
    }


    @Override
    public void init() {


//        engrenagem = createSprite(R.mipmap.gear,1,1);
//        engrenagem.setScreenPercent(30,30);
//        engrenagem.vrPosition.setY(AGScreenManager.iScreenHeight*0.80f);
//        engrenagem.vrPosition.setX(AGScreenManager.iScreenWidth/2);


        botao_musica = createSprite(R.mipmap.play_button,1,1);
        botao_musica.setScreenPercent(30,15);
        botao_musica.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        botao_musica.vrPosition.setY(AGScreenManager.iScreenHeight*0.6f);
//        botao_musica.addAnimation(5,true,0,1);
//        botao_musica.addAnimation(5,true,2,3);

        botao_play_musica = createSprite(R.mipmap.play_musica,1,1);
        botao_play_musica.setScreenPercent(10,10);
        botao_play_musica.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        botao_play_musica.vrPosition.setY(AGScreenManager.iScreenHeight*0.4f);


        botao_sair = createSprite(R.mipmap.exit,1,1);
        botao_sair.setScreenPercent(10,10);
        botao_sair.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        botao_sair.vrPosition.setY(AGScreenManager.iScreenHeight*0.1f);



    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        if(botao_musica.collide(AGInputManager.vrTouchEvents.getLastPosition())){

            musica.vrMusic.pause();

        }
        if (botao_play_musica.collide(AGInputManager.vrTouchEvents.getLastPosition()))
            {

            musica.vrMusic.play();

        }
        if(botao_sair.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            vrGameManager.setCurrentScene(1);

        }



    }
}
