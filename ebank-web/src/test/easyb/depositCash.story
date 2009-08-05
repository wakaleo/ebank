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
/*
import com.thoughtworks.selenium.DefaultSelenium
import com.thoughtworks.selenium.Selenium

scenario "Deposit cash via the web interface", {
    given "the account details page is displayed", {
    }
    when "the user enters a value in the 'deposit cash' field", {

        Selenium selenium = new DefaultSelenium("localhost", 4444,
                                               "*firefox", "http://localhost:8080");
        selenium.start();
        selenium.open("/ebank-web");
        selenium.waitForPageToLoad("10000");
        selenium.type("depositAmount", "100");
        selenium.click("deposit");
        selenium.waitForPageToLoad("10000");
        selenium.isTextPresent("Current balance: $100");
        selenium.stop()
    }
    and "the user clicks on the 'deposit' button", {
    }
    then "the deposited amount is added to the current balance and displayed", {
    }
}
*/
