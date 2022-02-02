package ui.plugin;

public class MainFrameDialogPlugin extends DialogPlugin {

    public String getDialogName() {
        return "FinCo";
    }

    public String getPersonalAccountButtonName() {
        return "Add personal account";
    }

    public String getOrganizationAccountButtonName() {
        return "Add company account";
    }

    public String getWithdrawButtonName() {
        return "Withdraw";
    }

    public String getDepositButtonName() {
        return "Deposit";
    }
}
