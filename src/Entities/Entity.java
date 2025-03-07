package Entities;

import java.awt.image.BufferedImage;

public class Entity {
	public int x, y; 
	public int speed; 
	
	public int dmg, hp, def, lvl, mgc; // Damage, Health Points, Defense, Level, Mana/Magic
	
	public BufferedImage up1, up2, down1, down2, left1, left2, left3, right1, right2, right3;
	public String direction;
	
	public int spriteCounter = 0; 
	public int spriteNum = 1; 
}