package ru.fkoban.utils;

import ru.fkoban.gelix.GelixOnePacket;

import java.util.Locale;

public class SimpleJSONer {
    public static String makeJSONFromProcessingObject(GelixOnePacket processingGelixObject){
        String returnString = String.format(new Locale("en"),"{\"sdt\":\"%s\",\"ts\":%ts,\"lat\":%.6f,\"lon\":%.6f,\"speed\":%.1f,\"dir\":%.1f,\"sats\":%d,\"in0\":%.3f,\"in1\":%.3f,\"in2\":%.3f,\"in3\":%.3f,\"in4\":%d,\"in5\":%d,\"in6\":%d,\"in7\":%d,\"com\":%d,\"rawPacket\":\"%s\",\"addInfo\":\"%s\"}",
                processingGelixObject.getStrDateTime(),
                processingGelixObject.getTimeStamp(),
                processingGelixObject.getLat(),
                processingGelixObject.getLon(),
                processingGelixObject.getSpeed(),
                processingGelixObject.getDir(),
                processingGelixObject.getSats(),
                processingGelixObject.getIn0(),
                processingGelixObject.getIn1(),
                processingGelixObject.getIn2(),
                processingGelixObject.getIn3(),
                processingGelixObject.getIn4(),
                processingGelixObject.getIn5(),
                processingGelixObject.getIn6(),
                processingGelixObject.getIn7(),
                processingGelixObject.getRs232(),
                processingGelixObject.getRawPacket(),
                processingGelixObject.getAdditionalInfo()
        );
            return returnString;
    }
}
