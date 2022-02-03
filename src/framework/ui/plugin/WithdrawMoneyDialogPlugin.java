package framework.ui.plugin;

import framework.ui.template.WithdrawMoneyDialogListener;

public class WithdrawMoneyDialogPlugin extends DialogPlugin{

    @Override
    public String getDialogName() {
        return "Withdraw";
    }

    public String getAccountNoLabel() {
        return "Acc Nr";
    }

    public WithdrawMoneyDialogListener getWithdrawDialogListener() {
        return new WithdrawMoneyDialogListener();
    }
}
