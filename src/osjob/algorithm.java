/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author harsh
 */
public class algorithm {
      ArrayList<process> all = new ArrayList<process>();
      ArrayList<process> ready = new ArrayList<process>();
      ArrayList<process> finished =new ArrayList<process>();
      int curr=0;
      
       DecimalFormat df = new DecimalFormat("####.###");
      
      ArrayList<Integer> tt = new ArrayList<Integer>();
      ArrayList<Integer> wait= new ArrayList<Integer>();
      int allit=0,readyit=0,finishedit=0;
      
      public algorithm(ArrayList<process> arr){
          all=arr;
      }
      public void nextstep(){
      }

      
      boolean isempty(){
          System.out.println("size: "+ready.size());
          if(all.size()==allit&&ready.size()==0) return true;
          return false;
      }
      
      void print(){
          for(int i=0;i<finished.size();i++){
              System.out.println("id: "+finished.get(i).processId+" at: "+finished.get(i).arrivalTime+" bt: "+finished.get(i).burstTime+" p: "+finished.get(i).priority);
          }
      }
      
      String gettt(){
          double x=0;
          if(tt.size()==0) return Double.toString(0);
          for(int i=0;i<tt.size();i++){
              x+=tt.get(i);
          }
          return df.format(x/tt.size());
      }
      
      String getwt(){
         double x=0;
          if(wait.size()==0) return Double.toString(0);
          for(int i=0;i<wait.size();i++){
              x+=wait.get(i);
          }
          return df.format(x/tt.size()); 
      }
}
