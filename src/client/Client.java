
package client;

import com.company.ClientMessage;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    //private SocketIO masterSocket,tabletSocket;
    public Socket masterSocket,tabletSocket1,tabletSocket2;
    private PrintWriter masterOut,tabletOut1,tabletOut2;


    public Client() throws Exception {

        //connect to master
        masterSocket = new Socket(InetAddress.getByName("localhost"),9000);
      //  masterOut=new PrintWriter(masterSocket.getOutputStream(), true);

        //connect to tablet server  no.1
        //tabletSocket1 =new Socket("localhost",6666);
        //tabletOut1=new PrintWriter(tabletSocket1.getOutputStream(), true);

        //connect to tablet server no.2
        //tabletSocket2 =new Socket("localhost",6666);
        //tabletOut2=new PrintWriter(tabletSocket2.getOutputStream(), true);



    }
    //Input: row key, [column family: (qualifier) and cell data] can be repeated n times
    public void set(String rowKey,ArrayList<String> colFamily,ArrayList<String> cellData) throws IOException
    {
        JSONArray masterObj = new JSONArray ();
        JSONArray  tabletObj1 = new JSONArray ();
        JSONArray  tabletObj2 = new JSONArray ();
        ClientMessage msg =new ClientMessage();
        int num=0;
        //create the mrequest msg
        msg.tag=3;
        msg.content.add(rowKey);
        //writer object
        ObjectOutputStream out=new ObjectOutputStream(masterSocket.getOutputStream());
        out.writeObject(msg); //send the request to the server
        //recieve tablet server number
        ObjectInputStream in=new ObjectInputStream(masterSocket.getInputStream());
        try {
            // write the object
            msg=(ClientMessage)in.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(msg.tag);
        System.out.println(msg.content.get(0));


        //send a request to the tablet server
       /*      if(num==1) //server no.1
       {

       for(int i =0 ;i<colFamily.size();i++)
       {
       JSONObject tjo=new JSONObject();
       tjo.put("tag","5")
       .put("rowKey",rowKey)
       .put(colFamily.get(i), cellData.get(i));
       tabletObj1.put(tjo);
       }
       tabletOut1.println(tabletObj1);

       //get the result from the tablet server and send it to the client UI
       //if the query blocked leave the connection open until getting the request

       BufferedReader inTablet = new BufferedReader(new InputStreamReader(tabletSocket1.getInputStream()));
       PrintWriter outTablet = new PrintWriter(tabletSocket1.getOutputStream(), true);
       JSONArray served = new JSONArray(outTablet);
       System.out.println(served);

       }
       else //server no.2
       {
       for(int i =0 ;i<colFamily.size();i++)
       {
       JSONObject tjo=new JSONObject();
       tjo.put("tag","5")
       .put("rowKey",rowKey)
       .put(colFamily.get(i), cellData.get(i));
       tabletObj2.put(tjo);
       }
       tabletOut2.println(tabletObj2);

       //get the result from the tablet server and send it to the client UI
       //if the query blocked leave the connection open until getting the request
       BufferedReader inTablet = new BufferedReader(new InputStreamReader(tabletSocket1.getInputStream()));
       PrintWriter outTablet = new PrintWriter(tabletSocket1.getOutputStream(), true);
       JSONArray served = new JSONArray(outTablet);
       System.out.println(served);
       }
       */
   //     masterOut.println(masterObj);


    }
    //Input: row key, [column family: (qualifier)] can be repeated n times
    public void deleteCells(String rowKey,ArrayList<String> colFamily)
    {

    }
    //Input: row key
    public void deleteRow(String rowKey)
    {


    }
    //Input: row key, [column family: (qualifier) and cell data] can be repeated n times
    public void addRow(String rowKey,ArrayList<String> colFamily,ArrayList<String> cellData)
    {

    }

    //Input: [row key] can be repeated n times
    public void readRows(String rowKey)
    {

    }



}
