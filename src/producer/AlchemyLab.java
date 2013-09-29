package producer;

import main.Upgrade;

public class AlchemyLab implements Producer {
	private static int count = 0;
	private static double baseCPS = 400, baseCost = 200000;
	private static Upgrade[] upgrades = {
		new Upgrade(0,100,"Antimony"),
		new Upgrade(1,2,"Essence of dough"),
		new Upgrade(1,2,"True chocolate"),
		new Upgrade(1,2,"Ambrosia")
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
