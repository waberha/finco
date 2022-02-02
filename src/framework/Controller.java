package framework;

import framework.account.Account;
import framework.command.Command;
import framework.command.CommandManager;
import framework.command.impl.*;
import framework.party.Party;
import framework.reporting.ReportingStrategy;

public class Controller {

    protected final CommandManager commandManager;
    protected final CommandFactory commandFactory;

    // Package protecting constructor
    Controller(CommandManager commandManager, CommandFactory commandFactory){
        this.commandManager = commandManager;
        this.commandFactory = commandFactory;
    }

    public Account createParty(Party party, Account account) {
        CreatePartyCommand command = commandFactory.createCreatePartyCommand(party, account);
        commandManager.submit(command);
        return command.getAccount();
    }

    public void removeParty(String name) {
        RemovePartyCommand command = commandFactory.createRemovePartyCommand(name);
        commandManager.submit(command);
    }

    public Account createAccount(String name, Account account) {
        CreateAccountCommand command = commandFactory.createCreateAccountCommand(name, account);
        commandManager.submit(command);
        return command.getAccount();
    }

    public void removeAccount(String accountNo) {
        RemoveAccountCommand command = commandFactory.createRemoveAccountCommand(accountNo);
        commandManager.submit(command);
    }

    public void withdrawMoney(String accountNo, double amount) {
        WithdrawMoneyCommand command = commandFactory.createWithdrawMoneyCommand(accountNo, amount);
        commandManager.submit(command);
    }

    public void depositMoney(String accountNo, double amount) {
        DepositMoneyCommand command = commandFactory.createDepositMoneyCommand(accountNo, amount);
        commandManager.submit(command);
    }

    public String generateReport(ReportingStrategy reportingStrategy) {
        return reportingStrategy.generateReport();
    }

    public void runCommand(Command<?> command) {
        commandManager.submit(command);
    }
}
