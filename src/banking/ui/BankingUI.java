package banking.ui;

import banking.ui.plugin.MainFrameBankingDialogPlugin;
import framework.ui.UIRunner;

public class BankingUI {

    public static void main(String[] args) {

        UIRunner uiRunner = new UIRunner.UIRunnerBuilder()
                .dialogPlugin(new MainFrameBankingDialogPlugin())
                .build();

        uiRunner.run();
    }
}
