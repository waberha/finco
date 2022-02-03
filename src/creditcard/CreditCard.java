package creditcard;

import creditcard.ui.plugin.CCardMainframeDialogPlugin;
import framework.FinCo;
import framework.ui.UIRunner;

public class CreditCard {

    public static void main(String[] args) {

        UIRunner uiRunner = new UIRunner.UIRunnerBuilder()
                .dialogPlugin(new CCardMainframeDialogPlugin())
                .build();

        FinCo finCo = new FinCo.FinCoBuilder().build();
        uiRunner.run(finCo);
    }
}
