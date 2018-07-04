package exercicesFranceIoi.geometrie;
import static java.lang.Math.*;

/**
 * Created by monsio on 2/3/16.
 */
public class Vecteur {

    private Point origine, extremite;
    private Double normeVecteur;

    public Vecteur(Point origine, Point extremite) {
        this.origine = origine;
        this.extremite = extremite;
        this.normeVecteur = normeVecteur();
    }

    public double longueurAbscisse(){
        return extremite.x - origine.x;
    }

    public double longeurOrdonnee(){
        return extremite.y - origine.y;
    }

    public double normeVecteur(){
        return sqrt(pow(origine.x - extremite.x,2.0) + pow(origine.y - extremite.y,2.0));
    }

    public double produitScalaire(Vecteur v2){
       return (v2.longueurAbscisse() * longueurAbscisse()) + (v2.longeurOrdonnee() * longeurOrdonnee());
    }

    public double produitEnCroix(Vecteur v2){
        return abs(v2.longueurAbscisse() * longeurOrdonnee() - v2.longeurOrdonnee() * longueurAbscisse()) ;
    }

    public double projection(Vecteur v2){
        return produitScalaire(v2) / normeVecteur;
    }

    public double projectioCroix(Vecteur v2){
        return produitEnCroix(v2) / normeVecteur;
    }

    public void multiplier( double r ){
        extremite.x = origine.x + ( longueurAbscisse() * r );
        extremite.y = origine.y + ( longeurOrdonnee() * r );
    }

    public void diviser( double r ){
        extremite.x = origine.x + ( longueurAbscisse() / r );
        extremite.y = origine.y + ( longeurOrdonnee() / r );
    }

    public Vecteur getNewVecteurDivise( double r ){
       return new Vecteur(
               this.origine,
               new Point(
                       origine.x + ( longueurAbscisse() / r ),
                       extremite.y = origine.y + ( longeurOrdonnee() / r )
               ));
    }

    public Vecteur getNewVecteurMultiplier( double r ){
        return new Vecteur(
                this.origine,
                new Point(
                        origine.x + ( longueurAbscisse() * r ),
                        extremite.y = origine.y + ( longeurOrdonnee() * r )
                ));
    }

    private double m(Vecteur v){
        double m = (v.extremite.y-v.origine.y)/**10e7 *// (v.extremite.x-v.origine.x);
       // m = Math.round(m)/10e7;
        return m;
    }

    private double p(Vecteur v, double m){
        return v.origine.y - (m*v.origine.x);
    }

    /**
     * Utilise un systeme de résolution à deux équations pour determiner le point commun.
     * à partir des valeurs (x1,y1) et (x2,y2) des deux vecteurs
     * formules :
     * y = mx + p
     * m = (y2-y1)/(x2-x1)
     * p = y1|2 - ( m * x1|2 )
     * */
    public Point intersectionS2e(Vecteur v2){

        double ma = m(this);
        double pa = p(this,ma);

        double mb = m(v2);
        double pb = p(v2,mb);

        double x = ( pb - pa ) / ( ma - mb);

        double y = (ma * x) + pa;
/*
        x = Math.round(x*10e5)/10e5;
        y = Math.round(y*10e5)/10e5;
*/

        return new Point(x,y);
    }
/**
 * Utilise le théorème de Thales et le produit en croix de deux vecteurs pour determiner le point d'intersection I
 * L'intersection de fait dans le prolongement de AB et CD.
 * I = B + [ v.AB / [(AA / BB) - 1] ]
 * ou AA et la distance entre le point A et CD et BB est la distance entre le point B et CD
 * la longeur AA se calcule à l'aide du produit en croix des vecteurs CD et CA divisés par DC pour obtenir la projection de CA sur CD
 * pivoté de 90° dans le sens trigonométrique ( sens inverse des eguille d'une montre ). Idem pour BB.
 * */
    public Point intersectionGeometrique(Vecteur CD){

        Vecteur CA = new Vecteur(CD.origine, this.origine);//DC.extremite = D et this.origine = A
        Vecteur CB = new Vecteur(CD.origine, this.extremite);//DC.extremite = D et this.origine = A

        double normeAAp = CD.projectioCroix(CA);
        double normeBBp = CD.projectioCroix(CB);

        return this.extremite.getNewPointPlusVecteur(this.getNewVecteurDivise((normeAAp / normeBBp) - 1));
    }

    public Point intersectionGeometrique2(Vecteur CD){

        //Vecteur CB = new Vecteur(this.origine,CD.origine);
        Vecteur CB = new Vecteur(CD.origine,this.extremite);

        double taux = this.produitEnCroix(CB) / this.produitEnCroix(CD);

        Vecteur CK = CD.getNewVecteurMultiplier(taux);

        return CD.origine.getNewPointPlusVecteur(CK);
    }

    /*=============================GETTER SETTER======================*/

    @Override
    public String toString() {
        return origine +" "+ extremite;
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
        this.normeVecteur = normeVecteur();
    }

    public Point getExtremite() {
        return extremite;
    }

    public void setExtremite(Point extremite) {
        this.extremite = extremite;
        this.normeVecteur = normeVecteur();
    }

    public Double getNormeVecteur() {
        return normeVecteur;
    }


    public static void main(String[] args) {

        Vecteur v1 = new Vecteur(new Point(10,30),new Point(35,35));
        Vecteur v2 = new Vecteur(new Point(25,5),new Point(50,30));

        System.out.println(v1.intersectionGeometrique2(v2));

    }
}
