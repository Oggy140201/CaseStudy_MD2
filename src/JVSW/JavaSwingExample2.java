package JVSW;

import javax.swing.*;

public class JavaSwingExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản Lý Nhân Viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set cho cái khung cửa sổ mặc định khi mà người dùng đóng cửa sổ thì sẽ dừng chương trình

        // Thêm các thành phần UI vào frame
        JLabel lblUsername = new JLabel("Email:");//tạo ra một ô để nhập tên đăng nhập
        lblUsername.setBounds(20, 20, 100, 20);//set kích thước cho ô
        frame.add(lblUsername);//sau đó add thằng

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(120, 20, 150, 20);
        frame.add(txtUsername);

        JLabel lblPassword = new JLabel("PassWord:");
        lblPassword.setBounds(20, 50, 100, 20);
        frame.add(lblPassword);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(120, 50, 150, 20);
        frame.add(txtPassword);


        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 80, 100, 20);
        frame.add(btnLogin);

        frame.setLayout(null); // Vô hiệu hóa bố cục mặc định
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
