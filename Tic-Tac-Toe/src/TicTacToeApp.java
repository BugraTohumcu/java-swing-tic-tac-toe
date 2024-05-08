import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public  class TicTacToeApp {
	
	
	
		
		private static  final int  HEIGHT  = 900;
		private static final int WIDTH = 800;
		static final int numberOfButtons = 9;

		final private JFrame mainFrame = new JFrame();
		final private JPanel gamePanel = new JPanel();
		
		public static JButton[] buttons = new JButton[numberOfButtons];
		static JLabel turnLabel = new JLabel();
		static JLabel scoreLabel = new JLabel();
		
		private final String restartIcon ="refresh.png";
		private final JButton restartButton = new JButton(new ImageIcon(new ImageIcon(restartIcon).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		
		
		private final Font labelFont = new Font("Robotto" , Font.PLAIN,25);
		private final Font buttonFont = new Font("Helvetica", Font.PLAIN,100);

		
		
		
		public TicTacToeApp() {
			
			// Initialize components
			initializeTurnLabel();
	        initializeRestartButton();
	        initializeScoreLabel();
	        initializeButtons();
	        initilaizeGamePanel();

	        //Set up main Frame
	        setupMainFrame();
	    }	
		
		
		
		private void initializeTurnLabel() {
	        turnLabel.setOpaque(true);
	        turnLabel.setFont(labelFont);
	        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        turnLabel.setVerticalAlignment(SwingConstants.CENTER);
	        turnLabel.setForeground(Color.WHITE);
	        turnLabel.setBackground(Color.BLACK);
	        turnLabel.setBounds(0, 0, WIDTH, 50);
	    }
			
		 private void initializeRestartButton() {
		        restartButton.setBounds(WIDTH - 125, 70, 100, 100);
		        restartButton.setBackground(new Color(238, 238, 238));
		        restartButton.setBorder(null);
		        restartButton.setFocusable(false);
		        restartButton.addActionListener(e -> Game.resetGame());
		    }

		   private void initializeScoreLabel() {
		        scoreLabel.setText("Score: " + Game.playerXScore + " - " + Game.playerOScore);
		        scoreLabel.setOpaque(true);
		        scoreLabel.setBounds(10, 80, 500, 100);
		        scoreLabel.setFont(new Font("MV boli", Font.PLAIN, 60));
		    }
			
		   
		   private void initializeButtons() {
		        for (int i = 0; i < numberOfButtons; i++) {
		            buttons[i] = new JButton();
		            buttons[i].setSize(50, 50);
		            buttons[i].setBackground(Color.WHITE);
		            buttons[i].setFocusable(false);
		            buttons[i].setBorder(null);
		            buttons[i].setFont(buttonFont);
		            buttons[i].addActionListener(new ActionListener() {
						
						@Override 
						public void actionPerformed(ActionEvent e) {
							//Button functionality and Game
							for(int i = 0 ; i < numberOfButtons ; i++) {
								if(e.getSource()==buttons[i] && buttons[i].getText().isEmpty()) {
									
									Game.placeSymbol(i);
									Game.checkForWinner();
										}
								}
							
							}
					});
		            gamePanel.add(buttons[i]);
		        }
		    
		   }

		
		   private void initilaizeGamePanel(){
			gamePanel.setBorder(null);
			gamePanel.setBounds(10,175,765,655);
			gamePanel.setLayout(new GridLayout(3,3,10,10));
		   	}
			
			
			 private void setupMainFrame() {
			        mainFrame.setSize(WIDTH, HEIGHT);
			        mainFrame.setTitle("Tic-Tac-Toe");
			        mainFrame.setResizable(false);
			        mainFrame.setVisible(true);
			        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        mainFrame.setLayout(null);
			        
			        mainFrame.add(gamePanel);
			        mainFrame.add(scoreLabel);
			        mainFrame.add(restartButton);
			        mainFrame.add(turnLabel);
			    }
			 
			 public static void main(String[] args) {
			        SwingUtilities.invokeLater(() -> {
			        	new TicTacToeApp();
			        	
			        	});
			    }
		}
		
		
		

