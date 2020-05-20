package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {

	private PriorityQueue<Event> queue = new PriorityQueue<>();
	private List<Tavolo> tavoli = new LinkedList<>();
	
	private final LocalTime oraApertura = LocalTime.of(8, 00);
	private final LocalTime oraChiusura = LocalTime.of(23, 00);
	
	private int clienti ;
	private int insoddisfatti ;
	
	public void listaTavoli () {
		
		tavoli.add(new Tavolo (10, 2, 10));
		tavoli.add(new Tavolo (8, 4, 8));
		tavoli.add(new Tavolo (6, 4, 6));
		tavoli.add(new Tavolo (4, 5, 4));
		Collections.sort(tavoli);
	
	}
	public int getClienti() {
		return clienti;
	}

	public int getInsoddisfatti() {
		return insoddisfatti;
	}
	
	public void run() {
		System.out.println(tavoli);
		this.clienti = this.insoddisfatti = 0 ;
		this.queue.clear();
		LocalTime oraArrivoCliente = this.oraApertura ;
		
		do {
			int persone = (int) (Math.random()*10+1);
			Duration permanenza = Duration.of(Math.round(((float)(Math.random()+1)*60)),ChronoUnit.MINUTES);
			Double tolleranza = Math.random();
			Event e = new Event(oraArrivoCliente, EventType.ARRIVO_GRUPPO_CLIENTI, persone, permanenza, tolleranza);
			this.queue.add(e);
			
			oraArrivoCliente = oraArrivoCliente.plus(Duration.of((int) (Math.random()*10+1), ChronoUnit.MINUTES));
			
		} while(oraArrivoCliente.isBefore(this.oraChiusura));
		
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll();
			processEvent(e);
			System.out.println(e);
	}
	}
	
	private void processEvent(Event e) {
	
		switch(e.getType()) {
		
		case ARRIVO_GRUPPO_CLIENTI:
			
			boolean assegnati=false;
			for (Tavolo t : tavoli) {
				if (e.getPersone()<=t.getNumPosti() && t.getNumDisponibli()>0 && e.getPersone()>=t.getNumPosti()/2) {
					t.setNumDisponibli(t.getNumDisponibli()-1);
					clienti = clienti+e.getPersone();
					assegnati=true;
					e.setId(t.getId());
					break;
				}
			}
			if (assegnati == false) {
				if (e.getTolleranza()>=0.5)
					clienti = clienti+e.getPersone();
				else
					insoddisfatti = insoddisfatti+e.getPersone();
			}
			if (assegnati==true) {
			Event nuovo = new Event (e.getTime().plus(e.getPermanenza()), EventType.TAVOLO_LIBERATO, e.getPersone(), e.getPermanenza(), e.getTolleranza());
			nuovo.setId(e.getId());
			this.queue.add(nuovo); }
			
			break;
			
		case TAVOLO_LIBERATO:
			
			switch(e.getId()) {
			
			case 10:
				for (Tavolo t : tavoli) {
					if (t.getNumPosti()==10)
						t.setNumDisponibli(t.getNumDisponibli()+1);
					break;
				}
			case 8:
				for (Tavolo t : tavoli) {
					if (t.getNumPosti()==8)
						t.setNumDisponibli(t.getNumDisponibli()+1);
					break;
				}
			case 6:
				for (Tavolo t : tavoli) {
					if (t.getNumPosti()==6)
						t.setNumDisponibli(t.getNumDisponibli()+1);
					break;
				}
			case 4:
				for (Tavolo t : tavoli) {
					if (t.getNumPosti()==4)
						t.setNumDisponibli(t.getNumDisponibli()+1);
					break;
				}
			}
			break;
}
	}
}
