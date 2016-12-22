package ru.fkoban.gelix;

import java.util.Date;

public class GelixOnePacket {
    private Date timeStamp;
    private String strDateTime;
    private double lat;
    private double lon;
    private int sats;
    private double speed;
    private double dir;
    private double in0;
    private double in1;
    private double in2;
    private double in3;
    private int in4;
    private int in5;
    private int in6;
    private int in7;
    private int rs232;

    public String getStrDateTime() {
        return strDateTime;
    }

    public void setStrDateTime(String strDateTime) {
        this.strDateTime = strDateTime;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getSats() {
        return sats;
    }

    public void setSats(int sats) {
        this.sats = sats;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDir() {
        return dir;
    }

    public void setDir(double dir) {
        this.dir = dir;
    }

    public double getIn0() {
        return in0;
    }

    public void setIn0(double in0) {
        this.in0 = in0;
    }

    public double getIn1() {
        return in1;
    }

    public void setIn1(double in1) {
        this.in1 = in1;
    }

    public double getIn2() {
        return in2;
    }

    public void setIn2(double in2) {
        this.in2 = in2;
    }

    public double getIn3() {
        return in3;
    }

    public void setIn3(double in3) {
        this.in3 = in3;
    }

    public int getIn4() {
        return in4;
    }

    public void setIn4(int in4) {
        this.in4 = in4;
    }

    public int getIn5() {
        return in5;
    }

    public void setIn5(int in5) {
        this.in5 = in5;
    }

    public int getIn6() {
        return in6;
    }

    public void setIn6(int in6) {
        this.in6 = in6;
    }

    public int getIn7() {
        return in7;
    }

    public void setIn7(int in7) {
        this.in7 = in7;
    }

    public int getRs232() {
        return rs232;
    }

    public void setRs232(int rs232) {
        this.rs232 = rs232;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
