package creditcard.ui;

import creditcard.ui.plugin.MainFrameCCardDialogPlugin;
import framework.ui.UIRunner;

public class CCardUI {

    public static void main(String[] args) {

        UIRunner uiRunner = new UIRunner.UIRunnerBuilder()
                .dialogPlugin(new MainFrameCCardDialogPlugin())
                .build();

        uiRunner.run();
    }
}
