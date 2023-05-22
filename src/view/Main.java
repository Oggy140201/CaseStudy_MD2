package view;

import model.CD.LoadingThread;

public class Main {
    public static void main(String[] args) {
        LoadingThread loadingThread = new LoadingThread();
        loadingThread.start();
    }
}
