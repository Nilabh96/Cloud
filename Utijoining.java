/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Nilabh
 */
public class Utijoining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
                 ArrayList<ArrayList<Integer>> alIntegers = new ArrayList<>();
		File file = new File("C:\\Users\\HP\\Desktop\\final.csv");
		File file2 = new File("C:\\Users\\HP\\Desktop\\final22.csv");
                BufferedReader br4 = new BufferedReader(new FileReader(file));
                BufferedWriter br5 = new BufferedWriter(new FileWriter(file2));
		String contentLine = br4.readLine();
		while (contentLine != null) {
			ArrayList<Integer> alTemp = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(contentLine, ",");
			while (st.hasMoreTokens()) {
				alTemp.add(Integer.parseInt(st.nextToken()));
			}
			alIntegers.add(alTemp);
			contentLine = br4.readLine();
		}
		int array[][] = new int[alIntegers.size()][alIntegers.get(0).size()];
		for (int i = 0; i <= alIntegers.size() - 1; i++) {
			for (int j = 0; j <= alIntegers.get(i).size() - 1; j++) {
				array[i][j] = alIntegers.get(i).get(j);
			}
		}
		//for (int i = 0; i <= alIntegers.size() - 1; i++) {
		//	for (int j = 0; j <= alIntegers.get(i).size() - 1; j++) {
		//		if (j != alIntegers.get(i).size() - 1)
		//			System.out.print("");
		//	}
		//	System.out.println();
		//}
                int count=0,count2=0,count3=0;
    for (int i = 0; i <= alIntegers.size() - 1; i++) {
        int uti=array[i][0];
        String uti11=Integer.toString(uti);
        if(array[i][0]==(101)){
            count=count+array[i][2];
        }
        if(array[i][0]==102){
        count2=count2+array[i][2];
    }
         if(array[i][0]==103){
        count3=count3+array[i][2];
    }
    }
         br5.write(101+","+count+"\n");
         br5.write(102+","+count2+"\n");
         br5.write(103+","+count3+"\n");
         
         
     br4.close();
    br5.close();
br5.close();
br5.close();
    }
    }  

