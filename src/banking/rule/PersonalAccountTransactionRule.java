package banking.rule;

import framework.account.AccountEntry;
import framework.customer.IPerson;
import framework.rule.Rule;

public class PersonalAccountTransactionRule implements Rule<AccountEntry> {

    @Override
    public boolean isApplicable(AccountEntry entry) {
        return entry.getAccount().getCustomer() instanceof IPerson
                && (Math.abs(entry.getAmount()) > 400 || entry.getAccount().getBalance() < 0);
    }

    @Override
    public void apply(AccountEntry entry) {

        boolean isDeposit = entry.getAmount() > 0;

        String subject = (isDeposit ? "Deposit " : "Withdraw ") + "notification";
        String message = String.format("A %s of %f is made to account no%s%n", isDeposit ? "deposit" : "withdraw", entry.getAmount(), entry.getAccount().getAccountNo());
        entry.getAccount().getCustomer().emailCustomer(subject, message);
    }
}
