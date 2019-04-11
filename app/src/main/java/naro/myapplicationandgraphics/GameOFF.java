package naro.myapplicationandgraphics;

import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGInputManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;

public class GameOFF extends AGScene {

    AGSprite gameOFF;

    public GameOFF (AGGameManager gameManager){
        super(gameManager);

    }

    @Override
    public void init() {
    setSceneBackgroundColor(1,0,0);

    gameOFF = createSprite(R.mipmap.game_off,1,1);
    gameOFF.setScreenPercent(30,30);
    gameOFF.vrPosition.setY(AGScreenManager.iScreenHeight/2);
    gameOFF.vrPosition.setX(AGScreenManager.iScreenWidth/2);

    }



    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        if (AGInputManager.vrTouchEvents.screenClicked()){
            vrGameManager.setCurrentScene(1);

        }

    }
}
