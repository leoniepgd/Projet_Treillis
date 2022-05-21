/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculs;


import com.mycompany.treilli.Lire;

/**
 *
 * @author Elève
 */
/* Resolution d'un systeme de n equations      */
/* lineaires a n inconnues                     */
/* par la methode du pivot de Gauss            */

public class PivotGauss {

/* Fonction d'affichage des valeurs contenues  */
/* dans un tableau de double a 1 indice        */
 
  static void affichageVecteur(double [] t) {
    for ( int i = 0 ; i < t.length ; i++ ) {
        System.out.print("   "+t[i]);
    }
   
  }

/* Fonction d'affichage des valeurs contenues  */
/* dans un tableau de double a 2 indices       */
 
  static void affichageMatrice(double [][] t) {
    for ( int i = 0 ; i < t.length ; i++ ) {
      for ( int j = 0 ; j < t[i].length ; j++ ) {
        System.out.print("   "+t[i][j]);
      }
      System.out.println();
    }
  }
 
/* Fonction de calcul du produit d'un tableau  */
/* carre de taille n.n par un tableau          */
/* a 1 indice de taille n                      */
/* Retour: Un tableau a 1 indice de taille n   */

  static double [] produit(double [][] m,double [] v) {
    int n = v.length;
    double [] w = new double[n];
    for ( int i = 0 ; i < n ; i++ ) {
      w[i] = 0.0;
      for ( int j = 0 ; j < n ; j++ ) {
        w[i] = w[i] + m[i][j]*v[j]; } }
    return w;
  }
 
/////////////////////////////////////////////////

/* Fonction de calcul et retour d'une copie    */
/* d'un tableau de double a 1 indice           */
/* t : Le tableau à cloner                     */

  static double [] clone(double [] t) {
    int n = t.length;
    double [] nt = new double[n];
    for ( int i = 0 ; i < n ; i++ ) {
      nt[i] = t[i]; }
    return nt;
  }

/* Fonction de calcul et retour d'une copie    */
/* d'un tableau de double a 2 indices          */
/* t : La matrice à cloner                     */

  static double [][] clone(double [][] t) {
    int n = t.length;
    int m = t[0].length;
    double [][] nt = new double[n][m];
    for ( int i = 0 ; i < n ; i++ ) {
      for ( int j = 0 ; j < m ; j++ ) {
        nt[i][j] = t[i][j]; } }
    return nt;
  }

/* Recherche et permutation entre lignes       */
/* de coefficients dans le cadre               */
/* de la résolution d'un système               */
/* de n équations linéaires à n inconnues      */
/* par pivot de Gauss                          */
/* l : Le numéro de la ligne à permuter        */
/* a : La matrice de réels à traiter           */
/* b : Le tableau de réels à traiter           */
/*     concourrament à la matrice a            */

  static void permutation(int l,double [][] a,double [] b) {
    int n = b.length;
    double aux;
    int ll = l;
    while ( a[ll][l] == 0.0 ) {
      ll++; }
    for ( int i = l ; i < n ; i++ ) {
      aux = a[l][i];
      a[l][i] = a[ll][i];
      a[ll][i] = aux; }
    aux = b[l];
    b[l] = b[ll];
    b[ll] = aux;
  }

/* Première partie de la méthode de résolution */
/* d'un système de n équations linéaires       */
/* à n inconnues par pivot de Gauss:           */
/* Triangularisation de la matrice             */
/* des coefficients et modification            */
/* concourante du vecteur                      */
/* a : La matrice de réels à transformer       */
/*     par triangularisation                   */
/* b : Le tableau de réels modifié             */
/*     concourrament à la matrice a            */

