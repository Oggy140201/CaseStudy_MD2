package menu;

import controller.Manager;
import model.CC.Employee;
import model.CR.SecretarialStaff;

import java.util.*;

public class MenuThread extends Thread{
    static Manager manager = new Manager();
    public static Map<String , String> users = new HashMap<String , String>();
    static Scanner scanner = new Scanner(System.in);

    public void run() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new SecretarialStaff("Nguyễn Văn A", 23, "Cà Mau", 001, 10.000000, 25));
        list.add(new SecretarialStaff("Phan Thị B", 24, "Hà Nội", 002, 11.000000, 26));
        list.add(new SecretarialStaff("Trần Văn C", 25, "Hải Phòng", 003, 12.000000, 27));
        list.add(new SecretarialStaff("Giàng Văn D", 26, "Đà Nẵng", 004, 13.000000, 28));
        list.add(new SecretarialStaff("Cao Văn E", 27, "Phú Yên", 005, 14.000000, 29));
        boolean exit = false;
        manager.writeCsv(list);
        manager.readFile();
        System.out.println("Đây là danh sách nhân viên đã có: \n" + list);
        while (!exit) {
            System.out.println("""
                    \n                                 ᠁᠁ WELCOME TO LOGIN ᠁᠁                                     \n
                                                \033[35m֍🐾🐾🐾🐾🐾🐾🐾❚█══█❚🐾🐾🐾🐾🐾🐾🐾🐾֎
                                                𒁂                MENU               𒁂
                                                〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 
                                                ✍ ✍ ✍ ✍         ⚆ _ ⚆         ✍ ✍ ✍ ✍
                                                ✅ 1. Login🔒                        ⚓
                                                ✅ 2. Register🔑                     ⚓
                                                ✅ 3. DeleteAccount                  ⚓
                                                ✅ 4. DisPlayAccount                 ⚓
                                                ✅ 0. Exit                           ⚓
                                                ⏩===================================⏪
                                                 ❤ ᚐ  ᚑᚑ  ᚒᚒ  ᚓᚓ  ☑💖☑ ᚓᚓ  ᚒᚒ  ᚑᚑ  ᚐ  ❤               
                                                💯===================================💯\033[0m
                    \n                                PLEASE ENTER YOUR SELECTION                                    \n
                    """);
            String choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1":
                    if (!manager.login()) {
                        manager.setLoadingThread();
                        break;
                    }
                    while (true) {
                        System.out.println("""
                                \n                         WELCOME TO THE MAIN MENU                                   \n 
                                                 \033[33m〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓
                                                 |𒋨                MENU               𒋨|
                                                 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓
                                                 | ❶, Add Employee                         |
                                                 | ❷, Edit By Type                         |
                                                 | ❸, Delete By Type Employee              |
                                                 | ❹, Search Employee                      |
                                                 | ❺, Staff Arrangenment                   |
                                                 | ❻, Display Employee                     |
                                                 | ❼, CheckEmployee                        |
                                                 | ❽, PayRollEmployee                      |
                                                 | 𝟘,Exit                                  |
                                                 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓
                                                 |▬▬ι═══════ﺤ▬▬★𝑳𝒖𝒄𝒊𝒇𝒆𝒓︵★ﺤ▬ι═══════ﺤ▬▬ι|
                                                 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\033[0m
                                """);
                        String choice0 = new Scanner(System.in).nextLine();
                        switch (choice0) {
                            case "1":
                                manager.addEmployee();
                                break;
                            case "2":
                                boolean choice1 = true;
                                while (choice1) {
                                    System.out.println("""
                                                          \033[32m============================
                                                          |            MENU          |
                                                          ============================
                                                          | 1.EditName.              |
                                                          | 2.EditAge.               |
                                                          | 3.EditID.                |
                                                          | 4.EditSalary.            |
                                                          | 5.Exit.                  |
                                                          ============================
                                                          |
                                                          ============================\033[0m
                                            """);
                                    int num = Integer.parseInt(scanner.nextLine());
                                    switch (num) {
                                        case 1:
                                            manager.editName();
                                            break;
                                        case 2:
                                            manager.editAge();
                                            break;
                                        case 3:
                                            manager.editId();
                                            break;
                                        case 4:
                                            manager.editSalary();
                                            break;
                                        case 5:
                                            choice1 = false;
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                manager.deleteLogin();
                                break;
                            case "4":
                                manager.searchE();
                                break;
                            case "5":
                                manager.arrangeEmployee();
                                break;
                            case "6":
                                manager.disPlay();
                                break;
                            case "7":
                                manager.checkSecretarialStaff();
                                break;
                            case "8":
                                manager.payRoll();
                                break;
                            case "0":
                                break;
                        }
                    }
                case "2":
                    manager.register();
                    break;
                case "3":
                    manager.deleteLogin();
                    break;
                case "4":
                    manager.disPlayAccount();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
