package creditcard.ui.plugin;


import framework.ui.plugin.MainframeTemplatePlugin;

public class CCardMainframeDialogPlugin extends MainframeTemplatePlugin {

    @Override
    public String getDialogName() {
        return "Credit Card Processing Application";
    }

    @Override
    public String getWithdrawButtonLabel() {
        return "Charge";
    }
}
