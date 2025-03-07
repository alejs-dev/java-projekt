package Entities;

import java.awt.Color;
import java.awt.Graphics2D;

import sigma.PanelClass;

public class EnemyClass extends Entity{
	
	PanelClass panel; 
	int count = 0;
	boolean isOnDestination = false;
	
	
	public EnemyClass(PanelClass panel) {
		this.panel = panel;
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		x = 300; 
		y = 100; 
		speed = 2; 
	}
	
	public void update() {
		
		if (isOnDestination == false) {			
			if (count <= 100) {
				this.y += this.speed;
				this.count++;
				
				if (count == 100) {
					this.isOnDestination = true;
				}
			}
		}
		else {
			if (count >= 0) {
				this.y -= this.speed;
				this.count--;
				
				if (count == 0) {
					this.isOnDestination = false;
				}
			}
		}
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(x, y, panel.TileSize, panel.TileSize); 
	}
	
	
	
	public int getLevel() {
		return lvl;
	}
	
	public int getAttack() {
		return dmg;
	}
	
	public int getDefense() {
		return def;
	}
	
	public int getLife() {
		return hp;
	}
	
	public int getMana() {
		return mgc;
	}
	
	
	
	public void setLevel(int l) {
		lvl = l;
	}
	
	public void setAttack(int a) {
		dmg = a;
	}
	
	public void setDefense(int d) {
		def = d;
	}
	
	public void setLife(int h) {
		hp = h;
	}
	
	public void setMana(int m) {
		mgc = m;
	}
	
}
