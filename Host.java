/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Nilabh
 */

public class Host {
static int hid,utilisationlevel,emax,emin,eh,EH1=0,EH2=0,j,i,utihost1=0,utihost2=0;
static int vmutilisation;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
                //Reading CSV and Storing in an 2d array
                
                ArrayList<ArrayList<Integer>> alIntegers = new ArrayList<>();
		File file = new File("C:\\Users\\HP\\Desktop\\final155.csv");
                File file3 = new File("C:\\Users\\HP\\Desktop\\FHA15OUTPUT.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter br2 = new BufferedWriter(new FileWriter(file3));
		String contentLine = br.readLine();
		while (contentLine != null) {
			ArrayList<Integer> alTemp = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(contentLine, ",");
			while (st.hasMoreTokens()) {
				alTemp.add(Integer.parseInt(st.nextToken()));
			}
			alIntegers.add(alTemp);
			contentLine = br.readLine();
		}
		int array[][] = new int[alIntegers.size()][alIntegers.get(0).size()];
		for (int i = 0; i <= alIntegers.size() - 1; i++) {
			for (int j = 0; j <= alIntegers.get(i).size() - 1; j++) {
				array[i][j] = alIntegers.get(i).get(j);
			}
		}
		for (int i = 0; i <= alIntegers.size() - 1; i++) {
			for (int j = 0; j <= alIntegers.get(i).size() - 1; j++) {
				if (j != alIntegers.get(i).size() - 1)
					System.out.print("");
			}
			System.out.println();
		}
	
        
                  Host h1=new Host();
                  Host h2=new Host();
         
                  
                        j=1;
			for (i = 0; i <= alIntegers.size() - 1; i++) {
                        
                        // we will check the EH values of both the Host now
                        
                        if(EH1==EH2){
                        
                            if(h1.utilisationlevel>h2.utilisationlevel){
                         
                            vmutilisation=array[i][j];
                         
                            utihost1=utihost1+vmutilisation;
                         
                            EH1=h1.host1(201,20,5,100);
                         
                            System.out.println("host id:  "+h1.hid+"   vm id"+array[i][0]);
                            br2.write(h1.hid+","+array[i][0]+"\n");
                            }
                            else
                            
                            {
                         vmutilisation=array[i][j];
                         //now the utilisation of allocated host will increase:: host utilisation= current host utilisation+ VM utlisation
                         utihost2=utihost2+vmutilisation;
                          
                         EH2=h2.host2(202,30,10,150);
                         
                         System.out.println("host id:  "+h2.hid+"   vm id: "+array[i][0]);
                            br2.write(h2.hid+","+array[i][0]+"\n");
                            }
                            }
                            else{
                            {
                            if(EH1>EH2){
                            vmutilisation=array[i][j];
                            utihost2=utihost2+vmutilisation;
                            EH2=h2.host2(202,30,10,150);
                            System.out.println(h2.hid+" "+array[i][0]);
                            br2.write(h2.hid+","+array[i][0]+"\n");
                            }
                            else{
                        
                            vmutilisation=array[i][j];
                            utihost1=utihost1+vmutilisation;
                            EH1=h1.host1(201,20,5,100);
                            br2.write(h1.hid+","+array[i][0]+"\n");
                            System.out.println(h1.hid+" "+array[i][0]);
                            }
                        }
                    }}
    br2.close();               
    br2.close();
    br2.close();
    br2.close();}
                           
public int host1(int a,int b,int c,int d){
    hid=a;
    emax=b;
    emin=c;
    utilisationlevel=d;
    eh=emin+(emax-emin)*utihost1;
    System.out.println("Energy Consumption of Host 1:   "+eh+"\n");
    return eh;
}    
public int host2(int a,int b,int c,int d){
    hid=a;
    emax=b;
    emin=c;
    utilisationlevel=d;
    eh=emin+(emax-emin)*utihost2;
    System.out.println("Energy Consumption of Host 2:        "+eh+"\n");
    return eh;
}    

}
