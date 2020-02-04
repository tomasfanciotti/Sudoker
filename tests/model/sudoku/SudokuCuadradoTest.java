package model.sudoku;

import model.excepciones.NumeroInvalidoError;
import model.excepciones.PosicionOcupadaError;
import model.elementos.posicion.Posicion;
import model.elementos.posicion.Cartesiana;
import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuCuadradoTest {

    @Test
    public void test01MostrarUnValorDadaUnaPosicion() {

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(4,7);
        unSudoku.set(unaPosicion,5);

        assertEquals(5,unSudoku.see(unaPosicion));

    }

    @Test
    public void test02SetearUnValorDadaUnSudokuVacio() {

        String detalleDelTest= "Seteo del numero 2 en un sudoku vacio";
        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(6,1);

        assertTrue(unSudoku.set(unaPosicion,2));

    }

    @Test
    public void test03EliminarUnValorSeteadoAnteriormenteDevuelveNumero() {

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(0,1);
        unSudoku.set(unaPosicion,8);

        assertEquals(8, unSudoku.remove(unaPosicion));

    }

    @Test
    public void test04EliminarUnValorSeteadoAnteriormenteLimpiaLaCasilla() {

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(0,1);
        unSudoku.set(unaPosicion,8);
        unSudoku.remove(unaPosicion);

        assertEquals(0, unSudoku.see(unaPosicion));

    }

    @Test
    public void test05IngresarTodoElRangoDeValoresPermitidosEnLaDiagonal(){

        Sudoku unSudoku = new SudokuCuadrado(3);

        for (int i = 0; i < 9 ; i++){

            unSudoku.set(new Cartesiana(i,i),i+1);

        }

        assertTrue(true);

    }

    @Test
    public void test06SetearUnNumeroLuegoDeBorrarOtroEnUnaMismaPosicion(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(0,0);

        unSudoku.set(unaPosicion,1);
        unSudoku.remove(unaPosicion);
        unSudoku.set(unaPosicion,9);

        assertEquals(9, unSudoku.see(unaPosicion));

    }

    // Testeo de Excepciones

    @Test(expected = NumeroInvalidoError.class)
    public void test07IngresarUnValorNegativo(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(7,9);
        unSudoku.set(unaPosicion,-2 );
    }

    @Test(expected = NumeroInvalidoError.class)
    public void test08IngresarUnValorSuperiorALosPermitidos(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(7,9);
        unSudoku.set(unaPosicion,10);
    }

    @Test(expected = NumeroInvalidoError.class)
    public void test09IngresarUnValorInferiorALosPermitidos(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(7,9);
        unSudoku.set(unaPosicion,15);
    }

    @Test(expected = NumeroInvalidoError.class)
    public void test10IngresarUnValorInferiorALosPermitidos(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(7,9);
        unSudoku.set(unaPosicion,0);
    }

    @Test(expected = PosicionOcupadaError.class)
    public void test11IngresarUnValorEnUnaPosicionOcupada(){

        Sudoku unSudoku = new SudokuCuadrado(3);
        Posicion unaPosicion = new Cartesiana(0,0);
        unSudoku.set(unaPosicion,5);
        unSudoku.set(unaPosicion,6);

    }
}