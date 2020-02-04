package model.elementos.checker;

import model.elementos.posicion.Posicion;
import model.sudoku.Sudoku;

public interface Checker {

    boolean checkearInsercion(Sudoku unSudoku, int valor, Posicion unaPosicion);

    void numeroValido(Sudoku unSudoku, int valor);
    void posicionValida(Sudoku unSudoku, Posicion unaPosicion);

}

