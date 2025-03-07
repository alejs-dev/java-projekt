package sigma;

import javax.swing.JFrame;

public class MainApp {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("2D Game");
		
		PanelClass gamepanel = new PanelClass();		
		frame.add(gamepanel);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		gamepanel.startGameThread();
	}

}
