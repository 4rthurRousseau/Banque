package main.java.com.epsi.soap;

@javax.jws.WebService
public class Banque {
    public int crediter(int... nombres){
        int resultat = 0;
        for (int nombre : nombres){
            resultat += nombre;
        }
        return resultat;
    }

    public int debiter(int... nombres){
        int resultat = 0;
        for (int nombre : nombres){
            resultat += nombre;
        }
        return resultat;
    }
}