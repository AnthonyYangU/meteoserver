package com.example.demo.utils;

import com.example.demo.entity.Meteo;
import com.example.demo.entity.Humitemp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataAnalysis {
    //    String[] standard = new String[4];
    private static byte[] controlCharBytes = {0x01, 0x02, 0x03, 0x04};//SOH,STX,ETX,EOT
    private static String controlChar = new String(controlCharBytes);
    private static String header = "1|00124|1011173512|HUMITEMP|1|02L";
    private static String body1 = "TAINS|R|N|20.00|C";
    private static String body2 = "TA10M|R|N|20.00|C";
    private static String example = controlChar.substring(0, 1) + header + controlChar.substring(2, 3) +
            controlChar.substring(1, 2) + body1 + controlChar.substring(2, 3) + controlChar.substring(1, 2)
            + body2 + controlChar.substring(2, 3) + controlChar.substring(3, 4);
    private static String scale = controlChar.substring(2, 3) + controlChar.substring(1, 2);

    private static Set<String> typeSet = Set.of("CLOUD", "HUMITEMP", "PRESS", "RAIN", "VIS", "WIND", "PW", "PV", "ROSA", "RWYLIGHTS");

    public static Meteo getHeaderInfo(String message) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(message);

        int start = 0;
        int end = message.length()-2;
        int position;
        String headerContent = null;
        String messageType;
        List<String> bodyContent = new ArrayList<>();

        while (true) {
             position = message.indexOf(scale,start);
//             System.out.println("position is" + position);
             if(position==-1){
                 bodyContent.add(message.substring(start,end));
                 break;
             }else{
                 if(start==0){
                     headerContent = message.substring(start+1,position);
                 }else{
                     bodyContent.add(message.substring(start, position));
                 }
                 start = position + 2;
             }
        }

        String[] headerArray = headerContent.split("\\|");
        Meteo meteo = getMeteoInfo(headerArray,bodyContent);

        return meteo;
    }

    public static void getHeadInfo(String[] headerArray,Meteo meteo){
        meteo.setVersion(Integer.parseInt(headerArray[0]));

        if (headerArray[1].equals("0") || headerArray[1].equals("")) {
            //无序列号
        } else {
             meteo.setSequenceNumber(Integer.parseInt(headerArray[1]));
        }

        if (headerArray[2].equals("0")) {
            //无时间
        } else {
            if (headerArray[2].length() != 10) {
                throw new RuntimeException("UTC unix time data error");
            } else {
                meteo.setMessageTime(Integer.parseInt(headerArray[2]));
//                Instant ins = Instant.ofEpochSecond(Integer.parseInt(headerArray[2]));
//                messageTime = ins.atZone((ZoneId.systemDefault()));
            }
        }

        if (typeSet.contains(headerArray[3])) {
            meteo.setMessageType(headerArray[3]);
        } else {
            throw new RuntimeException("Unknown message type");
        }

        if (headerArray[4].equals("")) {
            //数据无法定位
        } else {
            meteo.setSensorId(Integer.parseInt(headerArray[4]));
        }

        if (headerArray[5].equals("")) {
            //数据无法定位或位置数据不可用
        } else if (headerArray[5].equals("///")) {
            throw new RuntimeException("Sensor Location can't be used");
        } else {
           meteo.setLocationId(headerArray[5]);
        }

    }

    public static Meteo getMeteoInfo(String[] headerArray,List<String> bodyList) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(typeSet.contains(headerArray[3])){
            String className = headerArray[3].substring(0,1) + headerArray[3].substring(1).toLowerCase();
            Class meteoClass = Class.forName("com.example.demo.entity."+className);
            Constructor cons = meteoClass.getConstructor();
            Meteo meteo = (Meteo) cons.newInstance();
            getHeadInfo(headerArray,meteo);
            Class argClass;
            for(String body : bodyList) {
                String[] strings = body.split("\\|");
                switch (strings[1]) {
                    case ("I"):
                        argClass = Integer.class;
                        break;
                    case ("R"):
                        argClass = Double.class;
                        break;
                    case ("S"):
                        argClass = String.class;
                        break;
                    default:
                        throw new ClassNotFoundException();
                }
                String methodName = "set" + strings[0].substring(0, 1) + strings[0].substring(1).toLowerCase();
                Method m = meteoClass.getMethod(methodName, argClass);

                if (argClass == Integer.class) {
                    m.invoke(meteo, Integer.parseInt(strings[3]));
                } else if (argClass == Double.class) {
                    m.invoke(meteo, Double.parseDouble(strings[3]));
                } else if (argClass == String.class) {
                    m.invoke(meteo, strings[3]);
                }
            }
            Method test = meteoClass.getMethod("getTains");
            System.out.println(test.invoke(meteo));
            return meteo;
        }
        return null;
    }

//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Meteo headerInfo = DataAnalysis.getHeaderInfo(example);
////        System.out.println(headerInfo);
//    }
}
