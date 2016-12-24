package com;

public class Component {
	private int compID;
	private String compName;
	private int dosage;
	
	public Component(int compID, String compName, int dosage) {
		super();
		this.compID = compID;
		this.compName = compName;
		this.dosage = dosage;
	}

	public int getCompID() {
		return compID;
	}

	public void setCompID(int compID) {
		this.compID = compID;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + compID;
		result = prime * result + ((compName == null) ? 0 : compName.hashCode());
		result = prime * result + dosage;
		return result;
	}
	
	//comparing components with id and name
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (compID != other.compID)
			return false;
		if (compName == null) {
			if (other.compName != null)
				return false;
		} else if (!compName.equals(other.compName))
			return false;
		if (dosage != other.dosage)
			return false;
		return true;
	}
	
	
	
	
}
