
import net.sourceforge.jwebunit.junit.WebTestCase;

class DepositCashWebClient extends extends WebTestCase {

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

scenario "Deposit cash via the web interface", {
    given "the application home page is displayed", {
      webClient.beginAt("/")
    }
    and "the current balance is 0", {
	  assert webClient.assertTextPresent("Current Balance: \$0")
    }
    when "the user enters a value in the 'deposit cash' field", {
 	  webClient.setTextField("depositAmount","100")
	  webClient.clickButtonWithText("deposit")
    }
    then "the balance should be equal to the amount deposited", {
      assert webClient.assertTextPresent("Current Balance: \$100")
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