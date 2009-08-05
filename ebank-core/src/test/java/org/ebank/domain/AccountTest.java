package org.ebank.domain;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void balanceShouldBeEqualToInitialDepositAfterInitialBalance() {
        Account account = new Account();
        BigDecimal initialAmount = new BigDecimal("100");
        account.makeDeposit(initialAmount);
        assertThat(account.getBalance(), is(initialAmount));
    }
    
    @Test 
    public void withdrawalShouldDeductSumFromBalance() throws Exception {
    	Account account = new Account();
        BigDecimal initialAmount = new BigDecimal("100");
        account.makeDeposit(initialAmount);
        account.withdraw(new BigDecimal("60"));
        assertThat(account.getBalance(), is(new BigDecimal("40")));
    }
}
