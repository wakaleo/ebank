package org.ebank.domain 

scenario "Make initial deposit onto a new account", {
    given "a new account", {
       account = new Account()
    }
    when "an initial deposit is made", {
       initialAmount = 100
       account.makeDeposit(initialAmount)
    }
    then "the balance should be equal to the amount deposited", {
        account.balance.shouldBe 100
    }
}