package Entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sigma.MovementClass;
import sigma.PanelClass;

public class PlayerClass extends Entity {

	PanelClass panel;
	MovementClass movement;

	public PlayerClass(PanelClass panel, MovementClass movement) {
		this.panel = panel;
		this.movement = movement;
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerUp1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerUp2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerDown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerDown2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerLeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerLeft2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerLeft3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerRight1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerRight2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/yeeahh/yuhh/PlayerRight3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if (movement.upPressed == true || movement.downPressed == true || movement.leftPressed == true
				|| movement.rightPressed == true) {
			if (movement.upPressed == true) {
				direction = "up";
				y -= speed;
			} else if (movement.downPressed == true) {
				direction = "down";
				y += speed;
			} else if (movement.leftPressed == true) {
				direction = "left";
				x -= speed;

			} else if (movement.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2 && direction == "left") {
					spriteNum = 3;
				} else if (spriteNum == 2 && direction == "right") {
					spriteNum = 3;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				} else if (spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

	}

	public void draw(Graphics2D g) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			if (spriteNum == 3) {
				image = left3;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			if (spriteNum == 3) {
				image = right3;
			}
			break;
		}

		g.drawImage(image, x, y, panel.TileSize, panel.TileSize, null);
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
