package vista;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import controlador.CrearSedeController;
import modelo.Ciudad;
import modelo.SedeJJOO;
import modelo.TipoJJOO;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CrearSedeView extends Composite {
	private Text text;
	CrearSedeController controller;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public CrearSedeView(Composite parent, int style) {
		super(parent, style);
		controller = new CrearSedeController();
		setLayout(null);

		Label lblAo = new Label(this, SWT.NONE);
		lblAo.setBounds(80, 10, 28, 15);
		lblAo.setText("Año");

		text = new Text(this, SWT.BORDER);
		text.setBounds(114, 7, 91, 21);

		Label lblCiudad = new Label(this, SWT.NONE);
		lblCiudad.setBounds(70, 37, 38, 15);
		lblCiudad.setText("Ciudad");

		final Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(114, 34, 91, 23);
		for (Ciudad c : controller.todasCiudad()) {
			combo.add(c.getNOMBRE_CIUDAD());
			combo.setData(c.getNOMBRE_CIUDAD(), c.getID_CIUDAD());
		}
		combo.select(0);

		Label lblTipoDeOlimpias = new Label(this, SWT.NONE);
		lblTipoDeOlimpias.setBounds(17, 66, 91, 15);
		lblTipoDeOlimpias.setText("Tipo de Olimpidas");

		final Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(114, 63, 91, 23);
		for (TipoJJOO tipoJO : controller.todosTiposJJOO()) {
			combo_1.add(tipoJO.getDESCRIPCION_TIPO());
			combo_1.setData(tipoJO.getDESCRIPCION_TIPO(), tipoJO.getID_TIPO_JJOO());
		}
		combo_1.select(0);

		Button btnNewButton = new Button(this, SWT.NONE);
		final Shell s = parent.getShell();
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (text.getText().trim().length() != 0) {
					try {
						int año = Integer.parseInt(text.getText());
						int sede = ((Integer) combo_1.getData(combo_1.getText()));
						int tipo = ((Integer) combo.getData(combo.getText()));
						controller.crearSede(new SedeJJOO(año, sede, tipo));
						s.close();
					} catch (NumberFormatException nfe) {
						text.forceFocus();
						MessageBox messageBox = new MessageBox(s,
								SWT.ICON_WARNING | SWT.OK);

						messageBox.setText("Warning");
						messageBox.setMessage("El año es un campo numérico");
						messageBox.open();
					}

				}
			}
		});
		btnNewButton.setBounds(80, 92, 75, 38);
		btnNewButton.setText("Crear Sede");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
