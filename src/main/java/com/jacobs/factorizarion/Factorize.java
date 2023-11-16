/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jacobs.factorizarion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author DAWOUD
 */
public class Factorize {
   public static void main(String args[]){
      int thread_pool_size = 0,count=0;
      Thread threads[];
      Queue<String> elements_queue= new LinkedList<String>();
      System.out.println(args[0]+ args[1]);
            String raw_input, classify_inputs[];
      //&& StringUtils.isNumeric(args[1])
      if(args[0].matches("-t"))
      {
          thread_pool_size=Integer.valueOf(args[1]); 
      }
      else{
          while(thread_pool_size<=0){
      System.out.println("Please, Enter positive integer number as size of thread pool");
      Scanner sc = new Scanner(System.in);  
      thread_pool_size = sc.nextInt();}
      }
    
        System.out.println("Please, Enter number prefixed with a tag");
    try(Scanner sc = new Scanner(System.in)){ 
        System.out.println("Enter the elements: ");  
    while(sc.hasNextLine()&& ((raw_input = sc.nextLine()).compareTo("_end_")!=0)&&(raw_input.compareTo("")!=0))  
    {   
        elements_queue.add(raw_input);
        System.out.println(elements_queue.size());
        count++;
    //takes the string input and prints the same string  


    }// End While there is input or input is not equal to the "_end_"
}// End try input scanner
if(thread_pool_size<elements_queue.size())
        threads = new Thread[elements_queue.size()];
else    
        threads = new Thread[thread_pool_size];
    for(int j=0;j<count;j++)
    {   
        classify_inputs=(elements_queue.poll()).split("\\s");
        FactorizationThread factorization = new FactorizationThread(classify_inputs[0], Long.parseLong(classify_inputs[1]));
        threads[j]= new Thread(factorization);
        threads[j].setName(classify_inputs[0]);
        threads[j].start();
    }//End for separation numbers from tag and start threads

   }// End Main method
}
