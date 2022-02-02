package creditcard.ui.plugin;

import framework.ui.plugin.MainFrameDialogPlugin;

public class MainFrameCCardDialogPlugin extends MainFrameDialogPlugin {

    @Override
    public String getDialogName() {
        return "Credit Card Processing Application";
    }

    @Override
    public String getWithdrawButtonName() {
        return "Charge";
    }
}
