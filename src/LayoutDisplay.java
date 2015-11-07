import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class LayoutDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel period, timeLeft, currentTime, day, alarmTime, alarmOnOff;
	JTextField timing;
	JCheckBox alarmCheck;
	private static boolean shouldFill = true;
	private CHS chs;
	private TimeKeeper keeper;

	LayoutDisplay(CHS chs, TimeKeeper keeper) {
		this.chs = chs;
		this.keeper = keeper;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		if(shouldFill){
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		day = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		add(day, c);
		
		currentTime = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		add(currentTime, c);
		
		period = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		add(period, c);
		
		timeLeft = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		add(timeLeft, c);
		
		alarmTime = new JLabel("Set when alarm will goes off.");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0 ,0,0);
		c.gridx = 0;
		c.gridy = 4;
		//add(alarmTime, c);
		
		timing = new JTextField(2);
		timing.addActionListener(new TempListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		//add(timing, c);
		
		alarmOnOff = new JLabel("Turns alarm on and off.");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		//add(alarmOnOff, c);
		
		alarmCheck = new JCheckBox("press to turn on");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(-10,0,0,0);
		c.gridx = 2;
		c.gridy = 5;
		//add(alarmCheck, c);
		
		
		day.setFont(new Font("Serif", Font.PLAIN, 20));
		period.setFont(new Font("Serif", Font.PLAIN, 20));
		currentTime.setFont(new Font("Serif", Font.PLAIN, 20));
		alarmTime.setFont(new Font("Serif", Font.PLAIN, 20));
		timeLeft.setFont(new Font("Serif", Font.PLAIN, 20));
		alarmOnOff.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
	}

	public void update() {
		keeper.updateTime();
		
		//chs.update(keeper.getHour(), keeper.getMinute());

		period.setText(chs.displayPeriod());
		timeLeft.setText(chs.displayTimeLeft());
		currentTime.setText("Current time is " + keeper.displayInfo());
		day.setText("Today is " + keeper.day());
	}
	
	private class TempListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int delay;
			
			String text = timing.getText();
			
			delay = Integer.parseInt(text);
		}
		
	}
}













