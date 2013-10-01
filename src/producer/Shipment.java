package producer;

import main.Upgrade;

public class Shipment implements Producer {
	private static int count = 0;
	private static final double baseCPS = 100, baseCost = 40000;
	private static Upgrade[] upgrades = {
		new Upgrade(0,30,"Vanilla nebulae"),
		new Upgrade(1,2,"Wormholes"),
		new Upgrade(1,2,"Frequent flyer"),
		new Upgrade(1,2,"Warp drive")
	};
	
	@Override
	public int getCount(){
		return count;
	}
	
	@Override
	public void add() {
		count++;
	}

	@Override
	public double getEfficiency() {
		return getCPS()/getCost();
	}

	@Override
	public double getCPS() {
		double cps = baseCPS;
		for(int i = 0;i<upgrades.length;i++){
			if(upgrades[i].getOwned()){
				cps = upgrades[i].alterCPS(cps);
			}
		}
		return cps;
	}

	@Override
	public double getCost() {
		return baseCost*Math.pow(1.15, count);
	}

	@Override
	public void buyUpgrade(int which) {
		if(which<upgrades.length)
			upgrades[which].buy();
	}

}
