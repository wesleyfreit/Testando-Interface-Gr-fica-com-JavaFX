package controller;

import java.util.ArrayList;
import java.util.List;

import classes.Conta;

public class ListDados {
    static List<Conta> accounts = new ArrayList<>();

    public static List<Conta> getAccounts() {
        return accounts;
    }  
}
