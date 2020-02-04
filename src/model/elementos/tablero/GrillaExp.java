package model.elementos.tablero;

import model.excepciones.PosicionInvalidaError;
import model.elementos.posicion.Cartesiana;
import model.elementos.posicion.Posicion;

public class GrillaExp extends Tablero {

    private int size;
    private int [][] tablero;

    public GrillaExp(int r){

        this.size = r;
        this.tablero = new int[r*r][r*r];

    }

    public int access(Posicion unaPosicion){

        Cartesiana unaCartesiana = (Cartesiana)unaPosicion;
        int m = unaCartesiana.getM();
        int n = unaCartesiana.getN();

        return this.tablero[m][n];
    }

    public void edit(Posicion unaPosicion, int valor){

        Cartesiana unaCartesiana = (Cartesiana)unaPosicion;
        int m = unaCartesiana.getM();
        int n = unaCartesiana.getN();

        if ( m < 0 || size*size <= m ) throw new PosicionInvalidaError();
        if ( n < 0 || size*size <= n ) throw new PosicionInvalidaError();

        this.tablero[m][n] = valor;
    }

}
