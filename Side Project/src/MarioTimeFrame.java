import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.sun.javafx.scene.text.TextLayout;

public class MarioTimeFrame extends JFrame {
	
	Questions questions;
	
	 final int WIDTH = 650;
	    final int HEIGHT = 400;
	    JPanel top, rightNorth, rightSouth, middle, bottom, main, subpanel, right, bottomSub;
	    JButton mushroom, fire, ice, acorn;
	    JLabel title, playerWins, computerWins, ties, subLabel;
	    JTextField stats;
	    JTextArea results;
	    JScrollPane gameScroll;
	    ImageIcon mushroomIcon, fireIcon, iceIcon,  acornIcon, marioIcon;
	    Random random = new Random();
	    int playerWinTally = 0;
	    int computerWinTally = 0;
	    int tiesTally = 0;
	    //ArrayList<String> questions = new ArrayList<>();
	    int questionIndex = 0;




	    public MarioTimeFrame(String name) {
	        name = "Mario Time Text Adventure!";
	        questions = new Questions(loadQuestionsAndAnswers());
	        
	        //top panel with icons
	         
	        top = new JPanel();
	        top.setBackground(new Color(151,255,252));
	        //title = new JLabel("SUPER MARIO TIME TEXT ADVENTURE!");
	        JLabel label = new JLabel("<html><font color=blue>ELIJAH'S</font><font color=red> SUPER</font><font color=green> MARIO</font><font color=yellow> ADVENTURE</font>");
//	        title.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
//	        JLabel label = new JLabel("SUPER MARIO TEXT ADVENTURE");
	        label.setFont(new Font("Comic Sans MS", Font.BOLD, 32)); 
	        //top.setBackground(Color.RED);
//	        top.add(title);
	        top.add(label);
	        
	      //Compound borders
	        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	        
	        Border compound;
	        Border blackline = BorderFactory.createMatteBorder(5,5,5,5,Color.black);

	        //This creates a nice frame.
	        compound = BorderFactory.createCompoundBorder(
	                                  raisedbevel, loweredbevel);
	        compound = BorderFactory.createCompoundBorder(blackline, compound);
	        top.setBorder(compound);
//	        ImageIcon icon = new ImageIcon("images/wavy.gif", "wavy-line border icon"); //20x22
//
//	        	top.setBorder(BorderFactory.createMatteBorder(
//                      -1, -1, -1, -1, icon));
//	        Border blackline = BorderFactory.createLineBorder(Color.black);
//	        Border titled = BorderFactory.createTitledBorder(blackline, "SUPER MARIO TIME TEXT ADVENTURE!", TitledBorder.CENTER, TitledBorder.TOP, new Font("Comic Sans MS", Font.PLAIN, 48));
//	        top.setBorder(titled);
	        mushroomIcon = new ImageIcon("C:\\Users\\Student\\Desktop\\Side Project - CLASSIFIED\\assets\\mushroom.png");
	        Image mushroomImage = mushroomIcon.getImage();
	        Image modShroom = mushroomImage.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	        mushroomIcon = new ImageIcon(modShroom);
	        mushroom = new JButton(mushroomIcon);
//	        mushroom.setVerticalTextPosition(SwingConstants.BOTTOM);
//	        mushroom.setHorizontalTextPosition(SwingConstants.CENTER);
	        mushroom.addActionListener(actionEvent ->
	                {
	                    results.append("Your move: ROCK\n");
	                    computer(0);
	                }
	                );

	        fireIcon = new ImageIcon("C:\\Users\\Student\\Desktop\\Side Project - CLASSIFIED\\assets\\fireflower.png");
	        Image fireImage = fireIcon.getImage();
	        Image modFire = fireImage.getScaledInstance(35,35, Image.SCALE_SMOOTH);
	        fireIcon = new ImageIcon(modFire);
	        fire = new JButton(fireIcon);
//	        paper.setVerticalTextPosition(SwingConstants.BOTTOM);
//	        paper.setHorizontalTextPosition(SwingConstants.CENTER);
//	        paper.addActionListener(actionEvent ->
//	                {
//	                    results.append("Your move: PAPER\n");
//	                    computer(1);
//	                }
//	        );

	        iceIcon = new ImageIcon("C:\\Users\\Student\\Desktop\\Side Project - CLASSIFIED\\assets\\ice.png");
	        Image iceImage = iceIcon.getImage();
	        Image modIce = iceImage.getScaledInstance(35,35, Image.SCALE_SMOOTH);
	        iceIcon = new ImageIcon(modIce);
	        ice = new JButton(iceIcon);
//	        scissors.setVerticalTextPosition(SwingConstants.BOTTOM);
//	        scissors.setHorizontalTextPosition(SwingConstants.CENTER);
//	        scissors.addActionListener(actionEvent ->
//	                {
//	                    results.append("Your move: SCISSORS\n");
//	                    computer(2);
//	                }
//	        );
//
	        acornIcon = new ImageIcon("C:\\Users\\Student\\Desktop\\Side Project - CLASSIFIED\\assets\\acornpower.jpg");
	        Image acornImage = acornIcon.getImage();
	        Image modAcorn = acornImage.getScaledInstance(35,35, Image.SCALE_SMOOTH);
	        acornIcon = new ImageIcon(modAcorn);
	        acorn = new JButton(acornIcon);
//	        quit.setVerticalTextPosition(SwingConstants.BOTTOM);
//	        quit.setHorizontalTextPosition(SwingConstants.CENTER);
//	        quit.addActionListener(actionEvent ->
//	                {
//	                    System.exit(0);
//	                }
//	        );
	        
	        marioIcon = new ImageIcon("C:\\Users\\Student\\Desktop\\Side Project - CLASSIFIED\\assets\\oldmario.png");
	        Image marioImage = marioIcon.getImage();
	        Image modMario = marioImage.getScaledInstance(175,175, Image.SCALE_SMOOTH);
	        marioIcon = new ImageIcon(modMario); 
	        
	        
	        
	        right = new JPanel();
	        rightNorth = new JPanel();
	        subpanel = new JPanel();
	       
	        subpanel.add(mushroom);
	        subpanel.add(fire);
	        subpanel.add(ice);
	        subpanel.add(acorn);
	       
	        right.setLayout(new BorderLayout());
	        rightNorth.setLayout(new BorderLayout());

	        rightNorth.add(subpanel);
	        right.add(rightNorth, BorderLayout.NORTH);
//	        rightNorth.add(fire, BorderLayout.PAGE_START);
//	        rightNorth.add(ice, BorderLayout.PAGE_START);
//	        rightNorth.add(quit);
 
	        rightSouth = new JPanel();
	        bottomSub = new JPanel();
	        subLabel = new JLabel();
	        subLabel.setIcon(marioIcon);
	        bottomSub.add(subLabel);
	        rightSouth.add(subLabel);
	        right.add(rightSouth, BorderLayout.SOUTH);

	        //middle panel with the moves/results
	        middle = new JPanel();
	        results = new JTextArea(50,50);
	        results.setBackground(new Color(255, 225, 135));
	        gameScroll = new JScrollPane(results);
	        gameScroll.setPreferredSize(new Dimension(450,650));
	        gameScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        gameScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        results.setFont(new Font("SchoolHouse Printed A", Font.BOLD, 15));
//	        questions.setQuestions(loadQuestionsAndAnswers());
	        results.append(questions.getRandomQuestion());
//	        results.append("\n\n\n\n\n\n           A SneakoXU Masterpiece");
	        //gameScroll.add(results);
	        middle.add(gameScroll);
	        //middle.add(results);

	        //bottom panel with the stats
	        bottom = new JPanel();
//	        playerWins = new JLabel("Player wins: 0");
	        playerWins = new JLabel("Mario x" + playerWinTally);
//	        computerWins = new JLabel("Computer wins: 0");
	        computerWins = new JLabel(" | 000000 | ");
//	        ties = new JLabel("Ties: 0");
	        ties = new JLabel("WORLD 1-1");
	        bottom.add(playerWins);
	        bottom.add(computerWins);
	        bottom.add(ties);


	        main = new JPanel();
	        main.setLayout(new BorderLayout());
	        main.add(top, BorderLayout.NORTH);
	        main.add(middle, BorderLayout.CENTER);
	        main.add(bottom, BorderLayout.SOUTH);
	        main.add(right, BorderLayout.EAST);
//	        main.add(rightNorth, BorderLayout.EAST);
//	        main.add(rightSouth, BorderLayout.EAST);

	        add(main);
	        setSize(WIDTH, HEIGHT);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

		private void computer(int playerMove){


	    playerWins.setText("Mario x" + playerWinTally);
	    computerWins.setText("000000");
	    }
		
		 public Map<String,String> loadQuestionsAndAnswers() {
			 Map<String, String> mapQuestions = new HashMap<>();
			 mapQuestions.put("-- Penguin incoming! Select a power-up to freeze it.", "Ice Flower");
			 
		       
		     return mapQuestions;  
		 }
	
	}



