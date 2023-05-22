package controller;

import model.CC.Employee;
import model.CD.LoadingThread;
import model.CR.Accountant;
import model.CR.FullTimeStaff;
import model.CR.PartTimeStaff;
import model.CR.SecretarialStaff;
import model.Regex.MyRegex;
import model.Regex.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Manager extends JFrame implements Comparable<Employee> {
    MyRegex myRegex = new MyRegex();
    ArrayList<Employee> list;
    static Map<String, String> map = new TreeMap<>();
    ArrayList<User> listUser = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String admin = "tienanh@gmail.com";
    String passWord = "007";

    private JTextField usernameField;
    private JPasswordField passwordField;
    LoadingThread loadingThread = new LoadingThread();


    public void setLoadingThread() {
        loadingThread.start();
        try {
            loadingThread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int id;

    public void addEmployee() {
        System.out.println("""
                \033[31m=================================
                |             MENU 1            |
                =================================
                | 1/ Add SecretarialStaff       |
                | 2/ Add Accountant             |
                | 3/ Add FullTimeStaff          |
                | 4/ Add PartTimeStaff          |
                | 5/ Exit                       |
                =================================
                |             END               |
                =================================\033[0m
                """);
        boolean choice = true;
        while (choice) {
            int num = Integer.parseInt(scanner.nextLine());
            switch (num) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Day: ");
                    int day = Integer.parseInt(scanner.nextLine());
                    Employee secretarialStaff = new SecretarialStaff(name, age, address, ++id, salary, day);
                    list.add(secretarialStaff);
                    addList();
                    writeCsv(list);
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name0 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age0 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Address: ");
                    String address0 = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary0 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Day: ");
                    int day0 = Integer.parseInt(scanner.nextLine());
                    Employee accountant = new Accountant(name0, age0, address0, ++id, salary0, day0);
                    list.add(accountant);
                    addList();
                    writeCsv(list);
                    break;
                case 3:
                    System.out.print("Enter Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Address: ");
                    String address1 = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Day: ");
                    int day1 = Integer.parseInt(scanner.nextLine());
                    Employee fullTimeStaff = new SecretarialStaff(name1, age1, address1, ++id, salary1, day1);
                    list.add(fullTimeStaff);
                    addList();
                    writeCsv(list);
                    break;
                case 4:
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Address: ");
                    String address2 = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary2 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Day: ");
                    int workingHouse = Integer.parseInt(scanner.nextLine());
                    Employee partTimeStaff = new PartTimeStaff(name2, age2, address2, ++id, salary2, workingHouse);
                    list.add(partTimeStaff);
                    addList();
                    writeCsv(list);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng.Mời bạn nhập lại");
            }
            break;
        }
    }


    public Manager() {
        list = new ArrayList<>();
        list = (ArrayList<Employee>) readFile();
        if (list.size() == 0) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId();
        }
    }

    public void addList() {
        System.out.println("""
                                    
                \033[30m=============================
                |           MENU 2          |
                =============================
                | 1/ Do you want more?      |
                | 2/ Exit                   |
                -----------------------------
                |                           |
                -----------------------------\033[0m
                """);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                addEmployee();
                break;
            case 2:
                break;

        }
    }


