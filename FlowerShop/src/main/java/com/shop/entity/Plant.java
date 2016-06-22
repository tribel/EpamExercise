package com.shop.entity;

import com.shop.flowerEnum.PlantType;


/**
 * Super class of the flowers.
 * @author Tribel
 *
 */
public class Plant {
	
	protected PlantType plantType;
	
	public PlantType getPlantType() {
		return plantType;
	}

	public void setPlantType(PlantType plantType) {
		this.plantType = plantType;
	}

	@Override
	public String toString() {
		return "Plant [plantType=" + plantType + "]";
	}
	
	
}
