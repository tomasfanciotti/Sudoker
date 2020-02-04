package model.elementos.posicion;

//TODO: mmmm vs decis

public class Cartesiana extends Posicion {

    public int m;
    public int n;

    public Cartesiana(int unM, int unN) {

        this.m = unM;
        this.n = unN;
    }

    @Override
    public boolean comparar(Posicion otraPosicion) {

        return (this.n == ((Cartesiana) otraPosicion).n) == (this.m == ((Cartesiana) otraPosicion).m);
    }

    public int getM(){
        return this.m;
    }

    public int getN(){
        return this.n;
    }
}
