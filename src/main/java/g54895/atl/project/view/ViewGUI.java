package g54895.atl.project.view;

import g54895.atl.project.controller.ControllerGUI;
import g54895.atl.project.model.Direction;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;

/**
 * The GUI View part of the MVC structure.
 *
 * @author Ayoub
 */
public class ViewGUI implements PropertyChangeListener {

    private ControllerGUI controller;
    private final Stage primaryStage;
    private final Scene scene;
    private final VBox root;
    private GridPane leaf1;
    private VBox leaf2;

    private int[][] board;
    private TextArea textOutput;
    private Alert alertWindow;

    /**
     * Constructor of ViewGUI, sets the stage, initialize the root and the scene
     * and modifies the stage.
     *
     * @param stage
     */
    public ViewGUI(Stage stage) {
        root = new VBox();
        scene = new Scene(root, 900, 700, Color.BLACK);
        this.primaryStage = stage;
        this.primaryStage.setMaxWidth(1000);
        this.primaryStage.setMaxHeight(800);
        this.primaryStage.setMinWidth(1000);
        this.primaryStage.setMinHeight(800);
        this.primaryStage.setTitle("2048");
        Image logo = new Image(getClass().getClassLoader().getResourceAsStream("images/2048_logo.png"));
        this.primaryStage.getIcons().add(logo);
        this.primaryStage.setScene(scene);
    }

    /**
     * Simple setter of the controller, sets the controller, starts the game
     * initialize the board and add a listener which will fire the game board.
     *
     * @param controller a Controller
     */
    public void setController(ControllerGUI controller) {
        this.controller = controller;
        this.controller.startGame();
        board = new int[4][4];
        this.controller.addModelListener(this);

    }

    /**
     * Method showStage, shows the stage.
     */
    public void showStage() {
        this.primaryStage.show();
    }

    /**
     * Method initialize, initializes the components and adds the components to
     * the root.
     */
    public void initialize() {
        HBox branch1 = new HBox();
        HBox branch2 = new HBox();

        //BUTTON
        Button restartButton = new Button("Restart");
        restartButton.setStyle(" -fx-font-size: 2em;"
                + " -fx-background-color: #745f46; -fx-border-width: 1px;"
                + " -fx-text-fill: #d6dfdc; -fx-background-insets: 0,1,2;"
                + " -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30;");
        restartButton.setTextAlignment(TextAlignment.CENTER);
        restartButton.setPrefWidth(300);
        restartButton.setPrefHeight(60);
        restartButton.setOnAction(click -> {
            this.controller.tryRestart();
            System.out.println("bouton clické");
        });

        //LEAF*
        leaf1 = new GridPane();
        updateBoard();
        leaf2 = new VBox();

        //JTextArea textOutput = new JTextArea();
        //textOutput.setEditable(false);
        textOutput = new TextArea();
        displayMessage("Bienvenue au 2048");
        textOutput.setEditable(false);
        textOutput.setDisable(true);
        textOutput.setPrefHeight(630);
        leaf2.getChildren().addAll(textOutput);
        leaf2.setAlignment(Pos.CENTER);

        //BRANCH
        //Branch 1
        branch1.getChildren().addAll(leaf1, leaf2);
        branch1.setPadding(new Insets(20, 5, 5, 5));
        branch1.setSpacing(5);
        branch1.setAlignment(Pos.CENTER_LEFT);

        //Branch 2
        branch2.getChildren().addAll(restartButton);
        branch2.setPadding(new Insets(5, 5, 20, 5));
        branch2.setSpacing(5);
        branch2.setAlignment(Pos.CENTER_LEFT);
        //ROOT 
        root.getChildren().addAll(branch1, branch2);
        root.setStyle("-fx-background-color: #a5978c");
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP://Z:
                        controller.tryMove(Direction.UP);
                        break;
                    case DOWN://S:
                        controller.tryMove(Direction.DOWN);
                        break;
                    case LEFT://Q:
                        controller.tryMove(Direction.LEFT);
                        break;
                    case RIGHT://D:
                        controller.tryMove(Direction.RIGHT);
                        break;
                    case Z:
                        controller.tryMove(Direction.UP);
                        break;
                    case S:
                        controller.tryMove(Direction.DOWN);
                        break;
                    case Q:
                        controller.tryMove(Direction.LEFT);
                        break;
                    case D:
                        controller.tryMove(Direction.RIGHT);
                        break;
                }
            }
        });
    }

    /**
     * Methode update, updates the board.
     */
    public void updateBoard() {
        root.requestFocus();
        leaf1.getChildren().removeAll();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Rectangle tile = new Rectangle(150, 150);
                tile.setArcWidth(10.0);
                tile.setArcHeight(10.0);
                tile.setFill(getBackColor(board[i][j]));
                Text text = new Text(String.valueOf(board[i][j]));
                text.setFont(Font.font(65));
                text.setFill(getTextColor(board[i][j]));
                StackPane stackPane = new StackPane(tile, text);
                stackPane.setPadding(new Insets(5));
                leaf1.add(stackPane, j, i);
            }
        }
    }

    /**
     * Method getBackColor, gets the backgroung color of the tile, depending on
     * the value given in parameter.
     *
     * @param value an integer.
     * @return a javaFx Color.
     */
    public Color getBackColor(int value) {
        switch (value) {
            case 0:
                return Color.web("#fcf5ed");
            case 2:
                return Color.web("#fcf5ed");
            case 4:
                return Color.web("#f9e8d5");
            case 8:
                return Color.web("#ffaf7a");
            case 16:
                return Color.web("#fe7b3e");
            case 32:
                return Color.web("#fa8072");
            case 64:
                return Color.web("#f14f3b");
            case 128:
                return Color.web("#ffd480");
            case 256:
                return Color.web("#dfb93e");
            case 512:
                return Color.web("#ddb024");
            case 1024:
                return Color.web("#edb100");
            case 2048:
                return Color.web("#f7b700");
            default:
                return Color.web("#fcf5ed");
        }
    }

    /**
     * Method getTextColor, gets the text color of the tile, depending on the
     * value given in parameter.
     *
     * @param value an integer.
     * @return a javaFx Color.
     */
    public Color getTextColor(int value) {
        switch (value) {
            case 0:
                return Color.web("#fcf5ed");
            case 2:
                return Color.web("#262626");
            case 4:
                return Color.web("#191919");
            default:
                return Color.web("#ffffff");
        }
    }

    /**
     * Method displayWin, informs the user that he won.
     */
    public void displayWin() {
        displayMessage("Partie est terminée");
        displayMessage("Vous avez gagné !!!");
        alertWindow = new Alert(AlertType.NONE);
        alertWindow.setAlertType(AlertType.INFORMATION);
        alertWindow.setContentText("YOU HAVE WON CONGRATS!!!");
        alertWindow.show();

    }

    /**
     * Method displayFail, informs the user that he failed.
     */
    public void displayFail() {
        displayMessage("Partie est terminée");
        displayMessage("Vous avez perdu !!!");
        alertWindow = new Alert(AlertType.NONE);
        alertWindow.setAlertType(AlertType.INFORMATION);
        alertWindow.setContentText("YOU FAILED RETRY!!!");
        alertWindow.show();

    }

    /**
     * Method displayError, displays a message in the Application console.
     *
     * @param message a String
     */
    public void displayMessage(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        textOutput.appendText(LocalDateTime.now().format(formatter) + " - "
                + message + "\n");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.board = (int[][]) evt.getNewValue();
    }
}
