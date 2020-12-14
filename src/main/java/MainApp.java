import java.io.*;

public class MainApp {
    private static String filePathCreate = "E:\\work\\resource.txt";
    public static String filePathGet = "E:\\work\\resource.txt";

//    public static void createFile(String fileNameCreate) {
//        try {
//            File file = new File(fileNameCreate);
//            if (file.createNewFile()) {
//                System.out.println("File is created !");
//            } else {
//                System.out.println("File already exists !");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static int[] getDataFromFile(String fileNameGet) throws IOException {
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

    public void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0)
            return;
        if (left >= right)
            return;
        int middle = left + (right - left) / 2;
        int pivot = arr[middle];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(arr, left, j);
        }
        if (right > i) {
            quickSort(arr, i, right);
        }
    }

    public static void main(String[] args) throws IOException {
//        createFile(filePathCreate);
        int[] arr = getDataFromFile(filePathGet);
        MainApp quickSort = new MainApp();
        quickSort.display(arr);
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
        quickSort.display(arr);
    }
}
