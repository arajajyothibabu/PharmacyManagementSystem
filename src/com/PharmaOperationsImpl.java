package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PharmaOperationsImpl implements PharmaOperations {
	
	private static List<Medicine> medList;

	public List<Medicine> getMedList() {
		return medList;
	}

	public void setMedList(List<Medicine> medList) {
		this.medList = medList;
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		if(medicine != null && medicine.getComponent() != null){
			for(Medicine currentMedicine : medList){
				if(currentMedicine.getName().equals(medicine.getName())){
					medList.add(medicine);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void updateMedicine(Medicine medicine) throws MedicineNotFoundException{
		boolean medicineNotFound = true;
		if(medicine != null){
			Component component = null;
			for(Medicine currentMedicine : medList){
				if(medicine.equals(currentMedicine)){
					component = currentMedicine.getComponent();
					if(component != null){
						int dosage = component.getDosage();
						component.setDosage((dosage/10) + dosage);
						medicineNotFound = false;
						break;
					}
				}
			}
		}
		if(medicineNotFound)
			throw new MedicineNotFoundException();
	}

	@Override
	public Set<Medicine> findMedicines(int compID) {
		Set<Medicine> medicines = new HashSet<Medicine>();
		Component component = null;
		for(Medicine currentMedicine : medList){
			component = currentMedicine.getComponent();
			if(component != null && component.getCompID() == compID){
				medicines.add(currentMedicine);
			}
		}
		return medicines;
	}
	
	
	Map<Component, List<Medicine>> getComponentMedicineMap() {
		Map<Component, List<Medicine>> componentMedicineMap = new HashMap<Component, List<Medicine>>();
		for(Medicine medicine : medList){
			if(componentMedicineMap.containsKey(medicine.getComponent())){
				componentMedicineMap.get(medicine.getComponent()).add(medicine);
			}
			else{
				List<Medicine> medicineList = new ArrayList<Medicine>();
				medicineList.add(medicine);
				componentMedicineMap.put(medicine.getComponent(), medicineList);
			}
		}
		return componentMedicineMap;
	}

}
