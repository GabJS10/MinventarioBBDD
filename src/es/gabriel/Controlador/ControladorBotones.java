package es.gabriel.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.gabriel.Modelo.Conexion;
import es.gabriel.Modelo.Producto;
import es.gabriel.Vista.VentanaActualizar;
import es.gabriel.Vista.VentanaInsertar;
import es.gabriel.Vista.VentanaPrincipal;
import es.gabriel.Vista.modeloTabla;

public class ControladorBotones implements ActionListener{
	
	public ControladorBotones(VentanaPrincipal miventanaP) {
		this.miventanaP = miventanaP;
	}
	
	
	
	public ControladorBotones(VentanaInsertar miventanaInsertar) {
		this.miventanaInsertar = miventanaInsertar;
	}
	
	
	

	public ControladorBotones(VentanaActualizar miventanaAct) {
		super();
		this.miventanaAct = miventanaAct;
	}



	public ControladorBotones(VentanaActualizar miventanaAct, VentanaPrincipal miventanaP) {
		this.miventanaP = miventanaP;
		this.miventanaAct = miventanaAct;
	}

 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals(" Insertar ")) {
			miventanaInsertar.setVisible(true);
		}else if (e.getActionCommand().equals("Ok")) {
			String nombre = miventanaInsertar.txtnombre.getText();
			String descripcion = miventanaInsertar.txtdescripcion.getText();
			Double precio = ((Number) miventanaInsertar.txtprecio.getValue()).doubleValue();
			int cantidad = Integer.parseInt(miventanaInsertar.cantidades.getValue().toString());
			
			Producto producto = new Producto(cantidad,nombre,descripcion,precio);
			miconexion = new Conexion();
			
			miconexion.registrar(producto);
			
			System.out.println(producto);
			miventanaInsertar.setVisible(false);
			
		}else if (e.getActionCommand().equals(" Eliminar ")) {
			int id = ((Number) miventanaP.selectCodigo.getValue()).intValue();
			
			miconexion = new Conexion();
			try {
				miconexion.eliminar(id);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "El registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			modelo = new modeloTabla(miconexion.getRegistros());
			miventanaP.tabla.setModel(modelo);
			
		}else if (e.getActionCommand().equals("Actualizar")) {
			if (miventanaP.selectCodigo.getValue()!=null) {
				//System.out.println(miventanaP.selectCodigo.getText());
				//miventanaAct.codigo.setText(miventanaP.selectCodigo.getText());
				miconexion = new Conexion();
				try {
					Producto p_aux = miconexion.getProducto(miventanaP.selectCodigo.getText());
					miventanaAct.codigo.setText(miventanaP.selectCodigo.getText());
					miventanaAct.txtnombre.setText(p_aux.getNombre());
					miventanaAct.txtdescripcion.setText(p_aux.getDescripcion());
					miventanaAct.cantidades.setValue(p_aux.getCantidad());
					miventanaAct.txtprecio.setValue(p_aux.getPrecio());
					miventanaAct.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "El registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}else {
				
				JOptionPane.showMessageDialog(miventanaP, "Escriba el codigo del producto a actualizar",null,JOptionPane.ERROR_MESSAGE);

			}
		}else if (e.getActionCommand().equals("Actualizar producto")) {
			System.out.println(miventanaAct.codigo.getText());
			
			int id = Integer.parseInt(miventanaAct.codigo.getText());
			String nombre = miventanaAct.txtnombre.getText();
			String descripcion = miventanaAct.txtdescripcion.getText();
			int cantidad = Integer.parseInt(miventanaAct.cantidades.getValue().toString());
			double precio = ((Number) miventanaAct.txtprecio.getValue()).intValue();
			
			Producto p = new Producto(id,cantidad,nombre,descripcion,precio);
			
			miconexion = new Conexion();
			
			miconexion.actualizar(p);
			
			miventanaAct.setVisible(false);
		}
		
		
	}
	
	private VentanaActualizar miventanaAct;
	private modeloTabla modelo;
	private Conexion miconexion;
	private VentanaPrincipal miventanaP;
	private VentanaInsertar miventanaInsertar;

}
