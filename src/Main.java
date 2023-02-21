import java.time.LocalDate;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static int dayHim = 0;
    public static int monthHim = 0;
    public static int PfSD = 0;
    public static int PfSM = 0;
    public static int PfMD = 0;
    public static int PfMM = 0;

    public static void main(String[] args) {

        // next introduction

        System.out.println("Bitte geben sie mir das Jahr für das die Feiertage berechnet werden sollen.");
        Scanner scanner = new Scanner(System.in);
        int yearEingabe = Integer.valueOf(scanner.nextLine());
        System.out.println("Nun gaben sie das Bundesland an.");
        System.out.println(" 1: Baden-Württemberg");
        System.out.println(" 2: Bayern");
        System.out.println(" 3: Berlin");
        System.out.println(" 4: Brandenburg");
        System.out.println(" 5: Bremen");
        System.out.println(" 6: Hamburg");
        System.out.println(" 7: Hessen");
        System.out.println(" 8: Mecklenburg-Vorpommern");
        System.out.println(" 9: Niedersachsen");
        System.out.println("10: Nordrhein-Westfalen");
        System.out.println("11: Rheinland-Pfalz");
        System.out.println("12: Saarland");
        System.out.println("13: Sachsen");
        System.out.println("14: Sachsen-Anhalt");
        System.out.println("15: Schleswig-Holstein");
        System.out.println("16: Thüringen");

        int Bundesland = Integer.valueOf(scanner.nextLine());
        LocalDate date = gauss(yearEingabe);
        int dayOfMonth = date.getDayOfMonth();
        int monthOfDay = date.getMonthValue();
        int OsterFreitag = dayOfMonth - 2;
        int Ostermontag = dayOfMonth + 1;

        // next for calculating Himmelsfahrt

        if(monthOfDay == 3) {
            int tagHimmelsfahrt = dayOfMonth + 39;
            int mouthHimmelsfahrt = monthOfDay;
            if(tagHimmelsfahrt >= 31) {
                tagHimmelsfahrt = tagHimmelsfahrt - 31;
                mouthHimmelsfahrt = mouthHimmelsfahrt + 1;
                dayHim = tagHimmelsfahrt;
                monthHim = mouthHimmelsfahrt;
                if(tagHimmelsfahrt >= 30) {
                    tagHimmelsfahrt = tagHimmelsfahrt - 30;
                    mouthHimmelsfahrt = mouthHimmelsfahrt + 1;
                    dayHim = tagHimmelsfahrt;
                    monthHim = mouthHimmelsfahrt;
                }
            }
        }
        else {
            if(monthOfDay == 4) {
                int tagHimmelsfahrt = dayOfMonth + 39;
                int mouthHimmelsfahrt = monthOfDay;
                if(tagHimmelsfahrt >= 30) {
                    tagHimmelsfahrt = tagHimmelsfahrt - 30;
                    mouthHimmelsfahrt = mouthHimmelsfahrt + 1;
                    dayHim = tagHimmelsfahrt;
                    monthHim = mouthHimmelsfahrt;
                    if(tagHimmelsfahrt >= 31) {
                        tagHimmelsfahrt = tagHimmelsfahrt - 31;
                        mouthHimmelsfahrt = mouthHimmelsfahrt + 1;
                        dayHim = tagHimmelsfahrt;
                        monthHim = mouthHimmelsfahrt;
                    }
                }
            }
        }

        // next for calculating Pfingstsonntag

        if(monthHim == 4) {
            int tagPFSonntag = dayHim + 10;
            int monthPFSonntag = monthHim;
            if(tagPFSonntag >= 30) {
                tagPFSonntag = tagPFSonntag - 30;
                monthPFSonntag = monthPFSonntag + 1;
                PfSD = tagPFSonntag;
                PfSM = monthPFSonntag;
            }
        }
        if(monthHim == 5) {
            int tagPFSonntag = dayHim + 10;
            int monthPFSonntag = monthHim;
            PfSD = tagPFSonntag;
            PfSM = monthPFSonntag;
            if(tagPFSonntag > 31) {
                tagPFSonntag = tagPFSonntag - 31;
                monthPFSonntag = monthPFSonntag + 1;
                PfSD = tagPFSonntag;
                PfSM = monthPFSonntag;
            }
        }
        if(monthHim == 6) {
            int tagPFSonntag = dayHim + 10;
            int monthPFSonntag = monthHim;
            PfSD = tagPFSonntag;
            PfSM = monthPFSonntag;
        }

        // next for calculating Pfingstmontag

        if(PfSM == 5) {
            int tagPFMontag = PfSD + 1;
            int monthPFMontag = PfSM;
            PfMD = tagPFMontag;
            PfMM = monthPFMontag;
            if(tagPFMontag > 31) {
                tagPFMontag = tagPFMontag - 31;
                monthPFMontag = monthPFMontag + 1;
                PfMD = tagPFMontag;
                PfMM = monthPFMontag;
            }
        }
        if(PfSM == 6) {
            int tagPFMontag = PfSD + 1;
            int monthPFMontag = PfSM;
            PfMD = tagPFMontag;
            PfMM = monthPFMontag;
        }

        // next output result

        System.out.println("1.1." + yearEingabe + ": Neujahrstag");

        if(Bundesland == 1) {
            System.out.println("6.1." + yearEingabe + ": Heiligen drei Könige");
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("1.11." + yearEingabe + ": Allerheiligen");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 2) {
            System.out.println("6.1." + yearEingabe + ": Heiligen drei Könige");
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("1.11." + yearEingabe + ": Allerheiligen");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 3) {
            System.out.println("8.1." + yearEingabe + ": Frauentag");
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 4) {
            System.out.println(OsterFreitag + ".0" + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(dayOfMonth + "." + monthOfDay + "." + yearEingabe + ": Ostersonntag");
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfSD + "." + PfSM + "." + yearEingabe + ": Pfingstsonntag");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 5) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 6) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 7) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(dayOfMonth + "." + monthOfDay + "." + yearEingabe + ": Ostersonntag");
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfSD + "." + PfSM + "." + yearEingabe + ": Pfingstsonntag");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 8) {
            System.out.println("8.1." + yearEingabe + ": Frauentag");
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 9) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 10) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("1.11." + yearEingabe + ": Allerheiligen");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 11) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("1.11." + yearEingabe + ": Allerheiligen");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 12) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("1.11." + yearEingabe + ": Allerheiligen");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 13) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 14) {
            System.out.println("6.1." + yearEingabe + ": Heiligen drei Könige");
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 15) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }
        if(Bundesland == 16) {
            System.out.println(OsterFreitag + "." + monthOfDay + "." + yearEingabe + ": Karfreitag" );
            System.out.println(Ostermontag + "." + monthOfDay + "." + yearEingabe + ": Ostermontag" );
            System.out.println("1.5." + yearEingabe + ": Tag der Arbeit");
            System.out.println(dayHim + "." + monthHim + "." + yearEingabe + ": Himmelsfahrt");
            System.out.println(PfMD + "." + PfMM + "." + yearEingabe + ": Pfingstmontag");
            System.out.println("20.9." + yearEingabe + ": Weltkindertag");
            System.out.println("3.10." + yearEingabe + ": Tag der Deutschen Einheit");
            System.out.println("31.10." + yearEingabe + ": Reformationstag");
            System.out.println("25.12." + yearEingabe + ": 1.Weihnachtsfeiertag");
            System.out.println("26.12." + yearEingabe + ": 2.Weihnachtsfeiertag");
        }

    }

    // next for calculating Ostersonntag
    static LocalDate gauss(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int H1 = year / 100;
        int H2 = year / 400;
        int N = 4 + H1 - H2;
        int M = 15 + H1 - H2 - (8 * H1 + 13) / 25;
        int d = (19 * a + M) % 30;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int f = (c + 11 * d + 22 * e) / 451;
        int tage = 22 + d + e - 7 * f;
        return LocalDate.of(year, 3, 1).plus(tage - 1, DAYS);
    }
}
