/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author yannp
 */
public class Treillis {
   // Atributs
    public List<Barre> listbarre;
    public List<Noeud> listnoeud;
    
    
    //Constructeur
    
    public Treillis ( List <Noeud> n, List <Barre> b){
        this.listbarre= b;
        this.listnoeud=n;
    }
    
    
   public List <Barre> getlistbarre(){
       return listbarre;
   }
   public List <Noeud>  getlistnoeud(){
       return listnoeud;
   }
   public void setlistbarre(List <Barre> b2){
       this.listbarre= b2;
   }
   public void setlistnoeud (List <Noeud>  n2){
       this.listnoeud=n2;
   }
   
   @Override
   public String toString() {
        return ("liste des noeuds " + this.getlistnoeud() + "   liste des barres" + this.getlistbarre());
    }
   public static int maxIdNoeud (List <Noeud>  n){
      int maxid=0;
      for (int i=0; i<n.size(); i++){
          if (i == 0) {
        	  maxid=n.get(i).getId();
          }
          else if (n.get(i).getId()>n.get(i-1).getId()){ //Cherche si l'identifiant du noeud est supérieur ou non au précedent
              maxid=n.get(i).getId();
          }
        }
      return maxid;
   }
   
   public static int maxIdBarre (List <Barre> b){
       int maxid=0;
      for (int i=0; i<b.size(); i++){
          if (b.get(i).getId()>maxid){
              maxid=b.get(i).getId();
          }
        }
      return maxid;
   }
   
   public void ajouteNoeud(List<Noeud> t, Noeud n){
       if (t.contains(n)){  //Permet de vérifier si n existe dans la liste 
           System.out.println("Erreur le noeud est déjà présent"); 
       }
       else{
           int max=maxIdNoeud(t)+1;
           NoeudSimple nouveaunoeud= new NoeudSimple (n.getPosx(), n.getPosy(), n.getForce(),max);
           t.add(nouveaunoeud);   
       }
   }
   public static void ajouteBarre(List<Barre> t, Barre b){
        if (t.contains(b)){  //Permet de vérifier si n existe dans la liste 
           System.out.println("Erreur la barre est déjà présente"); 
       }
       else{
           int max=maxIdBarre(t)+1;
           Barre nouvellebarre= new Barre (b.getNd(),b.getNf(),max, b.getTractionmax(), b.getPrix(),b.getCompressionmax());
           t.add(nouvellebarre);   
       }
    }
   
    public void save(Writer w) throws IOException {
        
        // w.close();
    }
    
    public void sauvegarde(File fout) throws IOException {
        BufferedWriter bout = new BufferedWriter(new FileWriter(fout));
        this.save(bout);
    }


   
}