package es.gabriel.Controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import es.gabriel.Modelo.Conexion;
import es.gabriel.Vista.*;

public class ControladorInv extends WindowAdapter {

	public ControladorInv(VentanaPrincipal miventana) {
		this.miventana = miventana;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		cargarTabla();
		//System.out.println("hola");
	}

	
	public void cargarTabla() {
		miconexion = new Conexion();

		ResultSet mirs = miconexion.getRegistros();

		modeloTabla modelo = new modeloTabla(mirs);

		miventana.tabla.setModel(modelo);

	}

	private VentanaPrincipal miventana;
	private Conexion miconexion;
}