//    public static boolean login() {
//        if(manager.login()){
//            return true;
//        }
//        manager.checkLogin(manager.getListUser(),scanner);
//        return false;
//    }
//
//    public static void register() {
//        manager.register();
//    }
//
//    public static void disPlayAccount(){
//        manager.disPlayAccount();
//    }
//    public static void delete(){
//        manager.delete();
//    }


    //sửa theo tên
    public void editName() {
        System.out.println("Enter the name you want to edit: ");
        String check = scanner.nextLine();
        boolean isExted = false;
        for (Employee e : list) {
            if (e.getName().equals(check)) {
                isExted = true;
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                e.setName(newName);
                System.out.println("Đã thay đổi tên thành công. " + newName);
                break;
            }
        }
        if (!isExted) {
            System.err.println("Không có mã nhân viên này. ");
        }
    }

    //sửa theo id
    public void editId() {
        System.out.println("Nhập id nhân viên muốn sửa: ");
        int check = Integer.parseInt(scanner.nextLine());
        boolean isExted = false;
        for (Employee e : list) {
            if (e.getId() == check) {
                isExted = true;
                System.out.println("Nhập tên mới: ");
                int newName = Integer.parseInt(scanner.nextLine());
                e.setId(newName);
                System.out.println("Đã thay đổi tên thành công. " + newName);
                break;
            }
        }
        if (!isExted) {
            System.err.println("Không có mã nhân viên này. ");
        }
    }

    //sửa theo tuổi
    public void editAge() {
        System.out.println("Nhập tuổi nhân viên muốn sửa: ");
        int check = Integer.parseInt(scanner.nextLine());
        boolean isExted = false;
        for (Employee e : list) {
            if (e.getAge() == check) {
                isExted = true;
                System.out.println("Nhập tên mới: ");
                int newName = Integer.parseInt(scanner.nextLine());
                e.setAge(newName);
                System.out.println("Đã thay đổi tên thành công. " + newName);
                break;
            }
        }
        if (!isExted) {
            System.err.println("Không có mã nhân viên này. ");
        }
    }

    //sửa theo lương
    public void editSalary() {
        System.out.println("Nhập lương nhân viên muốn sửa: ");
        int check = Integer.parseInt(scanner.nextLine());
        boolean isExted = false;
        for (Employee e : list) {
            if (e.getSalary() == check) {
                isExted = true;
                System.out.println("Nhập tên mới: ");
                double newName = Double.parseDouble(scanner.nextLine());
                e.setSalary(newName);
                System.out.println("Đã thay đổi tên thành công. " + newName);
                break;
            }
        }
        if (!isExted) {
            System.err.println("Không có mã nhân viên này. ");
        }
    }

    //hiển thị danh sách
    public void disPlay() {
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    //tìm kiếm
    public void searchE() {
        searchEmployee();
    }

//    public static void arrangeE() {
//        for (Employee e : list) {
//
//        }
//    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    //đăng nhập
    public String[] login(Scanner scanner) {
        System.out.println("\n                                 WElCOME TO LOGIN                                    \n");
        boolean check = false;
        String inputEmail;
        String inputPassWord;
        System.out.print("Enter Email : ");
        do {
            inputEmail = scanner.nextLine();
            if (myRegex.regex(inputEmail, myRegex.getPatternEmail())) {
                check = true;
            } else {
                System.err.print("Email format is incorrect\nPlease re-enter : ");
            }
        } while (!check);
        System.out.print("Enter PassWord : ");
        inputPassWord = scanner.nextLine();
        return new String[]{inputEmail, inputPassWord};
    }


    //check tài khoản có đúng định dang hay không!
    public User checkLogin(List<User> listCustomer, Scanner scanner) {//tạp pt nhận đầu vào là một danh sách các đtg user và một đtg scanner để đọc dữ liệu đầu vào
        String[] login = login(scanner);//tạo ra một mảng có kiểu dữ liệu là String:chứa email và mật khẩu và gọi ra phương thức đăng nhập
        User user = null;//tạo một biến user bằng null
        String outPut;//khởi tạo một biến sau khi đăng nhập đúng thì hiển thị thông báo
        boolean check = false;
        for (User c : listCustomer) {//dùng foreach duyệt trong list<User> listCustomer check xem email trong list có trùng với email đăng nhập
            if (c.getEmail().equals(login[0])) {//lấy giá trị của thằng email so sánh với mảng login tại 0
                if (c.getPassword().equals(login[1])) {//lấy giá trị của thằng password so sánh với mảng login tại 1
                    if (isAdmin(c)) {//nếu m đúng thì hiển thị lên màn hình đây là tài khoản
                        outPut = "\n                                   Welcome Back ADMIN " + c.getName() + " ....!";
                    } else {//sai thì nhảy xuống khối lệnh này
                        outPut = "\n                                    Welcome Back " + c.getName() + " ....!";
                    }
                    System.out.println(outPut);
                    user = c;
                    check = true;
                    break;
                } else {
                    System.err.println("                               Wrong Password\n                              ");
                    System.out.println("\n                          You have 3 times enter                           ");
                    System.out.println("-----------------------------------------------------------------------------");
                    int count = 3;
                    while (count > 0) {
                        System.out.println("Incorrect password : ");
                        System.out.print("Enter password " + count + " times : ");
                        login[1] = scanner.nextLine();
                        System.out.println("------------------------");
                        if (c.getPassword().equals(login[1])) {
                            outPut = "                    Welcome Back " + c.getName() + " ....!";
                            System.out.println(outPut);
                            check = true;
                            return c;
                        } else {
                            count--;
                        }
                    }
                    System.out.println("                          You forgot your Password                           ");
                    System.out.println("                           Press y to get it back                            ");
                    System.out.println("                          Press n to return to Login                         ");
                    System.out.print("Enter Choice:");
                    String choice = scanner.nextLine();
                    if (choice.equals("y")) {
                        passwordRetrieval(scanner);
                        return checkLogin(listCustomer, scanner);
                    } else if (choice.equals("n")) {
                        return checkLogin(listCustomer, scanner);
                    }

                }
            } else {
                check = false;
            }
        }
        if (!check) {
            System.err.println("\n                                  Login Unsuccessful\n");
            System.out.println("\n                                E-mail does not exist yet");
            System.out.println("                                     PLEASE SIGN UP ");
            System.out.println("                              -------------------------------");
        }
        return user;
    }


    //so sánh xem tk email có đúng với tk đã khởi tạo
    public boolean isAdmin(User user) {//Tạo một đối tượng là user
        boolean checkAdmin = false;//một biến check mặc định bằng false
        try {
            if (user.getEmail().equals(admin)) {// lấy giá trị email so sánh với tk của thằng admin đã khởi tạo
                checkAdmin = true;//đúng thì true
            }
        } catch (NullPointerException e) {//sai thì nhảy vào khối lệnh này
            checkAdmin = false;
        }

        return checkAdmin;
    }

    //nhập đúng định dang password
    public void passwordRetrieval(Scanner scanner) {//nhập 1 tham số là sc để đọc dữ liệu người dùng bàn phím
        String inputEmail;
        boolean check = false;
        boolean checkEmail = false;
        do {
            System.out.println("                             Enter  Registered Email                                 ");
            inputEmail = scanner.nextLine();
            if (myRegex.regex(inputEmail, myRegex.getPatternEmail())) {//kiểm tra xem nhập email có đúng định dạng không?
                check = true;// và lấy mẫu regex để so sánh xem có khớp với địa chỉ email
            } else {
                System.err.print("                      Email format is incorrect\nPlease re-enter :                 ");//không đúng thì bắt nhập lại
            }
        } while (!check);
        User user = null;//tạo 1 đtg user
        for (User c : listUser) {//duyệt xem listUser này
            if (c.getEmail().equals(inputEmail)) {//rồi lấy thằng email đã được định dạng rồi so sánh với cái người dùng nhâp
                checkEmail = true;
                user = c;
            }
        }
//        if (checkEmail) {
//            String random = myRandom.randomAlphaNumeric();
//            System.out.println("a code is sent email");
//            System.out.println("your code is : \n" + random);
//            System.out.print("Enter code :");
//            String code = scanner.nextLine();
//            if (random.equals(code)) {
//                System.out.println("PassWord your :\n" + customer.getPassWord() + "\n");
//            }
//
//        } else {
        System.out.println("                                    Email does not exist\n");
    }


    //tìm kiếm nhân viên
    public void searchEmployee() {
        System.out.println("Enter the name you want to search: ");
        String checked = scanner.nextLine();
        List<Employee> filteredList = list.stream()
                .filter(employee -> employee.getName().contains(checked))
                .collect(Collectors.toList());
        for (Employee employee : filteredList) {
            System.out.println("This is the name you just found: ");
            System.out.println(employee);
        }
    }

//    public void loginAndRegister() {
//        System.out.println("Enter an account: ");
//        String login = scanner.nextLine();
//        System.out.println("Enter password: ");
//        int prd = Integer.parseInt(scanner.nextLine());
//        if (username.equals(login) && passWord == prd) {
//            System.out.println("Đăng nhập thành công");
//        } else {
//            System.out.println("Đăng nhập thất bại =>>> Lêu Lêu");
//            System.exit(0);
//        }
//    }

    //đăng kí tài khoản
    public void register() {
        int count = 0;
        boolean check = true;
        while (check) {
            try {
                if (count == 6) {
                    System.out.println("Hệ thống đã đầy, không thể đăng kí thêm tài khoản.");
                    return;
                }
                System.out.print("Enter UserName: ");
                String username = scanner.nextLine();
                System.out.print("Enter PassWord: ");
                String password = scanner.nextLine();
                if (username.equals("") && password.equals("")) {
                    System.err.println("Registration failed.");
                } else {
                    System.out.println("Sign up successfully.");
                    count++;
                    map.put(username, password);
                    check = false;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    //đăng nhập
    public boolean login() {
        try {
            System.out.print("Enter UserName: ");
            String usernames = scanner.nextLine();

            System.out.print("Enter PassWord: ");
            String passwords = scanner.nextLine();

            for (Map.Entry<String, String> checkCondition : map.entrySet()) {
                if (usernames.equals(checkCondition.getKey()) && passwords.equals(checkCondition.getValue())) {
                    System.out.println("\n                     ☻....Logged in successfully....☻      \n");
                    return true;
                } else {
                    System.err.println("\n                              Username or password is incorrect.                        \n");
                    return false;
                }
            }
            System.err.println("                                   Login failed.                                   \n");
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //xóa tài khoản
    public void deleteLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        if (map.containsKey(username)) {
            map.remove(username);
            System.out.println("\n                   !....Account successfully deleted....!                        \n");
            return;
        } else {
            System.err.println("\n                           !.....Not Found.....!                                 \n");
        }
    }

    //hiển thị tài khoản
    public void disPlayAccount() {
        for (String display : map.keySet()) {
            System.out.println("Here is the list of accounts:  ");
            System.out.println(display);
        }
    }

    //sắp xếp nhân viên theo tên tương đối
    public void arrangeEmployee() {
        list.sort(Comparator.comparing(Employee::getName));
//        list.sort(Comparator.comparing(Employee::getName).reversed());
        System.out.println(list);
    }

    //check xem nhân viên này là loại nhân viên gì
    public void checkSecretarialStaff() {
        String check = scanner.nextLine();
        for (Employee s : list) {
            if (s instanceof SecretarialStaff) {
                System.out.println("This is the SecretarialStaff." + check);
            }
            if (s instanceof Accountant) {
                System.out.println("This is the Accountant." + check);
            }
            if (s instanceof FullTimeStaff) {
                System.out.println("This is the FullTimeStaff." + check);
            }
            if (s instanceof PartTimeStaff) {
                System.out.println("This is the PartTimeStaff." + check);
            }
        }
    }


    //đọc file
    public List<Employee> readFile() {
        String path = "src\\file\\AD\\data.txt";
        ArrayList<Employee> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                int id = Integer.parseInt(txt[0]);
                String name = txt[1];
                int age = Integer.parseInt(txt[2]);
                String address = txt[3];
                int salary = Integer.parseInt(txt[4]);
                list.add(new Employee(name, age, address, id, salary) {
                    @Override
                    public double payrollCalculation() {
                        return 0;
                    }
                });
            }
            br.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    //ghi file
    public void writeCsv(ArrayList<Employee> list) {
        String path = "src\\file\\AD\\data.txt";
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Employee product : list) {
                bw.write(product.toString());
                bw.newLine();
            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //tính lương
    public void payRoll() {
        Accountant accountant = new Accountant();
        FullTimeStaff fullTimeStaff = new FullTimeStaff();
        PartTimeStaff partTimeStaff = new PartTimeStaff();
        SecretarialStaff secretarialStaff = new SecretarialStaff();
        while (true) {
            System.out.println("""
                                                ֍🐾🐾🐾🐾🐾🐾🐾❚█══█❚🐾🐾🐾🐾🐾🐾🐾🐾֎
                                                𒁂                MENU               𒁂
                                                〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓 〓
                                                ✍ ✍ ✍ ✍         ⚆ _ ⚆         ✍ ✍ ✍ ✍
                                                ✅ 1. PayRoll Accountant             ⚓
                                                ✅ 2. PayRoll SecretarialStaff       ⚓
                                                ✅ 3. PayRoll FullTimeStaff          ⚓
                                                ✅ 4. PayRoll PartTimeStaff          ⚓
                                                ✅ 0. Exit                           ⚓
                                                ⏩===================================⏪
                                                 ❤ ᚐ  ᚑᚑ  ᚒᚒ  ᚓᚓ  ☑💖☑ ᚓᚓ  ᚒᚒ  ᚑᚑ  ᚐ  ❤
                                                💯===================================💯
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    double payrollCalculation = accountant.payrollCalculation();
                    System.out.println("This is the employee's salary: " + payrollCalculation);
                    break;
                case 2:
                    secretarialStaff.payrollCalculation();
                    break;
                case 3:
                    fullTimeStaff.payrollCalculation();
                    break;
                case 4:
                    partTimeStaff.payrollCalculation();
                    break;
                case 5:
                    break;

            }
        }
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}

