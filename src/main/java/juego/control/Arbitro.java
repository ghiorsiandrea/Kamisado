package juego.control;

import juego.modelo.*;
import juego.util.Sentido;

/**
 * El paquete contiene una clase. Define la lógica de negocio o reglas del juego a implementar,
 * comprobando la legalidad de las jugadas, realizando los movimientos si son legales, gestionando el
 * cambio de turno y la actualización del los últimos colores de celda a los que ha movido cada jugador
 * <p>
 * El constructor asigna el tablero con el que se va a jugar.
 */
public class Arbitro {

// TODO: RECORDAR CAMBIAR ESTADOS

    private Color colorCeldaUltimoMovimiento;

    private Color colorPenultimoMovimiento;

    private Tablero tablero;

    private Turno turnoActual;

    private int numeroJugada;

    private boolean ultimoMovimientoEsCero;

    public Arbitro(Tablero tablero) {
        this.colorCeldaUltimoMovimiento = null;
        this.colorPenultimoMovimiento = null;
        this.tablero = tablero;
        this.turnoActual = null;
        this.numeroJugada = 0;
        this.ultimoMovimientoEsCero = false;
    }

    /**
     *  El método cambiarTurno cambia el turno al otro jugador.
     * ◦ Nota: este método es amigable, y se limita su acceso a clases del mismo paquete. (PACKAGE PRIVATE)
     */
    void cambiarTurno() {

        if (turnoActual == Turno.NEGRO) {
            turnoActual = Turno.BLANCO;
        } else {
            turnoActual = Turno.NEGRO;
        }
    }

    /**
     *  El método colocarTorres() inicializa el tablero asignado en el constructor, con todas las torres
     * de ambos jugadores en sus filas correspondientes.
     */
    public void colocarTorres() {
//          esta es la opcion larga, solo queda de ejemplo
//        tablero.colocar(new Torre(Turno.BLANCO, Color.NARANJA), 0, 0);
//        tablero.colocar(new Torre(Turno.BLANCO, Color.NARANJA), 0, 0);

        for (int i = 0; i < tablero.obtenerNumeroColumnas(); i++) {
            tablero.colocar(new Torre(Turno.BLANCO, tablero.obtenerCelda(0, i).obtenerColor()), 0, i);
            tablero.colocar(new Torre(Turno.NEGRO, tablero.obtenerCelda(7, i).obtenerColor()), 7, i);
        }
        this.turnoActual = Turno.NEGRO;
    }

    /**
     *  El método colocarTorres(Torre[], String[], Color, Color, Turno) permite inicializar el tablero con una
     * configuración diferente a la inicial, pasando un array de torres, un array de coordenadas en notacion algebraica
     * donde colocar las torres, el color del último movimiento del jugador con turno negro, el color del último
     * movimiento del jugador con turno blanco y el jugador con turno actual.
     * ◦ Nota: este método se implementa para ser utilizados en los tests automáticos y para facilitar al alumnado
     * las pruebas y depuración del código.
     * Se puede sustituir temporalmente la invocación al método colocarTorres() por este método para cargar partidas
     * más simples de probar, sin tener que realizar tantos movimientos.
     */
    public void colocarTorres(Torre[] torres, String[] coordenadas, Color ultimoColorTurnoNegro,
                              Color ultimoColorTurnoBlanco, Turno turnoActual) {

        if (torres.length != coordenadas.length || torres.length == 0) {
            return;
        }
        for (int i = 0; i < torres.length; i++) {
//            Esta es una forma mas larga y ordenada de hacerlo
//            Torre torre = torres[i];
//            String coordenada = coordenadas[i];
//            tablero.colocar(torre, coordenada);

            tablero.colocar(torres[i], coordenadas[i]);
        }
        this.turnoActual = turnoActual;
        if (turnoActual == Turno.NEGRO) {
            colorCeldaUltimoMovimiento = ultimoColorTurnoBlanco;
            colorPenultimoMovimiento = ultimoColorTurnoNegro;
        } else {
            colorCeldaUltimoMovimiento = ultimoColorTurnoNegro;
            colorPenultimoMovimiento = ultimoColorTurnoBlanco;

        }
    }

