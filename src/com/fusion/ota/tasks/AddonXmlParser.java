package com.fusion.ota.tasks;

import android.util.Log;

import com.fusion.ota.Addon;
import com.fusion.ota.utils.Constants;

import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AddonXmlParser extends DefaultHandler implements Constants {

    private final static String TAG = "AddonXmlParser";

    public static ArrayList<Addon> parse(File xmlFile) {
        ArrayList<Addon> addons = null;
        try {
            SAXParserFactory xmlReader = SAXParserFactory.newInstance();
            SAXParser saxParser = xmlReader.newSAXParser();
            AddonsSaxHandler saxHandler = new AddonsSaxHandler();
            saxParser.parse(xmlFile, saxHandler);
            addons = saxHandler.getAddons();
        } catch (Exception ex) {
            Log.d(TAG, "SAXXMLParser: parse() failed");
        }
        return addons;
    }
}