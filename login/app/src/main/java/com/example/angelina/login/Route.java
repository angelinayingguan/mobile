package com.example.angelina.login;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.nearby.messages.Distance;

import java.util.List;

import javax.xml.datatype.Duration;



/**
 * Created by Mai Thanh Hiep on 4/3/2016.
 */
public class Route {
    public Distance distance;
    public com.example.angelina.login.Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
