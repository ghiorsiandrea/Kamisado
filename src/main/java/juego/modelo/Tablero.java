package juego.modelo;

import juego.util.Sentido;

public class Tablero {

    public Tablero() {
        // TODO: Crear lógica de constructor por defecto
    }

    /*
     * Un tablero se considera como un conjunto de celdas, cada una en una posición (fila,columna).
     * Suponiendo que el tablero es de 8 filas x 8 columnas, entonces tenemos: [0][0] las coordenadas
     * de la esquina superior izquierda, [0][7] las coordenadas de la esquina superior derecha, [7][0]
     * las coordenadas de la esquina inferior izquierda y [7][7] las coordenadas de la esquina inferior
     * derecha. Se numera de izquierda a derecha y en sentido descendente.
     *
     *  El conjunto de celdas de un tablero debe implementarse con un array3
     *  de celdas de dos
     * dimensiones. Al instanciar un tablero se crean y asignan las correspondientes celdas vacías, con
     * sus correspondientes coordenadas y colores.
     */


    /**
     * El método buscarTorre obtiene la celda que contiene la torre del turno y color indicada.
     */
    public Celda buscarTorre(Turno turno, Color color) {
        return null;
    }

    /**
     * El método colocar(Torre, Celda) coloca la torre en la celda indicada (método sobrecargado).
     */
    public void colocar(Torre torre, Celda celda) {
    }

    /**
     *  El método colocar(Torre, String) coloca la torre en la celda indicada en notación algebraica.
     * Si la celda en notación algebraica es incorrecta en sintaxis, no se hace nada (método
     * sobrecargado).
     * ◦ Nota: todos los métodos sobrecargados colocar deben realizar el doble enganche entre torre y
     * celda.
     */
    public void colocar(Torre torre, String notacionAlgebraica) {
    }

    /**
     * El método colocar(Torre, int, int) coloca la torre en la fila y columna indicada. Si los
     * valores de fila y columna son incorrectos (no están en los límites del tablero), no se hace nada
     * (método sobrecargado)
     */
    public void colocar(Torre torre, int fila, int columna) {
    }

    /**
     *El método estanVaciasCeldasEntre devuelve true si las celdas entre el origen y destino no
     * contienen torres, es decir están vacías, o false en caso contrario
     * Si las dos celdas están consecutivas sin celdas entre medias se devuelve true.
     * Si las celda origen y destino no están alineadas en alguno de los sentidos definidos en la
     * enumeración Sentido, se devuelve false.
     * No se tiene en cuenta el estado de las celdas origen y destino, solo el de las celdas entre medias
     * para comprobar si hay torres
     */
    public boolean estanVaciasCeldasEntre(Celda origen, Celda destino) {
        return false;
    }

    /**
     * El método moverTorre mueve la torre de la celda origen a destino. Si no hay torre en origen, o la
     * celda destino no está vacía, no se hace nada.
     */
    public void moverTorre(Celda origen, Celda destino) {
    }

    /**
     * El método obtenerCelda, devuelve la referencia a la celda del tablero.
     */
    public Celda obtenerCelda(int fila, int columna) {
        return null;
    }

    /**
     * El método obtenerCeldaDestinoEnJugada, devuelve la referencia a la celda destino en la jugada
     * introducida en notación algebraica (e.g. con "a1c3" retorna la celda en [5][2]). Si el formato
     * de texto es incorrecto retorna null.
     */
    public Celda obtenerCeldaDestinoEnJugada(String textoJugada) {
        return null;
    }

    /**
     * El método obtenerCeldaOrigenEnJugada, devuelve la referencia a la celda origen en la jugada
     * introducida en notación algebraica (e.g. con "a1c3" retorna la celda en [7][0]). Si el formato
     * de texto es incorrecto retorna null.
     */
    public Celda obtenerCeldaOrigenEnJugada(String textoJugada) {
        return null;
    }

    /**
     *El método obtenerCeldaParaNotacionAlgebraica, devuelve la referencia a la celda en notación
     * algebraica (e.g. con "a1" retorna la celda [7][0]). Si el formato de texto es incorrecto retorna
     * null.
     */
    public Celda obtenerCeldaParaNotacionAlgebraica(String texto) {
        return null;
    }

