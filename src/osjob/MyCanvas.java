/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osjob;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author harsh
 */
public class MyCanvas extends java.awt.Canvas {
    
    public MyCanvas() {
        setSize(1500,200);
    }
    
   
    
    ArrayList<process> p;
    
    Integer[] color={Color.BLACK.getRGB(),Color.BLUE.getRGB(),Color.CYAN.getRGB(),Color.GRAY.getRGB(),Color.GREEN.getRGB(),Color.MAGENTA.getRGB(),Color.ORANGE.getRGB(),Color.PINK.getRGB(),Color.RED.getRGB(),Color.YELLOW.getRGB()};
    int index=0;
    
    
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    
    void add(ArrayList<process> p){
        this.p=p;
        repaint();
    }
    
    public void paint(Graphics g){
        System.out.println("hksdfasdfas");
        int i=0;
        int currx=0,curry=0;
        int curr=0;
        if(p!=null){
            while(i<p.size()){
              System.out.println("finid: "+p.get(i).processId);
              Font f1 = new Font("Dialog", Font.PLAIN, 15);
              g.setFont(f1);
              g.setColor(Color.black);
              g.drawLine(currx, curry, currx,curry+ 70);
              g.drawString(Integer.toString(curr), currx+2,curry+ 65);
              currx+=2;
              Font f = new Font("Dialog", Font.PLAIN, 25);
              g.setFont(f);
            if(p.get(i).processId.equals("blank")){
                g.setColor(Color.white);
                g.fillRect(currx, curry, 30*p.get(i).burstTime, 50);
            }else{
                
                //////////////////////////////////////////////
                if(!map.containsKey(p.get(i).processId)){
                    map.put(p.get(i).processId, color[index]);
                    index++;
                }
                
                //////////////////////////////////////////////////
                g.setColor(new Color(map.get(p.get(i).processId)));
                g.fillRect(currx, curry, 30*p.get(i).burstTime, 50);
                g.setColor(Color.white);
                g.drawString(p.get(i).processId, currx+(30*p.get(i).burstTime/2)-10, curry+30);
            }
              curr+=p.get(i).burstTime;
            currx+=30*p.get(i).burstTime+2;
            i++;
        }
            g.setColor(Color.black);
            Font f1 = new Font("Dialog", Font.PLAIN, 15);
            g.setFont(f1);
             g.drawLine(currx,curry+ 0, currx,curry+ 70);
            g.drawString(Integer.toString(curr), currx+2,curry+ 65);
        }
    }
}

