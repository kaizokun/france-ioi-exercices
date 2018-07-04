package exercicesFranceIoi.algorithmeGlouton;

import java.util.*;

/**
 * Created by monsio on 2/28/16.
 */
public class ChaineDeProduction {



    public static void main(String[] args) {



        M m1[] = new M[]{new M(0,1),new M(0,3),new M(0,4)},
          m2[] = new M[]{new M(0,3),new M(0,5),new M(0,8)};

        List<P> pr = new ArrayList(Arrays.asList(new P[]{new P(0),new P(0),new P(0),new P(0),new P(0)}));

        List<I> it = new ArrayList();

        for(M m : m1){

            int dt = m.di;

            for( int i = 0 ; i < pr.size() ; i ++ ){
                it.add(new I(m, dt, dt+m.te));
                dt += m.te;
            }

        }

        Collections.sort(it);

        for( I i : it)
            System.out.print(i + " ");

        for( int i = 0 ; i < pr.size() ; i ++ )
            pr.get(i).d = it.get(i).f;

        System.out.println();
        System.out.println("Traitement ligne 1 : "+pr.get(pr.size()-1).d);

        for( P p : pr)
            System.out.print(p + " ");
/*
        for(M m : m2){
            m.di = pr.get(0).d;
        }
*/
        System.out.println();
        System.out.println();

        int T;
        int total = 0;

        while(!pr.isEmpty()){
            //le temps de travail à considerer pour les machines de la ligne 2 et le temps de disponibilité du premier produit.
            T = pr.get(0).d;

            /*Pour les machines qui ne sont pas ou plus occupé en temps T on initialise leur disponibilité en temps T
            *pour les machines qui travaillent toujours en temps T est dont l'instant de disponibilite est superieur ou égal à T rien ne change*/
            for( M m : m2)
                if(m.di < T )
                    m.di = T;

            System.out.println("T : "+T);

            it = new ArrayList();

            //pour chaque machine de la ligne 2
            for(M m : m2){
                //le debut de traitement des produits eventuel par cette machine correspond à son temps de disponibilité
                int dt = m.di;
                //Pour chaque machine et chaque  produit si il est disponible en temps T on calcule les intervalles de taitement
                for( int i = 0 ; i < pr.size() && pr.get(i).d <= T ; i ++ ){
                    it.add(new I(m,dt,dt+m.te));
                    dt += m.te;
                }
            }
            //on trie les intervalles par fin de taitement puis debut de traitement
            Collections.sort(it);

            for( int i = 0 ; i < it.size(); i ++ ){
                System.out.print(it.get(i)+ " ");
            }
            System.out.println();

            total = 0;

            //on compte le nombre de produits disponibles en temps T
            for( int i = 0 ; i < pr.size() && pr.get(i).d <= T ; i ++ ){
                System.out.print(it.get(i)+ " ");
                //pour une intervalle de travaille on modifie l'instant de disponibilite de la machine à la fin de cet intervalle
                it.get(i).m.di = it.get(i).f;
               // tMax = it.get(i).f;
                total++;
            }


            System.out.println();
            //on retire les produits traités
            for( int i = 0 ; i < total ; i ++ ){
               pr.remove(0);
            }


        }

        System.out.println(it.get(total-1).f);



    }

    static class M implements Comparable<M>{
        //disponibilite et temps d'execution
        int di, te;

        public M(int di, int te) {
            this.di = di;
            this.te = te;
        }

        public int compareTo(M o) {
            return this.te - o.te;
        }

        @Override
        public String toString() {
            return " M["+te+"]";
        }
    }

    static class I implements Comparable<I>{
        M m;
        int d,f;

        public I(M m, int d, int f) {
            this.m = m;
            this.d = d;
            this.f = f;
        }

        @Override
        public int compareTo(I o) {

            int cmp = this.f - o.f;

            if(cmp == 0)
                return this.d - o.d;

            else return cmp;

        }

        @Override
        public String toString() {
            return m+" : ["+d+"-"+f+"[ --";
        }
    }

    static class P{

        int d;

        public P(int d) {
            this.d = d;
        }

        @Override
        public String toString() {
            return "P{" + d + "}";
        }
    }



}
