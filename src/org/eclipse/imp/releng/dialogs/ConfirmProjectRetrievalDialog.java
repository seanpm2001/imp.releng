package org.eclipse.imp.releng.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class ConfirmProjectRetrievalDialog extends Dialog {
    private final List<String> fProjectNames;

    public ConfirmProjectRetrievalDialog(Shell parentShell, List<String> projectNames) {
        super(parentShell);
        fProjectNames= projectNames;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        // create OK and Cancel buttons by default
        createButton(parent, IDialogConstants.OK_ID, "Proceed", true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Retrieve projects?");
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        final Composite area= (Composite) super.createDialogArea(parent);

        org.eclipse.swt.widgets.List projectList= new org.eclipse.swt.widgets.List(area, SWT.SINGLE);

        for(String projectName: fProjectNames) {
            projectList.add(projectName);
        }
        return area;
    }
}
