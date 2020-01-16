package com.company.view;

import com.company.model.Dyrektor;
import com.company.model.Handlowiec;
import com.company.model.Model;
import com.company.model.Pracownik;

public class View {

        public void printPeselID(){
            System.out.print("Identyfikator PESEL:       ");
        }
        public void printOprion4(){
            System.out.println("4. Kopia zapasowa");
            System.out.print("[Z]achowaj/[O]dtwórz :      ");
        }

        public void printOprion3(){
            System.out.println("3. Usun pracownika");
            System.out.println();
            System.out.print("Podaj identyfikator PESEL:       ");
        }
        public void printOption2(){
            System.out.println("2. Dodaj pracownika");
            System.out.println();
            System.out.print("[D]yrektor/[H]handlowiec: ");
        }

        public void printMap(int i,int size){
            System.out.println("[Pozycja:" + i + "/" + size + "]");
            System.out.println("[Enter] - nastepny");
            System.out.println("[Q] - powrot");
        }

        public void printElement(Pracownik map,String pesel){
            System.out.println("PESEL:    "+pesel);
            System.out.println("Imie:    "+map.getImie());
            System.out.println("Nazwisko:    "+map.getNazwisko());

            System.out.println("Wynagrodzenie (zł):    "+map.getWyplata());
            System.out.println("Telefon służbowy numer:    "+map.getNrTelefony());

            if (map.getClass().getName().equals("com.company.model.Handlowiec")){
                Handlowiec handlowiec = (Handlowiec)map ;
                System.out.println("Stanowisko: handlowiec");
                System.out.println("Prowizja %:    "+handlowiec.getProwizja());
                System.out.println("Limit prowizji/miesiąc (zł) :    "+handlowiec.getLimitProwizji());
            }else{
                Dyrektor dyrektor = (Dyrektor)map;
                System.out.println("Stanowisko: Dyrektor");
                System.out.println("Dodatek służbowy (zł):       " + dyrektor.getDodatek());
                System.out.println("Karta służbowa numer:       "+dyrektor.getKarta());
                System.out.println("Limit kosztów/miesiąc (zł):       "+dyrektor.getLimit());
            }


        }

        public void printMenu(){
            System.out.println("MENU");
            System.out.println("1. Lista pracownikow");
            System.out.println("2. Dodaj pracownika");
            System.out.println("3. Usun pracownika");
            System.out.println("4. Kopia zapasowa");
            System.out.println("5. Koniec programu");
        }

        public void check(){
            System.out.println("[Enter] - zapisz");
            System.out.println("[Q] - porzuc");
        }


        public  void printImie(){
            System.out.print("Imie:       ");
        }
        public  void printNazwisko(){
            System.out.print("Nazwisko:       ");
        }
        public  void printWynagrodzenie(){
            System.out.print("Wynagrodzenie (zł):       ");
        }
        public  void printTelefon(){
            System.out.print("Telefon służbowy numer:       ");
         }
         public  void printDodatek(){
             System.out.print("Dodatek służbowy (zł):       ");
        }
        public void printKarta() {
            System.out.print("Karta służbowa numer:       ");
        }

        public void printLimit(){
            System.out.print("Limit kosztów/miesiąc (zł):       ");
        }
        public void printProwizja(){
            System.out.print("Prowizja (%):       ");
        }
        public void printLimitProwizji(){
            System.out.print("Limit prowizji/miesiąc (zł):       ");
        }

        public void printKonwersja(){
            System.out.print("Kompresja [G]zip/[Z]ip :      ");
        }

        public void printNazwa(){
            System.out.print("Nazwa pliku: ");
        }
}
