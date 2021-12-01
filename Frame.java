import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame{
	/**
	 * Main frame for the dijkstra algorithm with the graph info window and algorithm
	 * Implements various actionlisteners for the buttons and the execution of the algorithm
	 * @authors Isa Cordoba, Ian Hu, Jose Cruz, Cristopher Moreira
	 */
	
	// An object of Algorithm
	Algorithm m = new Algorithm();

	private static final long serialVersionUID = 1L;

	// Adjacency matrix (used to get minimum distance and path)

	int[][] adjacency= {{0,0,184,0,0,0,25,0,0,28,0,40,0,83,0},
			{0,0,0,25,105,197,0,0,200,0,0,0,0,0,0},
			{185,0,0,0,0,176,174,115,0,185,0,0,0,108,170},
			{0,25,0,0,92,185,0,0,187,0,0,0,0,0,240},
			{0,105,0,89,0,106,0,0,107,0,0,0,0,0,193},
			{0,197,178,182,106,0,0,66,68,0,0,0,0,0,89},
			{24,0,174,0,0,0,0,0,0,11,0,20,0,67,0},
			{0,0,116,0,0,66,0,0,132,0,0,0,0,0,107},
			{0,0,0,0,107,68,0,132,0,0,0,0,0,0,59},
			{29,0,185,0,0,0,12,0,0,0,0,18,0,77,0},
			{0,0,0,0,0,0,0,0,418,323,0,0,0,0,0},
			{43,0,168,0,0,0,19,0,0,18,0,0,0,60,0},
			{0,0,0,0,0,0,237,0,0,228,0,224,0,234,0},
			{83,0,107,0,0,0,67,0,0,83,0,62,0,0,170},
			{0,0,170,0,192,88,0,120,59,0,0,0,0,170,0}};


	JPanel lowerPanel, bottomPanel,  resultPanel, graphPanel;
	JButton calculate, start, reset, info;

	JTextField initialTextfield, finalTextfield;
	JLabel initialLabel, finalLabel, resultLabel;
	
	// Builds the visual components
	public Frame() {
		setLayout(new BorderLayout());
		Font textFont = new Font("Book Antiqua", Font.PLAIN, 18);

		// Frame Icon's Image
		try {
			Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("abc.png"));
			ImageIcon icon = new ImageIcon(image);
			setIconImage(icon.getImage());
		} catch (Exception e) {
		}

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

		graphPanel = new JPanel();
		ImageIcon image = new ImageIcon(getClass().getResource("graph.png"));
		JLabel graph = new JLabel();
		graph.setIcon(image);
		graphPanel.setBackground(Color.WHITE);
		graphPanel.add(graph);

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

		add(graphPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		//Places an action listener to begin the methods initialized by pressing the button start
		/**
		 * Initializes the algorithm with its respective adjency matrix
		 * @author Isa Cordoba
		 */
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adjacency = new int[][]{{0, 0, 184, 0, 0, 0, 25, 0, 0, 28, 0, 40, 0, 83, 0},
						{0, 0, 0, 25, 105, 197, 0, 0, 200, 0, 0, 0, 0, 0, 0},
						{185, 0, 0, 0, 0, 176, 174, 115, 0, 185, 0, 0, 0, 108, 170},
						{0, 25, 0, 0, 92, 185, 0, 0, 187, 0, 0, 0, 0, 0, 240},
						{0, 105, 0, 89, 0, 106, 0, 0, 107, 0, 0, 0, 0, 0, 193},
						{0, 197, 178, 182, 106, 0, 0, 66, 68, 0, 0, 0, 0, 0, 89},
						{24, 0, 174, 0, 0, 0, 0, 0, 0, 11, 0, 20, 0, 67, 0},
						{0, 0, 116, 0, 0, 66, 0, 0, 132, 0, 0, 0, 0, 0, 107},
						{0, 0, 0, 0, 107, 68, 0, 132, 0, 0, 0, 0, 0, 0, 59},
						{29, 0, 185, 0, 0, 0, 12, 0, 0, 0, 0, 18, 0, 77, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 418, 323, 0, 0, 0, 0, 0},
						{43, 0, 168, 0, 0, 0, 19, 0, 0, 18, 0, 0, 0, 60, 0},
						{0, 0, 0, 0, 0, 0, 237, 0, 0, 228, 0, 224, 0, 234, 0},
						{83, 0, 107, 0, 0, 0, 67, 0, 0, 83, 0, 62, 0, 0, 170},
						{0, 0, 170, 0, 192, 88, 0, 120, 59, 0, 0, 0, 0, 170, 0}};
				start.setEnabled(false);
				initialTextfield.setEnabled(true);
				finalTextfield.setEnabled(true);
				calculate.setEnabled(true);
			}
		});

		// when you hit enter in initialTextfield, control will move to finalTextfield
		initialTextfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent text) {
				finalTextfield.requestFocus();
			}
		});

		// when you hit enter in finalTextfield, control will click calculate button
		finalTextfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent text) {
				calculate.doClick();
			}
		});

		// It will calculate the required distance, Dijkstra algorithm works here
		/**
		 * Initializes the calculations using the algorithm
		 * @author Isa Cordoba, Ian Hu
		 */
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				try {
					Integer source = Integer.parseInt(initialTextfield.getText());
					Integer destination = Integer.parseInt(finalTextfield.getText());

					initialTextfield.setText("");
					finalTextfield.setText("");

					// main algorithm, m is the object of class Algorithm
					m.Dijkstra(adjacency, source, destination);

					// if there is no path b/w source and destination
					if (m.distance == Integer.MAX_VALUE)
						resultLabel.setText("There is no way to go from " + source + " to " + destination);
					else {
						resultLabel.setText("Minimum Distance between " + source + " and " + destination + " is " + m.distance + " ( via" + m.via + " )");
						System.out.println(m.path);
						System.out.println(m);
						System.out.println(m.distance);
						System.out.println(m.via);
					}

					initialTextfield.setEnabled(false);
					finalTextfield.setEnabled(false);
					calculate.setEnabled(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
					initialTextfield.setText("");
					finalTextfield.setText("");
					initialTextfield.requestFocus();
				}

			}
		});

		// reset button listener
		/**
		 * Resets the nodes to be able to ask again a new path to calculate
		 * @author Ian Hu
		 */
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adjacency = new int[][]{{0, 0, 184, 0, 0, 0, 25, 0, 0, 28, 0, 40, 0, 83, 0},
						{0, 0, 0, 25, 105, 197, 0, 0, 200, 0, 0, 0, 0, 0, 0},
						{185, 0, 0, 0, 0, 176, 174, 115, 0, 185, 0, 0, 0, 108, 170},
						{0, 25, 0, 0, 92, 185, 0, 0, 187, 0, 0, 0, 0, 0, 240},
						{0, 105, 0, 89, 0, 106, 0, 0, 107, 0, 0, 0, 0, 0, 193},
						{0, 197, 178, 182, 106, 0, 0, 66, 68, 0, 0, 0, 0, 0, 89},
						{24, 0, 174, 0, 0, 0, 0, 0, 0, 11, 0, 20, 0, 67, 0},
						{0, 0, 116, 0, 0, 66, 0, 0, 132, 0, 0, 0, 0, 0, 107},
						{0, 0, 0, 0, 107, 68, 0, 132, 0, 0, 0, 0, 0, 0, 59},
						{29, 0, 185, 0, 0, 0, 12, 0, 0, 0, 0, 18, 0, 77, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 418, 323, 0, 0, 0, 0, 0},
						{43, 0, 168, 0, 0, 0, 19, 0, 0, 18, 0, 0, 0, 60, 0},
						{0, 0, 0, 0, 0, 0, 237, 0, 0, 228, 0, 224, 0, 234, 0},
						{83, 0, 107, 0, 0, 0, 67, 0, 0, 83, 0, 62, 0, 0, 170},
						{0, 0, 170, 0, 192, 88, 0, 120, 59, 0, 0, 0, 0, 170, 0}};
				start.setEnabled(true);
				initialTextfield.setEnabled(false);
				finalTextfield.setEnabled(false);
				calculate.setEnabled(false);
				m.reset();
			}
		});
		/**
		 * Adds the window with the information required
		 * @author Cristopher Moreira
		 */
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
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
