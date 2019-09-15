//Sakina Master
//Implementing a card game Pitch in Java and creating a GUI utilizing JavaFX.

import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {
    Pitch firstGame;
    int numPlayers;
    public static void main(String[] args) {
        launch(args);
    }

    Stage myStage1;
    Scene welcomeScene, gameScene2;
    HashMap<String, Scene> sceneMap;
    Group Player3Group;
    Button twoPlayers, threePlayers, fourPlayers;
    Button card1, card2, card3, card4, card5, card6;
    Button card7, card8, card9, card10, card11, card12;
    Button card13, card14, card15, card16, card17, card18;
    Button card19, card20, card21, card22, card23, card24;
    Button displayCard1, displayCard2, displayCard3, displayCard4;
    Button bidPlayer1, bidPlayer2, bidPlayer3, bidPlayer4;
    boolean isTwoPlayer = false; boolean isThreePlayer = false; boolean isFourPlayer = false;

    ArrayList<Button> userCards; ArrayList<Button> AIPlayer2; ArrayList<Button> AIPlayer3; ArrayList<Button> AIPlayer4;
    ArrayList<Card> trick1 = new ArrayList<>();
    Label text, enter_bid, user, player1, player2, player3;  TextField userBid;
    Button startWelcome; Button exitWelcome; Button startGame; Button exitGame;
    BorderPane pane; BorderPane game2; BorderPane game3; BorderPane game4;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome");
        myStage1 = primaryStage;
        sceneMap = new HashMap<String, Scene>();
        text = new Label("WELCOME TO THE PITCH GAME\n\n\nChoose the number of players.\n\n");
        twoPlayers = new Button("2 Players");
        threePlayers = new Button("3 Players");
        fourPlayers = new Button("4 Players");
        user = new Label("User");
        player1 = new Label("Player1");
        player2 = new Label("Player2");
        player3 = new Label("Player3");
        startWelcome = new Button("Start");
        exitWelcome = new Button("Exit");
        startGame = new Button("Start");
        exitGame = new Button("Exit");

        //Buttons for game Scene
        card1 = new Button();   card7 = new Button("         \n           ");
        card2 = new Button();   card8 = new Button("         \n           ");
        card3 = new Button();   card9 = new Button("         \n           ");
        card4 = new Button();   card10 = new Button("        \n           ");
        card5 = new Button();   card11 = new Button("        \n           ");
        card6 = new Button();   card12 = new Button("        \n           ");
        card13 = new Button("         \n           ");  card19 = new Button("         \n           ");
        card14 = new Button("         \n           ");  card20 = new Button("         \n           ");
        card15 = new Button("         \n           ");  card21 = new Button("         \n           ");
        card16 = new Button("         \n           ");  card22 = new Button("         \n           ");
        card17 = new Button("         \n           ");  card23 = new Button("         \n           ");
        card18 = new Button("         \n           ");  card24 = new Button("         \n           ");

        displayCard1 = new Button("         \n          "); displayCard3 = new Button("         \n          ");
        displayCard2 = new Button("         \n          "); displayCard4 = new Button("         \n          ");
        bidPlayer1 = new Button("Press me");
        bidPlayer2 = new Button();  bidPlayer3 = new Button();  bidPlayer4 = new Button();

        enter_bid = new Label("Enter bid");
        userBid = new TextField();

        userCards = new ArrayList<Button>();
        userCards.add(card1); userCards.add(card2); userCards.add(card3); userCards.add(card4);
        userCards.add(card5); userCards.add(card6);

        AIPlayer2 = new ArrayList<Button>();
        AIPlayer2.add(card7); AIPlayer2.add(card8); AIPlayer2.add(card9); AIPlayer2.add(card10);
        AIPlayer2.add(card11); AIPlayer2.add(card12);

        AIPlayer3 = new ArrayList<Button>();
        AIPlayer3.add(card13); AIPlayer3.add(card14); AIPlayer3.add(card15); AIPlayer3.add(card16);
        AIPlayer3.add(card17); AIPlayer3.add(card18);

        AIPlayer4 = new ArrayList<Button>();
        AIPlayer4.add(card19); AIPlayer4.add(card20); AIPlayer4.add(card21); AIPlayer4.add(card22);
        AIPlayer4.add(card23); AIPlayer4.add(card24);

        //Scene1: Welcome Screen
        pane = new BorderPane();
        pane.setPadding(new Insets(70));

        VBox paneTop = new VBox(10, text);    //Creating RootNode in the top
        pane.setTop(paneTop);

        HBox paneCenter = new HBox(10, twoPlayers, threePlayers, fourPlayers);
        pane.setCenter(paneCenter);
        HBox paneBottom = new HBox(30, startWelcome, exitWelcome);
        pane.setBottom(paneBottom);

        welcomeScene = new Scene(pane, 500, 500);       //breadth, height
        sceneMap.put("welcome", welcomeScene);
        primaryStage.setScene(sceneMap.get("welcome"));
        //-----------------------------------------------

        //When 2Players is pressed
        twoPlayers.setOnAction(event -> {
                numPlayers = 2;
                firstGame = new Pitch(2);
                AIPlayer user = firstGame.playerList.get(0);
                for (int i = 0; i < userCards.size(); i++) {
                    Button button = userCards.get(i);
                    button.setText(user.getCard(i));
                }
                AIPlayer AI1 = firstGame.playerList.get(1);
                for (int i = 0; i < AIPlayer2.size(); i++) {
                    Button button = AIPlayer2.get(i);
                    //button.setText(AI1.getCard(i));
                }
                threePlayers.setDisable(true);
                fourPlayers.setDisable(true);
                isTwoPlayer = true;
                HBox DisplayCards2 = new HBox(0, displayCard1, displayCard2);
                game2.setCenter(DisplayCards2);
                DisplayCards2.setAlignment(Pos.CENTER);
            });

        //When 3players is pressed
        threePlayers.setOnAction(event -> {
            numPlayers=3;
            firstGame = new Pitch(3);
            AIPlayer user = firstGame.playerList.get(0);
            for (int i = 0; i < userCards.size(); i++) {
                Button button = userCards.get(i);
                button.setText(user.getCard(i));
            }
            AIPlayer AI1 = firstGame.playerList.get(1);
            for (int i = 0; i < AIPlayer2.size(); i++) {
                Button button = AIPlayer2.get(i);
                //button.setText(AI1.getCard(i));
            }
            AIPlayer AI2 = firstGame.playerList.get(2);
            for (int i = 0; i < AIPlayer3.size(); i++) {
                Button button = AIPlayer3.get(i);
                //button.setText(AI2.getCard(i));
            }
            twoPlayers.setDisable(true);
            fourPlayers.setDisable(true);
            isThreePlayer = true;
            HBox AIPlayer33Cards = new HBox(0, player2, bidPlayer3, card13, card14, card15, card16, card17, card18);
            HBox DisplayCards3 = new HBox(0, displayCard1, displayCard2, displayCard3);
            game2.setTop(AIPlayer33Cards);
            AIPlayer33Cards.setAlignment(Pos.TOP_CENTER);
            game2.setCenter(DisplayCards3);
            DisplayCards3.setAlignment(Pos.CENTER);
        });

        //When 4 players is pressed
        fourPlayers.setOnAction(event -> {
            numPlayers = 4;
            firstGame = new Pitch(4);
            AIPlayer user = firstGame.playerList.get(0);
            for (int i = 0; i < userCards.size(); i++) {
                Button button = userCards.get(i);
                button.setText(user.getCard(i));
            }
            AIPlayer AI1 = firstGame.playerList.get(1);
            for (int i = 0; i < AIPlayer2.size(); i++) {
                Button button = AIPlayer2.get(i);
                //button.setText(AI1.getCard(i));
            }
            AIPlayer AI2 = firstGame.playerList.get(2);
            for (int i = 0; i < AIPlayer3.size(); i++) {
                Button button = AIPlayer3.get(i);
                //button.setText(AI2.getCard(i));
            }
            AIPlayer AI3 = firstGame.playerList.get(3);
            for (int i = 0; i < AIPlayer4.size(); i++) {
                Button button = AIPlayer4.get(i);
                //button.setText(AI3.getCard(i));
            }
            twoPlayers.setDisable(true);
            threePlayers.setDisable(true);
            isFourPlayer = true;

            HBox AIPlayer44Cards = new HBox(0, player2, bidPlayer3, card13, card14, card15, card16, card17, card18);
            VBox AIPlayer444Cards = new VBox(0, player3, bidPlayer4, card19, card20, card21, card22, card23, card24);
            HBox DisplayCards4 = new HBox(0, displayCard1, displayCard2, displayCard3, displayCard4);
            game2.setTop(AIPlayer44Cards);
            AIPlayer44Cards.setAlignment(Pos.TOP_CENTER);
            game2.setRight(AIPlayer444Cards);
            AIPlayer444Cards.setAlignment(Pos.CENTER_RIGHT);
            game2.setCenter(DisplayCards4);
            DisplayCards4.setAlignment(Pos.CENTER);
        });


        //Scene2 for gamePlay
        myStage1.setTitle("Game Play");
        game2 = new BorderPane();
        game2.setPadding(new Insets(70));

        HBox user2 = new HBox(0, card1, card2, card3, card4, card5, card6);
        VBox AIPlayer2Cards = new VBox(0, player1, bidPlayer2, card7, card8, card9, card10, card11, card12);
        HBox start_exit = new HBox(20, startGame, exitGame);
        HBox textDisplay2 = new HBox(10, enter_bid, userBid, bidPlayer1);
        HBox userLabel = new HBox(0, user);
        game2.setLeft(AIPlayer2Cards);
        AIPlayer2Cards.setAlignment(Pos.CENTER_LEFT);
        BorderPane pane1 = new BorderPane();
        game2.setBottom(pane1);
        pane1.setTop(user2);
        user2.setAlignment(Pos.CENTER);
        pane1.setCenter(textDisplay2);
        textDisplay2.setAlignment(Pos.CENTER);
        pane1.setBottom(userLabel);
        userLabel.setAlignment(Pos.CENTER);
        pane1.setRight(start_exit);
        start_exit.setAlignment(Pos.BASELINE_RIGHT);
        //---------------------------------------------------------------------------

        startWelcome.setOnAction(event -> myStage1.setScene(sceneMap.get("2Players")));

        //Bidding
        bidPlayer1.setOnAction(event -> {
            bidPlayer1.setText(userBid.getText());
            ArrayList<Integer> bids = new ArrayList<>();
            bids.add(0,0);  //User's bid
            bids.add(1,0);  //Player 1's bid
            bids.add(2,0);  //Player 2's bid
            bids.add(3,0);  //Player 3's bid
            if(userBid.getText().equals("2")){
                bids.set(0, 2);
            }
            else if(userBid.getText().equals("3")) {
                bids.set(0, 3);
            }
            else if(userBid.getText().equals("4")) {
                bids.set(0, 4);
            }
            else if(userBid.getText().equals("5")) {
                bids.set(0, 5);
            }
            else
                    bids.set(0, 0);

            userBid.clear();
            if(numPlayers >=2) {
                AIPlayer user1 = firstGame.playerList.get(1);
                Suit trump1 = user1.trump();
                bids.set(1, user1.Bid(trump1));
                if (bids.get(1) > bids.get(0))
                    bidPlayer2.setText(bids.get(1) + " ");
                else
                    bidPlayer2.setText("0");
            }
            if(numPlayers >= 3) {
                AIPlayer users2 = firstGame.playerList.get(2);
                Suit trump2 = users2.trump();
                bids.set(2, users2.Bid(trump2));
                if((bids.get(2) > bids.get(0)) && (bids.get(2) > bids.get(1)))
                    bidPlayer3.setText(bids.get(2) + " ");
                else
                    bidPlayer3.setText("0");
            }
            if(numPlayers == 4) {
                AIPlayer user3 = firstGame.playerList.get(3);
                Suit trump3 = user3.trump();
                bids.set(3, user3.Bid(trump3));
                if((bids.get(3) > bids.get(0)) && (bids.get(3) > bids.get(1)) && (bids.get(3) > bids.get(2)))
                    bidPlayer4.setText(bids.get(3) + " ");
                else
                    bidPlayer4.setText("0");
            }

            //Find out who did the max bid
            Integer maxBid = Collections.max(bids);
            Integer maxBidIndex = bids.indexOf(maxBid);

            if((bids.get(0) == 0) && (bids.get(1) == 0) && (bids.get(2) == 0) & (bids.get(3) == 0)) {
                firstGame = new Pitch(numPlayers);
                AIPlayer user = firstGame.playerList.get(0);
                for (int i = 0; i < userCards.size(); i++) {
                    Button button = userCards.get(i);
                    button.setText(user.getCard(i));
                }
                AIPlayer AI1 = firstGame.playerList.get(1);
                for (int i = 0; i < AIPlayer2.size(); i++) {
                    Button button = AIPlayer2.get(i);
                    button.setText(AI1.getCard(i));
                }
                if(numPlayers >=3) {
                    AIPlayer AI2 = firstGame.playerList.get(2);
                    for (int i = 0; i < AIPlayer3.size(); i++) {
                        Button button = AIPlayer3.get(i);
                        button.setText(AI2.getCard(i));
                    }
                }
                if(numPlayers == 4) {
                    AIPlayer AI3 = firstGame.playerList.get(3);
                    for (int i = 0; i < AIPlayer4.size(); i++) {
                        Button button = AIPlayer4.get(i);
                        button.setText(AI3.getCard(i));
                    }
                }
                bidPlayer1.setText("Press Me");
            }

            //Play the game
            Suit trump = firstGame.playerList.get(maxBidIndex).trump();
            if(maxBidIndex!=0) {
                trick1.add( firstGame.playFirstCard(maxBidIndex));
                trump = trick1.get(0).getSuit();
                displayCard2.setText(trick1.get(0).toString());
            //    maxBidIndex = maxBidIndex +1;
            //    if(maxBidIndex == 3) {  maxBidIndex = 0; }
            }

       /*     if(maxBidIndex !=0) {
                trick1.add( firstGame.otherPlayersTurn(trick1,maxBidIndex,trump));
                displayCard3.setText(trick1.get(1).toString());
                maxBidIndex = maxBidIndex +1;
                if(maxBidIndex == 4) {  maxBidIndex = 0; }
            }

            if(maxBidIndex !=0) {
                trick1.add( firstGame.otherPlayersTurn(trick1,maxBidIndex,trump));
                displayCard4.setText(trick1.get(2).toString());
            }
            */
        });

        card1.setOnAction(event -> {
            displayCard1.setText(card1.getText());
            trick1.add(firstGame.playerList.get(0).getACard(0));
            card1.setVisible(false);
        });
        card2.setOnAction(event -> {
            displayCard1.setText(card2.getText());
            trick1.add(firstGame.playerList.get(0).getACard(1));
            card2.setVisible(false);
        });
        card3.setOnAction(event -> {
            displayCard1.setText(card3.getText());
            trick1.add(firstGame.playerList.get(0).getACard(2));
            card3.setVisible(false);
        });
        card4.setOnAction(event -> {
            displayCard1.setText(card4.getText());
            trick1.add(firstGame.playerList.get(0).getACard(3));
            card4.setVisible(false);
        });
        card5.setOnAction(event -> {
            displayCard1.setText(card5.getText());
            trick1.add(firstGame.playerList.get(0).getACard(4));
            card5.setVisible(false);
        });
        card6.setOnAction(event -> {
            displayCard1.setText(card6.getText());
            trick1.add(firstGame.playerList.get(0).getACard(5));
            card6.setVisible(false);
        });

        exitWelcome.setOnAction(event ->  System.exit(0));  //Exits the program

        exitGame.setOnAction(event -> {
            //game2.getChildren().removeAll();
            myStage1.setScene(sceneMap.get("welcome"));
            //Player3Group.getChildren().clear();
            twoPlayers.setDisable(false);
            threePlayers.setDisable(false);
            fourPlayers.setDisable(false);
        });

        gameScene2 = new Scene(game2, 800, 800);       //breadth, height
        sceneMap.put("2Players", gameScene2);
        primaryStage.show();    //Shows the screen to the user.
    }
}


//Declare Suit and Value as enum since they are constants.
enum Suit {
    HEART, SPADE, CLUB, DIAMOND
}
enum FaceName {
    TWO(2),    THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7),  EIGHT(8), NINE(9), TEN(10), JACK(11),
    QUEEN(12), KING(13), ACE(14);

    public int faceValue;
    FaceName(int cardValue) {
        this.faceValue = cardValue;
    }
}

interface DealerType {
    Dealer createDealer();
}

interface Dealer {
    ArrayList<Card> dealHand();
}

