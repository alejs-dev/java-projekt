package sigma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entities.EnemyClass;
import Entities.PlayerClass;
import tiles.TileManager;

public class PanelClass extends JPanel implements Runnable{

	final int OriginalTileSize = 16; //16 * 16 Pixels
	final int Scale = 4;
	
	public final int TileSize = OriginalTileSize * Scale; //64 * 64 Pixels
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 10;
	
	public final int ScreenWidth = maxScreenCol * TileSize;
	public final int ScreenHeight = maxScreenRow * TileSize;
	
	// LOL FPS count
	int FPS = 60;
	
	// Data for Player
	
	TileManager tileM = new TileManager(this);
	
	MovementClass movement = new MovementClass();
	Thread gameThread;
	
	PlayerClass player = new PlayerClass(this, movement);
	EnemyClass enemy = new EnemyClass(this);
	
	
	public PanelClass() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(movement);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawtime = System.nanoTime() + drawInterval; 
		
		while (gameThread != null) {

			// Update information	
			update();
			
			// Repaint Components
			repaint();
			
			// Sleep Method
			try {
				double remainingTime = nextDrawtime - System.nanoTime();
				remainingTime = remainingTime / 10000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawtime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update() {
		
		player.update();
		if (checkCollision() == true) {
			System.out.print("Kollision\n");
		}
//		enemy.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D Graphics = (Graphics2D)g;
		
		tileM.draw(Graphics);
		
		player.draw(Graphics);
		
//		enemy.draw(Graphics);
		
		Graphics.dispose();
	}
	
	public boolean checkCollision() {
		boolean collision = false;
		
        int playerCoordPointXX = player.x;
        int playerCoordPointXY = player.y;
        
        int playerCoordPointYX = player.x + TileSize;
        int playerCoordPointYY = player.y;
        
        int playerCoordPointZX = player.x + TileSize; 
        int playerCoordPointZY = player.y - TileSize; 
        
        int playerCoordPointAX = player.x;
        int playerCoordPointAY = player.y - TileSize; 
        
        
        

		return collision;
	}
	
}	
