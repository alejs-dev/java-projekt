package sigma;

public class LevelSystem {
	int playerLevel = 0;
	int playerAttack = 0;
	int playerDefense = 0;
	int playerLife = 0;
	int playerMana = 0;
	
	
	
	public int getLevel() {
		return playerLevel;
	}
	
	public int getAttack() {
		return playerAttack;
	}
	
	public int getDefense() {
		return playerDefense;
	}
	
	public int getLife() {
		return playerLife;
	}
	
	public int getMana() {
		return playerMana;
	}
	
	
	
	public void setLevel(int pl) {
		playerLevel = pl;
	}
	
	public void setAttack(int atk) {
		playerAttack = atk;
	}
	
	public void setDefense(int def) {
		playerDefense = def;
	}
	
	public void setLife(int hp) {
		playerLife = hp;
	}
	
	public void setMana(int man) {
		playerMana = man;
	}
	
	
	
	public void LevelUp() {
		playerLevel = playerLevel + 1;
		playerAttack = playerAttack + 2;
		playerDefense = playerDefense + 2;
		playerLife = playerLife + 5;
		playerMana = playerMana + 1;
	}
}