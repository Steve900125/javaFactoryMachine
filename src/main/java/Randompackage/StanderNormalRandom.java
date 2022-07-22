/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Randompackage;
/**
 *
 * @author USER
 */

//使用Box–Muller數學公式產生一個常態分佈的亂數   
public class StanderNormalRandom {
    public static double get(float u ,float v){ 
        double u1 = Math.random();    
        double u2 = Math.random();
        double z1 = Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2);
        
        //u 是平均值 v 是變異數 Math.sqrt(v)是標準差
        return Math.sqrt(v) * z1 + u;
    }
     public static double get(){
        double u1 = Math.random();    
        double u2 = Math.random();
        double z1 = Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2);   
        return z1;
     }
    
    public static void showInfor(){
        System.out.println("使用Box–Muller數學公式產生一個常態分佈的亂數");
        System.out.println("使用方法StanderNormalRandom.get() 能取得一個常態分布的亂數"
                + "\n如果沒有加入參數則是預設範圍"
                + "\n若要加入則需給予get(u平均值 , v變異數)"
                );
    }
    
    public static void showText(float u ,float v , int times){
        double sum = 0;
        double min=0,max=0,avg=0,temp=0;
        
        for(int i = 1 ; i <= times ; i++ ){
            temp = get(u,v);
            if(i == 1){
                min = temp;
                max = temp;
            }
            
            if(temp > max ){
                max = temp;
            }else if(temp < min){
                min = temp;
            }
            sum+=temp;
        }
        avg = sum / times;        
        System.out.println("(times: " + times + "   u(平均值): " + u + "    v(變異數): " + v + ")");
        System.out.println("min: " + min + "    max: "+max + "  var: " + avg);
    }
}
