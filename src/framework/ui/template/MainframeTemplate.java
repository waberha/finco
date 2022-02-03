package framework.ui.template;

import framework.ui.plugin.AddAccountDialogPlugin;
import framework.ui.plugin.DepositMoneyDialogPlugin;
import framework.ui.plugin.MainframeTemplatePlugin;
import framework.ui.plugin.WithdrawMoneyDialogPlugin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Optional;

public final class MainframeTemplate extends javax.swing.JFrame {
    /****
     * init variables in the object
     ****/
    String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainframeTemplate myframe;
    private Object rowdata[];

    private final AddAccountDialogTemplate addAccountDialogTemplate;
    private final DepositMoneyDialogTemplate depositMoneyDialogTemplate;
    private final WithdrawMoneyDialogTemplate withdrawMoneyDialogTemplate;


    public MainframeTemplate(
            MainframeTemplatePlugin templatePlugin,
            AddAccountDialogPlugin addAccountDialogPlugin,
            DepositMoneyDialogPlugin depositMoneyDialogPlugin,
            WithdrawMoneyDialogPlugin withdrawMoneyDialogPlugin
    ) {

        myframe = this;

        this.addAccountDialogTemplate = new AddAccountDialogTemplate(this, addAccountDialogPlugin, addAccountDialogPlugin.getAddAccountDialogListener());
        this.depositMoneyDialogTemplate = new DepositMoneyDialogTemplate(this, depositMoneyDialogPlugin, depositMoneyDialogPlugin.getDepositMoneyDialogListener(), accountnr);
        this.withdrawMoneyDialogTemplate = new WithdrawMoneyDialogTemplate(this, withdrawMoneyDialogPlugin, withdrawMoneyDialogPlugin.getWithdrawDialogListener(), accountnr);
        MainframeListener frameListener = templatePlugin.getMainframeListener();

        setTitle(templatePlugin.getDialogName());
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 582, 322);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AcctNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount = false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 440, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 422, 0);
//        rowdata = new Object[8];

        JButton_PerAC.setText(templatePlugin.getAddAccountLabel());
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);

        Optional.ofNullable(templatePlugin.getTopPanel()).ifPresent(JPanel1::add);
        JButton_Deposit.setText(templatePlugin.getDepositButtonLabel());
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText(templatePlugin.getWithdrawButtonLabel());
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText(templatePlugin.getAddInterestButtonLabel());
        JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 30);
        // lineBorder1.setRoundedCorners(true);
        // lineBorder1.setLineColor(java.awt.Color.green);
        //$$ lineBorder1.move(24,312);

        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);

        frameListener.setMainframeTemplate(this);
        JButton_Exit.addActionListener(frameListener);
        JButton_PerAC.addActionListener(frameListener);
        JButton_Deposit.addActionListener(frameListener);
        JButton_Withdraw.addActionListener(frameListener);
        JButton_Addinterest.addActionListener(frameListener);

    }


    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    //    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == MainframeTemplate.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }


    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

//        JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
        addAccountDialogTemplate.setBounds(450, 20, 300, 330);
        addAccountDialogTemplate.show();

        if (newaccount) {
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "P";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }


    }

//    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
//		/*
//		 construct a JDialog_AddCompAcc type object
//		 set the boundaries and
//		 show it
//		*/
//
//        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
//        pac.setBounds(450, 20, 300, 330);
//        pac.show();
//
//        if (newaccount) {
//            // add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "C";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//            newaccount = false;
//        }
//
//    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            depositMoneyDialogTemplate.setBounds(430, 15, 275, 140);
            depositMoneyDialogTemplate.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String) model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
            long newamount = currentamount + deposit;
            model.setValueAt(String.valueOf(newamount), selection, 5);
        }


    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            withdrawMoneyDialogTemplate.setBounds(430, 15, 275, 140);
            withdrawMoneyDialogTemplate.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String) model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
            long newamount = currentamount - deposit;
            model.setValueAt(String.valueOf(newamount), selection, 5);
            if (newamount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }


    }

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

    }
}
