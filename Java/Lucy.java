/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucy;

import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author naveen
 */
public class Lucy {

    /**
     * @param args the command line arguments
     * @throws com.jaunt.NotFound
     */
    public static void main(String[] args) throws NotFound {
        // TODO code application logic here
        String description = null;
        String[] urlarray = args[0].split("\\s+");
        String sub, rest;
        sub = urlarray[0].substring(0, 1);
        rest = urlarray[0].substring(1);
        sub = sub.toUpperCase();
        urlarray[0] = sub + rest;
        String gotourl = urlarray[0];
        for(int i=1; i<urlarray.length; i++){
            sub = urlarray[i].substring(0, 1);
            rest = urlarray[i].substring(1);
            sub = sub.toUpperCase();
            urlarray[i] = sub + rest;
            gotourl = gotourl + "_" + urlarray[i];
        }
        if(args[0].equals("Hi!")||args[0].equals("hi!")||args[0].equals("hi")||args[0].equals("Hi")){
            System.out.println("Hi! I am Lucy.");
        }
        else{
            String url = "https://en.wikipedia.org/wiki/" + gotourl; 
            try {
                 UserAgent userAgent = new UserAgent();
                 userAgent.visit(url);
                 description = userAgent.doc.findFirst("<p>").innerText();
                 System.out.println(description);
            } catch (ResponseException ex) {
                 System.out.println("Can't find " + args[0] + " Please try another keyword.");
            }
        }
    }
}
