package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] latitudeArray = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i++) {
			latitudeArray[i] = gpspoints[i].getLatitude();
			
			
		}
		return latitudeArray;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[] longitudeArray = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i++) {
			longitudeArray[i] = gpspoints[i].getLongitude();

		
		}
		return longitudeArray;
	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		
		
		double latitude1 = Math.toRadians(gpspoint1.getLatitude());
		double longitude1 = Math.toRadians(gpspoint1.getLongitude());
		double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		double longitude2 = Math.toRadians(gpspoint2.getLongitude());
		double d1 = (latitude2 - latitude1);
		double d2 = longitude2 - longitude1;
		double a = compute_a(latitude1, latitude2, d1,d2);
		double c = compute_c(a);
		double d = R * c;

		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		double a = Math.pow(Math.sin(deltaphi / 2), 2) + (Math.cos(phi1) * Math.cos(phi2) * Math.pow(Math.sin(deltadelta / 2), 2));
		return a;
	}

	private static double compute_c(double a) {

		
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return c;

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = 0;
		int gps1Secs = gpspoint1.getTime();
		int gps2Secs = gpspoint2.getTime();
		double distance = distance(gpspoint1,gpspoint2);
		secs = gps2Secs - gps1Secs;
		double speed = distance / secs;
		
		
		
		
		
		return speed;

	}

	public static String formatTime(int secs) {

		
		String TIMESEP = ":";
		int hours = secs / 3600;
		int minutes = (secs % 3600) /60;
		int seconds = secs % 60;
		String h = String.valueOf(hours);
		String m = String.valueOf(minutes);
		String s = String.valueOf(seconds);
		if(hours < 10) {
			h = "0" + h;
		}
		if(minutes <10) {
			m = "0" + m;
		}
		if(seconds<10) {
			s = "0" + s;
		}
		
		String timestr = "  " + h + TIMESEP + m + TIMESEP + s;
		return timestr;
		
		
	}
	
	private static int TEXTWIDTH = 10;

	

	public static String formatDouble(double d) {
	    String dString = String.valueOf(d);
	    String[] parts = dString.split("\\.", 2);     
	    String integerPart = parts[0];
	    String decimalPart = "00"; 
	    
	    if (parts.length > 1) {
	        decimalPart = parts[1];

	       
	        if (decimalPart.length() > 2) {
	            
	            int desNum = Character.getNumericValue(decimalPart.charAt(2)); 
	            if (desNum >= 5) {
	                int secondDecimal = Character.getNumericValue(decimalPart.charAt(1)) + 1;
	                if (secondDecimal == 10) {
	                    secondDecimal = 0;
	                    integerPart = String.valueOf(Integer.parseInt(integerPart) + 1);
	                }
	                decimalPart = decimalPart.substring(0, 1) + secondDecimal;
	            } else {
	                decimalPart = decimalPart.substring(0, 2); 
	            }
	        } else if (decimalPart.length() == 1) {
	            decimalPart += "0"; 
	        } else {
	            decimalPart = "00";
	        }
	    }

	    
	    String nyString = integerPart + "." + decimalPart;

	    
	    if (nyString.length() < TEXTWIDTH) {
	        int x = TEXTWIDTH - nyString.length();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < x; i++) {
	            sb.append(" ");
	        }
	        sb.append(nyString);
	        nyString = sb.toString();
	    }

	    return nyString;
	}

}
