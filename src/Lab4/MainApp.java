package Lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    static List<Echipament> echipamente = new ArrayList<>();
    private static void afisareEchipamente() {
        for (Echipament echipament : echipamente) {
            System.out.println(echipament);
        }
    }

    private static void afisareImprimante() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Imprimanta) {
                System.out.println(echipament);
            }
        }
    }

    private static void afisareCopiatoare() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Copiator) {
                System.out.println(echipament);
            }
        }
    }

    private static void afisareSistemeCalcul() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof SistemCalcul) {
                System.out.println(echipament);
            }
        }
    }

    private static void modificareStareEchipament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti nr echipamentului: ");
        int nr_inv = scanner.nextInt();
        scanner.nextLine();

        for (Echipament echipament : echipamente) {
            if (echipament.getNr_inv() == nr_inv) {
                System.out.print("Introduceti noua stare: achizitionat, expus sau vandut: ");
                String nouaStare = scanner.next();
                try {
                    situatieEchipament stare = situatieEchipament.valueOf(nouaStare);
                    echipament.setSituatie(stare);
                    System.out.println("Actualizat");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Actualizare nereusita");
                    return;
                }
            }
        }

        System.out.println("Echipamentul cu nr. " + nr_inv+ " nu a fost găsit.");
    }

    private static void setareModTiparireImprimanta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți nr imprimantei pentru modificare: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        for (Echipament echipament : echipamente) {
            if (echipament instanceof Imprimanta && echipament.getNr_inv() == nrInv) {
                Imprimanta imprimanta = (Imprimanta) echipament;
                System.out.print("Introduceți noul mod de tiparire (color sau alb negru): ");
                String mod_tip = scanner.nextLine();
                try {
                    modTiparire mod = modTiparire.valueOf(mod_tip);
                    imprimanta.setM_tiparire(mod);
                    System.out.println("Actualizat.");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Actualizare nereusita");
                    return;
                }
            }
        }

        System.out.println("Imprimanta cu numărul de inventar " + nrInv + " nu a fost găsită.");
    }

    private static void setareFormatCopiereCopiator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți nr copiatorului pentru modificare: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        for (Echipament echipament : echipamente) {
            if (echipament instanceof Copiator && echipament.getNr_inv() == nrInv) {
                Copiator copiator = (Copiator) echipament;
                System.out.print("Introduceți noul format de copiere :A3 sau A4 ");
                String format_copiere = scanner.nextLine();
                try {
                    formatCopiere format = formatCopiere.valueOf(format_copiere);
                    copiator.setF_copiere(format);
                    System.out.println("Actualizat.");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Actualizare nereusita");
                    return;
                }
            }
        }

        System.out.println("Copiatorul cu numărul de inventar " + nrInv + " nu a fost găsit.");
    }

    private static void instalareSistemOperareSistemCalcul() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de inventar al sistemului de calcul pentru instalare sistem de operare: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        for (Echipament echipament : echipamente) {
            if (echipament instanceof SistemCalcul && echipament.getNr_inv() == nrInv) {
                SistemCalcul sistemCalcul = (SistemCalcul) echipament;
                System.out.print("Introduceți sistemul de operare windows sau linux: ");
                String sist = scanner.nextLine();
                if ("windows".equalsIgnoreCase(sist)) {
                    sistemCalcul.setS_operare(sistemOperare.windows);
                    System.out.println("Instalat.");
                } else if ("linux".equalsIgnoreCase(sist)) {
                    sistemCalcul.setS_operare(sistemOperare.linux);
                    System.out.println("Instalat.");
                } else {
                    System.out.println("Operatiune nereusita");
                }
                return;
            }
        }

        System.out.println("Sistemul de calcul cu numărul de inventar " + nrInv + " nu a fost găsit.");
    }

    private static void afisareEchipamenteVandute() {
        for (Echipament echipament : echipamente) {
            if (echipament.getSituatie() == situatieEchipament.vandut) {
                System.out.println("Echipamente vandute:" + echipament);
            }
        }
    }

    private static void serializareColectieObiecte() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("echip.bin"))) {
            out.writeObject(echipamente);
            System.out.println("Colecția de obiecte a fost serializată");
        } catch (IOException e) {
            System.out.println("Eroare " + e.getMessage());
        }
    }

    private static void deserializareColectieObiecte() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("echip.bin"))) {
            echipamente = (List<Echipament>) in.readObject();
            System.out.println("Colecția de obiecte a fost deserializată");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eroare " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "echipamente.txt";
        try {
            BufferedReader flux_in = new BufferedReader(new FileReader(inputFile));
            String linie;
            while ((linie = flux_in.readLine()) != null) {
                String[] dateImpartite = linie.split(";");
                if (dateImpartite.length >= 8) {
                    String denumire = dateImpartite[0];
                    int nr_inv = Integer.parseInt(dateImpartite[1]);
                    double pret = Double.parseDouble(dateImpartite[2]);
                    String zona_mag = dateImpartite[3];
                    situatieEchipament stare = situatieEchipament.valueOf(dateImpartite[4]);
                    String tipEchipament = dateImpartite[5];

                    switch (tipEchipament) {
                        case "imprimanta":
                            int ppm = Integer.parseInt(dateImpartite[6]);
                            String rezolutie = dateImpartite[7];
                            int paginiCarut = Integer.parseInt(dateImpartite[8]);
                            modTiparire mod_tiparire = modTiparire.valueOf(dateImpartite[9]);
                            Imprimanta imprimanta = new Imprimanta(denumire, nr_inv, pret, zona_mag, stare, ppm, rezolutie, paginiCarut, mod_tiparire);
                            echipamente.add(imprimanta);
                            break;
                        case "copiator":
                            int paginiToner = Integer.parseInt(dateImpartite[6]);
                            formatCopiere form_copiere = formatCopiere.valueOf(dateImpartite[7]);
                            Copiator copiator = new Copiator(denumire, nr_inv, pret, zona_mag, stare, paginiToner, form_copiere);
                            echipamente.add(copiator);
                            break;
                        case "sistem de calcul":
                            String tipMonitor = dateImpartite[6];
                            double vitezaProcesor = Double.parseDouble(dateImpartite[7]);
                            int capacitateHDD = Integer.parseInt(dateImpartite[8]);
                            sistemOperare sist = sistemOperare.valueOf(dateImpartite[9]);
                            SistemCalcul sistemCalcul = new SistemCalcul(denumire, nr_inv, pret, zona_mag, stare, tipMonitor, vitezaProcesor, capacitateHDD, sist);
                            echipamente.add(sistemCalcul);
                            break;
                        default:
                            System.out.println("Tip de echipament necunoscut: " + tipEchipament);
                    }

                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișare toate echipamentele");
            System.out.println("2. Afișare imprimante");
            System.out.println("3. Afișare copiatoare");
            System.out.println("4. Afișare sisteme de calcul");
            System.out.println("5. Modificare stare echipament");
            System.out.println("6. Setare mod de tiparire pentru imprimanta");
            System.out.println("7. Setare format de copiere pentru copiator");
            System.out.println("8. Instalare sistem de operare pentru sistem de calcul");
            System.out.println("9. Afișare echipamente vândute");
            System.out.println("10. Serializare colecție de obiecte");
            System.out.println("11. Deserializare colecție de obiecte");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");

            int opt;
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    afisareEchipamente();
                    break;
                case 2:
                    afisareImprimante();
                    break;
                case 3:
                    afisareCopiatoare();
                    break;
                case 4:
                    afisareSistemeCalcul();
                    break;
                case 5:
                    modificareStareEchipament();
                    break;
                case 6:
                    setareModTiparireImprimanta();
                    break;
                case 7:
                    setareFormatCopiereCopiator();
                    break;
                case 8:
                    instalareSistemOperareSistemCalcul();
                    break;
                case 9:
                    afisareEchipamenteVandute();
                    break;
                case 10:
                    serializareColectieObiecte();
                    break;
                case 11:
                    deserializareColectieObiecte();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
    }
}