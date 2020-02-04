package model.elementos.tablero;

import model.excepciones.PosicionInvalidaError;
import model.elementos.posicion.Cartesiana;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrillaExpTest {

    @Test
    public void test00inicializacion(){

        Tablero tablero = new GrillaExp(3);

        boolean todo_ok = true;
        for( int i = 0; i < 3*3; i++){

            for( int j = 0; j < 3*3; j++){

                if (tablero.access(new Cartesiana(i,j)) != 0){
                    todo_ok = false;
                    break;
                }
            }
            if(!todo_ok) break;
        }

        assertTrue(todo_ok);
    }

    @Test
    public void test01SeAccedeAUnaPosicionPreviamenteSeteadaGrilla3x3() {

        Tablero tablero = new GrillaExp(3);

        Cartesiana unaPos = new Cartesiana(1,2);
        tablero.edit(unaPos,8);

        assertEquals(8,tablero.access(unaPos));

    }

    @Test
    public void test02SeAccedeAUnaPosicionPreviamenteSeteadaGrilla2x2() {

        Tablero tablero = new GrillaExp(3);

        Cartesiana unaPos = new Cartesiana(2,0);
        tablero.edit(unaPos,10);

        assertEquals(10,tablero.access(unaPos));

    }

    @Test
    public void test03SeAccedeAUnaPosicionPreviamenteSeteadaGrilla1x1() {

        Tablero tablero = new GrillaExp(3);

        Cartesiana unaPos = new Cartesiana(0,0);
        tablero.edit(unaPos,-2);

        assertEquals(-2,tablero.access(unaPos));

    }

    @Test
    public void test04SeChequeaSustitucionDeValoresGrilla3x3() {

        Tablero tablero = new GrillaExp(3);
        Cartesiana unaPos = new Cartesiana(0,0);

        assertEquals(0,tablero.access(unaPos));
        tablero.edit(unaPos,25);
        assertEquals(25,tablero.access(unaPos));
    }

    // Excepciones

    @Test(expected = PosicionInvalidaError.class)
    public void test05SeColocaUnNumeroEnUnaPosicionConCoordenadaXInvalida(){

        Tablero tablero = new GrillaExp(3);
        Cartesiana unaPos = new Cartesiana(-1,1);

        tablero.edit(unaPos,1);
    }

    @Test(expected = PosicionInvalidaError.class)
    public void test06SeColocaUnNumeroEnUnaPosicionConCoordenadaYInvalida(){

        Tablero tablero = new GrillaExp(3);
        Cartesiana unaPos = new Cartesiana(1,-2);

        tablero.edit(unaPos,1);
    }

    @Test(expected = PosicionInvalidaError.class)
    public void test07SeColocaUnNumeroEnUnaPosicionConCoordenadaXInvalida(){

        Tablero tablero = new GrillaExp(3);
        Cartesiana unaPos = new Cartesiana(12,1);

        tablero.edit(unaPos,1);
    }

    @Test(expected = PosicionInvalidaError.class)
    public void test08SeColocaUnNumeroEnUnaPosicionConCoordenadaXYInvalida(){

        Tablero tablero = new GrillaExp(3);
        Cartesiana unaPos = new Cartesiana(10,-1);

        tablero.edit(unaPos,1);
    }
}