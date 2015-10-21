package com.epsi.soap;

import java.util.List;

@javax.jws.WebService
public class Banque {

    public static List<Customer> accounts;


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

    public void creerCompte()
    {

    }
}