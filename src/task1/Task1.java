package task1;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {

        File file = new File(args[0]);
        //String[]fileList = file.list();
        //File file1 = new File(file, fileList[0]);


        ArrayList<Double> workList;
        if (args[0] == null || args[0].trim().isEmpty()) { //Are the args[] is empty?
            System.out.println("You need to specify a path!");
            return;
        } else {
            workList = makeWorkList(file);
        }

        Collections.sort(workList);
        double m = 0;
        for(double f: workList){
            m += f;
        }
        System.out.printf("90 перцентиль:= %.2f%n", workList.get((int)(workList.size()*0.9)+1));
        System.out.printf("Медиана:=  %.2f%n", workList.get((int)( (workList.size()*0.5)+1)));
        System.out.printf("Max значение:= %.2f%n", workList.get((workList.size()-1)));
        System.out.printf("Min значение:= %.2f%n", workList.get(0));
        System.out.printf("Среднее значение:= %.2f%n", m/workList.size());
        //System.out.println(fileList[0] +" "+ fileList[1]);

    }

    public static ArrayList<Double> makeWorkList (File file){
        ArrayList<Double> list = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
                String s  = reader.readLine();
                double d  = Double.parseDouble(s);
                list.add(d);
            }
            reader.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException eio){eio.printStackTrace();}
        return list;
    }
}
