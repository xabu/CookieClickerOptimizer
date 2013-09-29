package producer;

import main.Upgrade;

public class Portal implements Producer {
	private static int count = 0;
	private static double baseCPS = 6666, baseCost = 1666666;
	private static Upgrade[] upgrades = {
		new Upgrade(0,1666,"Ancient tablet"),
		new Upgrade(1,2,"Insane oatling workers"),
		new Upgrade(1,2,"Soul bond"),
		new Upgrade(1,2,"Sanity dance")
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
