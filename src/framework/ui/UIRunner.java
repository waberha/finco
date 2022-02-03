package framework.ui;

import framework.Controller;
import framework.FinCo;
import framework.ui.plugin.*;
import framework.ui.template.MainframeTemplate;

import javax.swing.*;
import java.util.Optional;

public class UIRunner {

    private MainframeTemplate mainFrameTemplate;

    public Controller run(FinCo finCo) {
        mainFrameTemplate.setVisible(true);
        return finCo.run();
    }

    private UIRunner(UIRunnerBuilder builder) {

        try {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            mainFrameTemplate = new MainframeTemplate(
                    Optional.ofNullable(builder.mainFrameTemplatePlugin).orElse(new MainframeTemplatePlugin()),
                    Optional.ofNullable(builder.addAccountDialogPlugin).orElse(new AddAccountDialogPlugin()),
                    Optional.ofNullable(builder.depositMoneyDialogPlugin).orElse(new DepositMoneyDialogPlugin()),
                    Optional.ofNullable(builder.withdrawMoneyDialogPlugin).orElse(new WithdrawMoneyDialogPlugin())
            );

        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    public static class UIRunnerBuilder {

        private MainframeTemplatePlugin mainFrameTemplatePlugin;
        private AddAccountDialogPlugin addAccountDialogPlugin;
        private DepositMoneyDialogPlugin depositMoneyDialogPlugin;
        private WithdrawMoneyDialogPlugin withdrawMoneyDialogPlugin;

        public UIRunnerBuilder dialogPlugin(MainframeTemplatePlugin dialogPlugin) {
            mainFrameTemplatePlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(AddAccountDialogPlugin dialogPlugin) {
            addAccountDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(DepositMoneyDialogPlugin dialogPlugin) {
            depositMoneyDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(WithdrawMoneyDialogPlugin dialogPlugin) {
            withdrawMoneyDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunner build() {
            return new UIRunner(this);
        }
    }
}
