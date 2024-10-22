package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class Main {

	
	public static void main(String[] args) {
		//"2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9"
		//"2017-08-13T04:37:12.000Z","41.385390","17.217217","104.9"
		GPSPoint gpsPoint1 = new GPSPoint(GPSDataConverter.toSeconds("2017-08-13T08:52:26.000Z"), Double.parseDouble("60.385390"), Double.parseDouble("5.217217"), Double.parseDouble("61.9"));
		GPSPoint gpsPoint2 = new GPSPoint(GPSDataConverter.toSeconds("2017-08-13T04:37:12.000Z"), Double.parseDouble("41.385390"), Double.parseDouble("17.217217"), Double.parseDouble("104.9"));
		
		GPSData gpsData = new GPSData(2);
		
		gpsData.insertGPS(gpsPoint1);
        gpsData.insertGPS(gpsPoint2);
        
        gpsData.print();

        
	}

}

