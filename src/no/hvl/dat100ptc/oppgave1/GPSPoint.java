package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		
	}

	// TODO - get/set metoder
	public int getTime() {
		return time;
		
	}

	public void setTime(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("Tid kan ikke være negativ.");
		}
		this.time = time;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		if (latitude < -90.0 || latitude > 90.0) {
			throw new IllegalArgumentException("Breddegraden må være mellom -90 og 90 grader.");
		}
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Lengdegraden må være mellom -180 og 180 grader.");
		}
		this.longitude = longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	
	public String toString() {
		return time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
	}
}
