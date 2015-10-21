package com.epsi.soap;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import java.util.HashMap;

@javax.jws.soap.SOAPBinding(style = SOAPBinding.Style.RPC)
@javax.jws.WebService
public class Banque {

    @Resource
    WebServiceContext wsctx;

    public static HashMap<String, Customer> accounts;

    public double crediter(double value) throws Exception {
        String[] credentials = Utility.RetrieveCredentials(wsctx);
        String login = credentials[0];
        String password = credentials[1];

        if (login == Constante.STRING_EMPTY || !accounts.containsKey(login) || login != password){
            throw new Exception("Connection failed.");
        }

        Customer account = accounts.get(login);
        account.setBalance(account.getBalance() + value);
        accounts.put(login, account);

        return account.getBalance();
    }

    public double debiter(double value) throws Exception {
        String[] credentials = Utility.RetrieveCredentials(wsctx);
        String login = credentials[0];
        String password = credentials[1];

        if (login == Constante.STRING_EMPTY || !accounts.containsKey(login) || login != password){
            throw new Exception("Connection failed.");
        }

        Customer account = accounts.get(login);
        account.setBalance(account.getBalance() - value);
        accounts.put(login, account);

        return account.getBalance();
    }

    public void createAccount(String login, String password) throws Exception
    {
        String[] credentials = Utility.RetrieveCredentials(wsctx);
        String uLogin = credentials[0];
        String uPassword = credentials[1];

        if (uLogin == Constante.STRING_EMPTY || uLogin != Constante.STRING_ADMIN  || uLogin != uPassword){
            throw new Exception("You're not an administrator...");
        } else if(accounts.containsKey(login.trim())){
            throw new Exception("Login already in use.");
        } else if (login.trim() == Constante.STRING_EMPTY || password.trim() == Constante.STRING_EMPTY){
            throw new Exception("All parameters must be set.");
        }

        Customer c = new Customer(login.trim(), password.trim());
        accounts.put(login, c);
    }

    public void createAccount(String login, String password, int balance) throws Exception
    {
        String[] credentials = Utility.RetrieveCredentials(wsctx);
        String uLogin = credentials[0];
        String uPassword = credentials[1];

        if (uLogin == Constante.STRING_EMPTY || uLogin != Constante.STRING_ADMIN  || uLogin != uPassword){
            throw new Exception("You're not an administrator...");
        } else if(accounts.containsKey(login.trim())){
            throw new Exception("Login already in use.");
        } else if (login.trim() == Constante.STRING_EMPTY || password.trim() == Constante.STRING_EMPTY){
            throw new Exception("All parameters must be set.");
        }

        Customer c = new Customer(login.trim(), password.trim(), balance);
        accounts.put(login, c);
    }
}