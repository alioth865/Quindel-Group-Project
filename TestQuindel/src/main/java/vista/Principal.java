package vista;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

public class Principal {

	protected Shell shlIndelTest;
	private Composite contentPanel;
	private StackLayout stackLayout;
	private ConsultaEspecialView cev;
	private ListarSedesView lsv;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Principal window = new Principal();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlIndelTest.open();
		shlIndelTest.layout();
		while (!shlIndelTest.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIndelTest = new Shell();
		shlIndelTest.setSize(621, 300);
		shlIndelTest.setText("Indel Test");
		shlIndelTest.setLayout(null);
		
		Menu menu = new Menu(shlIndelTest, SWT.BAR);
		shlIndelTest.setMenuBar(menu);
		
		MenuItem mntmPanel = new MenuItem(menu, SWT.NONE);
		mntmPanel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				stackLayout.topControl=new ConsultaEspecialView(contentPanel, SWT.NONE);
				contentPanel.layout();
				
			}
		});
		mntmPanel.setText("Consulta Tarea 2");
		
		MenuItem mntmPanel_1 = new MenuItem(menu, SWT.NONE);
		mntmPanel_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				stackLayout.topControl=new ListarSedesView(contentPanel, SWT.NONE);
				contentPanel.layout();
			}
		});
		mntmPanel_1.setText("Listar Sedes");
			
		
		contentPanel = new Composite(shlIndelTest, SWT.NONE);
		contentPanel.setBounds(25, 25, 601, 280);
		stackLayout=new StackLayout();
		contentPanel.setLayout(stackLayout);
	}
}
