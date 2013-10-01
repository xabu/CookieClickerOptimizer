package producer;

public class Factory implements Producer {
	private static int count = 0;
	private static final double baseCPS = 10, baseCost = 3000;
	private static Upgrade[] upgrades = {
		new Upgrade(0,4,"Sturdier conveyor belts"),
		new Upgrade(1,2,"Child labor"),
		new Upgrade(1,2,"Sweatshop"),
		new Upgrade(1,2,"Radium reactors")
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
