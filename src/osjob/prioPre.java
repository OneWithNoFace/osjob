/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author harsh
 */
public class prioPre extends algorithm {
      
    HashMap<String,Integer> map = new HashMap<String,Integer>();

    public prioPre(ArrayList<process> arr) {
      super(arr);
        for(int i=0;i<arr.size();i++){
            if(!map.containsKey(arr.get(i).processId)){
                map.put(arr.get(i).processId, arr.get(i).burstTime);
            }
        }
    }
    
    
    @Override
    public void nextstep(){
        while(allit<all.size()&&all.get(allit).arrivalTime<=curr){
            ready.add(all.get(allit));
            allit++;
        }
        
        Collections.sort(ready, new sortByArri());
        Collections.sort(ready, new sortByPrio());
        
        if(ready.size()!=0){
            curr++;
            if(finished.size()>0){
                if(finished.get(finished.size()-1).processId.equals(ready.get(0).processId)){
                    finished.get(finished.size()-1).burstTime++;
                }else{
                    process x= new process(ready.get(0).processId,ready.get(0).arrivalTime,1,ready.get(0).priority);
                    finished.add(x);
                }
            }else{
                process x= new process(ready.get(0).processId,ready.get(0).arrivalTime,1,ready.get(0).priority);
                finished.add(x);
            }
            ready.get(0).burstTime--;
            if(ready.get(0).burstTime==0){
                 tt.add(curr-ready.get(0).arrivalTime);
                 wait.add(tt.get(tt.size()-1)-map.get(ready.get(0).processId));
                ready.remove(0);
            }else{
               
            }
            
        }else{
            if(finished.size()>0&&finished.get(finished.size()-1).processId.equals("blank")){
                //System.out.println(finished.get(finished.size()-1).processId);
                finished.get(finished.size()-1).burstTime++;
            }else{
                process x= new process("blank",0,1,0);
                finished.add(x);
            }
            curr++;
        }
        /*Collections.sort(ready);
        if(readyit<ready.size()){
            finished.add(ready.get(readyit));
            curr+=ready.get(readyit).burstTime;
            tt.add(curr-ready.get(readyit).arrivalTime);
            wait.add(tt.get(tt.size()-1)-ready.get(readyit).burstTime);
            ready.remove(readyit);
        }else{
            if(finished.size()>0&&finished.get(finished.size()-1).processId.equals("blank")){
                //System.out.println(finished.get(finished.size()-1).processId);
                finished.get(finished.size()-1).burstTime++;
            }else{
                process x= new process("blank",0,1,0);
                finished.add(x);
            }
            curr++;
        }*/
    }
    
    
}
