package OOPS;

public class UPI implements PaymentMethod {

  String upiId;

  UPI(String id) {
    this.upiId = id;
  }

  @Override
  public void pay() {
    System.out.println("Paid using UPI");
  }
}
