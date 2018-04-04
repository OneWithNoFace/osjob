/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

/**
 *
 * @author harsh
 */
public class process implements Comparable<process>{
    String processId;
    Integer arrivalTime;
    Integer burstTime;
    Integer priority;
    
    public process(String id,Integer at,Integer bt,Integer p){
        this.processId=id;
        this.arrivalTime=at;
        this.burstTime=bt;
        this.priority=p;
    }
    
    public String getProcessId(){
        return processId;
    }
    
    public Integer getArrivalTime(){
        return arrivalTime;
    }
    
    public Integer getBurstTime(){
        return burstTime;
    }
    
    public Integer getPriority(){
        return priority;
    }

    @Override
    public int compareTo(process o) {
        int compareQuantity = ((process) o).getBurstTime();

		//ascending order
		return this.burstTime - compareQuantity;
    }
    
    
}
