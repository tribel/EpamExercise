package com.shop.entity;

import com.shop.flowerEnum.FreshType;
import com.shop.flowerEnum.StemType;


/**
 * Flower class that realized builder pattern,
 * includes name, cost, type and fresh condition 
 * of the flower.
 * @author Tribel
 *
 */
public class Flower extends Plant {

	protected String name;
	protected int cost;
	protected StemType stemType;
	protected FlowerBase flowerBase;
	protected FreshType freshType;

	protected Flower() {
	}
	
	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public StemType getStemType() {
		return stemType;
	}

	public FlowerBase getFlowerBase() {
		return flowerBase;
	}

	public FreshType getFreshType() {
		return freshType;
	}

	/**
	 * Create builder pattern method.
	 * @return {@link FlowerBuilder} entity.
	 */
	public static FlowerBuilder newBuilder() {
		return new Flower().newBuilder();
	}
	

	/**
	 * Inner class that realized builder pattern.
	 * @author Tribel
	 *
	 */
	public class FlowerBuilder {
		
		/**
		 * Private Default constructor.
		 */
		private FlowerBuilder() {
		}
		
		public FlowerBuilder setName(String name) {
			Flower.this.name = name;
			return this;
		}

		public FlowerBuilder setCost(int cost) {
			Flower.this.cost = cost;
			return this;
		}

		public FlowerBuilder setStemType(StemType stemType) {
			Flower.this.stemType = stemType;
			return this;
		}

		public FlowerBuilder setFlowerBase(FlowerBase flowerBase) {
			Flower.this.flowerBase = flowerBase;
			return this;
		}

		public FlowerBuilder setFreshType(FreshType freshType) {
			Flower.this.freshType = freshType;
			return this;
		}
		
		public FlowerBuilder build() {
			return FlowerBuilder.this;
		}
		
	}
	
	@Override
	public String toString() {
		return "Flower [name=" + name + ", cost=" + cost + ", stemType="
				+ stemType + "]";
	}

}
