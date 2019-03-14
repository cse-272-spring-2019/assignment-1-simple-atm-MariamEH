import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMForm  {
    Stage stage;
    Scene scene;
    Logic logical ;
    SecondScreen secondScreen;

    public ATMForm(Stage stage){
        this.stage=stage;
    }

    public void sceneForm (){
        logical = new Logic(0.0);
        Label enterLabel = new Label("Enter your card number    " );
        TextField cardNumber = new TextField();
        Button next = new Button("next");
        Label validationLabel = new Label();
        Label empty = new Label();
        GridPane grid = new GridPane();
        grid.add(enterLabel,0,0);
        grid.add(cardNumber,1,0);
        grid.add(empty,0,1);
        grid.add(next,1,2);
        grid.add(validationLabel,1,3);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent Event) {
                String cardNum = cardNumber.getText();
                boolean valid= logical.validate(cardNum);
                if (valid)
                    stage.setScene(secondScreen.getScene());
                else
                    validationLabel.setText("Invalid card number ");

                cardNumber.clear();
            }
        });
         scene = new Scene(grid,600,400);
    }
    public Scene getScene(){
        return this.scene;
    }

    public void setSecondScreen(SecondScreen secondScreen) {
        this.secondScreen = secondScreen;
    }
}
