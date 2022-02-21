package juego;

import juego.modelo.Color;
import org.junit.Test;

public class TestGenerico {

    @Test
    public void probarLoQueQuieras() {
        Color quantito = Color.obtenerColorAleatorio();
        System.out.println(quantito.toChar());
    }
}
