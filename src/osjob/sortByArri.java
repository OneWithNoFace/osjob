/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.util.Comparator;

/**
 *
 * @author harsh
 */
public class sortByArri implements Comparator<process> {

    @Override
    public int compare(process o1, process o2) {
        return o1.arrivalTime-o2.arrivalTime;
    }
    
}
