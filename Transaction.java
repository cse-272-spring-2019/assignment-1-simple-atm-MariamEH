import java.util.ArrayList;
import java.util.List;
import java.lang.String;
public class Transaction {

    List listType = new ArrayList();
    List listAmount = new ArrayList();
    public void setlastTransactionType(int index,String type){

        listType.add(index,type);
    }
    public void setlastTransactionAmount(int index,double amount){

        String numberAsString = String.valueOf(amount);
        listAmount.add(index,numberAsString);
    }
    public String getlastTransactionType (int index){
        String transactionType = (String) listType.get(index);
        return transactionType;
    }
    public String getlastTransactionAmount (int index){
        String transactionAmount = (String) listAmount.get(index);
        return transactionAmount;
    }
    public int sizeOfList(){
        int size = listType.size();
        return size;
    }
}
