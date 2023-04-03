package com.eurotech.test.day14_propertiesSingleton;

public class Singleton {

    // singleton class will have private constructor
    /// it means other classes can NOT  create an object of this

    private  Singleton(){


    }
    private static String str;

    public  static  String getInstance() {
        if (str == null) {
            System.out.println("str is null, assignning a value to it");

            str = "some value";
        } else {
            System.out.println(" it has a value , just returning it");
        }
        return str;
    }
}
