package es.gabriel.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import es.gabriel.Controlador.ControladorBotones;
import es.gabriel.Controlador.ControladorInv;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelIzquierda;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		// layouts, tamaño de el frame, bordes
		// look and feel del sistema
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
		contentPane.setLayout(new BorderLayout());
		panelIzquierda.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(contentPane, BorderLayout.CENTER);
		getContentPane().add(panelIzquierda, BorderLayout.EAST);
		// -----------------------------------------------------------------
		// panel para texto y textfield
		JPanel panelTexto = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel texto = new JLabel("Insertar codigo");
		NumberFormat formato = NumberFormat.getInstance();
		NumberFormatter reformato = new NumberFormatter(formato);
		reformato.setValueClass(Integer.class);
		reformato.setMinimum(0);
		reformato.setMaximum(Integer.MAX_VALUE);
		reformato.setAllowsInvalid(false);
		selectCodigo = new JFormattedTextField(reformato);
		selectCodigo.setColumns(10);
		panelTexto.add(texto);
		panelTexto.add(selectCodigo);

		panelIzquierda.add(panelTexto);

		// ----------------------------------------------------------------------
		// añadir botones, alineamiento en el centro, y dimensiones de los botones
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnActualizar.setPreferredSize(new Dimension(60, 30));
		panelIzquierda.add(btnActualizar);

		panelIzquierda.add(Box.createVerticalStrut(10));

		btnInsertar = new JButton(" Insertar ");
		btnInsertar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInsertar.setPreferredSize(new Dimension(60, 30));
		panelIzquierda.add(btnInsertar);

		panelIzquierda.add(Box.createVerticalStrut(10));

		btnEliminar = new JButton(" Eliminar ");
		btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEliminar.setPreferredSize(new Dimension(60, 30));
		panelIzquierda.add(btnEliminar);
		panelIzquierda.add(Box.createVerticalStrut(10));
		// -----------------------------------------------------------------------
		// añadir tabla
		tabla = new JTable(10, 8);
		JScrollPane deslizable = new JScrollPane(tabla);
		contentPane.add(deslizable, BorderLayout.CENTER);
		//metodos action
		

		addWindowListener(new ControladorInv(this));
		btnInsertar.addActionListener(new ControladorBotones(new VentanaInsertar()));
		btnEliminar.addActionListener(new ControladorBotones(this));
		btnActualizar.addActionListener(new ControladorBotones(new VentanaActualizar(),this));
	}

	public JButton btnActualizar;
	public JButton btnEliminar;
	public JButton btnInsertar;
	public JFormattedTextField selectCodigo;
	public JTable tabla;
}


