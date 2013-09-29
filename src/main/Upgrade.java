package main;


import producer.*;

public class Upgrade {
	private boolean have = false;
	private String name;
	private int type;
	/*
	 * 0 - flat bonus
	 * 1 - multiplier
	 * 2 - cursor - based on count of others
	 * 3 - grandma - based on grandma count
	 * 4 - grandma - based on antimatter count
	 */
	private double magnitude;
	private static Producer[] producers = {new Cursor(),new Grandma(), new Farm(), new Factory(), new Mine(), new Shipment(), new AlchemyLab(), new Portal(), new TimeMachine(), new AntimatterCondenser()};
	public Upgrade(int t, double mag, String s){
		type = t;
		magnitude = mag;
		name = s;
	}
	public double alterCPS(double cps){
            if(have){
		switch(type){
		case 0:
			return cps+magnitude;
		case 1:
			return cps*magnitude;
		case 2:
			int producerCount = 0;
			for(int i = 0; i < producers.length;i++){
				producerCount +=producers[i].getCount();
			}
			return cps+magnitude*(producerCount);
		case 3:
			return cps+magnitude*producers[1].getCount();
		case 4:
			return cps+magnitude*producers[9].getCount();
		default:
			return cps;
		}
            } else
                return cps;
	}
	public boolean getOwned(){
		return have;
	}
	public void buy(){
		have = true;
	}
}