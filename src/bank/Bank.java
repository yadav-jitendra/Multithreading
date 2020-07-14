package bank;

public class Bank {

    /**
     A bank is an array of accounts
     */
    private final Account[] account;

    public Bank() {
        account = new Account[100];    // size of acc array
        for(int i = 0; i <account.length; i++){
            account[i] = new Account(i);
        }
    }

    public void deposit(int accNr, float amount){
        synchronized(account[accNr]){
            float oldAmount = account[accNr].getBalance();
            float newAmount = oldAmount + amount;
            account[accNr].setBalance(newAmount);
        }
    }


    public void printAccount(){
        for(int i =0; i<account.length; i++){
            System.out.println("accNr-"+ account[i].getAccNr()+ " balance "+account[i].getBalance());
        }
    }
}
