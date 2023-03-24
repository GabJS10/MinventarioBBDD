package es.gabriel.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.text.NumberFormatter;

import es.gabriel.Controlador.ControladorBotones;

public class VentanaInsertar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaInsertar() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamaño = mipantalla.getScreenSize();
		int x = tamaño.width/4;
		int y = tamaño.height/4;
		
		setLocation(x, y);
		
		setSize(490,389);
		
		
		
		//----------------------------------------------------------

		JLabel nombre = new JLabel("Nombre: ");
		txtnombre = new JTextField(10);
		txtnombre.setColumns(10);
		txtnombre.setMaximumSize(txtnombre.getPreferredSize());
		Box cajaNombre = Box.createHorizontalBox();
		cajaNombre.add(nombre);
		cajaNombre.add(Box.createHorizontalStrut(10));
		cajaNombre.add(txtnombre);
		cajaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		//----------------------------------------------------------
		JLabel precio = new JLabel("Precio: ");
		NumberFormat formato = NumberFormat.getInstance();
		formato.setMaximumFractionDigits(2);
		formato.setMinimumFractionDigits(2);
		NumberFormatter reformato = new NumberFormatter(formato);
		reformato.setValueClass(Double.class);
		reformato.setAllowsInvalid(false);
		txtprecio = new JFormattedTextField(reformato);
		txtprecio.setColumns(10);
		txtprecio.setMaximumSize(txtprecio.getPreferredSize());
		Box cajaPrecio = Box.createHorizontalBox();
		cajaPrecio.add(precio);
		cajaPrecio.add(Box.createHorizontalStrut(10));
		cajaPrecio.add(txtprecio);
		cajaPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//----------------------------------------------
		
		JLabel cantidad = new JLabel("Cantidad: ");
		List<Integer> valores = new ArrayList<>();
		for (int i = 1; i <=100; i++) {
			valores.add(i);
		}
		
		SpinnerListModel  modelo = new SpinnerListModel(valores);
		
		cantidades = new JSpinner(modelo);
		cantidades.setMaximumSize(new Dimension(38,20));
		Box cajaCantidad = Box.createHorizontalBox();
		cajaCantidad.add(cantidad);
		cajaCantidad.add(Box.createHorizontalStrut(10));
		cajaCantidad.add(cantidades);
		cajaCantidad.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//---------------------------------------
		
		JLabel descripcion = new JLabel("Descripcion: ");
		txtdescripcion = new JTextArea();
		txtdescripcion.setRows(3);
		txtdescripcion.setColumns(30);
		txtdescripcion.setMaximumSize(txtdescripcion.getPreferredSize());
		Box cajaDesc = Box.createHorizontalBox();
		cajaDesc.add(descripcion);
		cajaDesc.add(Box.createHorizontalStrut(10));
		cajaDesc.add(txtdescripcion);
		cajaDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//---------------------------------------
		
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(cajaNombre);
		cajaVertical.add(cajaPrecio);
		cajaVertical.add(cajaCantidad);
		cajaVertical.add(cajaDesc);
		getContentPane().add(cajaVertical, BorderLayout.CENTER);
		
		//________________________________________
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ControladorBotones(this));
		add(btnOk, BorderLayout.SOUTH);
		
		
	}
	
	public JTextField txtnombre;
	public JFormattedTextField txtprecio;
	public JSpinner cantidades;
	public JButton btnOk;
	public JTextArea txtdescripcion;
}
