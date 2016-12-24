package com;

import java.util.Set;

public interface PharmaOperations {
	
	boolean addMedicine(Medicine medicine);
	
	void updateMedicine(Medicine medicine) throws MedicineNotFoundException;
	
	Set<Medicine> findMedicines(int compID);

}
