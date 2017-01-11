package ru.fkoban.utils;


import redis.clients.jedis.Jedis;

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
        cli.auth(password);
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
    public Map<String,String> getAllLastPoints() {
        Map<String,String> resultMap = new HashMap<String, String>();

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
    public String getLastPointByIMEI(String IMEI) {
        return cli.get("lastPoint_" + IMEI);
    }
}
