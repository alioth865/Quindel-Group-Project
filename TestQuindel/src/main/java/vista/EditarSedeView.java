package vista;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controlador.EditarSedeController;
import modelo.Ciudad;
import modelo.SedeJJOO;
import modelo.TipoJJOO;

public class EditarSedeView extends Composite {
	private Text text;
	private SedeJJOO sede;
	private EditarSedeController controller;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	/**
	 * @param parent
	 * @param style
	 * @param sede
	 */
	public EditarSedeView(Composite parent, int style, SedeJJOO sede) {
		super(parent, style);
		setLayout(null);
		this.sede = sede;
		this.controller = new EditarSedeController();

		Label lblAo = new Label(this, SWT.NONE);
		lblAo.setBounds(80, 10, 28, 15);
		lblAo.setText("Año");

		text = new Text(this, SWT.BORDER);
		text.setBounds(114, 7, 91, 21);
		text.setEnabled(false);
		text.setText(sede.getAÑO() + "");

		Label lblCiudad = new Label(this, SWT.NONE);
		lblCiudad.setBounds(70, 37, 38, 15);
		lblCiudad.setText("Ciudad");

		final Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(114, 34, 91, 23);
		int pos = -1;
		int cont = 0;
		for (Ciudad c : controller.todasCiudad()) {
			combo.add(c.getNOMBRE_CIUDAD());
			combo.setData(c.getNOMBRE_CIUDAD(), c.getID_CIUDAD());
			if (c.getID_CIUDAD() == sede.getSEDE()) {
				pos = cont;
			}
			cont++;
		}
		System.out.println(pos);
		combo.select(pos);

		Label lblTipoDeOlimpias = new Label(this, SWT.READ_ONLY);
		lblTipoDeOlimpias.setBounds(17, 66, 91, 15);
		lblTipoDeOlimpias.setText("Tipo de Olimpias");

		final Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(114, 63, 91, 23);
		combo_1.setEnabled(false);

		pos = -1;
		cont = 0;
		for (TipoJJOO t : controller.todosTiposJJOO()) {
			combo_1.add(t.getDESCRIPCION_TIPO());
			combo_1.setData(t.getDESCRIPCION_TIPO(), t.getID_TIPO_JJOO());
			if (t.getID_TIPO_JJOO() == sede.getID_TIPO_JJOO()) {
				pos = cont;
			}
			cont++;
		}
		System.out.println(pos);
		combo_1.select(pos);

		Button btnNewButton = new Button(this, SWT.NONE);
		final Shell s = parent.getShell();
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int año = Integer.parseInt(text.getText());
				int sede = ((Integer) combo_1.getData(combo_1.getText()));
				int tipo = ((Integer) combo.getData(combo.getText()));
				controller.editarSede(new SedeJJOO(año, sede, tipo));
				s.close();
				System.out.println("EDITADO");
			}
		});
		btnNewButton.setBounds(80, 92, 75, 38);
		btnNewButton.setText("Editar Sede");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
