package juego.control;

import juego.modelo.*;

/**
 * El paquete contiene una clase. Define la lógica de negocio o reglas del juego a implementar,
 * comprobando la legalidad de las jugadas, realizando los movimientos si son legales, gestionando el
 * cambio de turno y la actualización del los últimos colores de celda a los que ha movido cada jugador
 * <p>
 * El constructor asigna el tablero con el que se va a jugar.
 */
public class Arbitro {

    private Tablero tablero;

    public Arbitro(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     *  El método cambiarTurno cambia el turno al otro jugador.
     * ◦ Nota: este método es amigable, y se limita su acceso a clases del mismo paquete. (PACKAGE PRIVATE)
     */
    void cambiarTurno() {
    }

    /**
     *  El método colocarTorres() inicializa el tablero asignado en el constructor, con todas las torres
     * de ambos jugadores en sus filas correspondientes.
     */
    public void colocarTorres() {
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
    }

    /**
     *  El método consultarGanador retorna el turno del ganador de la partida, bien por alcanzar la fila  de salida
     * del jugador contrario, o bien por existir bloqueo mutuo. Si no hay ganador devuelve null.
     */
    public Turno consultarGanador() {
        return null;
    }

    /**
     *  El método esMovimientoLegalConTurnoActual dadas la celda origen y destino, devuelve true si es legal
     * realizar el movimiento con el turno actual, o false en caso contrario.
     */
    public boolean esMovimientoLegalConTurnoActual(Celda origen, Celda destino) {
        return false;
    }

    /**
     *  El método estaAlcanzadaUltimaFilaPor devuelve true si el jugador con el turno pasado ha alcanzado la fila
     * de salida del jugador contrario, o false en caso contrario.
     */
    public boolean estaAlcanzadaUltimaFilaPor(Turno turno) {
        return false;
    }

    /**
     *  El método estaBloqueadoTurnoActual devuelve true si el jugador con turno actual no puede mover la torre que
     * corresponde, o false en caso contrario.
     */
    public boolean estaBloqueadoTurnoActual() {
        return false;
    }

    /**
     *  El método hayBloqueoMutuo devuelve true si ninguno de los jugadores puede mover la torre
     * que corresponde, false en caso contrario.
     */
    public boolean hayBloqueoMutuo() {
        return false;
    }

    /**
     *  El método moverConTurnoActual realiza el movimiento de la torre desde la celda origen a la
     * celda destino. Se supone que previamente se ha comprobado la legalidad de la jugada y no es
     * necesario volver a comprobarla. Debe ajustar el color de último movimiento para el turno actual y
     * cambiar el turno, teniendo en cuenta que se ha finalizado una jugada.
     */
    public void moverConTurnoActual(Celda origen, Celda destino) {
    }

    /**
     *  El método moverConTurnoActualBloqueado realizar un movimiento de “distancia cero” para el
     * jugador con turno actual. Se supone que previamente se ha comprobado la situación de bloqueo
     * del jugador y no es necesario volver a comprobarlo. Debe ajustar el color de último movimiento
     * para el turno actual y cambiar el turno, teniendo en cuenta que se ha finalizado una jugada.
     */
    public void moverConTurnoActualBloqueado() {
    }

    /**
     *  El método obtenerNumeroJugada consulta el número de jugadas finalizadas en la partida. Todos
     * los movimientos cuentan, tanto de torre a otra celda, y de “distancia cero”.
     */
    public Object obtenerNumeroJugada() {
        return null;
    }

    /**
     *  El método obtenerTurno consulta qué jugador tiene el turno actualmente.
     */
    public Turno obtenerTurno() {
        return null;
    }

    /**
     *  El método obtenerUltimoMovimiento devuelve el color de la celda donde realizó su último
     * movimiento la torre del turno indicado.
     */
    public Color obtenerUltimoMovimiento(Turno negro) {
        return null;
    }


}
