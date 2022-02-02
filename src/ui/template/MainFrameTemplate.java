package ui.template;

import ui.plugin.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * A basic JFC based application.
 **/
public final class MainFrameTemplate extends JFrame {
    /****
     * init variables in the object
     ****/
    String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainFrameTemplate myframe;
    private Object rowdata[];

    private DepositDialogPlugin depositDialogPlugin;
    private WithdrawDialogPlugin withdrawDialogPlugin;
    private AddPersonalAccountDialogPlugin addPersonalAccountDialogPlugin;
    private AddOrganizationAccountDialogPlugin addOrganizationAccountDialogPlugin;
    private MainFrameDialogPlugin mainFrameDialogPlugin;



    public MainFrameTemplate(DepositDialogPlugin depositDialogPlugin,
                             WithdrawDialogPlugin withdrawDialogPlugin,
                             AddPersonalAccountDialogPlugin addPersonalAccountDialogPlugin,
                             AddOrganizationAccountDialogPlugin addOrganizationAccountDialogPlugin,
                             MainFrameDialogPlugin mainFrameDialogPlugin) {

        myframe = this;

        this.depositDialogPlugin = depositDialogPlugin;
        this.withdrawDialogPlugin = withdrawDialogPlugin;
        this.addPersonalAccountDialogPlugin = addPersonalAccountDialogPlugin;
        this.addOrganizationAccountDialogPlugin = addOrganizationAccountDialogPlugin;
        this.mainFrameDialogPlugin = mainFrameDialogPlugin;


        setTitle(mainFrameDialogPlugin.getDialogName());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

        JButton_PerAC.setText(mainFrameDialogPlugin.getPersonalAccountButtonName());
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        JButton_CompAC.setText(mainFrameDialogPlugin.getOrganizationAccountButtonName());
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 190, 33);
        JButton_Deposit.setText(mainFrameDialogPlugin.getDepositButtonName());
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText(mainFrameDialogPlugin.getWithdrawButtonName());
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
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
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);

    }

    JPanel JPanel1 = new JPanel();
    JButton JButton_PerAC = new JButton();
    JButton JButton_CompAC = new JButton();
    JButton JButton_Deposit = new JButton();
    JButton JButton_Withdraw = new JButton();
    JButton JButton_Addinterest = new JButton();
    JButton JButton_Exit = new JButton();

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(WindowEvent event) {
            Object object = event.getSource();
            if (object == MainFrameTemplate.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest)
                JButtonAddinterest_actionPerformed(event);

        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(ActionEvent event) {
        System.exit(0);
    }

    void JButtonPerAC_actionPerformed(ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/

        AddPersonalAccountDialogTemplate addPersonalAccountDialogTemplate = new AddPersonalAccountDialogTemplate(myframe, addPersonalAccountDialogPlugin);
        addPersonalAccountDialogTemplate.setBounds(450, 20, 300, 330);
        addPersonalAccountDialogTemplate.show();

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

    void JButtonCompAC_actionPerformed(ActionEvent event) {
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/

        AddOrganizationAccountDialogTemplate pac = new AddOrganizationAccountDialogTemplate(myframe, addOrganizationAccountDialogPlugin);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }

    }

    void JButtonDeposit_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            DepositDialogTemplate dep = new DepositDialogTemplate(myframe, accnr, depositDialogPlugin);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String) model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
            long newamount = currentamount + deposit;
            model.setValueAt(String.valueOf(newamount), selection, 5);
        }


    }

    void JButtonWithdraw_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
			WithdrawDialogTemplate wd = new WithdrawDialogTemplate(myframe, accnr, withdrawDialogPlugin);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

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

    void JButtonAddinterest_actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

    }
}
