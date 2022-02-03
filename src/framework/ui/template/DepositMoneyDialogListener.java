package framework.ui.template;

public class DepositMoneyDialogListener implements java.awt.event.ActionListener {

    DepositMoneyDialogTemplate dialogTemplate;

    public void actionPerformed(java.awt.event.ActionEvent event) {
        Object object = event.getSource();
        if (object == dialogTemplate.JButton_OK)
            dialogTemplate.JButtonOK_actionPerformed(event);
        else if (object == dialogTemplate.JButton_Cancel)
            dialogTemplate.JButtonCalcel_actionPerformed(event);
    }


    public void setDialogTemplate(DepositMoneyDialogTemplate dialogTemplate) {
        this.dialogTemplate = dialogTemplate;
    }
}
