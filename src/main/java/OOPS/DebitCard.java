package OOPS;

public class DebitCard extends Card {
  public DebitCard(String cardNo, String userName) {
    super(cardNo, userName);
  }

  @Override
  public void pay() {
    System.out.println("Paid using Debit Card");
  }
}
