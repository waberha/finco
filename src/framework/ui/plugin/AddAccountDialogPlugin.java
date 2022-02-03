package framework.ui.plugin;

import framework.ui.template.AddAccountDialogListener;

import java.awt.*;

public class AddAccountDialogPlugin extends DialogPlugin{

    @Override
    public String getDialogName() {
        return "Add account";
    }

    public Component getTopPanel() {
        return null;
    }

    public AddAccountDialogListener getAddAccountDialogListener() {
        return new AddAccountDialogListener();
    }
}
