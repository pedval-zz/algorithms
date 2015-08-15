package coinchange;

/**
 * Created by pedrovalencia on 28/03/15.
 */
public class Coin implements Comparable<Coin>{
    private Integer amount;

    public Coin(int amountIn) {
        this.amount = amountIn;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return this.amount.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coin coin = (Coin) o;

        if (amount != null ? !amount.equals(coin.amount) : coin.amount != null) return false;

        return true;
    }

    @Override
    public int compareTo(Coin o) {
        return -this.amount.compareTo(o.getAmount());
    }


}
