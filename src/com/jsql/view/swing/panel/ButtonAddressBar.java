/*******************************************************************************
 * Copyhacked (H) 2012-2014.
 * This program and the accompanying materials
 * are made available under no term at all, use it like
 * you want, but share and discuss about it
 * every time possible with every body.
 *
 * Contributors:
 *      ron190 at ymail dot com - initial implementation
 *******************************************************************************/
package com.jsql.view.swing.panel;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.jsql.view.swing.HelperGUI;

/**
 * A button displayed in address.
 */
@SuppressWarnings("serial")
public class ButtonAddressBar extends JButton {
    /**
     * State of current injection.
     */
    private String state = "Connect";

    /**
     * Return the current state of current process.
     * @return State of process
     */
    public String getState() {
        return this.state;
    }
    
    /**
     * Icon for loading process.
     */
    private static final Icon ARROWDEFAULT = new ImageIcon(ButtonAddressBar.class.getResource("/com/jsql/view/swing/images/arrowDefault.png"));

    /**
     * Icon rollover for loading process.
     */
    private static final Icon ARROWROLLOVER = new ImageIcon(ButtonAddressBar.class.getResource("/com/jsql/view/swing/images/arrowRollover.png"));

    /**
     * Icon pressed for loading process.
     */
    private static final Icon ARROWPRESSED = new ImageIcon(ButtonAddressBar.class.getResource("/com/jsql/view/swing/images/arrowPressed.png"));

    /**
     * Create a button in address bar.
     */
    public ButtonAddressBar() {
        this.setPreferredSize(new Dimension(18, 16));
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        
        // turn on before rollovers work
        this.setRolloverEnabled(true);
        this.setIcon(ButtonAddressBar.ARROWDEFAULT);
        this.setRolloverIcon(ButtonAddressBar.ARROWROLLOVER);
        this.setPressedIcon(ButtonAddressBar.ARROWPRESSED);
    }

    /**
     * Replace button with Stop icon ; user can stop current process.
     */
    public void setInjectionReady() {
        this.state = "Connect";
        this.setEnabled(true);
        
        // turn on before rollovers work
        this.setRolloverEnabled(true);
        this.setIcon(ButtonAddressBar.ARROWDEFAULT);
        this.setRolloverIcon(ButtonAddressBar.ARROWROLLOVER);
        this.setPressedIcon(ButtonAddressBar.ARROWPRESSED);
    }

    /**
     * Replace button with Stop icon ; user can stop current process.
     */
    public void setInjectionRunning() {
        this.state = "Stop";
        this.setEnabled(true);
        
        // turn on before rollovers work
        this.setRolloverEnabled(true);
        this.setIcon(new ImageIcon(this.getClass().getResource("/com/jsql/view/swing/images/stopDefault.png")));
        this.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/jsql/view/swing/images/stopRollover.png")));
        this.setPressedIcon(new ImageIcon(this.getClass().getResource("/com/jsql/view/swing/images/stopPressed.png")));
    }

    /**
     * Replace button with an animated GIF until injection process
     * is finished ; user waits the end of process.
     */
    public void setInjectionStopping() {
        this.state = "Stopping...";
        
        // turn on before rollovers work
        this.setRolloverEnabled(false);
        this.setIcon(HelperGUI.LOADER_GIF);
        this.setEnabled(false);
    }
}
