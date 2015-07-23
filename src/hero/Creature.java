package hero;

public class Creature {

	private final int damage;

	private final int healingPotion;

	public Creature(int damage, int healingPotion) {
		super();
		this.damage = damage;
		this.healingPotion = healingPotion;
	}

	public int getDamage() {
		return damage;
	}

	public int getHealingPotion() {
		return healingPotion;
	}

	public int getGain() {
		return healingPotion - damage;
	}

}
