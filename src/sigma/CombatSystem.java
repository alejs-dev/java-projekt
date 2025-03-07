package sigma;

public class CombatSystem {
	public static int PlayerAttack(int PA, int EH, int ED) {
		int UpdEnemyHealth = 0;
		if ((ED - PA) >= EH) {
			System.out.print("One Shot! You defeated the Enemy.");
		} 
		else {
			UpdEnemyHealth = (ED - PA) - EH;
		}
		return UpdEnemyHealth;
	}
	
	public static int EnemyAttack(int PH, int EA, int PD) {
		int UpdPlayerHealth = 0;
		if ((PD - EA) >= PH) {
			System.out.print("One Shot! You died lol.");
		} 
		else {
			UpdPlayerHealth = (PD - EA) - PH;
		}
		return UpdPlayerHealth;
	}
}
