package framework;

import framework.account.Account;
import framework.command.Command;
import framework.command.CommandManager;
import framework.command.impl.*;
import framework.customer.Customer;
import framework.reporting.ReportingStrategy;

public class Controller {

    protected final CommandManager commandManager;
    protected final CommandFactory commandFactory;

    // Package protecting constructor
    Controller(CommandManager commandManager, CommandFactory commandFactory){
        this.commandManager = commandManager;
        this.commandFactory = commandFactory;
    }

    public Account addCustomer(Customer customer, Account account) {
        CreateCustomerCommand command = commandFactory.createAddCustomerCommand(customer, account);
        commandManager.submit(command);
        return command.getAccount();
    }

    public void removeCustomer(String name) {
        RemoveCustomerCommand command = commandFactory.createRemoveCustomerCommand(name);
        commandManager.submit(command);
    }

    public Account addAccount(String name, Account account) {
        CreateAccountCommand command = commandFactory.createAddAccountCommand(name, account);
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
