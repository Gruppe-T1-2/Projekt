package com.example.scoregui;

import com.example.scoregui.BTNS.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class IntroSceneGUI extends Application {
    Background intro;
    Image background1;
    redBtnEvent redBTN;
    redBtnEvent2 redBTN2;
    redBtnEvent3 redBTN3;
    redBtnEvent4 redBTN4;
    GoBackBTNEvent goBackBTN;
    LeftArrowBTNEvent LeftArrowBTN;
    RightArrowBTNEvent RightArrowBTN;
    EndGameBTN endGameBTN;
    String background1Path = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/butik.jpg";
    String background2Path = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/netto.png";
    String background3Path = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/Slikafdeling.png";
    String candyshelf = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/slikreol.png";

    String BTNPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/BTN.png";
    String fryserPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/fryser.jpg";
    String BackArrowPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/redarrow.png";
    String ChickenPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/chicken.png";
    String OkseMeatPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/oksemeat.png";
    String NakkeFiletPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/nakkefilet.png";
    String LammeMeatPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/lammemeat.png";
    String ShelfPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/shelf.png";
    String AppleTrayPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/AppleTray.png";
    String OrganicApplePath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/OrganicApples.png";
    String BananaPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/Banana.png";
    String OrangePath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/Oranges.png";
    String LeftArrowPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/arrow.png";
    String coolerPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/cooler.png";
    String MælkPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/letmælk.png";
    String OstPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/ost.png";
    String OatlyPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/oatly.png";
    String MandelDrikPath="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/mandeldrik.png";
    String HytteOstPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/hytteost.png";
    String checkOutPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/kasse.png";

    String EndGameBTNPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/endgamebtn.png";
    String LastBackground = background1Path;
    Image NakkeImg;
    ImageView NakkeView;
    Image OkseImg;
    ImageView OkseView;
    StackPane root;
    ItemBTN ChickenBTN;
    ItemBTN NakkeBTN;
    ItemBTN OkseBTN;
    ItemBTN LamBTN;
    ItemBTN AppleTrayBTN;
    ItemBTN OrganicAppleBTN;
    ItemBTN OrangeBTN;
    ItemBTN  BananaBTN;
    ItemBTN    OstBTN;
    ItemBTN OatlyBTN;
    ItemBTN HytteOstBTN;
    ItemBTN  MandelDrikBTN;
    ItemBTN MælkBTN ;
    Scene scene;
    boolean freezer, cooler, shelf;
     int sceneWidth = 1500;
     int sceneHeight = 919;

    @Override
    public void start(Stage stage) throws Exception {
        root = new StackPane();
        InitScene();

        scene = new Scene(root,sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.show();


    }
    public void InitScene(){
        LastBackground = background1Path;
        //Click event on red button Scene swap
        redBTN = new redBtnEvent(BTNPath);
        redBTN2 = new redBtnEvent2(BTNPath);
        goBackBTN = new GoBackBTNEvent(BackArrowPath);
        LeftArrowBTN = new LeftArrowBTNEvent(LeftArrowPath);
        //setter baggrund
        root.getChildren().addAll(redBTN,redBTN2, LeftArrowBTN);

        setBackgroundImage(background1Path);

        redBTN.setOnAction(event -> {
            backgroundSwap(fryserPath);
            initfreezer();
            freezer=true;
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);



        });
        redBTN2.setOnAction(event -> {
            backgroundSwap(ShelfPath);
            initShelf();
            shelf=true;
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);

        });
        goBackBTN.setOnAction(actionEvent -> {
            // Go back arrow to main scene
            backgroundSwap(LastBackground);
            if(LastBackground.equals(background1Path)){
                root.getChildren().remove(goBackBTN);
                root.getChildren().addAll(redBTN,redBTN2,LeftArrowBTN);
                if(shelf){
                    RemoveGreenItems();
                    shelf=false;
                }
                if(freezer){
                    RemoveFreezerItems();
                    freezer=false;
                }

            } else if (LastBackground.equals(background2Path)) {
                root.getChildren().remove(goBackBTN);
                if(cooler){
                    RemoveCoolerItems();
                    cooler=false;
                }
                InitScene2();

            }else if(LastBackground.equals(background3Path)){
                root.getChildren().remove(goBackBTN);
                RemoveCandyShelfItems();
                InitScene3();

            }

        });
        //Swap to second Scene
        LeftArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background2Path);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);
            InitScene2();
        });

    }

    public void InitScene2(){
        LastBackground = background2Path;
        redBTN3 = new redBtnEvent3(BTNPath);
        RightArrowBTN = new RightArrowBTNEvent(LeftArrowPath);
        root.getChildren().addAll(RightArrowBTN, redBTN3, LeftArrowBTN);

        RightArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background1Path);
            root.getChildren().removeAll(RightArrowBTN, redBTN3);
            InitScene();
        });
        redBTN3.setOnAction(actionEvent -> {
            backgroundSwap(coolerPath);
            root.getChildren().removeAll(redBTN3, RightArrowBTN, LeftArrowBTN);
            root.getChildren().addAll(goBackBTN);
            cooler=true;
            initCooler();


        });
        //Swapping to Scene 3
        LeftArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background3Path);
            root.getChildren().removeAll(redBTN3, RightArrowBTN, LeftArrowBTN);
            InitScene3();
        });

    }
    public void InitScene3(){
        LastBackground = background3Path;
        redBTN4 = new redBtnEvent4(BTNPath);
        root.getChildren().addAll(redBTN4,RightArrowBTN, LeftArrowBTN);

        RightArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background2Path);
            root.getChildren().removeAll(redBTN4,RightArrowBTN);
            InitScene2();
        });
        redBTN4.setOnAction(actionEvent -> {
            backgroundSwap(candyshelf);
            initCandyShelf();
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN4, LeftArrowBTN, RightArrowBTN);
        });
        LeftArrowBTN.setOnAction(actionEvent -> {
        root.getChildren().removeAll(redBTN4,RightArrowBTN);
        initCheckout();
            });

    }
    public void initCheckout(){
        backgroundSwap(checkOutPath);
        endGameBTN = new EndGameBTN(EndGameBTNPath);
        root.getChildren().addAll(endGameBTN,RightArrowBTN);
        root.getChildren().remove(LeftArrowBTN);
        RightArrowBTN.setOnAction(actionEvent -> {
            root.getChildren().removeAll(endGameBTN, RightArrowBTN);
            InitScene3();
            backgroundSwap(background3Path);

        });
        endGameBTN.setOnAction(actionEvent -> {
            endGame();

        });


    }
    public static void main(String[] args) {
        launch(args);
    }
    public void backgroundSwap(String ImagePath){
        setBackgroundImage(ImagePath);
    }

    public void setBackgroundImage(String imagePath) {
        Image background = new Image("file:" + imagePath);
        BackgroundImage bgImg = new BackgroundImage(background, null, null, null, null);
        Background bg = new Background(bgImg);
        root.setBackground(bg);
    }
    public void initfreezer(){
        ChickenBTN = new ItemBTN("Kylling", root, ChickenPath);
        NakkeBTN = new ItemBTN("Nakkefilet", root, NakkeFiletPath);
        OkseBTN = new ItemBTN("Oksekød", root, OkseMeatPath);
        LamBTN = new ItemBTN("Lammekød", root, LammeMeatPath);

    }
    public void initShelf(){
        AppleTrayBTN = new ItemBTN("AppleTray", root, AppleTrayPath);
        OrganicAppleBTN = new ItemBTN("OrganicApple", root, OrganicApplePath);
        OrangeBTN = new ItemBTN("Orange", root, OrangePath);
        BananaBTN = new ItemBTN("Banana", root, BananaPath);
    }
    public void initCooler(){
        OstBTN = new ItemBTN("Ost", root, OstPath);
        OatlyBTN = new ItemBTN("Oatly", root, OatlyPath);
        HytteOstBTN = new ItemBTN("HytteOst", root, HytteOstPath);
        MandelDrikBTN = new ItemBTN("MandelDrik", root, MandelDrikPath);
        MælkBTN = new ItemBTN("Mælk", root, MælkPath);
    }
    public void initCandyShelf(){

    }
    public void removeCandyItems(){

    }
    public void RemoveCoolerItems(){
        OstBTN.RemoveBTN(root);
        OatlyBTN.RemoveBTN(root);
        HytteOstBTN.RemoveBTN(root);
        MandelDrikBTN.RemoveBTN(root);
        MælkBTN.RemoveBTN(root);

    }
    public void RemoveFreezerItems() {
        ChickenBTN.RemoveBTN(root);
        NakkeBTN.RemoveBTN(root);
        OkseBTN.RemoveBTN(root);
        LamBTN.RemoveBTN(root);

    }
    public void RemoveGreenItems() {
        AppleTrayBTN.RemoveBTN(root);
        OrganicAppleBTN.RemoveBTN(root);
        OrangeBTN.RemoveBTN(root);
        BananaBTN.RemoveBTN(root);
    }
    public void RemoveCandyShelfItems(){

    }
    public void endGame(){
        ScoreGFX scoreShow = new ScoreGFX();
        scoreShow.showScore(root);
    }
    public void ReSize(ImageView Image){
        Image.setFitHeight(200);
        Image.setFitWidth(200);
    }


}
