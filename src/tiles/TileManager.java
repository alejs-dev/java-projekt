package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import sigma.PanelClass;

public class TileManager {
	PanelClass panel; 
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(PanelClass panel) {
		this.panel = panel; 
		
		tile = new Tile[20];
		mapTileNum = new int[panel.maxScreenCol][panel.maxScreenRow];
		
		getTileImage(); 
		loadMap("/maps/map1.txt");
	}
	
	public void getTileImage() {
		try {
				tile[0] = new Tile();
				tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Blumen.png"));
				
				tile[1] = new Tile();
				tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Baum.png"));
				
				tile[2] = new Tile();
				tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Stein.png"));
				
				tile[3] = new Tile();
				tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ErdeDunkel.png"));
				
				tile[4] = new Tile();
				tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ErdeHell.png"));
				
				tile[5] = new Tile();
				tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wand.png"));
				
				tile[6] = new Tile();
				tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wasser.png"));
				
				tile[7] = new Tile();
				tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/StrasseStein.png"));
				
				tile[8] = new Tile();
				tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Gras.png"));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String pathToMap) {
		try {
			InputStream is = getClass().getResourceAsStream(pathToMap);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0; 
			int row = 0;
			
			while (col < panel.maxScreenCol && row < panel.maxScreenRow) {
				String line = br.readLine();
				
				while (col < panel.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num; 
					col++;
				}
				if(col == panel.maxScreenCol) {
					col = 0; 
					row++;
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g) {
		int col = 0; 
		int row = 0; 
		int x = 0; 
		int y = 0; 
		
		while(col < panel.maxScreenCol && row < panel.maxScreenRow) {
			
			int tileNum = mapTileNum[col][row];
			
			g.drawImage(tile[tileNum].image, x, y, panel.TileSize, panel.TileSize, null);
			col++;
			x += panel.TileSize;
			
			if (col == panel.maxScreenCol) {
				col = 0; 
				x = 0;
				row++; 
				y += panel.TileSize;
			}
		}
	}
	
}
