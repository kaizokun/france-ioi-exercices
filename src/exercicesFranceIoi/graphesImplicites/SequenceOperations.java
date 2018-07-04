package exercicesFranceIoi.graphesImplicites;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by monsio on 2/21/16.
 */
public class SequenceOperations {

    static int nombres[] = new int[]{10,4,2,3};
    static int depart = 21, resultatRecherche = 30;
    static boolean[] visited = new boolean[100001];
    static LinkedList<Integer> file = new LinkedList<>();

    public static void main(String[] args) {


        try {
            PrintStream ps = new PrintStream(new File("/home/monsio/outputSequenceOperation.log"));
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        file.add(depart);

        visited[depart] = true;

        while(!file.isEmpty()){

            int nbr = file.poll();

            traiterResultat(nbr,nombres[0],nbr+nombres[0],'+');
            traiterResultat(nbr,nombres[1],nbr-nombres[1],'-');
            traiterResultat(nbr,nombres[2],nbr*nombres[2],'*');
            if(nbr%nombres[3] == 0)
                traiterResultat(nbr, nombres[3], nbr / nombres[3], '/');

        }

        if(visited[resultatRecherche])
            System.out.println(1);
        else
            System.out.println(0);


    }

    private static void traiterResultat(int n1,int n2,int rs, char op){
        if(rs == resultatRecherche) {
            System.out.println(rs);
            System.out.println(1);
            System.exit(0);
        }
        if(rs >= 0 && rs <= 100000 && !visited[rs]){
            System.out.println(n1+" "+op+" "+n2+" = "+rs);
            file.add(rs);
            visited[rs] = true;
        }
    }



}
