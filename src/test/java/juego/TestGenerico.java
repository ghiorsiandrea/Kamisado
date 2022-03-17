package juego;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import juego.control.Arbitro;
import juego.modelo.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestGenerico {

    @Test
    public void probarLoQueQuieras() {
        Color quantito = Color.obtenerColorAleatorio();
        System.out.println(quantito.toChar());
    }

    @Test
    public void probarChar() {
        char caracter = '3';
        int result = 56 - caracter;
        System.out.println(result);
    }

    /**
     * Este test sirve para ver como usar equals genera null pointer exception y usando el == se evita eso
     */
    @Test
    public void probarIgualdadEnums() {
        Color ejemplo1 = Color.ROJO;
        Color ejemploNull = null;

        boolean sonIguales = ejemplo1.equals(ejemploNull);

        System.out.println(sonIguales);

        boolean sonIguales2 = ejemploNull == ejemplo1;

        System.out.println(sonIguales2);
    }

    @Test
    public void pruebaString() {
        String prueba = "hola \nuna \"quantita se porta mal\"";
        System.out.println(prueba);
    }

    @Test
    public void pruebaObjetoTableroArbitro() {
        Tablero tablero = new Tablero();
        Arbitro arbitro = new Arbitro(tablero);
        System.out.println(tablero);

        Celda origen = tablero.obtenerCelda(0, 0);
        origen.establecerTorre(new Torre(Turno.NEGRO, Color.AMARILLO));
        System.out.println(tablero);

        Celda destino = tablero.obtenerCelda(7, 7);
        tablero.moverTorre(origen, destino);
        System.out.println(tablero);
    }

    @Test
    public void pruebaAssert() {
        Tablero tablero = new Tablero();
        Arbitro arbitro = new Arbitro(tablero);
        arbitro.colocarTorres();

        // Si falla un assert no sigue con el siguiente
        //assertTrue("El tablero debe tener 8 columnas" ,tablero.obtenerNumeroColumnas() == 8);
        //assertThat(arbitro.obtenerTurno(), is(Turno.BLANCO));

        // Ejecuta todos los assert a la vez
        assertAll(() -> assertTrue("El tablero debe tener 8 columnas" ,tablero.obtenerNumeroColumnas() == 8),
                () -> assertThat(arbitro.obtenerTurno(), is(Turno.NEGRO)));
    }

//    @Test
//    public void pruebaStackOverflow() {
//        metodo1();
//    }
//
//    private void metodo1() {
//        System.out.println("hola");
//        metodo2();
//    }
//
//    private void metodo2() {
//        System.out.println("chau");
//        metodo1();
//    }
}
