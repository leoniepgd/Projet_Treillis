/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treilli;

import java.io.Serializable;

/**
 *
 * @author Elève
 */
public class Triangle implements Serializable   {
    
    //Variables globales
    
    public static int id;
    public static double xP1;
    public static double yP1;
    public static double xP2;
    public static double yP2;
    public static double xP3;
    public static double yP3;
    
    //Constructeur
    
    public Triangle (int id, double xP1, double yP1, double xP2, double yP2,double xP3, double yP3){
        this.id=id;
        this.xP1=xP1;
        this.yP1=yP1;
        this.xP2=xP2;
        this.yP2=yP2;
        this.xP3=xP3;
        this.yP3=yP3;
    }
    
    //Fonctions & méthodes
    
    public double getx(int point){
        if (point==1){
            return xP1;
        }
        if (point==2) {
            return xP2;
        }
        if (point==3){
            return xP3;
        }
        return 0;
    }
    
    public double gety(int point){
        if (point==1){
            return yP1;
        }
        if (point==2) {
            return yP2;
        }
        if (point==3){
            return yP3;
        }
        return 0;
    }
    
    //Get et set
    
    public double getxP1(){
        return this.xP1;
    }
    
    public void setxP1(double x){
        this.xP1=x;
    }
    
    public double getyP1(){
        return this.yP1;
    }
    
    public void setyP1(double y){
        this.yP1=y;
    }
    
    public double getxP2(){
        return this.xP2;
    }
    
    public void setxP2(double x){
        this.xP2=x;
    }
    
    public double getyP2(){
        return this.yP2;
    }
    
    public void setyP2(double y){
        this.yP2=y;
    }
    
    public double getxP3(){
        return this.xP3;
    }
    
    public void setxP3(double x){
        this.xP3=x;
    }
    
    public double getyP3(){
        return this.yP3;
    }
    
    public void setyP3(double y){
        this.yP3=y;
    }
    
    public int getId(){
        return this.id;
    }
}
