package ru.fkoban.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import ru.fkoban.gelix.GelixOnePacket;

import java.util.*;

public class RedisWorker {
    private Jedis cli;

    /**
     * constructor: connect to Redis server and authorization
     * @param host redis host (localhost usually )
     * @param port redis port
     * @param password redis password
     */
    public RedisWorker(String host, int port, String password) {
        //localhost 6379 by default
        cli = new Jedis(host, port, 5000);
        //cli.auth(password);
        try {
            cli.connect();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * close connection
     */
    public void close() {
        if (cli.isConnected()) {
                cli.disconnect();
        }
    }

    /**
     * get all keys that begin with "lastPoint_" string

     * @return list of strings
     */
    public Map<String,GelixOnePacket> getAllLastPoints() {
        Map<String,GelixOnePacket> resultMap = new HashMap<String, GelixOnePacket>();

        Set<String> allKeys =  cli.keys("lastPoint_*");

        for(Iterator<String> iterator = allKeys.iterator();iterator.hasNext();) {
            String IMEI =  iterator.next().split("_")[1];
            resultMap.put(IMEI, getLastPointByIMEI(IMEI));
        }
        return resultMap;
    }

    /**
     * sets or update lastPoint information for IMEI
     * @param IMEI imei of device
     * @param value JSON string with all parameters
     */
    public void updateLastPoint(String IMEI,String value) {
        cli.set("lastPoint_" + IMEI,value);
    }
    /**
     * gets lastPoint information for given IMEI
     * @param IMEI just IMEI of device
     * @return  String
     */
    public GelixOnePacket getLastPointByIMEI(String IMEI) {
        String lpString = cli.get("lastPoint_" + IMEI);
        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println("read lastpoint for device "+IMEI+" "+lpString);
            GelixOnePacket lastPacket = mapper.readValue(lpString, GelixOnePacket.class);
            return lastPacket;
        } catch (Exception e){
            return null;
        }

    }
}
