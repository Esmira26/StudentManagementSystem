package student;

import java.util.Scanner;

public class StudentTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int maxtelebe = 20;

        String[] name = new String[maxtelebe];
        int[] age = new int[maxtelebe];
        double[] point = new double[maxtelebe];
        char[] lettergrade = new char[maxtelebe];
        boolean[] transitionStatus = new boolean[maxtelebe];

        int studentnumber = 0;
        int choice;

        do {
            System.out.println("Telebe İdareetme Sistemine xos gelmisiniz!");
            System.out.println("1. Tələbə əlavə et");
            System.out.println("2. Bütün tələbələri göstər");
            System.out.println("3. Sinif Statistikaları");
            System.out.println("4. Tələbə Axtarışı");
            System.out.println("5. Yaş Aralığına görə Filtr");
            System.out.println("6. Keçid Statusuna görə Filtr");
            System.out.println("7. Qiymətə görə Sıralama");
            System.out.println("8. Ad-a gore silinme");
            System.out.println("0. Çıxış");
            System.out.print("Seçim edin: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    if (studentnumber < maxtelebe) {
                        System.out.println("Telebenin adi: ");
                        String newName = scanner.nextLine();
                        boolean incorrect = false;

                        for (int i = 0; i < studentnumber; i++) {
                            if (name[i].equalsIgnoreCase(newName)) {
                                incorrect = true;
                                break;
                            }
                        }
                        if (incorrect) {
                            System.out.println("Bu adda telebe var, yeniden daxil etmek olmaz!");
                        } else {
                            name[studentnumber] = newName;

                            System.out.println("Telebenin yasi: ");
                            age[studentnumber] = scanner.nextInt();

                            System.out.println("Telebenin bali: ");
                            point[studentnumber] = scanner.nextDouble();

                            if (point[studentnumber] > 90) {
                                lettergrade[studentnumber] = 'A';
                            } else if (point[studentnumber] > 80) {
                                lettergrade[studentnumber] = 'B';
                            } else if (point[studentnumber] > 70) {
                                lettergrade[studentnumber] = 'C';
                            } else if (point[studentnumber] > 60) {
                                lettergrade[studentnumber] = 'D';
                            } else {
                                lettergrade[studentnumber] = 'F';
                            }

                            studentnumber++;
                            System.out.println("Telebe elave olundu!");
                        }
                    }
                    else{
                        System.out.println("Max telebe sayina catdirilib deye, elave etmek mumkun deyil!");
                    }
                    break;

                case 2:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("Movcud olan butun telebeler: ");
                        for (int i = 0; i < studentnumber; i++){
                            System.out.println((i + 1) + ". Telebe:" + "\n Adi: " + name[i] + "\n Yasi: " + age[i] + "\n Bali: " + point[i] + "\n Aldigi bala uygun herf: " + lettergrade[i]);
                        }
                    }
                    break;

                case 3:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        double sum = 0;
                        double max = point[0];
                        double min = point[0];
                        int passCount = 0;
                        int failCount = 0;
                        int totalAge = 0;


                        for (int i = 0; i < studentnumber; i++){
                            sum += point[i];
                            totalAge += age[i];

                            if (point[i] < min) min = point[i];
                            if (point[i] > max) max = point[i];

                            if (point[i] >50){
                                passCount++;
                            }
                            else {
                                failCount++;
                            }
                        }

                        double avaragenumber = sum / studentnumber;
                        double avarageage =totalAge / studentnumber;
                        System.out.println("Ededi orta: " + avaragenumber);
                        System.out.println("Orta yas: " + avarageage);
                        System.out.println("En yuksek bal: " + max);
                        System.out.println("En asagi bal: " + min);
                        System.out.println("Kecen telebelerin sayi: " + passCount);
                        System.out.println("Kecmiyen telebelerin sayi: " + failCount);
                    }
                    break;

                case 4:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("Axtarilacaq telebenin adini daxil edin: ");
                        String searchname = scanner.nextLine().trim();
                        boolean found = false;

                        for (int i = 0; i < studentnumber; i++){
                            if (name[i].equalsIgnoreCase(searchname)){
                                System.out.println("Axtarilan telebe tapildi: ");
                                System.out.println("Telebenin Adi: " + name[i] + "\n" + "Yasi: " + age[i] + "\n" + "Bali: " + point
                                [i] + "\n" + (point[i] > 50 ? "Telebe kecid bali kecib" : "Telebe kecid bali kecmiyib"));
                                found = true;
                            }
                        }
                        if (!found){
                            System.out.println("Bele adli telebe yoxdur!");
                        }
                    }
                    break;

                case 5:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("Telebe ucun min yas daxil edin: ");
                        int minAge = scanner.nextInt();

                        System.out.println("Telebe ucun max yas daxil edin: ");
                        int maxAge = scanner.nextInt();

                        boolean found = false;

                        for(int i = 0; i < studentnumber; i++){
                            if (age[i] >= minAge && age[i] <= maxAge){
                                System.out.println("Daxil etdiyin yas araliginda olan telebeler: ");
                                System.out.println("Ad: " + name[i] + "\n" + "Yas: " + age[i] + "\n" + "Bal: " + point[i]);
                                found = true;
                            }
                        }

                        if (!found){
                            System.out.println("Bu yas araliginda telebe yoxdur!");
                        }
                    }
                    break;

                case 6:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("1. Kecen telebeleri goster: ");
                        System.out.println("2. Qalan telebeleri goster: ");
                        System.out.println("Seciminizi daxil edin: ");
                        int secim = scanner.nextInt();

                        boolean found = false;

                       if (secim == 1){
                           System.out.println("Kecidi kecen telebeler: ");
                           for (int i = 0; i < studentnumber; i++){
                               if (point[i] > 50){
                                   System.out.println("Ad: " + name[i] + "\n" + "Bal: " + point[i]);
                                   found = true;
                               }
                           }
                           if (!found){
                               System.out.println("Hec bir netice tapilmadi!");
                           }
                       } else if (secim == 2) {
                           System.out.println("Qalan telebeler: ");
                           for (int i = 0; i < studentnumber; i++){
                               if (point[i] <= 50){
                                   System.out.println("Ad: " + name[i] + "\n" + "Bal: " + point[i]);
                                   found = true;
                               }
                           }
                           if (!found){
                               System.out.println("Hec bir netice tapilmadi!");
                           }
                       }
                       else{
                           System.out.println("Seciminizi duzgun edin!");
                       }
                    }
                    break;

                case 7:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("Secimlerden 1-ni edin!");
                        System.out.println("1.Qiymetleri artma ardicilligi ile goster: ");
                        System.out.println("2.Qiymetleri azalma ardicilligi ile goster: ");
                        int secim = scanner.nextInt();

                        for (int i = 0; i < studentnumber - 1; i++) {
                            for (int j = 0; j < studentnumber - 1 - i; j++) {
                                boolean condition = false;
                                if (secim == 1) {
                                    condition = point[j] > point[j + 1];
                                } else if (secim == 2) {
                                    condition = point[j] < point[j + 1];
                                } else {
                                    System.out.println("Yanlis secim etdiniz.");
                                    return;
                                }
                                if (condition) {
                                    double tempPoint = point[j];
                                    point[j] = point[j + 1];
                                    point[j + 1] = tempPoint;
                                }
                            }
                        }

                        for (int i = 0; i < studentnumber; i++) {
                            System.out.println(" Bal: " + point[i]);
                        }
                    }
                    break;

                case 8:
                    if (studentnumber == 0){
                        System.out.println("Siyahi bosdur, Telebe elave olunmayib!");
                    }
                    else{
                        System.out.println("Silmek istediyiniz telebenin adini daxil edin:");
                        String removename = scanner.nextLine();

                        boolean removed = false;

                        for (int i = 0; i < studentnumber; i++){
                            if (name[i].equalsIgnoreCase(removename)){
                                studentnumber--;
                                removed = true;
                            }
                        }
                        if (removed){
                            System.out.println(removename + " adli telebe siyahidan silindi!");
                        }
                        else{
                            System.out.println("Bu adli telebe yoxdur!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Sistemden cixis edilir...");
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }while (choice != 0);
    }
}
