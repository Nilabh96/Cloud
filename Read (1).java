import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    ArrayList<String> colp=new ArrayList<>();
    ArrayList<String> nn=new ArrayList<>();
    ArrayList<String> colp3=new ArrayList<>();
    
    public ArrayList<String> getColp() {
        return colp;
    }

    public ArrayList<String> getNn() {
        return nn;
    }

    public ArrayList<String> getColp3() {
        return colp3;
    }
    
    String Line;

    Read() {
    }

    public void ReadCSV() throws IOException {
        File inpath =new File( "C:\\Users\\HP\\Desktop\\task15.csv");
        try {
            Scanner inputStream = new Scanner(inpath);
            while(inputStream.hasNext()) {
                String data = inputStream.next();
                String[] values = data.split(",");
                float val1 = Integer.parseInt(values[1]);
                String col1 = values[0];
                String col2 = values[1];
                String col3 = values[2];
                nn.add(col1);
                colp.add(col2);
                colp3.add(col3);
                //create the caring object with the required paramaters
                //add _caring object to the betreuen array here as it is within the same scope.
            }
            inputStream.close();
            }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            }
            }



    public int out(int x,int o)
    {
        String y = colp.get(x);
        int i=Integer.parseInt(y);
        int ed=o/i;
        return ed;
    }
}
