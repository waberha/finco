package framework.ui.plugin;

import framework.ui.template.MainframeListener;

import java.awt.*;

public class MainframeTemplatePlugin extends DialogPlugin {

    @Override
    public String getDialogName() {
        return "FinCo";
    }

    public String getAddAccountLabel() {
        return "Add account";
    }

    public Component getTopPanel() {
        return null;
    }

    public String getDepositButtonLabel() {
        return "Deposit";
    }

    public String getWithdrawButtonLabel() {
        return "Withdraw";
    }

    public String getAddInterestButtonLabel() {
        return "Add interest";
    }

    public MainframeListener getMainframeListener() {
        return new MainframeListener();
    }
}
