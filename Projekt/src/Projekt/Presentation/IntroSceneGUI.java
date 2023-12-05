package Projekt.Presentation;

import Projekt.BTNS.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class IntroSceneGUI{
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
    String background1Path = "src\\Projekt\\Presentation\\images\\butik.jpg";
    String background2Path = "src\\Projekt\\Presentation\\images\\netto.png";
    String background3Path = "src\\Projekt\\Presentation\\images\\Slikafdeling.png";
    String candyshelf = "src\\Projekt\\Presentation\\images\\slikreol.png";

    String BTNPath = "src\\Projekt\\Presentation\\images\\BTN.png";
    String fryserPath ="src\\Projekt\\Presentation\\images\\fryser.jpg";
    String BackArrowPath = "src\\Projekt\\Presentation\\images\\redarrow.png";
    String ChickenPath = "src\\Projekt\\Presentation\\images\\chicken.png";
    String OkseMeatPath = "src\\Projekt\\Presentation\\images\\oksemeat.png";
    String NakkeFiletPath = "src\\Projekt\\Presentation\\images\\nakkefilet.png";
    String LammeMeatPath = "src\\Projekt\\Presentation\\images\\lammemeat.png";
    String ShelfPath = "src\\Projekt\\Presentation\\images\\shelf.png";
    String AppleTrayPath = "src\\Projekt\\Presentation\\images\\AppleTray.png";
    String OrganicApplePath = "src\\Projekt\\Presentation\\images\\OrganicApples.png";
    String BananaPath = "src\\Projekt\\Presentation\\images\\Banana.png";
    String OrangePath = "src\\Projekt\\Presentation\\images\\Oranges.png";
    String LeftArrowPath = "src\\Projekt\\Presentation\\images\\arrow.png";
    String coolerPath ="src\\Projekt\\Presentation\\images\\cooler.png";
    String MælkPath ="src\\Projekt\\Presentation\\images\\letmælk.png";
    String OstPath ="src\\Projekt\\Presentation\\images\\ost.png";
    String OatlyPath ="src\\Projekt\\Presentation\\images\\oatly.png";
    String MandelDrikPath="src\\Projekt\\Presentation\\images\\mandeldrik.png";
    String HytteOstPath ="src\\Projekt\\Presentation\\images\\hytteost.png";
    String checkOutPath = "src\\Projekt\\Presentation\\images\\kasse.png";
    String slikPoseBTNPath = "src\\Projekt\\Presentation\\images\\slikpose.png";
    String milkaBTNPath = "src\\Projekt\\Presentation\\images\\milka.png";
    String marabouBTNPath = "src\\Projekt\\Presentation\\images\\marabou.png";

    String EndGameBTNPath = "src\\Projekt\\Presentation\\images\\endgamebtn.png";
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
    ItemBTN slikPoseBTN;
    ItemBTN milkaBTN;
    ItemBTN marabouBTN;
    boolean freezer, cooler, shelf;
    int sceneWidth = 1500;
    int sceneHeight = 919;


    public void InitSpaceGFX(StackPane pane, Scene scene, Stage primaryStage) throws Exception {
        root = pane;
        InitScene();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void InitScene() throws FileNotFoundException {
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
            try {
                initfreezer();
            } catch (FileNotFoundException e) {
                System.out.println("initFreezer error");
            }
            freezer=true;
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);



        });
        redBTN2.setOnAction(event -> {
            backgroundSwap(ShelfPath);
            try {
                initShelf();
            } catch (FileNotFoundException e) {
                System.out.println("initShelf error");
            }
            shelf=true;
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);

        });
        goBackBTN.setOnAction(actionEvent -> {
            goBack(LastBackground);

        });
        //Swap to second Scene
        LeftArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background2Path);
            root.getChildren().removeAll(redBTN,redBTN2,LeftArrowBTN);
            try {
                InitScene2();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void InitScene2() throws FileNotFoundException {
        LastBackground = background2Path;
        redBTN3 = new redBtnEvent3(BTNPath);
        RightArrowBTN = new RightArrowBTNEvent(LeftArrowPath);
        root.getChildren().addAll(RightArrowBTN, redBTN3, LeftArrowBTN);

        RightArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background1Path);
            root.getChildren().removeAll(RightArrowBTN, LeftArrowBTN, redBTN3);
            try {
                InitScene();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        redBTN3.setOnAction(actionEvent -> {
            backgroundSwap(coolerPath);
            root.getChildren().removeAll(redBTN3, RightArrowBTN, LeftArrowBTN);
            root.getChildren().addAll(goBackBTN);
            cooler=true;
            try {
                initCooler();
            } catch (Exception e) {
                System.out.println("initCooler error");
            }


        });
        //Swapping to Scene 3
        LeftArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background3Path);
            root.getChildren().removeAll(redBTN3, RightArrowBTN, LeftArrowBTN);
            try {
                InitScene3();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void InitScene3() throws FileNotFoundException {
        LastBackground = background3Path;
        redBTN4 = new redBtnEvent4(BTNPath);
        root.getChildren().addAll(redBTN4,RightArrowBTN, LeftArrowBTN);

        RightArrowBTN.setOnAction(actionEvent -> {
            backgroundSwap(background2Path);
            root.getChildren().removeAll(redBTN4,RightArrowBTN, LeftArrowBTN);
            try {
                InitScene2();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        redBTN4.setOnAction(actionEvent -> {
            backgroundSwap(candyshelf);
            initCandyShelf();
            root.getChildren().add(goBackBTN);
            root.getChildren().removeAll(redBTN4, LeftArrowBTN, RightArrowBTN);
        });
        LeftArrowBTN.setOnAction(actionEvent -> {
        root.getChildren().removeAll(redBTN4,RightArrowBTN);
            try {
                initCheckout();
            } catch (FileNotFoundException e) {
                System.out.println("InitCheckoutNotWorking");
            }
        });

    }
    public void initCheckout() throws FileNotFoundException {
        backgroundSwap(checkOutPath);
        endGameBTN = new EndGameBTN(EndGameBTNPath);
        root.getChildren().addAll(endGameBTN,RightArrowBTN);
        root.getChildren().remove(LeftArrowBTN);
        RightArrowBTN.setOnAction(actionEvent -> {
            root.getChildren().removeAll(endGameBTN, RightArrowBTN);
            try {
                InitScene3();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            backgroundSwap(background3Path);

        });
        endGameBTN.setOnAction(actionEvent -> {
            endGame();

        });


    }
    public void backgroundSwap(String ImagePath){
        try {
            setBackgroundImage(ImagePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBackgroundImage(String imagePath) throws FileNotFoundException {
        Image background = new Image(new FileInputStream(imagePath));
        BackgroundImage bgImg = new BackgroundImage(background, null, null, null, null);
        Background bg = new Background(bgImg);
        root.setBackground(bg);
    }
    public void initfreezer() throws FileNotFoundException {
        ChickenBTN = new ItemBTN("Kylling", root, ChickenPath, "Kød","500g ferskkylling, Salling");
        NakkeBTN = new ItemBTN("Nakkefilet", root, NakkeFiletPath, "Kød","500g svinekød, Slagteren");
        OkseBTN = new ItemBTN("Oksekød", root, OkseMeatPath, "Kød","500g oksekød, Salling");
        LamBTN = new ItemBTN("Lammekød", root, LammeMeatPath, "Kød","500g lammekød, Ludvig");

    }
    public void initShelf() throws FileNotFoundException {
        AppleTrayBTN = new ItemBTN("AppleTray", root, AppleTrayPath,"Frugt og grønt","Æbler, Sweetango, 8stk");
        OrganicAppleBTN = new ItemBTN("OrganicApple", root, OrganicApplePath,"Frugt og grønt","Æbler i bakke, 6stk");
        OrangeBTN = new ItemBTN("Orange", root, OrangePath,"Frugt og grønt","Appelsiner, Salling, 6stk");
        BananaBTN = new ItemBTN("Banana", root, BananaPath,"Frugt og grønt","Bananer, 6pak, ØKO");
    }
    public void initCooler() throws FileNotFoundException {
        OstBTN = new ItemBTN("Ost", root, OstPath,"Mejeriprodukter","Gul ost, Arla");
        OatlyBTN = new ItemBTN("Oatly", root, OatlyPath,"Mejeriprodukter","1L havremælk, Oatly");
        HytteOstBTN = new ItemBTN("HytteOst", root, HytteOstPath,"Mejeriprodukter","Gul, fedtfattig ost, Arla");
        MandelDrikBTN = new ItemBTN("MandelDrik", root, MandelDrikPath,"Mejeriprodukter","1L mandelmaelk, SPIR");
        MælkBTN = new ItemBTN("Mælk", root, MælkPath,"Mejeriprodukter","1L letmælk, Arla");
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

    public void initCandyShelf(){

        try {
            slikPoseBTN = new ItemBTN("slikpose", root, slikPoseBTNPath, "Sliksektion", "100g slik, Haribo");
            milkaBTN = new ItemBTN("milka", root, milkaBTNPath, "Sliksektion", "150g lys chokolade, Milka");
            marabouBTN = new ItemBTN("marabou", root, marabouBTNPath, "Sliksektion", "150g mørk chokolade, Marabou");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeCandyShelfItems(){
        slikPoseBTN.RemoveBTN(root);
        milkaBTN.RemoveBTN(root);
        marabouBTN.RemoveBTN(root);
    }
    public void endGame(){
        ScoreGFX scoreShow = new ScoreGFX();
        scoreShow.showScore(root);
    }
    public void ReSize(ImageView Image){
        Image.setFitHeight(200);
        Image.setFitWidth(200);
    }

    public void goBack(String LastBackground){
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
            try {
                InitScene2();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }else if(LastBackground.equals(background3Path)){
            root.getChildren().remove(goBackBTN);
            removeCandyShelfItems();
            try {
                InitScene3();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }}



}
