package es.gabriel.Vista;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class modeloTabla extends AbstractTableModel {

	public modeloTabla(ResultSet mirs) {
		try {
			this.mirs = mirs;

			this.metadatos = mirs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String getColumnName(int column) {
		try {
			
			return this.metadatos.getColumnName(column + 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public int getRowCount() {
		try {
			this.mirs.last();
			return this.mirs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	//cantidad de columnas
	@Override
	public int getColumnCount() {
		
		try {
			return this.metadatos.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		try {
			this.mirs.absolute(rowIndex + 1);
			return this.mirs.getObject(columnIndex+ 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	private ResultSet mirs;
	private ResultSetMetaData metadatos;

}
