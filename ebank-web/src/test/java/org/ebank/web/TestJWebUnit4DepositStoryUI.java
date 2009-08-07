package org.ebank.web;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTestCase;
import net.sourceforge.jwebunit.junit.WebTester;

public class TestJWebUnit4DepositStoryUI {

	private class DepositCashWebClient extends WebTestCase {

		public DepositCashWebClient() {
			tester = new WebTester();
		}
	};
	
	private DepositCashWebClient webClient;
	
	@Before
	public void setUp() {
		webClient = new DepositCashWebClient();
		webClient.setBaseUrl("http://localhost:9090/ebank-web");
	}
	
	@Test
	public void testHomePageShouldDisplayReassuringTitle() throws Exception {
		webClient.beginAt("/");
		webClient.assertTitleEquals("eBank - your money is safe with us!");		
	}
	
	@Test
	public void testDepositingCashShouldAddToBalance() {		
		webClient.beginAt("/");
		webClient.assertTextPresent("Current Balance: $0");
		webClient.setTextField("depositAmount","100");
		webClient.clickButtonWithText("deposit");
		webClient.assertTextPresent("Current Balance: $100");
	}
}
