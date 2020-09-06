package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

import java.util.Random;

public class Controller {

    private boolean turn;

    @FXML
    private TextField textField;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    public void initialize(){
        Random random=new Random();
        turn= random.nextBoolean();
        if (!turn)textField.setText("O");
        else textField.setText("X");
    }

    @FXML
    public void onButtonClicked(ActionEvent e){

        Button button=(Button) e.getSource();
        final String buttonText=button.getText();
        if (!buttonText.matches("X") && !buttonText.matches("O")) {

            if (!turn) {
                button.setText("O");
                button.setStyle("-fx-background-color: darkgrey");
                turn = true;
                textField.setText("X");
                win();
            } else if (turn) {
                button.setText("X");
                button.setStyle("-fx-background-color: darkgrey");
                turn = false;
                textField.setText("O");
                win();
            }
        }

    }
    public void win(){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tic-Tac-Toe");
        alert.setHeaderText(null);
        String s="";
        if (!turn) s="X";
        else s="O";
        alert.setContentText("["+s+"]"+"  player won.");
        DialogPane dialogPane=alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("myAlert.css").toExternalForm());
        dialogPane.getStyleClass().add("myAlert");
        if (check()){
            alert.showAndWait();
            reset();
        }else if (draw()){
            alert.setContentText("Its a draw.");
            alert.showAndWait();
            reset();
        }
    }

    public boolean check(){
        if((!button1.getText().isEmpty()) && button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText())){
            return true;
        }else if((!button1.getText().isEmpty()) && button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText())){
            return true;
        }else if((!button3.getText().isEmpty()) && button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText())){
            return true;
        }else if((!button7.getText().isEmpty()) && button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText())){
            return true;
        }else if((!button2.getText().isEmpty()) && button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText())){
            return true;
        }else if((!button2.getText().isEmpty()) && button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText())){
            return true;
        }else if((!button4.getText().isEmpty()) && button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText())){
            return true;
        }else if((!button1.getText().isEmpty()) && button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText())){
            return true;
        }else if((!button3.getText().isEmpty()) && button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText())){
            return true;
        }
        return false;
    }

    public boolean draw(){
        if ((!button1.getText().isEmpty()) && (!button2.getText().isEmpty()) && (!button3.getText().isEmpty()) && (!button4.getText().isEmpty())
                && (!button5.getText().isEmpty()) && (!button6.getText().isEmpty()) && (!button7.getText().isEmpty())
                && (!button8.getText().isEmpty()) && (!button9.getText().isEmpty())) {
        return true;
        }
        return false;
    }

    public void reset(){
        button1.setStyle(null);
        button1.setText("");
        button2.setStyle(null);
        button2.setText("");
        button3.setStyle(null);
        button3.setText("");
        button4.setStyle(null);
        button4.setText("");
        button5.setStyle(null);
        button5.setText("");
        button6.setStyle(null);
        button6.setText("");
        button7.setStyle(null);
        button7.setText("");
        button8.setStyle(null);
        button8.setText("");
        button9.setStyle(null);
        button9.setText("");
        initialize();
    }
    @FXML
    public void exit(){
        Platform.exit();
    }
}
