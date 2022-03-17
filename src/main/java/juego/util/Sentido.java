package juego.util;

/**
 * Sentido para comprobar celdas adyacentes.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena</a>
 * @version 1.0 20181008
 * @see juego.modelo.Tablero
 */

/**
 *La enumeración Sentido contiene los ocho sentidos de movimiento clásicos, en la dirección horizontal, vertical o
 * diagonal, junto con su desplazamiento en filas y columnas correspondiente a cada caso.
 * Se recuerda el uso del método values para obtener un array con todos los valores definidos en el tipo
 * enumerado para simplificar el código.
 * Es muy importante utilizar esta enumeración con los correspondientes valores de desplazamiento, para simplificar
 * el código.
 *  Este fichero se proporciona ya resuelto en UBUVirtual.
 */

public enum Sentido {
	/**Noreste. */
	DIAGONAL_NE(-1, +1),
	/** Noroeste. */
	DIAGONAL_NO(-1, -1),
	/** Sur. */
	DIAGONAL_SE(+1, +1),
	/** Oeste. */
	DIAGONAL_SO(+1, -1),
	/** Vertical Norte. */
	VERTICAL_N(-1, 0),
	/** Vertical Sur. */
	VERTICAL_S(+1,0),
	/** Horizontal Este. */
	HORIZONTAL_E(0,+1),
	/** Horizontal Oeste. */
	HORIZONTAL_O(0,-1);
	

	/** Desplazamiento en filas. */
	private int desplazamientoEnFilas;

	/** Desplazamiento en columnas. */
	private int desplazamientoEnColumnas;

	/**
	 * Constructor.
	 * 
	 * @param desplazamientoEnFilas desplazamiento en filas
	 * @param desplazamientoEnColumnas desplazamiento en columnas
	 */
	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		establecerDesplazamientoEnFilas(desplazamientoEnFilas);
		establecerDesplazamientoEnColumnas(desplazamientoEnColumnas);
	}

	/**
	 * Obtiene el desplazamiento en horizontal.
	 * 
	 * @return desplazamiento en horizontal
	 */
	public int obtenerDesplazamientoEnFilas() {
		return desplazamientoEnFilas;
	}

	/**
	 * Establece el desplazamiento en filas.
	 * 
	 * @param desplazamientoEnFilas desplazamiento en horizontal
	 */
	private void establecerDesplazamientoEnFilas(int desplazamientoEnFilas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
	}

	/**
	 * Obtiene el desplazamiento en columnas.
	 * 
	 * @return desplazamiento en vertical
	 */
	public int obtenerDesplazamientoEnColumnas() {
		return desplazamientoEnColumnas;
	}

	/**
	 * Establece el desplazamiento en columnas.
	 * 
	 * @param desplazamientoEnColumnas desplazamiento en columnas.
	 */
	private void establecerDesplazamientoEnColumnas(int desplazamientoEnColumnas) {
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}

}
