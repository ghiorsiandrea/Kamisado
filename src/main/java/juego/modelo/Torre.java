package juego.modelo;

public class Torre {

    /**
     * Una torre podría estar o no en una celda
     */
    private Celda celda;

    /**
     * Una torre tendrá un solo color y un color podría repetirse en muchas torres
     */
    private Color color;

    /**
     * Una torre pertenece a un turno (B o N) y el turno podría tener una o más torres.
     */
    private Turno turno;

    /**
     * Una torre se crea con un turno y color que no cambia a lo largo de la partida. Inicialmente una
     * torre no está “colocada” sobre el tablero y no tendrá celda asignada.
     */
    public Torre(Turno turno, Color color) {
        this.turno = turno;
        this.color = color;
        this.celda = null;
    }

    /**
     * • El método establecerCelda, asigna la celda a torre actual.
     */
    public void establecerCelda(Celda celda) {
        this.celda = celda;
    }


    public Celda obtenerCelda() {
        return celda;
    }

    public  Color obtenerColor() {
        return color;
    }

    public Turno obtenerTurno() {
        return turno;
    }

    /**
     * • El método toString devuelve en formato texto el estado actual de la torre, con el siguiente
     * formato: "TC". Donde T es el turno y C el color. Por ejemplo, para la torre blanca de color rosa,
     * tendríamos "BS".
     */

    public String toString() {
        String turnoTxt = String.valueOf(obtenerTurno().toChar());
        String colorTxt = String.valueOf(obtenerColor().toChar());
        return turnoTxt  + colorTxt;
    }




}
