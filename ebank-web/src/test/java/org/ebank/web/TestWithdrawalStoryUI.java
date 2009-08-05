package org.ebank.web;

import net.sourceforge.jwebunit.junit.WebTestCase;
import org.junit.Test;


public class TestWithdrawalStoryUI extends  WebTestCase {

	public void setUp() {
		setBaseUrl("http://localhost:9090/ebank-web");
	}
		
	public void testDepositingAndWithdrawingCashShouldUpdateBalance() {		
		beginAt("/");
		assertTextPresent("Current Balance: $0");
		setTextField("depositAmount","100");
		clickButtonWithText("deposit");
		assertTextPresent("Current Balance: $100");
		
		setTextField("withdrawalAmount", "20");
		clickButtonWithText("withdraw");
		assertTextPresent("Current Balance: $80");
		
	}
	    
}
