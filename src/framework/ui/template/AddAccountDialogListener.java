package framework.ui.template;

public class AddAccountDialogListener implements java.awt.event.ActionListener{

    AddAccountDialogTemplate dialogTemplate;

    public void actionPerformed(java.awt.event.ActionEvent event) {

        Object object = event.getSource();
        if (object == dialogTemplate.JButton_OK)
            dialogTemplate.JButtonOK_actionPerformed(event);
        else if (object == dialogTemplate.JButton_Cancel)
            dialogTemplate.JButtonCalcel_actionPerformed(event);
    }

    public void setDialogTemplate(AddAccountDialogTemplate dialogTemplate) {
        this.dialogTemplate = dialogTemplate;
    }
}
