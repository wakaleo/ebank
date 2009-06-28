package org.ebank.domain;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void balanceShouldBeEqualToInitialDepositAfterInitialBalance() {
        Account account = new Account();
        BigDecimal initialAmount = new BigDecimal("100");
        account.makeDeposit(initialAmount);
        assertTrue(account.getBalance().equals(initialAmount));
    }
}
