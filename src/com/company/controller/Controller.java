package com.company.controller;
import com.company.model.Dyrektor;
import com.company.model.Handlowiec;
import com.company.model.Model;
import com.company.model.Pracownik;
import com.company.view.View;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Controller {
    Model pracownikHashMap = new Model();
    Scanner input = new Scanner(System.in);
    View view = new View();
    public Controller(){
        menu();
    }

    public void printMap(){
        if (pracownikHashMap.size() >= 1) {
            int i = 0;
            for (String pesel : pracownikHashMap.keySet()) {
                view.printElement(pracownikHashMap.get(pesel),pesel);
                i += 1;
                view.printMap(i,pracownikHashMap.size());
                if(i == 1){
                    input.nextLine();
                }

                String s = input.nextLine();
                if (!s.equals("")) {
                    break;
                }
            }
        }
        else{
            System.err.println("Brak pracownikow");
        }
    }

    boolean checkPesel(String pesel){
        try{
            if ( pesel.matches("[0-9]+") && pesel.length() == 11){
                return true;
            }else{
                throw new NumberFormatException("Zly pesel");
            }
        }catch (NumberFormatException t){
            System.err.println("zly pesel");
        }
        return false;
    }

    void menu(){
        try{
            view.printMenu();
            int option = input.nextInt();
            while(option != 5){
               if (option == 1){
                    printMap();
               }else if(option == 2){
                    add();
               }else if(option == 3){
                   delete();
               }else if(option == 4){
                    kopia();
               }else{
                  System.err.println("zla operacja");
               }
                view.printMenu();
                option = input.nextInt();
            }
        }catch (NumberFormatException t){
            System.err.println(t.getMessage());
        }
    }

    boolean add(){
        try {
            view.printOption2();
            String a = input.next();
            if(a.matches("[dDhH]")){
                view.printPeselID();
                String pesel = input.next();
                view.printImie();
                String imie = input.next();
                view.printNazwisko();
                String nazwisko = input.next();
                view.printWynagrodzenie();
                BigDecimal wynagrodzenie = input.nextBigDecimal();
                view.printTelefon();
                String numer = input.next();
                if (a.matches("[dD]")){

                    if(checkPesel(pesel)) {
                        try {
                            view.printDodatek();
                            BigDecimal dodatek = input.nextBigDecimal();
                            view.printKarta();
                            String karta = input.next();
                            view.printLimit();
                            BigDecimal limit = input.nextBigDecimal();
                            view.check();
                            input.nextLine();
                            String s = input.nextLine();
                            if (s.equals("")){
                                Dyrektor dyrektor = new Dyrektor(pesel, imie, nazwisko, numer, wynagrodzenie, dodatek, karta, limit);
                                pracownikHashMap.put(pesel, dyrektor);
                            }
                        }catch (InputMismatchException t){
                            System.err.println("Niedozowlone dzialanie");
                            return false;
                        }
                    }
                }else{

                    if(checkPesel(pesel)) {
                        try {
                            view.printProwizja();
                            BigDecimal prowizja = input.nextBigDecimal();
                            view.printLimitProwizji();
                            BigDecimal limit = input.nextBigDecimal();
                            view.check();
                            input.nextLine();
                            String s = input.nextLine();
                            if (s.equals("")) {
                                Handlowiec handlowiec = new Handlowiec(pesel, imie, nazwisko, numer, wynagrodzenie, prowizja, limit);
                                pracownikHashMap.put(pesel, handlowiec);
                            }
                        }catch (InputMismatchException t){
                            System.err.println("Niedozowlone dzialanie");
                            return false;
                        }
                    }
                }

            }else{
                System.err.println("zla operacja");
            }
        }catch (InputMismatchException | NullPointerException t){
            System.err.println("Niedozowlone dzialanie");

        }
        return true;
    }

    void delete(){
        view.printOprion3();
        String pesel = input.next();
        if(checkPesel(pesel)) {
            if (pracownikHashMap.containsKey(pesel)) {
                view.printElement(pracownikHashMap.get(pesel),pesel);
                view.check();
                input.nextLine();
                String s = input.nextLine();
                if (s.equals("")){
                    pracownikHashMap.remove(pesel);
                }
            }else{
                System.err.println("Brak pracownika");
            }
        }
    }

    void kopia(){
        view.printOprion4();
        String operacja = input.next();
        if (operacja.matches("[Zz]")){
            view.printKonwersja();
            String typ = input.next();
            if (typ.matches("[Gg]")){
                File file = new File("user.gzip");
                view.check();
                input.nextLine();
                String s = input.nextLine();
                if (s.equals("")){
                    zapis(file);
                }
            }else if (typ.matches("[Zz]")){
                File file = new File("user.zip");
                view.check();
                input.nextLine();
                String s = input.nextLine();
                if (s.equals("")){
                    zapis(file);
                }
            }

        }else if (operacja.matches("[Oo]")){
            view.printNazwa();
            input.nextLine();
            String s = input.nextLine();
            File file = new File(s);
            if (file.exists()){
                view.check();
                String d = input.nextLine();
                if (d.equals("")){
                    odczyt(file);
                }
            }else {
                System.err.println("Nie ma takiego pliku");
            }
        }
    }

    void zapis(File file){
        try (FileOutputStream fos = new FileOutputStream(file);
             GZIPOutputStream gos = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gos)) {
            HashMap<String, Pracownik> hashtmp = new HashMap<>();
            hashtmp = pracownikHashMap.getPracownikHashMap();
            oos.writeObject(hashtmp);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void odczyt(File file){

        try (FileInputStream fis = new FileInputStream(file);
             GZIPInputStream gis = new GZIPInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(gis)) {
            HashMap<String, Pracownik> hashtmp = new HashMap<>();
            hashtmp = (HashMap<String, Pracownik>) ois.readObject();
            pracownikHashMap.setPracownikHashMap(hashtmp);
       } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
       }
    }

}
