package hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroSolver {

	public void solve(final int initialHealth, final Creature[] creatures) {
		List<Creature> listOfCreatures = Arrays.asList(creatures);

		Map<Boolean, List<Creature>> creaturesByPositiveGain = listOfCreatures.stream()
		.collect(
				Collectors.groupingBy(c -> c.getGain() >= 0));
				
		List<Creature> easyCreatures = creaturesByPositiveGain.getOrDefault(true, new ArrayList<>());
		List<Creature> hardCreatures = creaturesByPositiveGain.getOrDefault(false, new ArrayList<>());

		solve(initialHealth, easyCreatures, hardCreatures);		
	}

	private void solve(int initialHealth, List<Creature> easyCreatures,
			List<Creature> hardCreatures) {
		int currentHealth = fightEasyCreatures(initialHealth, easyCreatures);
		
		if (currentHealth < 0)
			return;
		
		fightHardCreatures(currentHealth, hardCreatures);
	}

	private int fightHardCreatures(int currentHealth,
			List<Creature> hardCreatures) {
		//TODO
/*		Arrays.sort((Creature[] )hardCreatures.toArray() , new Comparator<Creature>() {
			@Override
			public int compare(Creature o1, Creature o2) {
				return o2.getGain() - o1.getGain();
			}
		});
*/
		return fightCreatures(currentHealth, hardCreatures);
	}

	private boolean canDefeat(int health, Creature creature) {
		return health - creature.getDamage() > 0;
	}
	
	private int fightEasyCreatures(int health, List<Creature> creatures) {
		Arrays.sort((Creature[] )creatures.toArray() , new Comparator<Creature>() {
			@Override
			public int compare(Creature o1, Creature o2) {
				return o1.getDamage() - o2.getDamage();
			}
		});
		
		return fightCreatures(health, creatures);
	}

	private int fightCreatures(int health, List<Creature> creatures) {
		for (Creature creature : creatures) {
			if (!canDefeat(health, creature))
				return health - creature.getDamage();
			
			health += creature.getGain();
		}
		return health;
	}

}
