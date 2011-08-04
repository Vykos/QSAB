/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import com.sigma.qsab.data.Customer;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ext.jonas.frogvall
 */
public class ViewCustomerPanel extends JPanel {
    private final static int x = GUIFields.W_APP/2 - GUIFields.W_TEXTAREA/2;
    private final static int y = GUIFields.H_APP/2 - GUIFields.H_TEXTAREA/2;
    
    private JTextArea textArea;
    private Customer customer;
    
    public ViewCustomerPanel(GUIStrings strings, ActionListener al) {        
        setBackground(GUIFields.BGCOLOR);
        setLayout(null);        
        textArea = ComponentMaker.makeTextArea("", new Point(x,y), "area_customer");
        add(textArea);
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.LOGOUT),
                new Point(64, 688), al, "viewcustomer_logout"));        
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
        textArea.setText(customer.toString());
    }
}
