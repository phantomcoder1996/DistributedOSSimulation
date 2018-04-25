
package com.company;

import client.Client;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Client c =new Client();
        String rowKey="Travel & EventsStrictly DumplingSbehr63hZ-E";
        ArrayList<String> colFamily =new ArrayList<String>();
        ArrayList<String> cellData= new ArrayList<String>();
        colFamily.add("tags");
        cellData.add("new tags :travelling");
        c.set(rowKey, colFamily, cellData);
    }


}
