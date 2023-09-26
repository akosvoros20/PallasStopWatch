package hu.stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Watch extends JFrame implements ActionListener {
	
	private JFrame frame;
	private JLabel timeLabel;
	private JButton startButton, stopButton, resetButton;
	private JButton[] buttons = new JButton[3];
	private Timer timer;
	private JPanel panel, panel1;
	private int elapsedTime;
	private int windowWidth, windowHeight;
	private boolean visible;
	private Font font = new Font("MS Mincho",Font.BOLD, 16);
	    

	    public int getWindowWidth() {
			return windowWidth;
		}

		public void setWindowWidth(int windowWidth) {
			this.windowWidth = windowWidth;
		}

		public int getWindowHeight() {
			return windowHeight;
		}

		public void setWindowHeight(int windowHeight) {
			this.windowHeight = windowHeight;
		}
		

		public boolean isVisible() {
			return visible;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
		}

		public Watch() {
			setupGui();
		}
		
	    public void setupGui() {
	    	
	    	
	    	frame = new JFrame("Pallas Stop Watch");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setBackground(Color.darkGray);
			frame.setSize(getWindowWidth(), getWindowHeight());
			frame.setResizable(false);
			frame.setLayout(null);
				    		
			timeLabel = new JLabel("00:00:00", JLabel.CENTER);
			timeLabel.setFont(new Font("MS Mincho",Font.BOLD, 40));
			timeLabel.setForeground(Color.white);
			
			startButton = new JButton("Start");
			stopButton = new JButton("Stop");
			resetButton = new JButton("Reset");
			
			buttons[0] = startButton;
			buttons[1] = stopButton;
			buttons[2] = resetButton;
			
			for(int i=0; i<buttons.length; i++) {
				buttons[i].addActionListener(this);
				buttons[i].setFocusable(false);
				buttons[i].setBackground(Color.LIGHT_GRAY);
				buttons[i].setBorder(new LineBorder(Color.gray));
				buttons[i].setFont(font);
			}
			
			panel = new JPanel();
			panel.setBounds(70,60,150,50);
			panel.setAlignmentX(BOTTOM_ALIGNMENT);
			panel.setLayout(new GridLayout(1,3));
			panel.setBackground(Color.DARK_GRAY);
			
			panel.add(buttons[0]);
			panel.add(buttons[1]);
			panel.add(buttons[2]);
			
			panel1 = new JPanel();
			panel1.add(timeLabel);
			panel1.setBounds(45,0,200,50);
			panel1.setBackground(Color.DARK_GRAY);
			
			frame.add(panel1);
			frame.add(panel);	
			frame.setVisible(isVisible());
	        	

	        timer = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	           elapsedTime += 1000;
	           updateTimeLabel();
	            }
	        });  
	    }
	   

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == startButton) {
	            timer.start();
	        } else if (e.getSource() == stopButton) {
	            timer.stop();
	        } else if (e.getSource() == resetButton) {
	            timer.stop();
	            elapsedTime = 0;
	            updateTimeLabel();
	        }
	    }

	    private void updateTimeLabel() {
	        int hours = elapsedTime / 3600000;
	        int minutes = (elapsedTime % 3600000) / 60000;
	        int seconds = (elapsedTime % 60000) / 1000;
	        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	        timeLabel.setText(time);
	    }
}
