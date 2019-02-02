package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani","Ayanda","Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2,1}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Moontoes","SanguineBane","Sweetdrop","Quickglow","Twirlcloud"}));
        System.out.println(repeat(aList,aList2,strList,strList2));
    }

    public static String repeat(ArrayList<Integer> intList, ArrayList<Integer> intList2 ,ArrayList<String> strList, ArrayList<String> strList2){
        if(intList==null || intList2==null || strList==null || strList2==null){
            return null;
        }
        if(intList2.size()!=strList2.size()){
            return null;
        }
        if(intList.size()!=strList.size()){
            return null;
        }
        if(intList.contains(null)||intList2.contains(null)||strList.contains(null)||strList2.contains(null)){
            return null;
        }
        StringBuilder sb1 = new StringBuilder();
        for(int k=0; k <intList.size(); k++){
                for (int i = 0; i < intList.get(k); i++) {
                    sb1.append(strList.get(i)).append((i==intList.get(k)-1 ? "" : ",") );
                }
                sb1.append("\n");
        }
        for(int k=0; k <intList2.size(); k++){
            for (int i = 0; i < intList2.get(k); i++) {
                sb1.append(strList2.get(i)).append((i==intList2.get(k)-1 ? "" : ","));
            }
            sb1.append("\n");
        }
        return sb1.toString();
    }
}
