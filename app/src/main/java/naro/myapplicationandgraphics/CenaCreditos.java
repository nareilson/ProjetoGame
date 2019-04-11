package naro.myapplicationandgraphics;

import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGInputManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSoundManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;

public class CenaCreditos extends AGScene {

    AGSprite onca;
    AGSprite gato;
    int animacao = 0;
    int condigoSom = 0;

    public CenaCreditos(AGGameManager gameManager){
       super(gameManager);

   }

    @Override
    public void init() {

        condigoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav");

        setSceneBackgroundColor(1,0,0);
        onca = createSprite(R.mipmap.onca,2,4);
        onca.setScreenPercent(30,15);
        onca.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        onca.vrPosition.setY(AGScreenManager.iScreenHeight/2);
        onca.addAnimation(10,true,0,7);
        //Espelhando a imagem
        onca.iMirror=AGSprite.HORIZONTAL;
        //Transparecia da Sprite
        //onca.fAlpha = 0.3f;

        gato = createSprite(R.mipmap.gato,8,8);
        gato.setScreenPercent(30,15);
        gato.vrPosition.setX(AGScreenManager.iScreenWidth/3);
        gato.vrPosition.setY(AGScreenManager.iScreenHeight/3);
        gato.addAnimation(15,true,0,15);
        gato.addAnimation(10,true,16,28);
        gato.addAnimation(15,true,29,40);
        //Espelhando a imagem
        //gato.iMirror=AGSprite.HORIZONTAL;

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        //Teste de colisao
//        if(onca.collide(gato)){
//
//        }
        //fazer com que a Sprite gire em 360 graus
        onca.fAngle+= 0.5f;

        if (AGInputManager.vrTouchEvents.screenClicked()) {
           animacao ++;

           //Play no som de efeito
           AGSoundManager.vrSoundEffects.play(condigoSom);

           //Efetuar a troca das animacao na lista de animacao
           if (animacao > 2){
               animacao = 0;
           }
           gato.setCurrentAnimation(animacao);

        }

    }
}
