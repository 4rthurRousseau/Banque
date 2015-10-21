package com.epsi.soap;

import java.util.HashMap;

@javax.jws.WebService
public class Banque {

    public static HashMap<String, Customer> accounts;

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

    public void createAccount(String login, String password) throws Exception
    {
        if(accounts.containsKey(login)){
            throw new Exception("this login is already used");
        }

        Customer c = new Customer(login, password);

    }

    public void createAccount(String login, String password, int balance)
    {
        Customer c = new Customer(login, password, balance);
    }
}