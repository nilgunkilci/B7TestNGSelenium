package com.eurotech.test.day20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] tvAndRating() {
        String[][] data = {
                {"Game Of Thrones", "9"},
                {"Sandman", "8"},
                {"La Casa De Papel", "8"},
                {"John Wick", "7"},
                {"Matrix", "9"},
                {"Battal Gazi", "10"},
                {"Interstaller", "9"},
                {"Braveheart", "9"}
        };
        return data;
    }

    @Test(dataProvider= "tvAndRating")
    public void  testTvShows(String tvShow,String rating) {
        System.out.println("Tv Show " + tvShow + "has rating " + rating);
    }
}
