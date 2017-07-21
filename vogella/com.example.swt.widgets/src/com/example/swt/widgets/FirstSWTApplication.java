package com.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FirstSWTApplication {

	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);

		createUi(display, shell);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static void createUi(Display display, Shell shell) {
		Label label = new Label(shell, SWT.BORDER);
		label.setText("This is a label:");
		label.setToolTipText("This is the tooltip of this label");
		Text text = new Text(shell, SWT.NONE);
		text.setText("This is the text in the label");
		text.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		text.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
		// Resize widgets to there preferred size
		text.pack();
		label.pack();
	}
}
