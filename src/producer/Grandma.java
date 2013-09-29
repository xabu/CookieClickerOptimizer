package producer;

import main.Upgrade;

public class Grandma implements Producer {
	private static int count = 0;
	private static double baseCPS = 0.5, baseCost = 100;
	private static Upgrade[] upgrades = {
		new Upgrade(0,0.3,"Forwards from grandma"),
		new Upgrade(1,2,"Steel-plated rolling pins"),
		new Upgrade(1,2,"Lubricated dentures"),
		new Upgrade(1,2,"Prune Juice"),
		new Upgrade(1,2,"Farmer grandmas"),
		new Upgrade(1,2,"Worker grandmas"),
		new Upgrade(1,2,"Miner grandmas"),
		new Upgrade(1,2,"Cosmic grandmas"),
		new Upgrade(1,2,"Transmuted grandmas"),
		new Upgrade(1,2,"Altered grandmas"),
		new Upgrade(1,2,"Grandmas' grandmas"),
		new Upgrade(1,2,"Antigrandmas")
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
