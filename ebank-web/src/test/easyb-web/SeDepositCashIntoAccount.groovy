import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

before "initialize a web client", {
  given "selenium is up and running", {
    selenium = new DefaultSelenium("localhost", 4444,
                                               "*firefox", "http://localhost:8080");
    selenium.start();
  }
}

after "stop selenium" , {
 then "selenium should be shutdown", {
    selenium.stop()
 }
}

scenario "Deposit cash via the web interface", {
    given "the application home page is displayed", {
      selenium.open("/ebank-web")
      selenium.waitForPageToLoad("2000")
    }
    and "the current balance is 0", {
      selenium.isTextPresent("Current balance: \$100");
    }
    when "the user enters a value in the 'deposit cash' field", {
      selenium.type("depositAmount", "100")
      selenium.click("deposit")
      selenium.waitForPageToLoad("2000")
    }
    then "the balance should be equal to the amount deposited", {
      selenium.isTextPresent("Current balance: \$100");
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