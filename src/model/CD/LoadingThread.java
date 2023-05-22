package model.CD;

import menu.MenuThread;

import java.util.Collections;

public class LoadingThread extends Thread{
    @Override
    public void run() {
        int percent = 0;
        while (percent <= 100) {
            int numBars = percent / 2; // tính toán số lượng ký tự "|" cần in ra
            String bars = String.join(                                       "", Collections.nCopies(numBars,"\u001B[33m|\u001B[0m")); // tạo chuỗi chứa ký tự "|"
            System.out.print(                                                         "\r" + bars + " " + percent + "%"); // in ra chuỗi và phần trăm hoàn thành
            percent++; // tăng biến số phần trăm hoàn thành lên 1
            try {
                Thread.sleep(50); // tạm dừng 50ms trước khi in ra % loading tiếp theo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(                                                          "\nĐã Tải Xong \u001B[32m✓\u001B[0m");
        MenuThread menuThread = new MenuThread();
        menuThread.start();
//        try {
//            menuThread.join();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
