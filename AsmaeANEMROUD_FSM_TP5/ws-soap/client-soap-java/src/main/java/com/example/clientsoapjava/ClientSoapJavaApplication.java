package com.example.clientsoapjava;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class ClientSoapJavaApplication {

    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDH(90));
        Compte compte = proxy.getCompte(4);
        System.out.println("-----------------");
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        System.out.println(compte.getDateCreation());

        proxy.listeComptes().forEach(cp -> {
            System.out.println("-----------------");
            System.out.println(cp.getCode());
            System.out.println(cp.getSolde());
            System.out.println(cp.getDateCreation());
        });
    }

}
