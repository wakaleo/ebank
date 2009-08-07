package org.ebank.web;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

public class TestHtmlUnitDepositStoryUI {

    @Test
    public void homePage() throws Exception {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://localhost:9090/ebank-web");
        assertEquals("eBank - your money is safe with us!", page.getTitleText());
    }

    @Test
    public void depositCash() throws Exception {
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://localhost:9090/ebank-web");
        assert page.asText().contains("Current Balance: $0");
        HtmlForm form = page.getForms().get(0);
        HtmlSubmitInput depositButton = form.getInputByName("deposit");
        HtmlTextInput textField = form.getInputByName("depositAmount");

        // Change the value of the text field
        textField.setValueAttribute("100");

       // Now submit the form by clicking the button and get back the second page.
        HtmlPage result = depositButton.click();
        assert result.asText().contains("Current Balance: $100");
    }

    @Test
    public void withdrawCash() throws Exception {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://localhost:9090/ebank-web");
        System.out.println(page.asText());
        assert page.asText().contains("Current Balance: $0");

        final HtmlForm form = page.getForms().get(0);
        final HtmlSubmitInput depositButton = form.getInputByName("deposit");
        final HtmlTextInput textField = form.getInputByName("depositAmount");

        // Change the value of the text field
        textField.setValueAttribute("100");

       // Now submit the form by clicking the button and get back the second page.
        final HtmlPage page2 = depositButton.click();
        System.out.println(page2.asText());
        assert page2.asText().contains("Current Balance: $100");

        final HtmlForm form2 = page2.getForms().get(0);
        final HtmlSubmitInput withdrawButton = form2.getInputByName("withdraw");
        final HtmlTextInput withdrawalField = form2.getInputByName("withdrawalAmount");

        // Change the value of the text field
        withdrawalField.setValueAttribute("20");

       // Now submit the form by clicking the button and get back the second page.
        final HtmlPage page3 = withdrawButton.click();
        System.out.println(page3.asText());
        assert page3.asText().contains("Current Balance: $80");
    }

}
