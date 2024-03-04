package pl.mglabinski.creditcard;

import java.math.BigDecimal;

public class CreditCard {


    private BigDecimal creditLimit;

    public void assignCredit(BigDecimal creditLimit) {
        if (creditLimit) {
            this.creditLimit = creditLimit;
        }
    }

    public BigDecimal getBalance() {
        return creditLimit;
    }
}
