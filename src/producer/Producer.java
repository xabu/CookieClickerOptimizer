package producer;

public interface Producer {	
	public void add();
	public double getEfficiency();
	public double getCPS();
	public double getCost();
	public int getCount();
	public void buyUpgrade(int which);
}
