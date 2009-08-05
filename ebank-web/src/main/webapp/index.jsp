<%@ page import="org.ebank.domain.Account"  %>
<%@ page import="java.math.BigDecimal"  %>
<%@page import="org.ebank.domain.InsufficientFundsException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %> 

<%
Account account = (Account) session.getAttribute("account");
String errorMessage = "";

if (account == null) {
    account = new Account();
    session.setAttribute("account",account);
}

String withdrawAction = request.getParameter("withdraw");
String depositAction = request.getParameter("deposit");
    
if (depositAction != null && depositAction.equals("deposit")) {
    String depositAmount = request.getParameter("depositAmount");
    if (depositAmount.length() > 0) {
        account.makeDeposit(new BigDecimal(depositAmount));
    }
}

if (withdrawAction != null && withdrawAction.equals("withdraw")) {
    String withdrawalAmount = request.getParameter("withdrawalAmount");
    if (withdrawalAmount.length() > 0) {
    	try {
	        account.withdraw(new BigDecimal(withdrawalAmount));
    	} catch (InsufficientFundsException e) {
        	errorMessage = "Sorry, you don't have enough cash to do that.";
        }
    }
}

%>

<html>
<head>
    <title>eBank - your money is safe with us!</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="header" />
        <h2><f:message key="app.caption"/></h2>
    </div>
    <div class="content">
        <h3>Your account details:</h3> 
        <p>Current Balance: $<%=account.getBalance()%></p>
        <form name="deposit_withdraw" method="get">
          <table border="0">
              <tr>
                <td>Deposit cash:</td>
                <td><input name="depositAmount" type="text"></td>
                <td>&nbsp;</td><td><input name="deposit" value="deposit" type="submit"></td>
              </tr>
              <tr>
                <td>Withdraw cash:</td>
                <td><input name="withdrawalAmount" type="text"></td>
                <td>&nbsp;</td><td><input name="withdraw" value="withdraw" type="submit"></td>
              </tr>
          </table>
        </form>
       <div><span style="color: red;"><%=errorMessage%></span></div>
    </div>
</body>
</html>