    /**
     *  El método consultarGanador retorna el turno del ganador de la partida, bien por alcanzar la fila  de salida
     * del jugador contrario, o bien por existir bloqueo mutuo. Si no hay ganador devuelve null.
     */
    public Turno consultarGanador() {

        if (estaAlcanzadaUltimaFilaPor(Turno.BLANCO)) {
            return Turno.BLANCO;
        }
        if (estaAlcanzadaUltimaFilaPor(Turno.NEGRO)) {
            return Turno.NEGRO;
        }
        if (hayBloqueoMutuo()) {
            return obtenerTurnoSiguiente();
        }
        return null;
    }

    /**
     *  El método esMovimientoLegalConTurnoActual dadas la celda origen y destino, devuelve true si es legal
     * realizar el movimiento con el turno actual, o false en caso contrario.
     */
    public boolean esMovimientoLegalConTurnoActual(Celda origen, Celda destino) {

        if (origen.estaVacia() || !destino.estaVacia()) {
            return false;
        }
        if (!tablero.estanVaciasCeldasEntre(origen, destino)) {
            return false;
        }
        if (colorCeldaUltimoMovimiento != null && origen.obtenerColorDeTorre() != colorCeldaUltimoMovimiento) {
            return false;
        }

        if (turnoActual == Turno.NEGRO && origen.obtenerFila() < destino.obtenerFila()) {
            return false;
        }
        if (turnoActual == Turno.BLANCO && origen.obtenerFila() > destino.obtenerFila()) {
            return false;
        }
        return turnoActual == origen.obtenerTurnoDeTorre();
    }

    /**
     *  El método estaAlcanzadaUltimaFilaPor devuelve true si el jugador con el turno pasado ha alcanzado la fila
     * de salida del jugador contrario, o false en caso contrario.
     */
    public boolean estaAlcanzadaUltimaFilaPor(Turno turno) {

        if (turno == null) {
            return false;
        }
        int ultimaFila = 0;
        if (turno == Turno.BLANCO) {
            ultimaFila = tablero.obtenerNumeroFilas() - 1;
        }

        for (int i = 0; i < tablero.obtenerNumeroColumnas(); i++) {
            if (tablero.obtenerCelda(ultimaFila, i).obtenerTurnoDeTorre() == turno) {
                return true;
            }
        }
        return false;
    }

    /**
     *  El método estaBloqueadoTurnoActual devuelve true si el jugador con turno actual no puede mover la torre que
     * corresponde, o false en caso contrario.
     */
    public boolean estaBloqueadoTurnoActual() {
        if (colorCeldaUltimoMovimiento == null) {
            return false;
        }
        Celda celdaTurnoActualUtimoMovimiento = tablero.buscarTorre(turnoActual, colorCeldaUltimoMovimiento);

        for (Sentido sentido : sentidosDeTurno(turnoActual)) {

            int filaPosibleMovimiento = celdaTurnoActualUtimoMovimiento.obtenerFila() +
                    sentido.obtenerDesplazamientoEnFilas();
            int columnaPosibleMovimiento = celdaTurnoActualUtimoMovimiento.obtenerColumna() +
                    sentido.obtenerDesplazamientoEnColumnas();
            Celda celdaPosibleMovimiento = tablero.obtenerCelda(filaPosibleMovimiento, columnaPosibleMovimiento);

            // Aca reutilizamos código pero la carga de trabajo es significativamente mayor a la solución siguiente
            // if (esMovimientoLegalConTurnoActual(celdaTurnoActualUtimoMovimiento, celdaPosibleMovimiento)) {
            // return false;
            //
            //}

            if (celdaPosibleMovimiento != null && celdaPosibleMovimiento.estaVacia()) {
                return false;
            }

        }

        return true;
    }

    private Turno obtenerTurnoSiguiente() {
        if (turnoActual == Turno.BLANCO) {
            return Turno.NEGRO;
        } else {
            return Turno.BLANCO;
        }
    }

    /**
     * Este mètodo no se està usando ya que al usar el turno siguiente habia una referencia circular con Consultar
     * ganador y bloqueo mutuo (porque el ganador es el turno que no genera el bloqueo y porque si hay un ganador,
     * entonces no hay bloqueo mutuo a futuro (pero en el pasado si lo hubo).)
     * @return
     */

