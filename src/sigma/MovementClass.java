package sigma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementClass implements KeyListener {
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_W) {
			upPressed = true;
		}
		if (keyCode == e.VK_A) {
			leftPressed = true;
		}
		if (keyCode == e.VK_S) {
			downPressed = true;
		}
		if (keyCode == e.VK_D) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_W) {
			upPressed = false;
		}
		if (keyCode == e.VK_A) {
			leftPressed = false;
		}
		if (keyCode == e.VK_S) {
			downPressed = false;
		}
		if (keyCode == e.VK_D) {
			rightPressed = false;
		}
	}

}
