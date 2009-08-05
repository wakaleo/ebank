import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.*

before_each "initialize a web client", {
  given "web client is up and running", {
      webClient = new WebClient()
  }
}

scenario "The application name is displayed in the page title", {
    given "the application home page is displayed", {
      page = webClient.getPage("http://localhost:8080/ebank-web")
    }
    then "the balance should be equal to the amount deposited", {
      page.titleText.shouldBe "eBank - your money is safe with us!"
    }
}

scenario "Deposit cash via the web interface", {
    given "the application home page is displayed", {
      page = webClient.getPage("http://localhost:8080/ebank-web")
    }
    and "the current balance is 0", {
      page.asText().contains "Current Balance: \$0"
    }
    when "the user enters a value in the 'deposit cash' field", {
        form = page.forms[0];
        depositButton = form.getInputByName("deposit");
        textField = form.getInputByName("depositAmount");
        textField.valueAttribute = "100";

        resultPage = depositButton.click();
    }
    then "the balance should be equal to the amount deposited", {
      resultPage.asText().contains "Current Balance: \$100"
    }
}


/*

when "the user enters a value in the ‘deposit cash’ field"

and "the user clicks on the ‘deposit’ button"
?then "the deposited amount is added to the current balance and displayed"


scenario "The application name is displayed in the page title", {
  when "the application home page is displayed"?, {
      webClient = new WebClient()
      page = webClient.getPage("http://localhost:8080/ebank-web")
  }
  then "the application name and caption is displayed in the page title", {
      page.titleText.shouldBe "eBank - your money is safe with us!"

  }
}

*/
/*
scenario "Make initial deposit onto a new account", {
  given "the account details page is displayed"?, {
      webClient = new WebClient()
      page = webClient.getPage("http://localhost:8080/ebank-web")
      page.titleText.shouldBe "eBank - your money is safe with us!"
  }
  when "the user enters a value in the ‘deposit cash’ field"  
  and "the user clicks on the ‘deposit’ button"
  ?then "the deposited amount is added to the current balance and displayed"
}
*/
/*


before "start selenium", {
        selenium = new DefaultSelenium("localhost",
                SeleniumServer.getDefaultPort(),
                "*firefox",
                "http://localhost:8080")
        selenium.start()
}

after "stop selenium" , {
 then "selenium should be shutdown", {
  selenium.stop()
 }
}

scenario "a user enters an income value and calculates the corresponding income tax", {
  when "the account details page is displayed", {
    selenium.with {
        open "/"
        waitForPageToLoad "1000"
    }
  }
  and "the user enters a value in the ‘deposit cash’ field", {
    selenium.type("depositAmount", "100")
  }
  and "the user clicks on the ‘deposit’ button", {
    selenium.with {
        click "deposit"
        waitForPageToLoad "1000"
    }
  }
  then "the deposited amount is added to the current balance and displayed", {
    selenium.with {
       assert isTextPresent("Current balance: \$100")
    }
  }
}



*/