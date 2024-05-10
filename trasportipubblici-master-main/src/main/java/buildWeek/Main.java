package buildWeek;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import buildWeek.DAO.*;
import buildWeek.Entity.*;
import buildWeek.Entity.Manutenzione;
import buildWeek.Enum.*;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Benvenuto, quanti biglietti desideri acquistare?");
//        Integer biglietti = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Da dove parti?");
//        System.out.println("-Napoli \n-Roma \n-Firenze \n-Frosinone \n-Milano");
//        String inizio = scanner.nextLine();
//        System.out.println("Hai scelto di partire da: " + inizio + ". Dove vuoi andare?");
//        System.out.println("-Venezia \n-Bologna \n-Torino \n-Palermo \n-Bari");
//        String arrivo = scanner.nextLine();
//
//        System.out.println("Stai acquistando " + biglietti + " biglietti per un viaggio da " + inizio + " fino a " + arrivo);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasportopubblico");
        EntityManager em = emf.createEntityManager();

        UtentiDao utentiDao = new UtentiDao(em);
        MezziDao mezziDao = new MezziDao(em);
        TrattaDao trattaDao = new TrattaDao(em);
        ManutenzioneDao manutenzioneDao = new ManutenzioneDao(em);
        ViaggioDao viaggioDao = new ViaggioDao(em);
        BigliettiDao bigliettiDao = new BigliettiDao(em);
        AbbonamentiDao abbonamentiDao = new AbbonamentiDao(em);
        DistributoreAutomaticoDao distributoreAutomaticoDao = new DistributoreAutomaticoDao(em);
        RivenditoreDao rivenditoreDao = new RivenditoreDao(em);

        Utente utente1 = new Utente(Tessera.ABBONATO,"Pippo", "Bianchi");
        Utente utente2 = new Utente(Tessera.DA_RINNOVARE,"Pluto", "Rossi");
        Utente utente3 = new Utente(Tessera.ABBONATO,"Paperino", "Verdi");
        Utente utente4 = new Utente(Tessera.DA_RINNOVARE,"Pietro", "Gambadilegno");
        utentiDao.save(utente1);
        utentiDao.save(utente2);
        utentiDao.save(utente3);
        utentiDao.save(utente4);


        List<Mezzo> mezzi = new ArrayList<>();
        Mezzo mezzo1 = new Mezzo(Servizio.ATTIVO, CapienzaMezzo.SESSANTA, TipoMezzo.AUTOBUS);
        Mezzo mezzo2 = new Mezzo(Servizio.IN_MANUTENZIONE, CapienzaMezzo.DUECENTO, TipoMezzo.TRAM);
        Mezzo mezzo3 = new Mezzo(Servizio.ATTIVO, CapienzaMezzo.DUECENTO, TipoMezzo.TRAM);
        Mezzo mezzo4 = new Mezzo(Servizio.IN_MANUTENZIONE, CapienzaMezzo.SESSANTA, TipoMezzo.AUTOBUS);
        Mezzo mezzo5 = new Mezzo(Servizio.ATTIVO, CapienzaMezzo.SESSANTA, TipoMezzo.AUTOBUS);
        mezzi.add(mezzo1);
        mezzi.add(mezzo2);
        mezzi.add(mezzo3);
        mezzi.add(mezzo4);
        mezzi.add(mezzo5);
        mezziDao.save(mezzi);


        List<Manutenzione> manutenzioni = new ArrayList<>();
        Manutenzione manutenzione1 = new Manutenzione(LocalDate.of(2024, 1, 20), LocalDate.of(2024, 2, 25), mezzo2);
        Manutenzione manutenzione2 = new Manutenzione(LocalDate.of(2024, 2, 27), LocalDate.of(2024, 3, 25), mezzo4);
        manutenzioni.add(manutenzione1);
        manutenzioni.add(manutenzione2);
        manutenzioneDao.save(manutenzioni);



        Tratta tratta1 = new Tratta("Roma","Napoli",40,mezzi);
        Tratta tratta2 = new Tratta("Trieste","Trapani",1200,mezzi);
        Tratta tratta3 = new Tratta("Firenze", "Bari", 600, mezzi);
        Tratta tratta4 = new Tratta("Anagni", "Trani", 540, mezzi);
        Tratta tratta5 = new Tratta("Napoli", "Caserta", 40, mezzi);
        Tratta tratta6 = new Tratta("Roma", "Teramo", 120, mezzi);
        List<Tratta> tratte = new ArrayList<>(List.of(tratta1, tratta2, tratta3, tratta4, tratta5, tratta6));
        trattaDao.save(tratte);


        List<Biglietto> listaTotale = new ArrayList<>();

        DistributoreAutomatico distributore1 = new DistributoreAutomatico(StatoDistributori.ATTIVO, listaTotale);
        DistributoreAutomatico distributore2 = new DistributoreAutomatico(StatoDistributori.ATTIVO, listaTotale);
        DistributoreAutomatico distributore3 = new DistributoreAutomatico(StatoDistributori.ATTIVO, listaTotale);
        DistributoreAutomatico distributore4 = new DistributoreAutomatico(StatoDistributori.ATTIVO, listaTotale);
        List<DistributoreAutomatico> distributori = new ArrayList<>(List.of(distributore1, distributore2, distributore3, distributore4));
        distributoreAutomaticoDao.save(distributori);





        Rivenditore rivenditore1 = new Rivenditore("Atac", "Piazza Conca d'Oro", listaTotale);
        Rivenditore rivenditore2 = new Rivenditore("Cata", "Piazza Rebibbia", listaTotale);
        Rivenditore rivenditore3 = new Rivenditore("Acat", "Piazza Perla d'Oro", listaTotale);
        Rivenditore rivenditore4 = new Rivenditore("Acacat", "Piazza Cacca D'oro", listaTotale);
        List<Rivenditore> rivenditori = new ArrayList<>(List.of(rivenditore1, rivenditore2, rivenditore3, rivenditore4));
        rivenditoreDao.save(rivenditori);


        Biglietto biglietto1 = new Biglietto(true, LocalTime.of(10,20,25),LocalTime.of(11,50,55), utente1, tratta1, distributore1, LocalDate.of(2024, 2, 5));
        Biglietto biglietto2 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente2, tratta5, distributore2, LocalDate.of(2024, 3, 15));
        Biglietto biglietto3 = new Biglietto(false, LocalTime.of(20,50,11), LocalTime.of(22,10,12), utente3, tratta2, distributore3, LocalDate.of(2024, 12, 25));
        Biglietto biglietto4 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore1, LocalDate.of(2024, 6, 5));
        Biglietto biglietto5 = new Biglietto(true, LocalTime.of(20,50,11), LocalTime.of(22,10,12), utente2, tratta4, rivenditore1, LocalDate.of(2024, 6, 12));
        Biglietto biglietto6 = new Biglietto(false, LocalTime.of(10,20,25),LocalTime.of(11,50,55), utente1, tratta1, distributore1, LocalDate.of(2024, 2, 13));
        Biglietto biglietto7 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente2, tratta5, distributore2, LocalDate.of(2024, 1, 5));
        Biglietto biglietto8 = new Biglietto(false, LocalTime.of(20,50,11), LocalTime.of(22,10,12), utente3, tratta2, distributore3, LocalDate.of(2024, 12, 5));
        Biglietto biglietto9 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore1, LocalDate.of(2024, 3, 21));
        Biglietto biglietto10 = new Biglietto(false, LocalTime.of(20,50,11), LocalTime.of(22,10,12), utente2, tratta4, rivenditore1, LocalDate.of(2024, 8, 2));
        Biglietto biglietto11 = new Biglietto(false, LocalTime.of(20,50,11), LocalTime.of(22,10,12), utente3, tratta2, distributore3, LocalDate.of(2024, 5, 15));
        Biglietto biglietto12 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore2, LocalDate.of(2024, 6, 5));
        Biglietto biglietto13 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore3, LocalDate.of(2024, 6, 5));
        Biglietto biglietto14 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore4, LocalDate.of(2024, 6, 5));
        Biglietto biglietto15 = new Biglietto(true, LocalTime.of(12,23,22), LocalTime.of(13,50,55), utente4, tratta3, rivenditore4, LocalDate.of(2024, 6, 5));
        bigliettiDao.save(biglietto1);
        bigliettiDao.save(biglietto2);
        bigliettiDao.save(biglietto3);
        bigliettiDao.save(biglietto4);
        bigliettiDao.save(biglietto5);
        bigliettiDao.save(biglietto6);
        bigliettiDao.save(biglietto7);
        bigliettiDao.save(biglietto8);
        bigliettiDao.save(biglietto9);
        bigliettiDao.save(biglietto10);
        bigliettiDao.save(biglietto11);
        bigliettiDao.save(biglietto12);
        bigliettiDao.save(biglietto13);
        bigliettiDao.save(biglietto14);
        bigliettiDao.save(biglietto15);

        listaTotale.add(biglietto1);


        Viaggio viaggio1 = new Viaggio( LocalTime.of(10,20,25), LocalTime.of(12,20,25), mezzo1, tratta1);
        Viaggio viaggio2 = new Viaggio( LocalTime.of(12,25, 25), LocalTime.of(13, 5,15), mezzo5, tratta2);
        Viaggio viaggio3 = new Viaggio( LocalTime.of(10,20,25), LocalTime.of(12,20,25), mezzo2, tratta3);
        Viaggio viaggio4 = new Viaggio( LocalTime.of(12,25, 25), LocalTime.of(13, 5,15), mezzo3, tratta4);
        Viaggio viaggio5 = new Viaggio( LocalTime.of(10,20,25), LocalTime.of(12,20,25), mezzo1, tratta6);
        Viaggio viaggio6 = new Viaggio( LocalTime.of(12,25, 25), LocalTime.of(13, 5,15), mezzo5, tratta5);
        Viaggio viaggio7 = new Viaggio( LocalTime.of(10,20,25), LocalTime.of(12,20,25), mezzo3, tratta1);
        Viaggio viaggio8 = new Viaggio( LocalTime.of(12,25, 25), LocalTime.of(13, 5,15), mezzo5, tratta2);
        viaggioDao.save(viaggio1);
        viaggioDao.save(viaggio2);
        viaggioDao.save(viaggio3);
        viaggioDao.save(viaggio4);
        viaggioDao.save(viaggio5);
        viaggioDao.save(viaggio6);
        viaggioDao.save(viaggio7);
        viaggioDao.save(viaggio8);

        mezzo1.addBiglietto(biglietto1);
        mezzo1.addBiglietto(biglietto2);
        mezzo3.addBiglietto(biglietto4);
        mezzo3.addBiglietto(biglietto5);
        mezzo3.addBiglietto(biglietto7);

        mezzo5.addViaggio(viaggio8);
        mezzo5.addViaggio(viaggio2);


        Abbonamento abbonamento1 = new Abbonamento(Stato.ATTIVO, DurataAbbonamento.ANNUALE, utente1);
        Abbonamento abbonamento2 = new Abbonamento(Stato.ATTIVO, DurataAbbonamento.MENSILE, utente3);
        Abbonamento abbonamento3 = new Abbonamento(Stato.NON_ATTIVO, DurataAbbonamento.ANNUALE, utente2);

        abbonamentiDao.save(abbonamento1);
        abbonamentiDao.save(abbonamento2);
        abbonamentiDao.save(abbonamento3);

        distributoreAutomaticoDao.getBigliettiPerDistributoreAutomatico();

