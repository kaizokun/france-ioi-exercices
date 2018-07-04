package exercicesFranceIoi.algorithmeGlouton;

import java.util.*;

/**
 * Created by monsio on 24/06/16.
 */
public class VenteDeTeleviseur {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalStk = 3;//sc.nextInt();

        List<Tele> stock = new ArrayList<>(/*totalStk*/Arrays.asList(new Tele[]{new Tele(4,2),new Tele(4,4),new Tele(5,3)}));
        /*
        for( int i = 0 ; i < totalStk ; i ++){
            stock.add(new Tele(sc.nextInt(),sc.nextInt()));
        }
*/
        int totalOrd = 4;//sc.nextInt();

        List<Tele> orders = new ArrayList<>(/*totalOrd*/Arrays.asList(new Tele[]{new Tele(3,1),new Tele(2,4),new Tele(1,5),new Tele(5,4)}));
/*
        for( int i = 0 ; i < totalOrd ; i ++){
            orders.add(new Tele(sc.nextInt(),sc.nextInt()));
        }
        */

        Collections.sort(stock, new Comparator<Tele>() {
            public int compare(Tele t1, Tele t2) {
                int cmpH = t1.H - t2.H;
                return cmpH == 0 ? t1.L - t2.L : cmpH;
            }
        });


        for(Tele s : stock)
            System.out.println(s);


        countMatch(orders,stock);

        Comparator<Tele> cmpTele = new Comparator<Tele>() {
            @Override
            public int compare(Tele t1, Tele t2) {
                return t1.totalMatch - t2.totalMatch;
            }
        };

        Collections.sort(orders, cmpTele);

        System.out.println();
        for(Tele s : orders)
            System.out.println(s);


        int total = 0;

        //pour chaque commande
        for(int o = 0 ; o < orders.size() ; o ++ ){

            Tele ot = orders.get(o);

            System.out.println("-------------Commande tele : "+ot+"---------------");

            //si le nombre de tele correspondante dans le stock est superieur à zero
            if( ot.totalMatch > 0 ){
                //pour chacune de ces tele correspondante
                System.out.println(ot.match.size()+" correspondances : ");

                for( int m = 0 ; m < ot.match.size() ; m ++ ){
                    Tele mt = ot.match.get(m);
                    //si la télé est encore disponible
                    System.out.println("    "+mt);
                    if(mt.dispo){
                        System.out.println("         disponible");
                        //augmenter le nombre total de commande honoré
                        total++;
                        //rendre la télé indisponible pour les autres commandes
                        mt.dispo = false;

                        //diminuer le nombre de télé correspondantes pour chaque commande ou on retrouve celle du stock
                        for( Tele ot2 : mt.match ){
                            ot2.totalMatch --;
                        }

                        Collections.sort(orders.subList(o+1,orders.size()),cmpTele);

                        System.out.println("Nouvel ordre des commandes : ");
                        for (Tele s : orders)
                            System.out.println(s);

                        break;

                    }else{
                        System.out.println("         indisponible");
                    }

                }

            }else{
                System.out.println("Aucune correspondance");
            }


        }

        System.out.println(total);

    }



    public static void countMatch(List<Tele> orders, List<Tele> stock ){

        for(Tele o : orders){

            for( int s = stock.size() - 1 ; s >=0 && stock.get(s).H >= o.H  ; s -- ){
                Tele t = stock.get(s);
                if( t.L >= o.L ) {
                    o.addMatch(t);
                    t.addMatch(o);
                }
            }

        }

    }


    static class Tele{

        int H,L;

        boolean dispo = true;

        List<Tele> match = new LinkedList<>();

        int totalMatch = 0;

        public Tele(int h, int l) {
            H = h;
            L = l;
        }

        public void addMatch(Tele t){
            match.add(t);
            totalMatch ++;
        }

        @Override
        public String toString() {
            return "("+H+" - "+L+") : "+totalMatch;
        }
    }

}
