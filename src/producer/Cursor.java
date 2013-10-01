package producer;

public class Cursor implements Producer {
	private static int count = 0;
	private static final double baseCPS = 0.1, baseCost = 15;
	private static Upgrade[] upgrades = 
		{new Upgrade(0,1, "Reinforced index finger"),
		new Upgrade(2,0.1,"Thousand fingers"),
		new Upgrade(2,0.5,"Million fingers"),
		new Upgrade(2,2,"Billion Fingers"),
		new Upgrade(2,10,"Trillion fingers"),
		new Upgrade(2,20, "Quadrillion fingers"),
		new Upgrade(2,100, "Quintillion fingers"),
		new Upgrade(1,2, "Carpal Tunnel prevention cream"),
		new Upgrade(1,2,"Ambidextrous")
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