//        System.out.println(distributoreAutomaticoDao.getBigliettiPerDistributoreAutomatico());

        List<Object[]> results = distributoreAutomaticoDao.getBigliettiPerDistributoreAutomatico();

        System.out.println("----------------------------------------------");
        System.out.println("Biglietti emessi per Distributore automatico:");
        for (Object[] result : results) {
            Integer distributoreId = (Integer) result[0];
            Number anno = (Number) result[1];
            Number mese = (Number) result[2];
            Number numeroBiglietti = (Number) result[3];

            System.out.println("ID Distributore: " + distributoreId +
                    ", Anno: " + anno +
                    ", Mese: " + mese +
                    ", Numero di Biglietti: " + numeroBiglietti);
        }

        List<Object[]> rivenditoreResults = rivenditoreDao.getBigliettiPerRivenditore();
        System.out.println("----------------------------------------------");
        System.out.println("Biglietti emessi per Rivenditore Autorizzato:");
        for (Object[] result : rivenditoreResults) {
            Integer rivenditoreId = (Integer) result[0];
            Number anno = (Number) result[1];
            Number mese = (Number) result[2];
            Number numeroBiglietti = (Number) result[3];

            System.out.println("ID Rivenditore: " + rivenditoreId +
                    ", Anno: " + anno +
                    ", Mese: " + mese +
                    ", Numero di Biglietti: " + numeroBiglietti);
        }


        List<Object[]> mezzoResults = mezziDao.getBigliettiPerMezzo();

        System.out.println("----------------------------------------------");
        System.out.println("Biglietti Timbrati per Mezzo: ");
        for (Object[] result : mezzoResults) {
            Integer mezzoId = (Integer) result[0];
            Number numeroBiglietti = (Number) result[1];

            System.out.println("ID Mezzo: " + mezzoId +
                    ", Numero di Biglietti Timbrati: " + numeroBiglietti);
        }

        System.out.println("Viaggi di un dato mezzo per tratta");
        Number viaggiPerTratta = viaggioDao.getViaggiPerTratta(tratta2, mezzo5);
        System.out.println(viaggiPerTratta);
    }

}
