import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SecondScreen {
    Stage stage;
    Scene scene;
    ATMForm atmForm;
    int index=0;
    int count = 0;
    Logic logicalOperations = new Logic(0.0);
    Transaction transaction = new Transaction();

    public  SecondScreen(Stage stage ){
        this.stage=stage;
    }
    public void sceneForm(){
        GridPane grid = new GridPane();
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button balanceInquiry  = new Button("Balance Inquiry");
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Button logout = new Button("Logout");
        Label enter = new Label("Enter amount");
        TextField amount = new TextField();
        Label text = new Label();
        Label trans = new Label();
        Label empty = new Label();
        Label empty2 = new Label();
        Label empty3 = new Label();
        grid.add(deposit,0,0);
        grid.add(balanceInquiry,1,0);
        grid.add(withdraw,2,0);
        grid.add(enter,0,2);
        grid.add(amount,1,2);
        grid.add(empty2,0,1);
        grid.add(empty,0,3);
        grid.add(text,1,4);
        grid.add(previous,0,5);
        grid.add(next,2,5);
        grid.add(trans,1,6);
        grid.add(empty3,1,7);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    stage.setScene(atmForm.getScene());

            }
        });
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setVisible(false);
                    if (index==0)
                        trans.setText("End of previous transaction  " );
                    if(count<5) {
                        index--;
                        count++;
                        trans.setText("Previous transaction was " + transaction.getlastTransactionType(index) + transaction.getlastTransactionAmount(index));
                    }


            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent Event) {
                text.setVisible(true);
                amount.setVisible(true);
                enter.setVisible(true);
                String depositNumber = amount.getText();
                double d= Double.parseDouble(depositNumber);
                if (d>=0) {
                    logicalOperations.setDeposit(d);
                    text.setText("Deposit: "+logicalOperations.getDeposit());
                }
                else{ text.setText("Invalid amount");}
                transaction.setlastTransactionType(index,"Deposit:");
                transaction.setlastTransactionAmount(index,logicalOperations.getDeposit());
                index++;
                count=0;
                amount.clear();
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent Event ) {
                text.setVisible(true);
                amount.setVisible(true);
                enter.setVisible(true);
                String withdrawNumber = amount.getText();
                double d= Double.parseDouble(withdrawNumber);
                 if(d<=logicalOperations.getBalance()) {
                    logicalOperations.setWithdraw(d);
                    text.setText("Withdraw: "+logicalOperations.getWithdraw());
                }
                else
                    text.setText("withdrawal amount exceeds your current balance ");
                transaction.setlastTransactionType(index,"Withdraw:");
                transaction.setlastTransactionAmount(index,logicalOperations.getWithdraw());
                index++;
                count=0;
                amount.clear();
            }
        });
        balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent Event) {
                text.setVisible(true);
                text.setText("Your current balance is " + logicalOperations.getBalance());
                transaction.setlastTransactionType(index,"Balance:");
                transaction.setlastTransactionAmount(index,logicalOperations.getBalance());
                index++;
                count=0;
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setVisible(false);
                if (index<transaction.sizeOfList()-1){
                    index++;
                    trans.setText("Next transaction was " +transaction.getlastTransactionType(index)+transaction.getlastTransactionAmount(index));}
                else
                    trans.setText("End of transactions");


            }
        });

        scene = new Scene(grid,600,400);
    }
    public Scene getScene(){
        return scene;
    }
    public void setAtmForm(ATMForm atmForm) {
        this.atmForm = atmForm;
    }
}