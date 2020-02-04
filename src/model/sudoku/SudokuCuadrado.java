package model.sudoku;

import model.elementos.checker.BasicChecker;
import model.elementos.posicion.Posicion;
import model.elementos.tablero.GrillaExp;


public class SudokuCuadrado extends Sudoku {

    public SudokuCuadrado(int r) {
        super();

        this.size = r;
        this.tablero = new GrillaExp(r);
        this.cheker = new BasicChecker();

    }

    @Override
    public int see(Posicion unaPosicion) {
        return this.tablero.access(unaPosicion);
    }

    @Override
    public boolean set(Posicion unaPosicion, int valor) {

        if (!check(unaPosicion,valor))
            return false;

        this.tablero.edit(unaPosicion,valor);
        return true;
    }

    @Override
    public int remove(Posicion unaPosicion) {

        int valor = this.tablero.access(unaPosicion);
        this.tablero.edit(unaPosicion,0);

        return valor;
    }

    @Override
    public boolean check(Posicion unaPosicion, int valor) {
        return this.cheker.checkearInsercion(this,valor, unaPosicion);

        //TODO: Un metodo para acceder a cada metodo de la clase
        //TODO: o acceso directo?
    }
}


/*
    4 tipos de checkeo:

    1- Si al agregar un numero al tablero, el numero esta en el rango correcto
    2- Si al agregar un numero al tablero, la posicion es valida en el tablero.
    3- Si al agregar un numero al tablero, la posicion corresponde a una vacia.

    4- Si al agregar un numero al tablero, sigue las reglas del sudoku.

    5- Sudoku actual es valido -> Si sigue las reglas del sudoku


 **/