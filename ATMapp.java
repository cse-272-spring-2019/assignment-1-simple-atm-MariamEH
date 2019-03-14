import javafx.application.Application;
import javafx.stage.Stage;


    public class ATMapp extends Application {
        public static void main(String[] args) {

            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Simple ATM");
            ATMForm atmForm = new ATMForm(primaryStage);
            SecondScreen secondScreen = new SecondScreen(primaryStage);

            atmForm.sceneForm();
            secondScreen.sceneForm();

            atmForm.setSecondScreen(secondScreen);
            secondScreen.setAtmForm(atmForm);

            primaryStage.setScene(atmForm.getScene());
            primaryStage.show();

        }
    }
