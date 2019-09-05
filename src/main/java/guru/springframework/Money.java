package guru.springframework;

/**
 * Created by uc on 9/4/2019
 */
public class Money {

    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money money = (Money) obj;
            return (amount == money.amount) &&
                    currency == money.currency;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(amount);
    }
}
