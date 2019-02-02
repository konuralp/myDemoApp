package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testNull(){
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani","Ayanda","Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2,1}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Moontoes","SanguineBane","Sweetdrop","Quickglow","Twirlcloud"}));
        assertEquals(App.repeat(aList,aList2,strList,null),null);
        assertEquals(App.repeat(aList,aList2,null,strList2),null);
        assertEquals(App.repeat(aList,null,strList,strList2),null);
        assertEquals(App.repeat(null,aList2,strList,strList2),null);
    }

    public void testNullElement(){
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani",null,"Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2,1}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Moontoes","SanguineBane","Sweetdrop","Quickglow","Twirlcloud"}));
        assertEquals(App.repeat(aList,aList2,strList,strList2),null);
    }

    public void testSizeMismatch(){
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani","Ayanda","Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Sweetdrop","Quickglow","Twirlcloud"}));
        assertEquals(App.repeat(aList,aList2,strList,strList),null);
        assertEquals(App.repeat(aList,aList2,strList2,strList2),null);
        assertEquals(App.repeat(aList,aList2,strList,strList2),null);
        assertEquals(App.repeat(aList2,aList,strList2,strList),null);
    }

    public void testEmptyArrays(){
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani","Ayanda","Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2,1}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Moontoes","SanguineBane","Sweetdrop","Quickglow","Twirlcloud"}));
        assertEquals(App.repeat(new ArrayList(),new ArrayList(),new ArrayList(),new ArrayList()),"");
        assertEquals(App.repeat(aList,new ArrayList(),strList,new ArrayList()),"Fatsani\n" +
                "Ayanda,Ayanda\n" +
                "Adebayo,Adebayo,Adebayo\n" +
                "Mtendere,Mtendere,Mtendere,Mtendere\n" +
                "Azariel,Azariel,Azariel,Azariel,Azariel\n");
        assertEquals(App.repeat(new ArrayList(),aList2,new ArrayList(),strList2),"Moontoes_Moontoes_Moontoes_Moontoes_Moontoes\n" +
                "SanguineBane_SanguineBane_SanguineBane_SanguineBane\n" +
                "Sweetdrop_Sweetdrop_Sweetdrop\n" +
                "Quickglow_Quickglow\n" +
                "Twirlcloud\n");

    }

    public void testWorking(){
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(new String[]{"Fatsani","Ayanda","Adebayo","Mtendere","Azariel"}));
        ArrayList<Integer> aList2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5,4,3,2,1}));
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(new String[]{"Moontoes","SanguineBane","Sweetdrop","Quickglow","Twirlcloud"}));

        assertEquals(App.repeat(aList,aList2,strList,strList2),"Fatsani\n" +
                "Ayanda,Ayanda\n" +
                "Adebayo,Adebayo,Adebayo\n" +
                "Mtendere,Mtendere,Mtendere,Mtendere\n" +
                "Azariel,Azariel,Azariel,Azariel,Azariel\n" +
                "Moontoes_Moontoes_Moontoes_Moontoes_Moontoes\n" +
                "SanguineBane_SanguineBane_SanguineBane_SanguineBane\n" +
                "Sweetdrop_Sweetdrop_Sweetdrop\n" +
                "Quickglow_Quickglow\n" +
                "Twirlcloud\n");
    }


}
