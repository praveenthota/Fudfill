package com.fudfill.runner.slidingmenu.model;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.w3c.dom.Document;
import com.google.android.gms.maps.model.LatLng;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Sowmya on 12/31/2014.
 */
public class RunnerRouteMapPlan {
    public final static String MODE_DRIVING = "driving";
    public RunnerRouteMapPlan(){}
    public Document getDocument(LatLng start, LatLng end, String mode){
        String url = "http://maps.googleapis.com/maps/api/directions/xml?"
                + "origin=" + start.latitude + "," + start.longitude
                + "&destination=" + end.latitude + "," + end.longitude
                + "&sensor=false&units=metric&mode=driving";
        url = "https://goo.gl/maps/T9e9w";
        try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext localContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost(url);
                HttpResponse response = httpClient.execute(httpPost, localContext);
                InputStream in = response.getEntity().getContent();
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.parse(in);
                return doc;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


    }



}
