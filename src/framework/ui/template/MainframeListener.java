package framework.ui.template;

public class MainframeListener implements java.awt.event.ActionListener {

    MainframeTemplate mainFrameTemplate;

    public void actionPerformed(java.awt.event.ActionEvent event) {
        Object object = event.getSource();
        if (object == mainFrameTemplate.JButton_Exit)
            mainFrameTemplate.JButtonExit_actionPerformed(event);
        else if (object == mainFrameTemplate.JButton_PerAC)
            mainFrameTemplate.JButtonPerAC_actionPerformed(event);
        else if (object == mainFrameTemplate.JButton_Deposit)
            mainFrameTemplate.JButtonDeposit_actionPerformed(event);
        else if (object == mainFrameTemplate.JButton_Withdraw)
            mainFrameTemplate.JButtonWithdraw_actionPerformed(event);
        else if (object == mainFrameTemplate.JButton_Addinterest)
            mainFrameTemplate.JButtonAddinterest_actionPerformed(event);

    }

    public void setMainframeTemplate(MainframeTemplate mainFrameTemplate) {
        this.mainFrameTemplate = mainFrameTemplate;
    }
}
