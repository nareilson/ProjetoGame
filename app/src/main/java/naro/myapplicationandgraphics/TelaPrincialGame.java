package naro.myapplicationandgraphics;

import naro.myapplicationandgraphics.AndGraph.AGGameManager;
import naro.myapplicationandgraphics.AndGraph.AGInputManager;
import naro.myapplicationandgraphics.AndGraph.AGScene;
import naro.myapplicationandgraphics.AndGraph.AGScreenManager;
import naro.myapplicationandgraphics.AndGraph.AGSoundManager;
import naro.myapplicationandgraphics.AndGraph.AGSprite;
import naro.myapplicationandgraphics.AndGraph.AGTimer;

public class TelaPrincialGame extends AGScene {

    AGSprite imagemFundo1;
    AGSprite imagemFundo2;
    AGSprite paredeFim;
    AGSprite paredeInicio;
    AGSprite obstaculo;
    AGSprite player;
    AGSprite placar;
    AGSprite hidranteFundo;
    AGSprite hidranteFundo1;
    AGSprite moedas;
    AGSprite painelUnidade;
    AGSprite painelDezena;
    AGSprite painelCentena;
    AGSprite sensorInvisivel_1= null;
    AGSprite sensorInvisivel_2= null;
    AGSprite sensorInvisivel_3= null;
    AGTimer tempo = null;
    AGTimer tempoPainel = null;

    boolean playnoAR = false;
    int animacao = 0;
    int animacaoPainelUnitario = 0;
    int animacaoPainelDezena = 0;
    int animacaoPainelCentena = 0;
    int condigoSom;
    int codigoSomGameOver;
    int codigoSomMoedas;
    int contadorMoeda;
    int contadorMoedas;
    int contadorObstaculo;
    int dificuldade = 10;
    float contadorParalaxImg1;
    float contadorParalaxImg2;



    public TelaPrincialGame(AGGameManager gameManager) {
        super(gameManager);
    }


