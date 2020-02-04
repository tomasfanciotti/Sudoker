package model.elementos.tablero;

import model.elementos.posicion.Posicion;

public abstract class Tablero {

    abstract public int access(Posicion unaPosicion);
    abstract public void edit(Posicion unaPosicion, int valor);

}
