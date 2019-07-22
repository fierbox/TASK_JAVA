package task3;

import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        double[] cash = new double[16];  //array of sum values of each cash
        double[][] nums = new double[16][16]; // array of introduced data for all cash
        //int sum = 0;

        File folder = new File(args[0]);
        String[] fileNameList = folder.list();

        for (int i = 0; i < fileNameList.length; i++) { //заполнение массива
            addDataToArray(folder, fileNameList[i], nums, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[j][i];
            }
            //System.out.println(sum);
            cash[i] = sum;
        }

        double max = cash[0];
        for (int i = 1; i < cash.length; i++) {
            if (cash[i] > max) {
                max = cash[i];
            }
        }
        for (int i = 1; i < cash.length; i++) {
            if (cash[i] == max) {
                System.out.println(i+1);
                break;
            }
        }

    }

    public static void addDataToArray (File file, String s,double[][] arr, int i){
        File cashfile = new File(file, s);
        //double[]arr = new double[5];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(cashfile));
            while (reader.ready()) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = Double.parseDouble(reader.readLine());
                }
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
