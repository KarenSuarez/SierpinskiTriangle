package co.edu.uptc;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiTriangleApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SierpinskiTrianglePanel trianglePanel;

	public SierpinskiTriangleApp() {
		super("Sierpinski Triangle");
		initializeUI();
		trianglePanel = new SierpinskiTrianglePanel();
		add(trianglePanel);
	}

	private void initializeUI() {
		setSize(new Dimension(650, 550));
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setLevel(int level) {
		trianglePanel.setLevel(level);
	}

	public static void main(String[] args) {
		SierpinskiTriangleApp app = new SierpinskiTriangleApp();
		app.setLevel(getUserInput("Ingrese un nivel:"));
	}

	private static int getUserInput(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, message));
	}
}