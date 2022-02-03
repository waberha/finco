package framework.ui.template;

public class WithdrawMoneyDialogListener implements java.awt.event.ActionListener {

    WithdrawMoneyDialogTemplate dialogTemplate;

    public void actionPerformed(java.awt.event.ActionEvent event) {
        Object object = event.getSource();
        if (object == dialogTemplate.JButton_OK)
            dialogTemplate.JButtonOK_actionPerformed(event);
        else if (object == dialogTemplate.JButton_Calcel)
            dialogTemplate.JButtonCalcel_actionPerformed(event);
    }

    public void setDialogTemplate(WithdrawMoneyDialogTemplate dialogTemplate) {
        this.dialogTemplate = dialogTemplate;
    }
}