    /**
     * El método obtenerCeldas devuelve un array de una dimensión con todas las celdas del
     * tablero. Se recorren las celdas de arriba a abajo, y de izquierda a derecha. Este método se puede
     * utilizar en bucles for-each para recorrer todas las celdas del tablero de forma simplificada.
     */
    public Celda[] obtenerCeldas() {
        return new Celda[0];
    }

    /**
     * El método obtenerCoordenadasEnNotacionAlgebraica, devuelve el texto correspondiente a la
     * celda en notación algebraica (e.g. con la celda [7][0] se retorna "a1"). Si la celda no pertenece
     * al tablero se retorna "--".
     */
    public String obtenerCoordenadasEnNotacionAlgebraica(Celda celda) {
        return null;
    }

    /**
     * El método obtenerJugadaEnNotacionAlgebraica, devuelve el texto correspondiente a un par de
     * celdas origen y destino en notación algebraica (e.g. con la celda origen [7][0] y la celda destino
     * [5][2] se retorna "a1c3"). Si alguna celda no pertenece al tablero, su texto correspondiente es
     * "--".
     */
    public String obtenerJugadaEnNotacionAlgebraica(Celda origen, Celda destino) {
        return null;
    }

    public int obtenerNumeroColumnas() {
        return 0;
    }

    public int obtenerNumeroFilas() {
        return 0;
    }

    /**
     * El método obtenerNumeroTorres(Color) devuelve el número de torres de un determinado color
     * en el tablero (método sobrecargado).
     */
    public int obtenerNumeroTorres(Color color) {
        return 0;
    }

    /**
     * El método obtenerNumeroTorres(Turno) devuelve el número de torres de un determinado turno
     * en el tablero (método sobrecargado).
     */
    public int obtenerNumeroTorres(Turno turno) {
        return 0;
    }

    /**
     * El método obtenerSentido obtiene el sentido de movimiento desde una celda origen a destino.
     * Si las celda origen y destino no están alineadas en alguno de los sentidos definidos en la
     * enumeración Sentido, se devuelve null.
     */
    public Sentido obtenerSentido(Celda origen, Celda sentido) {
        return null;
    }

    /**
     * El método toString devuelve el estado actual del tablero en formato cadena de texto tal y como
     * se mostraría a un jugador en plena partida. Ej: se muestra el tablero tras realizar algún
     * movimiento de torres. En cada celda se indica en sus cuatros esquinas la letra con su color y en
     * el centro, el turno y color de la torre (e.g. "BN" para turno blanco con torre verde, "NM" para
     * turno negro con torre naranja, etc.) o bien un par de guiones si está vacía.
     *  a b c d e f g h
     * N..N Z..Z P..P S..S A..A R..R V..V M..M
     * 8 -BN- -BZ- -BP- ---- -BA- -BR- ---- -BMN..N Z..Z P..P S..S A..A R..R V..V M..M
     * R..R N..N S..S V..V Z..Z A..A M..M P..P
     * 7 ---- ---- ---- ---- ---- ---- -BV- ----
     * R..R N..N S..S V..V Z..Z A..A M..M P..P
     * V..V S..S N..N R..R P..P M..M A..A Z..Z
     * 6 ---- ---- ---- ---- ---- ---- ---- ----
     * V..V S..S N..N R..R P..P M..M A..A Z..Z
     * S..S P..P Z..Z N..N M..M V..V R..R A..A
     * 5 -NM- ---- ---- ---- ---- ---- ---- ----
     * S..S P..P Z..Z N..N M..M V..V R..R A..A
     * A..A R..R V..V M..M N..N Z..Z P..P S..S
     * 4 ---- ---- -NR- ---- ---- ---- ---- ----
     * A..A R..R V..V M..M N..N Z..Z P..P S..S
     * Z..Z A..A M..M P..P R..R N..N S..S V..V
     * 3 ---- ---- ---- ---- ---- ---- ---- ----
     * Z..Z A..A M..M P..P R..R N..N S..S V..V
     * P..P M..M A..A Z..Z V..V S..S N..N R..R
     * 2 ---- ---- ---- -BS- ---- ---- ---- ----
     * P..P M..M A..A Z..Z V..V S..S N..N R..R
     * M..M V..V R..R A..A S..S P..P Z..Z N..N
     * 1 ---- -NV- ---- -NA- -NS- -NP- -NZ- -NNM..M V..V R..R A..A S..S P..P Z..Z N..N
     */
    @Override
    public String toString() {
        return null;
    }

}
