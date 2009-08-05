package org.ebank.web;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.Test;
import org.junit.Ignore;

/**
 * Created by IntelliJ IDEA.
 * User: johnsmart
 * Date: 29/06/2009
 * Time: 14:31:30
 * To change this template use File | Settings | File Templates.
 */
public class TestUI {

    @Test
    @Ignore
    public void testDepositAmount() throws Exception {
    	
        Selenium selenium = new DefaultSelenium("localhost", 4444,
                                               "*firefox", "http://localhost:9090");
        selenium.start();
        selenium.open("/ebank-web");
        selenium.waitForPageToLoad("10000");
        selenium.type("depositAmount", "100");
        selenium.click("deposit");
        selenium.waitForPageToLoad("10000");
        selenium.isTextPresent("Current balance: $100");
       
    }

}
