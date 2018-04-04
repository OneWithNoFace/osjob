/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.util.ArrayList;

/**
 *
 * @author harsh
 */
public class rr extends algorithm{
    int quantumtime=0;
    
    public rr(ArrayList<process> arr,int t) {
        super(arr);
        quantumtime=t;
    }
 
    @Override
    public void nextstep(){
        while(allit<all.size()&&all.get(allit).arrivalTime<=curr){
            ready.add(all.get(allit));
            allit++;
        }
        if(readyit<ready.size()){
            if(ready.get(readyit).burstTime<=quantumtime){
                finished.add(ready.get(readyit));
                curr+=ready.get(readyit).burstTime;
                tt.add(curr-ready.get(readyit).arrivalTime);
                wait.add(tt.get(tt.size()-1)-ready.get(readyit).burstTime);
                ready.remove(readyit);
                if(ready.size()!=0)  readyit=(readyit)%ready.size();
            }else{
                process p = new process(ready.get(readyit).processId,ready.get(readyit).arrivalTime,quantumtime,1);
                finished.add(p);
                curr+=quantumtime;
                ready.get(readyit).burstTime=ready.get(readyit).burstTime-quantumtime;
                while(allit<all.size()&&all.get(allit).arrivalTime<=curr){
                    ready.add(all.get(allit));
                    allit++;
                }
                readyit=(readyit+1)%ready.size();
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
    }
}
