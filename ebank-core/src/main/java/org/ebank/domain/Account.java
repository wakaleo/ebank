package org.ebank.domain;

import java.math.BigDecimal;

/**
 * An online bank account.
 * A bank account belongs to one or more owners, who can withdraw money from the account.
 * Users can deposit and withdraw funds without incurring any fees.
 */
public class Account {

    private Long id;

    private String accountNumber;
    
    private BigDecimal balance;

    public Account() {
        balance = BigDecimal.ZERO;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    /**
     * Deposit a specified amount of money onto an account.
     * The amount must be greater than zero
     * @param deposit
     */
    public void makeDeposit(BigDecimal deposit) {
        balance = balance.add(deposit);
    }

    public void withdraw(BigDecimal withdrawal) throws InsufficientFundsException {
        if (withdrawal.compareTo(balance) > 0) {
            throw new InsufficientFundsException();
        }
        balance = balance.subtract(withdrawal);
    }


}
