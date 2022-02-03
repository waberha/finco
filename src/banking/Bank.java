package banking;

import banking.rule.CompanyTransactionNotificationRule;
import banking.rule.PersonalAccountTransactionRule;
import banking.ui.plugin.BankMainframePlugin;
import framework.FinCo;
import framework.ui.UIRunner;

public class Bank {

    public static void main(String[] args) {

        UIRunner uiRunner = new UIRunner.UIRunnerBuilder()
                .dialogPlugin(new BankMainframePlugin())
                .build();

        FinCo finCo = new FinCo.FinCoBuilder()
                .accountEntryRule(new CompanyTransactionNotificationRule())
                .accountEntryRule(new PersonalAccountTransactionRule())
                .build();

        uiRunner.run(finCo);
    }
}