    @Override
    public void init() {
        setSceneBackgroundColor(1,0,0);

        condigoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav");
        codigoSomGameOver = AGSoundManager.vrSoundEffects.loadSoundEffect("169685__beman87__impact-zap-1.wav");
        codigoSomMoedas = AGSoundManager.vrSoundEffects.loadSoundEffect("moedas_plop.mp3");
        tempo = new AGTimer(1000);
        tempoPainel = new AGTimer(100);
        contadorObstaculo = AGScreenManager.iScreenHeight;
        contadorMoedas = AGScreenManager.iScreenHeight/2;
        contadorParalaxImg1 = AGScreenManager.iScreenHeight/2;
        contadorParalaxImg2 = AGScreenManager.iScreenHeight*1.5f;



        imagemFundo1 = createSprite(R.mipmap.cenario_teste,1,1);
        imagemFundo1.setScreenPercent(100,100);
        imagemFundo1.vrPosition.setY(AGScreenManager.iScreenHeight/2);
        imagemFundo1.vrPosition.setX(AGScreenManager.iScreenWidth/2);

        imagemFundo2 = createSprite(R.mipmap.cenario_teste,1,1);
        imagemFundo2.setScreenPercent(100,100);
        imagemFundo2.vrPosition.setY(AGScreenManager.iScreenHeight*1.5f);
        imagemFundo2.vrPosition.setX(AGScreenManager.iScreenWidth/2);

        hidranteFundo = createSprite(R.mipmap.hidrante,8,4);
        hidranteFundo.setScreenPercent(20,20);
        hidranteFundo.vrPosition.setY(imagemFundo1.vrPosition.getY());
        hidranteFundo.vrPosition.setX(AGScreenManager.iScreenWidth*0.4f);
        hidranteFundo.addAnimation(10,true,1,29);
        hidranteFundo.fAngle=-90;

        hidranteFundo1 = createSprite(R.mipmap.hidrante,8,4);
        hidranteFundo1.setScreenPercent(20,20);
        hidranteFundo1.vrPosition.setY(imagemFundo2.vrPosition.getY());
        hidranteFundo1.vrPosition.setX(AGScreenManager.iScreenWidth*0.4f);
        hidranteFundo1.addAnimation(10,true,1,29);
        hidranteFundo1.fAngle=-90;

//        placar = createSprite(R.mipmap.numeros,19,15);
//        placar.setScreenPercent(10,10);
//        placar.vrPosition.setX(AGScreenManager.iScreenWidth*0.90f);
//        placar.vrPosition.setY(AGScreenManager.iScreenHeight*0.10f);
//        placar.addAnimation(5,true,1,98);
//        placar.fAngle = -90;

        painelUnidade = createSprite(R.mipmap.numero_dezeroanove,5,10);
        painelUnidade.setScreenPercent(10,10);
        painelUnidade.vrPosition.setX(AGScreenManager.iScreenWidth*0.90f);
        painelUnidade.vrPosition.setY(AGScreenManager.iScreenHeight*0.80f);
        painelUnidade.addAnimation(10,true,0,4);
        painelUnidade.addAnimation(10,true,5,9);
        painelUnidade.addAnimation(10,true,10,14);
        painelUnidade.addAnimation(10,true,15,19);
        painelUnidade.addAnimation(10,true,20,24);
        painelUnidade.addAnimation(10,true,25,29);
        painelUnidade.addAnimation(10,true,30,34);
        painelUnidade.addAnimation(10,true,35,39);
        painelUnidade.addAnimation(10,true,40,44);
        painelUnidade.addAnimation(10,true,45,49);
        painelUnidade.fAngle = -90;

        painelDezena = createSprite(R.mipmap.numero_dezeroanove,5,10);
        painelDezena.setScreenPercent(10,10);
        painelDezena.vrPosition.setX(AGScreenManager.iScreenWidth*0.90f);
        painelDezena.vrPosition.setY(AGScreenManager.iScreenHeight*0.85f);
        painelDezena.addAnimation(10,true,0,4);
        painelDezena.addAnimation(10,true,5,9);
        painelDezena.addAnimation(10,true,10,14);
        painelDezena.addAnimation(10,true,15,19);
        painelDezena.addAnimation(10,true,20,24);
        painelDezena.addAnimation(10,true,25,29);
        painelDezena.addAnimation(10,true,30,34);
        painelDezena.addAnimation(10,true,35,39);
        painelDezena.addAnimation(10,true,40,44);
        painelDezena.addAnimation(10,true,45,49);
        painelDezena.fAngle = -90;

        painelCentena = createSprite(R.mipmap.numero_dezeroanove,5,10);
        painelCentena.setScreenPercent(10,10);
        painelCentena.vrPosition.setX(AGScreenManager.iScreenWidth*0.90f);
        painelCentena.vrPosition.setY(AGScreenManager.iScreenHeight*0.90f);
        painelCentena.addAnimation(10,true,0,4);
        painelCentena.addAnimation(10,true,5,9);
        painelCentena.addAnimation(10,true,10,14);
        painelCentena.addAnimation(10,true,15,19);
        painelCentena.addAnimation(10,true,20,24);
        painelCentena.addAnimation(10,true,25,29);
        painelCentena.addAnimation(10,true,30,34);
        painelCentena.addAnimation(10,true,35,39);
        painelCentena.addAnimation(10,true,40,44);
        painelCentena.addAnimation(10,true,45,49);
        painelCentena.fAngle = -90;



        paredeFim = createSprite(R.mipmap.objto_invisivel,1,1);
        paredeFim.setScreenPercent(10,10);
        paredeFim.vrPosition.setX(AGScreenManager.iScreenWidth * 0.05f);
        paredeFim.vrPosition.setY(10f);

        paredeInicio = createSprite(R.mipmap.objto_invisivel,1,1);
        paredeInicio.setScreenPercent(10,10);
        paredeInicio.vrPosition.setX(AGScreenManager.iScreenWidth * 0.05f);
        paredeInicio.vrPosition.setY(AGScreenManager.iScreenHeight);

        obstaculo = createSprite(R.mipmap.bloco_tijolo,1,1);
        obstaculo.setScreenPercent(10,5);
        obstaculo.vrPosition.setX(AGScreenManager.iScreenWidth * 0.05f);
        obstaculo.vrPosition.setY(AGScreenManager.iScreenHeight);
        obstaculo.fAngle = -90;

        moedas = createSprite(R.mipmap.moedas_bonus,16,1);
        moedas.setScreenPercent(5,5);
        moedas.vrPosition.setY(AGScreenManager.iScreenHeight/2);
        moedas.vrPosition.setX(AGScreenManager.iScreenWidth*0.05f);
        moedas.addAnimation(10,true,0,15);
        moedas.fAngle = -90;

        player = createSprite(R.mipmap.personagem_png_lol,8,8);
        player.setScreenPercent(14,10);
        player.vrPosition.setX( AGScreenManager.iScreenWidth * 0.10f);
        player.vrPosition.setY(AGScreenManager.iScreenHeight/8);
        player.addAnimation(10,true,0,27);
        player.addAnimation(5,true,48,53);
        player.fAngle = -90;


        sensorInvisivel_1 = createSprite(R.mipmap.objto_invisivel,1,1);
        sensorInvisivel_1.setScreenPercent(10,10);
        sensorInvisivel_1.vrPosition.setX((AGScreenManager.iScreenWidth * 0.10f)+500 );
        sensorInvisivel_1.vrPosition.setY(AGScreenManager.iScreenHeight/8);

        sensorInvisivel_2 = createSprite(R.mipmap.objto_invisivel,1,1);
        sensorInvisivel_2.setScreenPercent(2,10);
        sensorInvisivel_2.vrPosition.setX(AGScreenManager.iScreenWidth *0.10f);
        sensorInvisivel_2.vrPosition.setY(AGScreenManager.iScreenHeight/8);

        sensorInvisivel_3 = createSprite(R.mipmap.objto_invisivel,1,1);
        sensorInvisivel_3.setScreenPercent(2,10);
        sensorInvisivel_3.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        sensorInvisivel_3.vrPosition.setY(AGScreenManager.iScreenHeight/2);

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        tempoPainel.update();
        tempo.update();

        if(tempoPainel.isTimeEnded()){
            tempoPainel.restart();
            animacaoPainelUnitario++;
            painelUnidade.setCurrentAnimation(animacaoPainelUnitario);
            if(animacaoPainelUnitario>9){
                animacaoPainelDezena++;
                painelDezena.setCurrentAnimation(animacaoPainelDezena);
                animacaoPainelUnitario = 0;

                if(animacaoPainelDezena>9) {
                    animacaoPainelCentena++;
                    painelCentena.setCurrentAnimation(animacaoPainelCentena);
                    animacaoPainelDezena=0;

                    if(animacaoPainelCentena>9){
                        animacaoPainelCentena = 0;

                    }
                }
                }

            }

//            if(contadorMoeda>10){
//            dificuldade++;
//            }
        //controle de velocidade do cenario e dos obtaculos tornando mais dificil o jogo
//        if(tempo.isTimeEnded()){
//            dificuldade++;
//            tempo.restart();
//        }



        obstaculo.vrPosition.setY(contadorObstaculo-=dificuldade);
        moedas.vrPosition.setY(contadorMoedas-=dificuldade);


        //Sisitema de Parallax

        imagemFundo1.vrPosition.setY(contadorParalaxImg1-=dificuldade);
        imagemFundo2.vrPosition.setY(contadorParalaxImg2-=dificuldade);
        hidranteFundo.vrPosition.setY(imagemFundo1.vrPosition.getY());
        hidranteFundo1.vrPosition.setY(imagemFundo2.vrPosition.getY());

        if (imagemFundo1.vrPosition.getY() <= -AGScreenManager.iScreenHeight/2){
            imagemFundo1.vrPosition.setY(AGScreenManager.iScreenHeight*1.5f);
            contadorParalaxImg1 = AGScreenManager.iScreenHeight*1.5f;
        }
        if (imagemFundo2.vrPosition.getY() <= -AGScreenManager.iScreenHeight/2){
            imagemFundo2.vrPosition.setY(AGScreenManager.iScreenHeight*1.5f);
            contadorParalaxImg2 = AGScreenManager.iScreenHeight*1.5f;
        }




        ///

        if(obstaculo.collide(paredeInicio)){
            obstaculo.bVisible = true;

        }

        if(moedas.collide(paredeInicio)){
            moedas.bVisible = true;
        }

        if(obstaculo.collide(paredeFim)){
            obstaculo.bVisible = false;
            obstaculo.vrPosition.setY(AGScreenManager.iScreenHeight);
            contadorObstaculo = AGScreenManager.iScreenHeight;
        }
        if(moedas.collide(paredeFim)){
            moedas.bVisible = false;
            moedas.vrPosition.setY(AGScreenManager.iScreenHeight);
            contadorMoedas = AGScreenManager.iScreenHeight;

        }

       if(AGInputManager.vrTouchEvents.screenClicked() && playnoAR == false){

            AGSoundManager.vrSoundEffects.play(condigoSom);
            animacao++;
            player.setCurrentAnimation(animacao);
            player.moveTo(500,player.vrPosition.getX()+500,player.vrPosition.getY());

        }


        if(player.collide(sensorInvisivel_1) && AGInputManager.vrTouchEvents.screenDragged()){
            playnoAR = true;
            player.moveTo(1000,player.vrPosition.getX()-300,player.vrPosition.getY());
        } else


        if (player.collide(sensorInvisivel_1)){
                playnoAR = true;
                player.moveTo(1000,player.vrPosition.getX()-400,player.vrPosition.getY());

            }


            if (player.collide(sensorInvisivel_2)){
                animacao=0;
                player.setCurrentAnimation(animacao);
            playnoAR = false;
            }

            if (player.collide(obstaculo)){
                AGSoundManager.vrSoundEffects.play(codigoSomGameOver);
            vrGameManager.setCurrentScene(4);
            }

//            if(player.collide(moedas)){
//            moedas.bVisible = false;
//                AGSoundManager.vrSoundEffects.play(codigoSomMoedas);
//            }


    }
}
