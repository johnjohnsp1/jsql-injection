/*******************************************************************************
 * Copyhacked (H) 2012-2014.
 * This program and the accompanying materials
 * are made available under no term at all, use it like
 * you want, but share and discuss about it
 * every time possible with every body.
 * 
 * Contributors:
 *      ron190 at ymail dot com - initial implementation
 ******************************************************************************/
package com.jsql.view.swing.dialog;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.jsql.i18n.I18n;

/**
 * File chooser for supporting 'file already exists'.
 */
@SuppressWarnings("serial")
public class ReplaceFileChooser extends JFileChooser {
    /**
     * Create a file chooser with a replace confirm dialog. 
     * @param s
     */
    public ReplaceFileChooser(String s) {
        super(s);
    }
    
    @Override
    public void approveSelection() {
        File f = this.getSelectedFile();
        if (this.getDialogType() == SAVE_DIALOG) {
            if (f.exists()) {
                int result = JOptionPane.showConfirmDialog(this,
                        this.getSelectedFile().getName() + " " + I18n.DIALOG_REPLACE_FILE_CONFIRM,
                        I18n.DIALOG_REPLACE_FILE_TITLE,
                        JOptionPane.YES_NO_OPTION);
                switch (result) {
                    case JOptionPane.YES_OPTION:
                        super.approveSelection();
                        return;
                    case JOptionPane.NO_OPTION:
                        return;
                    case JOptionPane.CLOSED_OPTION:
                        return;
                    case JOptionPane.CANCEL_OPTION:
                        this.cancelSelection();
                        return;
                    default:
                        break;
                }
            } else {
                super.approveSelection();
            }
        }
    }
}
