package vista;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controlador.ConsultaEspecialControler;

import org.eclipse.swt.SWT;

public class ConsultaEspecialView extends Composite {
	private Table table;
	private ConsultaEspecialControler cec;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ConsultaEspecialView(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(25, 25, 601, 280);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		String[] titles = { "ID PAIS", "NOMBRE PAIS", "ID CIUDAD", "NOMBRE CIUDAD", "VALOR", "DESCRIPCION TIPO",
				"CANTIDAD" };
		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(titles[loopIndex]);
		}
		
		cec=new ConsultaEspecialControler();
		
		for (String[] s:cec.getConsulta()) {
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0,s[0]);
			item.setText(1,s[1]);
			item.setText(2,s[2]);
			item.setText(3,s[3]);
			item.setText(4,s[4]);
			if(s[5]==null){
				item.setText(5,"NULL");
			}else{
				item.setText(5,s[5]);
			}
			
			item.setText(6,s[6]);
			
		}

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			table.getColumn(loopIndex).pack();
		}

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
