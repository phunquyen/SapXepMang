package com.xtel.training;

import java.io.*;

import static com.xtel.training.MyFile.filePathCreate;
import static com.xtel.training.MyFile.filePathGet;

public class MainApp {
    public static void main(String[] args) throws IOException {
        MyFile file = new MyFile();
        MyArray array = new MyArray();
        file.createFile(filePathCreate);
        int[] arr = file.getDataFromFile(filePathGet);
        array.display(arr);
        int left = 0;
        int right = arr.length - 1;
        array.quickSort(arr, left, right);
        array.display(arr);
    }
}
