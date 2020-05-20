package it.polito.tdp.bar.model;

public class Tavolo implements Comparable <Tavolo> {
	
	private int NumPosti;
	private int NumDisponibli;
	private int id;
	
	/**
	 * @param numPosti
	 * @param numDisponibli
	 */
	public Tavolo(int numPosti, int numDisponibli, int id) {
		super();
		NumPosti = numPosti;
		NumDisponibli = numDisponibli;
		this.id=id;
	}

	/**
	 * @return the numPosti
	 */
	public int getNumPosti() {
		return NumPosti;
	}

	/**
	 * @param numPosti the numPosti to set
	 */
	public void setNumPosti(int numPosti) {
		NumPosti = numPosti;
	}

	/**
	 * @return the numDisponibli
	 */
	public int getNumDisponibli() {
		return NumDisponibli;
	}

	/**
	 * @param numDisponibli the numDisponibli to set
	 */
	public void setNumDisponibli(int numDisponibli) {
		NumDisponibli = numDisponibli;
	}

	@Override
	public int compareTo(Tavolo o) {
		return this.NumPosti-o.NumPosti;
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tavolo [NumPosti=" + NumPosti + ", NumDisponibli=" + NumDisponibli + ", id=" + id + "]";
	}
	
	

}
