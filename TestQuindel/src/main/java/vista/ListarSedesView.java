package vista;



import controlador.ListarSedesControler;
import modelo.SedeJJOO;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;

public class ListarSedesView extends Composite {
	private Table table;
	private ListarSedesControler controller;
	private Button btnNewButton;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ListarSedesView(final Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 349, 280);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		final Shell shell = parent.getShell();
		btnNewButton = new Button(this, SWT.NONE);
		final Shell principal = parent.getShell();
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				final Shell dialog = new Shell(shell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
				dialog.addListener(SWT.Close, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						ListarSedesView.this.borrando();
						ListarSedesView.this.refreshData(shell);
					}
				});
				dialog.setLayout(new RowLayout());
				dialog.setText("Crear Sede");
				CrearSedeView csv = new CrearSedeView(dialog, SWT.NONE);
				dialog.pack();
				dialog.open();

			}
		});
		btnNewButton.setBounds(365, 10, 75, 60);
		btnNewButton.setText("Crear Sede");

		String[] header = { "Año", "Tipo", "Ciudad", "Eliminar", "Modificar" };
		for (int i = 0; i < header.length; i++) {
			TableColumn column = new TableColumn(table, SWT.CENTER);
			column.setText(header[i]);
			column.setWidth(100);
			column.pack();
		}
		refreshData(shell);

	}

	public void borrando() {
		TableItem[] items = table.getItems();
		for (TableItem item : items) {
			TableEditor editor = (TableEditor) item.getData("ELIMINAR");
			editor.getEditor().dispose();
			editor.dispose();
			editor = (TableEditor) item.getData("EDITAR");
			editor.getEditor().dispose();
			editor.dispose();
			table.remove(table.indexOf(item));
		}
		table.removeAll();
	}

	public void refreshData(final Shell shell) {
		// Borrando y corrigiendo el bug visual

		controller = new ListarSedesControler();
		for (final SedeJJOO sedes : controller.allSedes()) {
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0, sedes.getAÑO() + "");
			item.setText(1, controller.getTipoJJOOById(sedes.getID_TIPO_JJOO()).getDESCRIPCION_TIPO());
			item.setText(2, controller.getCiudadById(sedes.getSEDE()).getNOMBRE_CIUDAD());
			// Añadiendo los botones
			// Boton Eliminar
			TableEditor teEliminar = new TableEditor(table);
			Button botonEliminar = new Button(table, SWT.PUSH);
			botonEliminar.setText("Eliminar");
			teEliminar.grabHorizontal = true;
			teEliminar.minimumHeight = botonEliminar.getSize().y;
			teEliminar.minimumWidth = botonEliminar.getSize().x;
			teEliminar.setEditor(botonEliminar, item, 3);
			item.setData("ELIMINAR",teEliminar);

			botonEliminar.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);

					messageBox.setText("Warning");
					messageBox.setMessage("Seguro quiere eliminar la sede");
					int buttonID = messageBox.open();
					switch (buttonID) {
					case SWT.OK:
						System.out.println("Eliminando " + sedes.getAÑO());
						controller.delete(sedes);
						ListarSedesView.this.borrando();
						ListarSedesView.this.refreshData(shell);
						break;
					case SWT.CANCEL:
						// does nothing ...
					}

				}
			});
			// Boton Editar
			TableEditor teEditar = new TableEditor(table);
			Button botonEditar = new Button(table, SWT.PUSH);
			botonEditar.setText("Editar");
			teEditar.grabHorizontal = true;
			teEditar.minimumHeight = botonEditar.getSize().y;
			teEditar.minimumWidth = botonEditar.getSize().x;
			teEditar.setEditor(botonEditar, item, 4);
			item.setData("EDITAR",teEditar);
			botonEditar.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					final Shell dialog = new Shell(shell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
					dialog.setLayout(new RowLayout());
					dialog.setText("Editar Sede");

					dialog.addListener(SWT.Close, new Listener() {

						@Override
						public void handleEvent(Event arg0) { // AQUI VA
							ListarSedesView.this.borrando();
							ListarSedesView.this.refreshData(shell);

						}
					});

					EditarSedeView esv = new EditarSedeView(dialog, SWT.NONE, sedes);
					dialog.pack();
					dialog.open();

				}
			});

		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
