package com.service.population.bean;

public class WorldPopulation {
	
	private String Rank;
	private String country;
	private String population;
	private String World;
	
	
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getWorld() {
		return World;
	}
	public void setWorld(String world) {
		World = world;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	
	public String toString () {
		 return "rank: '" + getRank() + "', country: '" + getCountry() + "', population: '" + getPopulation() + "', world: '"+ getWorld();
	}

}
