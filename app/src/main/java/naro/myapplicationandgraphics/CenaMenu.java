package naro.myapplicationandgraphics;

import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGInputManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;

public class CenaMenu extends AGScene {

    AGSprite play = null;
    AGSprite config = null;
    AGSprite exit = null;
    AGSprite logo = null;
    boolean Scalando = false;

    public CenaMenu (AGGameManager gameManager){

        super(gameManager);

    }

    @Override
    public void init() {

        play = createSprite(R.mipmap.play_button,1,1);
        config = createSprite(R.mipmap.gear,1,1);
        exit = createSprite(R.mipmap.exit,1,1);
        logo = createSprite(R.mipmap.logo_qualquer,1,1);

        play.setScreenPercent(30,15);
        config.setScreenPercent(30,15);
        exit.setScreenPercent(30,15);
        logo.setScreenPercent(40,15);

        logo.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        logo.vrPosition.setY(AGScreenManager.iScreenHeight/1.2f);
        play.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        play.vrPosition.setY(AGScreenManager.iScreenHeight/2);
        config.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        config.vrPosition.setY(AGScreenManager.iScreenHeight/3);
        exit.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        exit.vrPosition.setY(AGScreenManager.iScreenHeight/6);

        setSceneBackgroundColor(0,1,0);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop()
    {
        //Testar se um evento de click na tela ocorreu para ir para a proxima tela

        if(AGInputManager.vrTouchEvents.screenClicked()){

            if (play.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                //Quando uma tela e chamdo motor destroi a tela anterior
                //por isso se usa o return, para que ele possa voltar a tela anterior
                vrGameManager.setCurrentScene(3);
                return;
            }
            if (config.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.setCurrentScene(5);
                return;
            }
        }
        if (exit.collide(AGInputManager.vrTouchEvents.getLastPosition())){
            vrGameManager.vrActivity.finish();
        }

//        if(Scalax < 2 && Scalay < 2 && Scalando == true){
//            Scalax+=1;
//            Scalay+=1;
//            if(Scalay == 2 && Scalax == 2){
//                Scalando = false;
//            }
//
//        } else if(Scalax>= 1 && Scalay >=1 && Scalando == false){
//
//            if(Scalay == 1 && Scalax == 1){
//                Scalando = true;
//            }
//            Scalay-=1;
//            Scalax-=1;
//        }

    }
}
