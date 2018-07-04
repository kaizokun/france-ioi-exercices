package exercicesFranceIoi.structureDonneeBalayage;

/**
 * Created by monsio on 2/11/16.
 */
public class Intervalle implements Comparable<Intervalle>{

    public int start,end;

    public Intervalle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Intervalle i2) {

        int cmpStart = start - i2.start;

        if(cmpStart == 0)
            return end - i2.end;

        return cmpStart;

    }
}
