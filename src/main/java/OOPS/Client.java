package OOPS;

public class Client {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        paymentService.addPaymentMethod("Zishan Debit Card", new DebitCard("262626", "Zishan"));
        paymentService.addPaymentMethod("Zishan Credit Card", new CreditCard("262626", "Zishan"));
        paymentService.addPaymentMethod("Zishan UPI", new UPI("1234567890"));
        paymentService.addPaymentMethod("Zishan Wallet", new Wallet("Zishan Wallet 26"));


        paymentService.makePayment("Zishan UPI");
        paymentService.makePayment("Zishan Credit Card");
        paymentService.makePayment("Zishan Debit Card");
        paymentService.makePayment("Zishan Wallet");

    }
}
