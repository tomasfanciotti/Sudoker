package model.sudoku;

import model.elementos.checker.Checker;
import model.elementos.posicion.Posicion;
import model.elementos.tablero.Tablero;

public abstract class Sudoku {

    Tablero tablero;
    Checker cheker;
    public int size;

    abstract public int see(Posicion unaPosicion);
    abstract public boolean set(Posicion unaPosicion, int valor);
    abstract public int remove(Posicion unaPosicion);
    abstract public boolean check(Posicion unaPosicion, int valor);
}
