package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("strList1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<String> strList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                strList1.add(sc1.next().replaceAll("\\s",""));
            }
            System.out.println(strList1);
            sc1.close();

            String input2 = req.queryParams("strList2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<String> strList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                strList2.add(sc2.next().replaceAll("\\s",""));
            }
            sc2.close();
            System.out.println(strList2);


            String input3 = req.queryParams("intList1");
            java.util.Scanner sc3 = new java.util.Scanner(input3);
            sc3.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> intList1 = new java.util.ArrayList<>();
            while (sc3.hasNext())
            {
                int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
                intList1.add(value);
            }
            System.out.println(strList2);
            sc3.close();

            String input4 = req.queryParams("intList2");
            java.util.Scanner sc4 = new java.util.Scanner(input4);
            sc4.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> intList2 = new java.util.ArrayList<>();
            while (sc4.hasNext())
            {
                int value = Integer.parseInt(sc4.next().replaceAll("\\s",""));
                intList2.add(value);
            }
            System.out.println(strList2);
            sc4.close();

            String result = "<br>"+App.repeat(intList1,intList2,strList1,strList2).replace("\n","<br>");

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
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
                    sb1.append(strList.get(k)).append((i==intList.get(k)-1 ? "" : ",") );
                }
                sb1.append("\n");
        }
        for(int k=0; k <intList2.size(); k++){
            for (int i = 0; i < intList2.get(k); i++) {
                sb1.append(strList2.get(k)).append((i==intList2.get(k)-1 ? "" : ","));
            }
            sb1.append("\n");
        }
        return sb1.toString();
    }
}