    private boolean estaBloqueadoTurnoSiguienteConTurnoActualBloqueado() {
        // este if no es necesario ya que se evalua en el metodo establoqueadoturnoactual
        if (colorCeldaUltimoMovimiento == null) {
            return false;
        }
        Celda celdaTurnoActualUtimoMovimiento = tablero.buscarTorre(turnoActual, colorCeldaUltimoMovimiento);
        Celda celdaTorreSiguienteMovimiento = tablero.buscarTorre(obtenerTurnoSiguiente(), celdaTurnoActualUtimoMovimiento.obtenerColor());

        for (Sentido sentido : sentidosDeTurno(obtenerTurnoSiguiente())) {

            int filaPosibleMovimiento = celdaTorreSiguienteMovimiento.obtenerFila() +
                    sentido.obtenerDesplazamientoEnFilas();
            int columnaPosibleMovimiento = celdaTorreSiguienteMovimiento.obtenerColumna() +
                    sentido.obtenerDesplazamientoEnColumnas();
            Celda celdaPosibleMovimiento = tablero.obtenerCelda(filaPosibleMovimiento, columnaPosibleMovimiento);

            // Aca reutilizamos código pero la carga de trabajo es significativamente mayor a la solución siguiente
            // if (esMovimientoLegalConTurnoActual(celdaTurnoActualUtimoMovimiento, celdaPosibleMovimiento)) {
            // return false;
            //
            //}

            if (celdaPosibleMovimiento != null && celdaPosibleMovimiento.estaVacia()) {
                return false;
            }

        }

        return true;
    }

    //  TODO: DEJAR PARA EL FINAL

    /**
     *  El método hayBloqueoMutuo devuelve true si ninguno de los jugadores puede mover la torre
     * que corresponde, false en caso contrario.
     */
    public boolean hayBloqueoMutuo() {

//        no puedo usar este metodo pues consultar ganador usa al metodo hay bloqueo mutuo
//        if (consultarGanador() != null) {
//            return false;
//        }

        if (ultimoMovimientoEsCero && estaBloqueadoTurnoActual()) {
            return true;
        } else return false;
    }

    private Sentido[] sentidosDeTurno(Turno turno) {

        if (turno == Turno.BLANCO) {
            return new Sentido[]{Sentido.DIAGONAL_SO, Sentido.VERTICAL_S, Sentido.DIAGONAL_SE};

        } else {
            return new Sentido[]{Sentido.DIAGONAL_NO, Sentido.VERTICAL_N, Sentido.DIAGONAL_NE};
        }
    }

    /**
     *  El método moverConTurnoActual realiza el movimiento de la torre desde la celda origen a la
     * celda destino. Se supone que previamente se ha comprobado la legalidad de la jugada y no es
     * necesario volver a comprobarla. Debe ajustar el color de último movimiento para el turno actual y
     * cambiar el turno, teniendo en cuenta que se ha finalizado una jugada.
     */
    public void moverConTurnoActual(Celda origen, Celda destino) {

        tablero.moverTorre(origen, destino);
        this.numeroJugada++;
        this.cambiarTurno();
        colorPenultimoMovimiento = colorCeldaUltimoMovimiento;
        colorCeldaUltimoMovimiento = destino.obtenerColor();
        ultimoMovimientoEsCero = false;
    }

    /**
     *  El método moverConTurnoActualBloqueado realizar un movimiento de “distancia cero” para el
     * jugador con turno actual. Se supone que previamente se ha comprobado la situación de bloqueo
     * del jugador y no es necesario volver a comprobarlo. Debe ajustar el color de último movimiento
     * para el turno actual y cambiar el turno, teniendo en cuenta que se ha finalizado una jugada.
     */
    public void moverConTurnoActualBloqueado() {
        Celda celdaTorreConMovimientoCero = tablero.buscarTorre(turnoActual, colorCeldaUltimoMovimiento);
        colorPenultimoMovimiento = colorCeldaUltimoMovimiento;
        colorCeldaUltimoMovimiento = celdaTorreConMovimientoCero.obtenerColor();

        this.numeroJugada++;
        this.cambiarTurno();
        ultimoMovimientoEsCero = true;
    }

    /**
     *  El método obtenerNumeroJugada consulta el número de jugadas finalizadas en la partida. Todos
     * los movimientos cuentan, tanto de torre a otra celda, y de “distancia cero”.
     */
    public int obtenerNumeroJugada() {
        return numeroJugada;
    }

    /**
     *  El método obtenerTurno consulta qué jugador tiene el turno actualmente.
     */
    public Turno obtenerTurno() {
        return turnoActual;
    }

    /**
     *  El método obtenerUltimoMovimiento devuelve el color de la celda donde realizó su último
     * movimiento la torre del turno indicado.
     */
    public Color obtenerUltimoMovimiento(Turno turno) {
        if (turno == turnoActual) {
            return colorPenultimoMovimiento;
        }
        return colorCeldaUltimoMovimiento;

    }

}
