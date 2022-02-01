package framework;

import framework.account.Account;
import framework.party.Party;
import framework.reporting.ReportingStrategy;

public class Controller {

    public Account createParty(Party party, Account account) {
        //TODO
        return null;
    }

    public void removeParty(Party party) {
        //TODO
    }

    public Account createAccount(String name, Account account) {
        //TODO
        return null;
    }

    public void removeAccount(String accountNo) {
        //TODO
    }

    public void withdrawMoney(String accountNo, double amount) {
        //TODO
    }

    public void depositMoney(String accountNo, double amount) {
        //TODO
    }

    public String generateReport(ReportingStrategy reportingStrategy) {
        return reportingStrategy.generateReport();
    }
}
