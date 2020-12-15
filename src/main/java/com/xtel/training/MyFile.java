package com.xtel.training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFile {
    public static String filePathCreate = "E:\\work\\resource.txt";
    public static String filePathGet = "E:\\work\\resource.txt";

    public void createFile(String fileNameCreate) {
        try {
            File file = new File(fileNameCreate);
            if (file.createNewFile()) {
                System.out.println("File is created !");
            } else {
                System.out.println("File already exists !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getDataFromFile(String fileNameGet) throws IOException {
        FileReader fileReader = new FileReader(fileNameGet);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        fileReader.close();

        String[] arr = stringBuilder.toString().split(" ");
        int[] arrTemp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrTemp[i] = Integer.parseInt(arr[i]);
        }
        return arrTemp;
    }
}
