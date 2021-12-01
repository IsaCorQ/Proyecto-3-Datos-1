
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame{
	
	// An object of Algorithm
	Algorithm m = new Algorithm();

	private static final long serialVersionUID = 1L;

	// Adjacency matrix (used to get minimum distance and path)
	int[][] adjacency= {{0,494,184,450,402,298,25,292,269,28,297,40,257,83,214},
			{494,0,366,25,105,197,500,255,200,510,505,494,560,450,284},
			{185,365,0,349,273,176,174,115,201,185,464,169,200,108,170},
			{456,25,353,0,92,185,455,242,187,467,481,450,545,407,240},
			{408,105,275,89,0,106,407,164,107,419,485,402,469,359,193},
			{304,197,178,182,106,0,303,66,68,314,473,298,371,254,89},
			{24,499,174,456,407,304,0,283,275,11,319,20,237,67,220},
			{293,255,116,239,164,66,282,0,132,293,493,277,311,216,107},
			{275,199,202,183,107,68,275,132,0,285,416,269,398,225,59},
			{29,510,185,467,419,314,12,293,285,0,323,18,228,77,230},
			{300,503,462,479,480,474,317,499,418,323,0,332,551,365,390},
			{43,493,168,450,401,297,19,276,269,18,334,0,224,60,214},
			{257,560,200,545,469,371,237,311,398,228,551,224,0,234,367},
			{83,449,107,406,357,254,67,216,224,83,366,62,234,0,170},
			{213,284,170,239,192,88,219,120,59,230,389,214,367,170,0}};

	JPanel lowerPanel, bottomPanel,  resultPanel;
	JButton calculate, start, reset, info;
	JTextField initialTextfield, finalTextfield;
	JLabel initialLabel, finalLabel, resultLabel;
	
	// Builds the visual components
	public Frame(){
		setLayout(new BorderLayout());
		Font textFont = new Font("Book Antiqua", Font.PLAIN, 18);
		
		// Frame Icon's Image
		try{
			Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("abc.png"));
			ImageIcon icon = new ImageIcon(image);
			setIconImage(icon.getImage());
		}catch(Exception e){}

		// Pink Panel
		resultLabel = new JLabel("");
		resultLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		resultLabel.setForeground(Color.WHITE);

		resultPanel = new JPanel();
		resultPanel.setLayout(new BorderLayout());

		resultPanel.setBackground(new Color(251, 119, 138));
		resultPanel.add(resultLabel, BorderLayout.CENTER);

		// Blue Panel

		initialTextfield = new JTextField(2);
		finalTextfield = new JTextField(2);


		initialLabel = new JLabel("Inital:", SwingConstants.CENTER);
			initialLabel.setFont(textFont);
		finalLabel = new JLabel("Final:", SwingConstants.CENTER);
			finalLabel.setFont(textFont);

		calculate = new JButton("Calculate");
			calculate.setFont(new Font("Bell MT", Font.BOLD, 14));
		start = new JButton("Start");
			start.setFont(new Font("Bell MT", Font.BOLD, 14));
		reset = new JButton("Reset");
			reset.setFont(new Font("Bell MT", Font.BOLD, 14));
		info = new JButton("Info");
			info.setFont(new Font("Bell MT", Font.BOLD, 14));


		initialTextfield.setEnabled(false);
		finalTextfield.setEnabled(false);
		calculate.setEnabled(false);

		lowerPanel = new JPanel();
		lowerPanel.setBackground(new Color(111, 160, 255));
		lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

		lowerPanel.add(start);
		lowerPanel.add(new JSeparator(SwingConstants.VERTICAL));
		lowerPanel.add(initialLabel);
		lowerPanel.add(initialTextfield);
		lowerPanel.add(finalLabel);
		lowerPanel.add(finalTextfield);
		lowerPanel.add(calculate);
		lowerPanel.add(reset);
		lowerPanel.add(info);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());

		bottomPanel.add(lowerPanel, BorderLayout.CENTER);
		bottomPanel.add(resultPanel, BorderLayout.NORTH);

		add(bottomPanel, BorderLayout.SOUTH);

		
		//Places an action listener to begin the methods initialized by pressing the button start
		start.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				adjacency= new int[][]{{0,494,184,450,402,298,25,292,269,28,297,40,257,83,214},
						{494,0,366,25,105,197,500,255,200,510,505,494,560,450,284},
						{185,365,0,349,273,176,174,115,201,185,464,169,200,108,170},
						{456,25,353,0,92,185,455,242,187,467,481,450,545,407,240},
						{408,105,275,89,0,106,407,164,107,419,485,402,469,359,193},
						{304,197,178,182,106,0,303,66,68,314,473,298,371,254,89},
						{24,499,174,456,407,304,0,283,275,11,319,20,237,67,220},
						{293,255,116,239,164,66,282,0,132,293,493,277,311,216,107},
						{275,199,202,183,107,68,275,132,0,285,416,269,398,225,59},
						{29,510,185,467,419,314,12,293,285,0,323,18,228,77,230},
						{300,503,462,479,480,474,317,499,418,323,0,332,551,365,390},
						{43,493,168,450,401,297,19,276,269,18,334,0,224,60,214},
						{257,560,200,545,469,371,237,311,398,228,551,224,0,234,367},
						{83,449,107,406,357,254,67,216,224,83,366,62,234,0,170},
						{213,284,170,239,192,88,219,120,59,230,389,214,367,170,0}};
				start.setEnabled(false);
				initialTextfield.setEnabled(true);
				finalTextfield.setEnabled(true);
				calculate.setEnabled(true);
			}
		});

		// when you hit enter in initialTextfield, control will move to finalTextfield
		initialTextfield.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent text){
				finalTextfield.requestFocus();
			}
		});
		
		// when you hit enter in finalTextfield, control will click calculate button
		finalTextfield.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent text){
				calculate.doClick();
			}
		});
		
		// It will calculate the required distance, Dijkstra algorithm works here
		calculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ee){
				
				try{
					Integer source = Integer.parseInt(initialTextfield.getText());
					Integer destination = Integer.parseInt(finalTextfield.getText());

					initialTextfield.setText("");
					finalTextfield.setText("");
					
					// main algorithm, m is the object of class Algorithm
					m.Dijkstra(adjacency, source, destination);
					
					// if there is no path b/w source and destination
					if (m.distance == Integer.MAX_VALUE)
						resultLabel.setText("There is no way to go from " + source +" to " + destination);
					else{
						resultLabel.setText("Minimum Distance between " + source + " and " + destination + " is " + m.distance + " ( via" + m.via + " )");
						System.out.println(m.path);
						System.out.println(m);
						System.out.println(m.distance);
						System.out.println(m.via);
					}

					initialTextfield.setEnabled(false);
					finalTextfield.setEnabled(false);
					calculate.setEnabled(false);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
					initialTextfield.setText("");
					finalTextfield.setText("");
					initialTextfield.requestFocus();
				}
				
			}
		});

		// reset button listener
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				adjacency= new int[][]{{0,494,184,450,402,298,25,292,269,28,297,40,257,83,214},
						{494,0,366,25,105,197,500,255,200,510,505,494,560,450,284},
						{185,365,0,349,273,176,174,115,201,185,464,169,200,108,170},
						{456,25,353,0,92,185,455,242,187,467,481,450,545,407,240},
						{408,105,275,89,0,106,407,164,107,419,485,402,469,359,193},
						{304,197,178,182,106,0,303,66,68,314,473,298,371,254,89},
						{24,499,174,456,407,304,0,283,275,11,319,20,237,67,220},
						{293,255,116,239,164,66,282,0,132,293,493,277,311,216,107},
						{275,199,202,183,107,68,275,132,0,285,416,269,398,225,59},
						{29,510,185,467,419,314,12,293,285,0,323,18,228,77,230},
						{300,503,462,479,480,474,317,499,418,323,0,332,551,365,390},
						{43,493,168,450,401,297,19,276,269,18,334,0,224,60,214},
						{257,560,200,545,469,371,237,311,398,228,551,224,0,234,367},
						{83,449,107,406,357,254,67,216,224,83,366,62,234,0,170},
						{213,284,170,239,192,88,219,120,59,230,389,214,367,170,0}};
				start.setEnabled(true);
				initialTextfield.setEnabled(false);
				finalTextfield.setEnabled(false);
				calculate.setEnabled(false);
				m.reset();
			}
		});
		info.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(FilterJList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
				java.awt.EventQueue.invokeLater(() -> {
					new FilterJList().setVisible(true);
				});
			}

		});


	}

	// Main Method
	public static void main(String args[]){
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		Frame cs = new Frame();
		cs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cs.setVisible(true);
		cs.setLocation(160,16);
		cs.setSize(1100,700);
		cs.setResizable(false);
		cs.setTitle("Dijkstra Algorithm");		
	}
}
