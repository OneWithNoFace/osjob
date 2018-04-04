/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author harsh
 */
public class sjf extends algorithm {
    
    public sjf(ArrayList<process> arr) {
        super(arr);
    }
    
    @Override
    public void nextstep(){
        while(allit<all.size()&&all.get(allit).arrivalTime<=curr){
            ready.add(all.get(allit));
            allit++;
        }
        Collections.sort(ready);
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
        }
    }
}
