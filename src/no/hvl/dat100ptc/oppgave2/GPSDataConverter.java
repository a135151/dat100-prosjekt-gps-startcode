package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		
		int hr = Integer.parseInt(timestr.substring(11,13))*60*60;
		int min = Integer.parseInt(timestr.substring(14,16))*60;
		int sec = Integer.parseInt(timestr.substring(17,19));
		int secs = hr + min + sec;
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		
		//"2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9"
		GPSPoint gpspoint = new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));

		return gpspoint;
		
	}
	
}
