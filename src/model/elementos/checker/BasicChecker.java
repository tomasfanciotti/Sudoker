package model.elementos.checker;

import model.excepciones.NumeroInvalidoError;
import model.excepciones.PosicionOcupadaError;
import model.elementos.posicion.Posicion;
import model.sudoku.*;

public class BasicChecker implements Checker {


    @Override
    public boolean checkearInsercion(Sudoku unSudoku, int valor, Posicion unaPosicion) {

        numeroValido(unSudoku,valor);
        posicionValida(unSudoku,unaPosicion);

        return true;
    }

    @Override
    public void numeroValido(Sudoku unSudoku, int valor) {

        int range = unSudoku.size * unSudoku.size;

        if ( valor <= 0  || range < valor ) throw new NumeroInvalidoError();
    }

    @Override
    public void posicionValida(Sudoku unSudoku, Posicion unaPosicion) {

        if (unSudoku.see(unaPosicion) != 0) throw new PosicionOcupadaError();

    }


}
