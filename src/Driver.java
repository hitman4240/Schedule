
/////////////////////////////////////////////////////////////////////////////
//
//      Driver class for the program.
//
//      Holds the main loop that the program goes through up update time and
//      date.
//		
//		Also creates the Display so that an executable file can be used.
//
/////////////////////////////////////////////////////////////////////////////

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver {
	static boolean running = true;
	static Date date = new Date();
	static TimeKeeper keeper = new TimeKeeper(date);
	static CHS chs = new CHS(date);
	static long now = System.currentTimeMillis(), now2 = System.currentTimeMillis();
	static JPanel primary;
	static JFrame frame;
	static LayoutDisplay display;

	private static void createDisplay() {
		frame = new JFrame("CHS Schedule");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setPreferredSize(new Dimension(700, 400));
		frame.setResizable(false);

		primary = new JPanel();

		display = new LayoutDisplay(chs, keeper);

		primary.add(display);

		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}

	private static void updateDisplay() {
		display.update();
	}

	public static void main(String[] args) throws InterruptedException {
		// Main loop to make everything update every second.

		createDisplay();
		updateDisplay();
		chs.update(keeper.getHour(), keeper.getMinute());
		while (running) {
			if (System.currentTimeMillis() - now > 1000) {
				updateDisplay();

				now = System.currentTimeMillis();
			}
			
			if(keeper.getSecond() == 0){
				chs.update(keeper.getHour(), keeper.getMinute());
			}
		}
	}
}
