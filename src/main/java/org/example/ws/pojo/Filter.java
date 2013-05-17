package org.example.ws.pojo;


public class Filter {

	private Region region;
	private Budget budget;
	private String key;
	private TypeOfCommercial TypeOfCommercial;
	private FacilityNeeded FacilityNeeded;

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the budget
	 */
	public Budget getBudget() {
		return budget;
	}

	/**
	 * @param budget
	 *            the budget to set
	 */
	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the typeOfCommercial
	 */
	public TypeOfCommercial getTypeOfCommercial() {
		return TypeOfCommercial;
	}

	/**
	 * @param typeOfCommercial
	 *            the typeOfCommercial to set
	 */
	public void setTypeOfCommercial(TypeOfCommercial typeOfCommercial) {
		TypeOfCommercial = typeOfCommercial;
	}

	/**
	 * @return the facilityNeeded
	 */
	public FacilityNeeded getFacilityNeeded() {
		return FacilityNeeded;
	}

	/**
	 * @param facilityNeeded
	 *            the facilityNeeded to set
	 */
	public void setFacilityNeeded(FacilityNeeded facilityNeeded) {
		FacilityNeeded = facilityNeeded;
	}
}
