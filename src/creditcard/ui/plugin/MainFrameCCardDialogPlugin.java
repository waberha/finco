package creditcard.ui.plugin;

import ui.plugin.MainFrameDialogPlugin;

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
