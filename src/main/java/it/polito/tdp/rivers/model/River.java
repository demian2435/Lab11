package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

public class River {
	private int id;
	private String name;
	private LocalDate firstDate;
	private LocalDate lastDate;
	private int totalMeasure;
	private float medianMeasure;
	private List<Flow> flows;

	public River(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(LocalDate firstDate) {
		this.firstDate = firstDate;
	}

	public LocalDate getLastDate() {
		return lastDate;
	}

	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}

	public int getTotalMeasure() {
		return totalMeasure;
	}

	public void setTotalMeasure(int totalMeasure) {
		this.totalMeasure = totalMeasure;
	}

	public float getMedianMeasure() {
		return medianMeasure;
	}

	public void setMedianMeasure(float medianMeasure) {
		this.medianMeasure = medianMeasure;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		return name;
	}

	public String toStringLong() {
		return name + " - tm: " + totalMeasure + " - mm: " + medianMeasure;
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
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
