package ui;

import ui.plugin.*;
import ui.template.MainFrameTemplate;

import javax.swing.*;
import java.util.Optional;

public class UIRunner {

    private MainFrameTemplate mainFrameTemplate;

    public void run() {
        mainFrameTemplate.setVisible(true);
    }

    private UIRunner(UIRunnerBuilder builder) {

        try {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

             mainFrameTemplate = new MainFrameTemplate(
                    Optional.ofNullable(builder.depositDialogPlugin).orElse(new DepositDialogPlugin()),
                    Optional.ofNullable(builder.withdrawDialogPlugin).orElse(new WithdrawDialogPlugin()),
                    Optional.ofNullable(builder.addPersonalAccountDialogPlugin).orElse(new AddPersonalAccountDialogPlugin()),
                    Optional.ofNullable(builder.addOrganizationAccountDialogPlugin).orElse(new AddOrganizationAccountDialogPlugin()),
                    Optional.ofNullable(builder.mainFrameDialogPlugin).orElse(new MainFrameDialogPlugin())
            );

        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    public static class UIRunnerBuilder {

        private MainFrameDialogPlugin mainFrameDialogPlugin;
        private AddOrganizationAccountDialogPlugin addOrganizationAccountDialogPlugin;
        private AddPersonalAccountDialogPlugin addPersonalAccountDialogPlugin;
        private DepositDialogPlugin depositDialogPlugin;
        private WithdrawDialogPlugin withdrawDialogPlugin;

        public UIRunnerBuilder dialogPlugin(MainFrameDialogPlugin dialogPlugin) {
            mainFrameDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(AddOrganizationAccountDialogPlugin dialogPlugin) {
            addOrganizationAccountDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(AddPersonalAccountDialogPlugin dialogPlugin) {
            addPersonalAccountDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(DepositDialogPlugin dialogPlugin) {
            depositDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunnerBuilder dialogPlugin(WithdrawDialogPlugin dialogPlugin) {
            withdrawDialogPlugin = dialogPlugin;
            return this;
        }

        public UIRunner build() {
            return new UIRunner(this);
        }
    }
}
