package OOPS;

public class Wallet implements PaymentMethod {

    private String walletId;

    Wallet(String walletId){
        this.walletId = walletId;
    }
    @Override
    public void pay() {
        System.out.println("Paid using Wallet");
    }
}

