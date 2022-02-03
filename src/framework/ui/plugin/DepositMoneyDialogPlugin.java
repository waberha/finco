package framework.ui.plugin;

import framework.ui.template.DepositMoneyDialogListener;

public class DepositMoneyDialogPlugin extends DialogPlugin{

    @Override
    public String getDialogName() {
        return "Deposit";
    }

    public String getAccountNoLabel() {
        return "Acc nN";
    }

    public DepositMoneyDialogListener getDepositMoneyDialogListener() {
        return new DepositMoneyDialogListener();
    }
}
