package hero;

import java.util.Comparator;

public class CreatureGainComparator implements Comparator<Creature>{

	public int compare(Creature creature1, Creature creature2) {
		return creature1.getGain() - creature2.getGain();
	}
	
	

}
