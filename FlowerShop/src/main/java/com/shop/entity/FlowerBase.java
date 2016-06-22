package com.shop.entity;

import com.shop.flowerEnum.BaseType;

/**
 * Class that implements base of the flower.
 * Includes Accessory Base type.
 * @author Tribel
 *
 */
public class FlowerBase extends Accessory {

	protected BaseType baseType;

	/**
	 * Default constructor.
	 */
	public FlowerBase() {
		super();
	}

	/**
	 * Constructor.
	 * @param baseType type of the flower base.
	 */
	public FlowerBase(BaseType baseType) {
		super();
		this.baseType = baseType;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	@Override
	public String toString() {
		return "FlowerBase [baseType=" + baseType + "]";
	}

}