  static void transformation(double [][] a,double [] b) {
    int n = b.length;
    for ( int i = 1 ; i < n ; i++ ) {
      if ( a[i-1][i-1] == 0.0 )
        permutation(i-1,a,b);
      for ( int j = i ; j < n ; j++ ) {
        double facteur = a[j][i-1]/a[i-1][i-1];
        for ( int k = i-1 ; k < n ; k++ ) {
          a[j][k] = a[j][k] - a[i-1][k]*facteur; }
        b[j] = b[j] - b[i-1]*facteur;  } }
  }

/* Seconde partie de la méthode de résolution  */
/* des systèmes de n équations linéaires       */
/* à n inconnues: Extraction du résultat       */
/* Le retour est un tableau de réels           */
/* a : La matrice de réels triangulaire carrée */
/* b : Le tableau de réels                     */
 
  static double [] extraction(double [][] a,double [] b) {
    int n = b.length;
    double [] v = new double[n];
    v[n-1] = b[n-1]/a[n-1][n-1];
    for ( int i = n-2 ; i >= 0 ; i-- ) {
      v[i] = b[i];
      for ( int j = n-1 ; j > i ; j-- ) {
        v[i] = v[i] - v[j]*a[i][j]; }
      v[i] = v[i]/a[i][i]; }
    return v;
  }

/* Fonction de calcul et retour de la solution */
/* du systeme d'équations linéaires a.v = b    */
/* a est une matrice de coefficients           */
/* b est un vecteur de coefficients            */
/* v est le vecteur à déterminer               */
/* a, b et v sont de taille n.n, n et n        */
/* n quelconque                                */
/* Méthode utilisée : pivot de Gauss           */
/* Attention: Les deux tableaux a et b         */
/* sont modifiés au cours de la résolution     */
/* Le retour est un tableau de réels           */
/* a : La matrice de réels (carrée)            */
/* b : Le tableau de réels                     */

  static double [] resolution(double [][] a,
                              double [] b) {
    transformation(a,b);
    return extraction(a,b);
  }
 
/* Fonction de calcul et retour de la solution */
/* du systeme d'équations linéaires a.v = b    */
/* a est une matrice de coefficients           */
/* b est un vecteur de coefficients            */
/* v est le vecteur à déterminer               */
/* a, b et v sont de taille n.n, n et n        */
/* n quelconque                                */
/* Méthode utilisée : pivot de Gauss           */
/* Une copie des deux tableaux a et b          */
/* supports des coefficients est réalisée      */
/* pour ne pas détruire ces informations       */
/* au cours de la résolution                   */
/* Le retour est un tableau de réels           */
/* a : La matrice de réels (carrée)            */
/* b : Le tableau de réels                     */

  static double [] resolutionGauss(double [][] a,
                                   double [] b) {
    return resolution(clone(a),clone(b));
  }

/////////////////////////////////////////////////
 
/* Programme principal                         */

  public static void main(String [] args) {
    int i,j;
    int nc, nl;
    Matrice m;
   
    System.out.println("donnez le nombre de ligne");
    nl = Lire.i();
    System.out.println("donnez le nombre de colonne");
    nc = Lire.i();
    double[] b = new double[nc];
    m = new Matrice(nl,nc);
    for (i=0; i<nl; i++){
        for (j =0; j<nc; j++){
            System.out.print("   "+m.coeffs[i][j]);
        }
        System.out.println();
    }
    for (i=0; i<nc; i++){
        System.out.println("donnez la somme des forces en ce point");
        b[i]=Lire.d();
        System.out.println();
    }
    System.out.println();
    double [][] a = m.coeffs;
    double [] v;
    double [] w;
    System.out.println("Matrice A:");
    affichageMatrice(a);
    System.out.println();
    System.out.println("Vecteur B:");
    affichageVecteur(b);
    System.out.println();
    v = resolutionGauss(a,b);
    System.out.println("Vecteur V trouvé par Gauss :");
    affichageVecteur(v);
    System.out.println();
    System.out.println("Produit A.V à comparer avec B:");
    w = produit(a,v);
    affichageVecteur(w);
    }
}