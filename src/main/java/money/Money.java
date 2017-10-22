package money;

public class Money implements Expression {

  protected int amount;

  protected String currency;

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  Money times(int multiplier) {
    return new Money(this.amount * multiplier, this.currency);
  }

  String currency() {
    return this.currency;
  }

  Expression plus(Money addend) {
    return new Sum(this, addend);
  }

  @Override
  public Money reduce(String to) {
    return this;
  }

  @Override
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount
      && this.currency().equals(money.currency());
  }

  @Override
  public String toString() {
    return this.amount + " " + this.currency;
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }
}
