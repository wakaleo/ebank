package org.ebank.domain

scenario "Withdraw money from an account", {
    given "an account with a certain balance", {
       initialBalance = 100
       account = new Account()
       account.balance = initialBalance
    }
    when "a sum is withdrawn from the account", {
       amountWithdrawn = 20
       account.withdraw(amountWithdrawn)
    }
    then "the withdrawn sum is deducted from the account balance", {
        account.balance.shouldBe initialBalance - amountWithdrawn
    }
}

scenario "Withdraw more money than there is in the account", {
    given "an account with a certain balance", {
       initialBalance = 100
       account = new Account()
       account.balance = initialBalance
    }
    and "an amount is withdrawn that is greater than the balance", {
        withdrawTooMuchMoney = {
	       account.withdraw(150)
        }
    }
    then "an InsufficientFundsException is raised", {
        ensureThrows(InsufficientFundsException.class){
            withdrawTooMuchMoney()
        }
    }
    and "the account balance remains unchanged", {
        account.balance.shouldBe initialBalance
    }
}