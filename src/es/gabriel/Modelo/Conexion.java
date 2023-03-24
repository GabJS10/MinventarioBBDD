package es.gabriel.Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	public Conexion() {
	}

	public Connection getConnection() {

		try {
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return miconexion;

	}

	// metodo para obtener un producto (), recibira por parametro el id del producto
	// a obtener

	public Producto getProducto(String codigoProducto) throws Exception{
		Connection miconexion = getConnection();
		CallableStatement miprocedimiento = null;
		ResultSet mirs = null;
		Producto p = null;
		

			miprocedimiento = miconexion.prepareCall("{call dameProducto(?)}");

			miprocedimiento.setString(1, codigoProducto);

			mirs = miprocedimiento.executeQuery();

			if (mirs.next()) {
				int id = mirs.getInt(1);
				String nombre = mirs.getString(2);
				String descripcion = mirs.getString(3);
				int cantidad = mirs.getInt(4);
				double precio = mirs.getDouble(5);

				p = new Producto(id, cantidad, nombre, descripcion, precio);

			}
			
		miconexion.close();	
		
		return p;
	}

	// metodo para eliminar, este metodo sera void, recibira el id del producto a
	// eliminar

	public void eliminar(int id) throws Exception{

		Connection miconexion = getConnection();
		CallableStatement miprocedimiento = null;


			miprocedimiento = miconexion.prepareCall("{call eliminar(?)}");
			miprocedimiento.setInt(1, id);

			miprocedimiento.execute();

			miconexion.close();

		

	}

	// metodo para obtener todos los registros, devuelve un ResultSet que usaremos
	// para pasarle al modelo de la tabla

	public ResultSet getRegistros() {
		// lo que necesitamos
		Connection miconexion = getConnection();
		CallableStatement miprocedimiento = null;
		ResultSet mirs = null;
		try {

			miprocedimiento = miconexion.prepareCall("{call mostrar_productos()}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			if (miprocedimiento != null)
				return mirs = miprocedimiento.executeQuery();
			;

			miconexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// metodo para actualizar, void, recibira por parametro el producto a actualizar

	public void actualizar(Producto p) {
		Connection miconexion = getConnection();
		CallableStatement miprocedimiento = null;

		try {

			miprocedimiento = miconexion.prepareCall("{call actualizarProducto(?,?,?,?,?)}");

			miprocedimiento.setInt(1, p.getId());
			miprocedimiento.setString(2, p.getNombre());
			miprocedimiento.setString(3, p.getDescripcion());
			miprocedimiento.setInt(4, p.getCantidad());
			miprocedimiento.setDouble(5, p.getPrecio());

			miprocedimiento.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// metodo para crear un registro, recibira por parametro el producto a registrar
	public void registrar(Producto p) {
		Connection miconexion = getConnection();
		CallableStatement miprocedimiento = null;

		try {
			miprocedimiento = miconexion.prepareCall("{call insertar(?,?,?,?)}");

			miprocedimiento.setString(1, p.getNombre());
			miprocedimiento.setString(2, p.getDescripcion());
			miprocedimiento.setInt(3, p.getCantidad());
			miprocedimiento.setDouble(4, p.getPrecio());

			miprocedimiento.execute();

			miconexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Connection miconexion = null;
	private PreparedStatement mipst;
}
