package com.shop.entity;

import java.util.List;

import com.shop.flowerEnum.BouquetType;
import com.shop.flowerEnum.CostType;

/**
 * Bouquet class that realized builder pattern.
 * Includes list flowers , wrappers, ribbon, basket type
 * cost and so on.
 * @author Tribel
 *
 */
public class Bouquet {

	protected List<Flower> flowers;
	protected FlowerBase flowerBase;
	protected FlowerWrapper flowerWrapper;
	protected FlowerRibbon flowerRibbon;
	protected Basket basket;
	protected CostType costType;
	protected BouquetType bouquetType;
	protected int sumCost;

	/**
	 * Private default constructor.
	 */
	private Bouquet() {
		super();
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public FlowerBase getFlowerBase() {
		return flowerBase;
	}

	public FlowerWrapper getFlowerWrapper() {
		return flowerWrapper;
	}

	public FlowerRibbon getFlowerRibbon() {
		return flowerRibbon;
	}

	public Basket getBasket() {
		return basket;
	}

	public CostType getCostType() {
		return costType;
	}

	public BouquetType getBouquetType() {
		return bouquetType;
	}

	public int getSumCost() {
		return sumCost;
	}

	/**
	 * Create builder pattern method.
	 * @return {@link Builder} entity.
	 */
	public static Builder newBuilder() {
		return new Bouquet().newBuilder();
	}
 	
	
	/**
	 * Inner class that realized bulder pattern for {@link Bouquet} class.
	 * @author Tribel
	 *
	 */
	public class Builder {
		
		/**
		 * Default constructor.
		 */
		private Builder() {
		}
		
		public Builder setFlowers(List<Flower> flowers) {
			Bouquet.this.flowers = flowers;
			return this;
		}

		public Builder setFlowerBase(FlowerBase flowerBase) {
			Bouquet.this.flowerBase = flowerBase;
			return this;
		}

		public Builder setFlowerWrapper(FlowerWrapper flowerWrapper) {
			Bouquet.this.flowerWrapper = flowerWrapper;
			return this;
		}

		public Builder setFlowerRibbon(FlowerRibbon flowerRibbon) {
			Bouquet.this.flowerRibbon = flowerRibbon;
			return this;
		}

		public Builder setBasket(Basket basket) {
			Bouquet.this.basket = basket;
			return this;
		}

		public Builder setCostType(CostType costType) {
			Bouquet.this.costType = costType;
			return this;
		}

		public Builder setBouquetType(BouquetType bouquetType) {
			Bouquet.this.bouquetType = bouquetType;
			return this;
		}

		public Builder setSumCost(int sumCost) {
			Bouquet.this.sumCost = sumCost;
			return this;
		}

		/**
		 * Finished builder creation.
		 * @return {@link Bouquet} entity.
		 */
		public Bouquet build() {
			return Bouquet.this;	
		}


	}
	
	@Override
	public String toString() {
		return "Bouquet [flowers=" + flowers + ", flowerBase=" + flowerBase
				+ ", flowerWrapper=" + flowerWrapper + ", flowerRibbon="
				+ flowerRibbon + ", basket=" + basket + ", costType="
				+ costType  + ", bouquetType="
				+ bouquetType + ", sumCost=" + sumCost + "]";
	}

}
