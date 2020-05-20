package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

public class Event implements Comparable <Event>{
	
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI, TAVOLO_LIBERATO;
	}
	
	private LocalTime time;
	private EventType type;
	private int persone;
	private Duration permanenza;
	private double tolleranza;
	private int id=0;

	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", persone=" + persone + ", permanenza=" + permanenza
				+ ", tolleranza=" + tolleranza + ", id=" + id + "]";
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param time
	 * @param type
	 * @param persone
	 * @param permanenza
	 * @param tolleranza
	 */
	public Event(LocalTime time, EventType type, int persone, Duration permanenza, double tolleranza) {
		super();
		this.time = time;
		this.type = type;
		this.persone = persone;
		this.permanenza = permanenza;
		this.tolleranza = tolleranza;
	}


	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}



	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}



	/**
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}



	/**
	 * @return the persone
	 */
	public int getPersone() {
		return persone;
	}



	/**
	 * @param persone the persone to set
	 */
	public void setPersone(int persone) {
		this.persone = persone;
	}



	/**
	 * @return the permanenza
	 */
	public Duration getPermanenza() {
		return permanenza;
	}



	/**
	 * @param permanenza the permanenza to set
	 */
	public void setPermanenza(Duration permanenza) {
		this.permanenza = permanenza;
	}



	/**
	 * @return the tolleranza
	 */
	public double getTolleranza() {
		return tolleranza;
	}



	/**
	 * @param tolleranza the tolleranza to set
	 */
	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}



	@Override
	public int compareTo(Event o) {
		return this.time.compareTo(o.time);
	}

}
