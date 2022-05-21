/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;


/**
 *
 * @author yannp
 * 
 * 
 */

public class Treillis implements Serializable {
	// Atributs
 
	private List<Noeud> listnoeud;

	public void setListnoeud(List<Noeud> listnoeud) {
		this.listnoeud = listnoeud;
	}

	public List<Noeud> getListnoeud() {
		return listnoeud;
	}
	
    private List<Barre> listbarre;
	

	public List<Barre> getListbarre() {
		return listbarre;
	}


	public void setListbarre(List<Barre> listbarre) {
		this.listbarre = listbarre;
	}


    //Constructeur
    
    public Treillis ( List <Noeud> n, List <Barre> b){
        this.listbarre= b;
        this.listnoeud=n;
    }

   
   @Override
   public String toString() {
        return ("liste des noeuds " + this.getListnoeud() + "   liste des barres" + this.getListbarre());
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
      
   
}