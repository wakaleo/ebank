import net.sourceforge.jwebunit.junit.WebTestCase;
import net.sourceforge.jwebunit.junit.WebTester;

class DepositCashWebClient extends WebTestCase {

    public DepositCashWebClient() {
        tester = new WebTester();
    }
};
    
before_each "initialize a web client", {
  given "web client is up and running", {
      webClient = new DepositCashWebClient()
      webClient.setBaseUrl("http://localhost:9090/ebank-web")
  }
}


scenario "Deposit cash via the web interface 2", {
    given "the application home page is displayed"
    and "the current balance is 0"
    when "I type \$100 in the 'deposit cash' field"
    and "I click on the 'deposit' button"
    then "the balance should be equal to the amount deposited"
}

scenario "Deposit cash via the web interface", {
    given "the application home page is displayed", {
      webClient.beginAt("/")
    }
    and "the current balance is 0", {
      webClient.assertTextPresent("Current Balance: \$0")
    }
    when "I type \$100 in the 'deposit cash' field", {
      webClient.setTextField("depositAmount","100")
    }
    and "I click on the 'deposit' button", {
      webClient.clickButtonWithText("deposit")
    } 
    then "the balance should be equal to the amount deposited", {
      webClient.assertTextPresent("Current Balance: \$100")
    }
}


/*

    public void setUp() {
        setBaseUrl("http://localhost:9090/ebank-web");
    }
    
    public void testHomePageShouldDisplayReassuringTitle() throws Exception {
        beginAt("/");
        assertTitleEquals("eBank - your money is safe with us!");
        
    }
    
    public void testDepositingCashShouldAddToBalance() {        
        beginAt("/");
        assertTextPresent("Current Balance: $0");
        setTextField("depositAmount","100");
        clickButtonWithText("deposit");
        assertTextPresent("Current Balance: $100");
    }

*/