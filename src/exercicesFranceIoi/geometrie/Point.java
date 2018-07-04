package exercicesFranceIoi.geometrie;

/**
 * Created by monsio on 2/3/16.
 */
class Point {

    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point getNewPointPlusVecteur(Vecteur v){
        return new Point(this.x + v.longueurAbscisse(), this.y + v.longeurOrdonnee());
    }

    public Point getNewPointMoinsVecteur(Vecteur v){
        return new Point(this.x - v.longueurAbscisse(), this.y - v.longeurOrdonnee());
    }

    public void additionneVecteur(Vecteur v){
        this.x += v.longueurAbscisse();
        this.y += v.longeurOrdonnee();
    }

    public void soustraitVecteur(Vecteur v){
        this.x -= v.longueurAbscisse();
        this.y -= v.longeurOrdonnee();
    }



    @Override
    public String toString() {
        return x + " " + y;
    }
}
