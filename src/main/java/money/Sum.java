package money;

public class Sum implements Expression {

  Expression augend;
  Expression addend;

  Sum(Expression augend, Expression addend) {
    this.augend = augend;
    this.addend = addend;
  }

  @Override
  public Expression plus(Expression addend) {
    return null;
  }

  @Override
  public Money reduce(Bank bank, String to) {
    int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
    return new Money(amount, to);
  }

}
