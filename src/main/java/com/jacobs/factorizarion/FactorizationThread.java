/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jacobs.factorizarion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAWOUD
 */
public class FactorizationThread implements Runnable{
    private String tag;
    private Long number;

    public FactorizationThread(String tag, Long number)
    {this.tag = tag;
     this.number = number;
    }//End FactorizationThread constructor
    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTag() {
        return tag;
    }

    public Long getNumber() {
        return number;
    }
    
   public List<Integer> calculateFactors(long number){
       List<Integer> factors = new LinkedList<Integer>();
      for(int i = 2; i< number; i++) {
         while(number%i == 0) {
            //System.out.println(i+" ");
            factors.add(i);
            number = number/i;
         }
      }
      if(number >1) {
          
         factors.add((int)number);
        // System.out.println(number);
      }
       return factors;
   }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        th.setName(getTag());
        List<Integer> factors = calculateFactors(getNumber());
        System.out.println(th.getName() + " " + getNumber()+" = "+factors);
    }
}
