package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Test {
	public static void main(String args[]) throws Exception {
		//just to test code
		List<Medicine> medicines = new ArrayList<Medicine>();
		medicines.add(new Medicine("Name1", "CODE1", new Component(1, "Comp1", 5)));
		medicines.add(new Medicine("Name2", "CODE2", new Component(2, "Comp2", 5)));
		medicines.add(new Medicine("Name3", "CODE3", new Component(1, "Comp1", 5)));
		medicines.add(new Medicine("Name4", "CODE4", new Component(2, "Comp2", 5)));
		medicines.add(new Medicine("Name5", "CODE5", new Component(1, "Comp1", 5)));
		medicines.add(new Medicine("Name6", "CODE1", new Component(1, "Comp1", 5)));
		medicines.add(new Medicine("Name7", "CODE2", new Component(3, "Comp3", 5)));
		medicines.add(new Medicine("Name8", "CODE3", new Component(4, "Comp4", 5)));
		medicines.add(new Medicine("Name9", "CODE4", new Component(3, "Comp3", 5)));
		medicines.add(new Medicine("Name10", "CODE5", new Component(5, "Comp5", 5)));
		
		PharmaOperationsImpl pharmaOperationsImpl = new PharmaOperationsImpl();
		pharmaOperationsImpl.setMedList(medicines);
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Menu: 1. addMedicine\t2.updateMedicine\t3.findMedicine\t4.getMap\t0.Exit");
			switch(in.nextInt()){
			case 1:
				pharmaOperationsImpl.addMedicine(new Medicine(in.next(), in.next(), new Component(in.nextInt(), in.next(), in.nextInt())));
				break;
			case 2:
				pharmaOperationsImpl.updateMedicine(new Medicine("Name1", "CODE1", new Component(1, "Comp1", 5)));
				break;
			case 3:
				Set<Medicine> set = pharmaOperationsImpl.findMedicines(in.nextInt());
				for(Medicine medicine : set)
					System.out.println(medicine.getComponent().getDosage());
				break;
			case 4:
				Map<Component, List<Medicine>> componentMedicineMap = pharmaOperationsImpl.getComponentMedicineMap();
				for(Entry<Component, List<Medicine>> map : componentMedicineMap.entrySet()){
					System.out.println(map.getKey().getCompName() + "---->" + map.getValue().size());
				}
				break;
			case 0: System.exit(0); 
			}
		}
	}
}
