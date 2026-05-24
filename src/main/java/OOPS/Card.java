package OOPS;

public abstract class Card implements PaymentMethod {

  private String cardNo;
  private String userName;

  public Card(String cardNo, String userName) {
    this.cardNo = cardNo;
    this.userName = userName;
  }

  public String getCardNo() {
    return cardNo;
  }

  public String getUserName() {
    return userName;
  }
}
