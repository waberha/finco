package banking.rule;

import framework.account.AccountEntry;
import framework.customer.IOrganization;
import framework.rule.Rule;

public class CompanyTransactionNotificationRule implements Rule<AccountEntry> {

    @Override
    public boolean isApplicable(AccountEntry entry) {
        return entry.getAccount().getCustomer() instanceof IOrganization;
    }

    @Override
    public void apply(AccountEntry entry) {

        boolean isWithdraw = entry.getAmount() < 0;

        String subject = (isWithdraw ? "Withdraw " : "Deposit ") + "notification";
        String message = String.format("A %s of %f is made to account no%s%n", isWithdraw ? "withdraw" : "deposit", entry.getAmount(), entry.getAccount().getAccountNo());
        entry.getAccount().getCustomer().emailCustomer(subject, message);
    }
}
