

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;
	public JButton tensecondpause;
	public ThreadsController c;

	public Window() {

		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;

		// Creates Threads and its data and adds it to the arrayList
		for (int i = 0; i < width; i++) {
			data = new ArrayList<DataOfSquare>();
			for (int j = 0; j < height; j++) {
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			Grid.add(data);
		}

		getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getContentPane().add(Grid.get(i).get(j).getSquare());
			}
		}

		// initial position of the snake
		Tuple position = new Tuple(10, 10);
		// passing this value to the controller
		c = new ThreadsController(position);
		// Let's start the game now..
		c.start();
		tensecondpause = new JButton("PAUSE");
		this.add(tensecondpause);
		tensecondpause.addActionListener(new ButtonListener());
		this.addKeyListener((KeyListener) new KeyboardListener());

	}
	private class ButtonListener implements	ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				c.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}