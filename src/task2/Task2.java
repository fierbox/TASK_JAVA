package task2;
import java.io.*;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) throws IOException {

        File fileOfquadrangle  = new File(args[0]);
        File fileOfPoints = new File(args[1]);
        ArrayList<Point> points = makePointList(fileOfPoints);
        ArrayList<Point> quadrangle = makePointList(fileOfquadrangle);


        for(int i = 0; i < points.size(); i++){
            //System.out.print(points.get(i).getX() + " " + points.get(i).getY() + " " );
            whereIsPoint(points.get(i),quadrangle);
        }

    }



    public static ArrayList<Point> makePointList (File file){
        ArrayList<Point> list = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
                String s = reader.readLine();
                String[]str = s.split(" ");
                list.add(new Point(Float.parseFloat(str[0]),Float.parseFloat(str[1])));
            }
            reader.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException eio){eio.printStackTrace();}
        return list;
    }

    public static int isPointOnLine(Point point, Point quadranglePoint1, Point quadranglePoint2){
        int i = (int)(((quadranglePoint2.x-quadranglePoint1.x)*(point.y-quadranglePoint1.y))-
                ((quadranglePoint2.y-quadranglePoint1.y)*(point.x-quadranglePoint1.x)));
        if (i==0) return 0;
        if (i < 0) {return 1;}
        else  {return -1;}


    }

    public static Boolean isInside(Point point, ArrayList<Point> list){
        Point quadranglePoint1 = list.get(0);
        Point quadranglePoint2 = list.get(1);
        Point quadranglePoint3 = list.get(2);
        Point quadranglePoint4 = list.get(3);
        if(     isPointOnLine(point, quadranglePoint1, quadranglePoint2)== 1&
                isPointOnLine(point, quadranglePoint2, quadranglePoint3)== 1&
                isPointOnLine(point, quadranglePoint3, quadranglePoint4)== 1&
                isPointOnLine(point, quadranglePoint4, quadranglePoint1)== 1
                )
        {return true;}
        else return false;
    }

    public static int isPointIsNode(Point point, ArrayList<Point> list){
        Point quadranglePoint1 = list.get(0);
        Point quadranglePoint2 = list.get(1);
        Point quadranglePoint3 = list.get(2);
        Point quadranglePoint4 = list.get(3);

        if(point.equals(quadranglePoint1)|point.equals(quadranglePoint2)|
                point.equals(quadranglePoint3)|point.equals(quadranglePoint4))return 0;
        else return 1;



    }

    public static int isPointIsRib(Point point, ArrayList<Point> list){
        Point quadranglePoint1 = list.get(0);
        Point quadranglePoint2 = list.get(1);
        Point quadranglePoint3 = list.get(2);
        Point quadranglePoint4 = list.get(3);
        return      isPointOnLine(point, quadranglePoint1, quadranglePoint2)+
                isPointOnLine(point, quadranglePoint2, quadranglePoint3)+
                isPointOnLine(point, quadranglePoint3, quadranglePoint4)+
                isPointOnLine(point, quadranglePoint4, quadranglePoint1);

    }

    public static void whereIsPoint(Point point, ArrayList<Point> list){
        if(isPointIsNode(point, list)==0){
            System.out.println("0");
        } else if(isInside(point, list)){
            System.out.println("2");
        } else if (isPointIsRib(point, list) ==3 ){
            System.out.println("1");
        }
        else System.out.println("3");

    }
}
