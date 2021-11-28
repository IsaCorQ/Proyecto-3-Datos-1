import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class FilterJList extends javax.swing.JFrame {

    DefaultListModel defaultListModel=new DefaultListModel();
    

    /*
    Constructor
    */
    public FilterJList() {
        initComponents();
        this.bindData();
    }
    /*
    Our data source
    */
    private ArrayList getStars()
    {
        QuickSortName algorithm = new QuickSortName();
        String[] unsorted = {"Niagara Falls",
            "Newburgh","Albany","New Rochelle","New York City","Ithaca","Binghamton",
            "Mount Vernon","Yonkers","Utica","White Plains","Rochester","Auburn","Syracuse","Búfalo"};
        algorithm.sort(unsorted);
        ArrayList stars=new ArrayList();
        for (String i : unsorted) {
            stars.add(i);
        }
        return stars;
    }
    /*
    Bind data to JList
    */
    private void bindData(){
        //foreach with functinal operation
        getStars().stream().forEach((star) -> {
            defaultListModel.addElement(star);
        });
        myJList.setModel(defaultListModel);
        myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    /*
    Search/Filter data
    */
    private void searchFilter(String searchTerm)
    {
        DefaultListModel filteredItems=new DefaultListModel();
        ArrayList stars=getStars();

        stars.stream().forEach((star) -> {
            String starName=star.toString().toLowerCase();
            if (starName.contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(star);
            }
        });
        defaultListModel=filteredItems;
        myJList.setModel(defaultListModel);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myJList = new javax.swing.JList<>();
        searchTxt = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana de ayuda");

        jPanel1.setBackground(new java.awt.Color(14, /**153*/84, /**104*/196));

        myJList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myJList);

        searchTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(204, 204, 204));
        searchLabel.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(18, 18, 18)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void myJListMouseClicked(java.awt.event.MouseEvent evt) {
        System.out.println(myJList.getSelectedValue());
        switch (myJList.getSelectedValue()) {
            case "Albany":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 95658"
                +"\nLugares de interes: Albany Institute of History & Art, USS SLATER, New York State Museum"
                +"\nLugares de comida: Villa di Como Ristorante, Son of Egg, Rosanna's"+
                "\nGasolineras: Mobil, Gulf, Sunoco", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Auburn":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 28574"
                +"\nLugares de interes: Seward House Museum, Cayuga Museum of History & Art, Grave of Harriet Tubman"
                +"\nLugares de comida: Garcia's Mexican Restaurant, Starting Gate Restaurant"+
                "\nGasolineras: Chevron, ARCO, Shell", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Binghamton":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 47380"
                +"\nLugares de interes: Ross Park Zoo, Roberson Museum and Science Center"
                +"\nLugares de comida: Tsha's Kitchen, Parlor City Vegan, Paul & Sons Pizza"+
                "\nGasolineras: Gulf, Mirabito Convenience Store, Speedway", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Búfalo":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 292648"
                +"\nLugares de interes: Casa Darwin D. Marti, Zoológico de Búfalo"
                +"\nLugares de comida: The Grotto, Vasilis Restaurant En Lefko, Buffalo Chophouse"+
                "\nGasolineras: Minitz Tonawanda, Gulf, Sunoco", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Ithaca":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 29287"
                +"\nLugares de interes: Herbert F. Johnson Museum of Art, Ithaca Falls"
                +"\nLugares de comida: Maxie's Supper Club & Oyster Bar, Ithaca Ale House"+
                "\nGasolineras: Sunoco, Speedway, Kwik Fill", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Mount Vernon":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 68321"
                +"\nLugares de interes: St Pauls Church National Historic Site"
                +"\nLugares de comida: The Bayou, Maggie Spillane's Ale House and Rooftop"+
                "\nGasolineras: South Mount Vernon Park and Ride, Chevron", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "New Rochelle":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 72182"
                +"\nLugares de interes: Glen Island Park, Five Islands Park, Thomas Paine Cottage Museum"
                +"\nLugares de comida: Dubrovnik, Modern Restaurant & Lounge, Aura wine & Bar"+
                "\nGasolineras: Gulf Express, New Rochelle Auto Care Citgo Gas Station", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "New York City":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 8274527"
                +"\nLugares de interes: Central Park, Estatua de la Libertad, Empire State Building"
                +"\nLugares de comida: Frevo, Royal 35 Steakhouse"+
                "\nGasolineras: Exxon, Mobil, Shell", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Newburgh":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 28259"
                +"\nLugares de interes: Dia Beacon, Washington's Headquarters State Historic Site"
                +"\nLugares de comida: El Metapaneco Restaurant, North Plank Road Tavern"+
                "\nGasolineras: Gulf, NEWBURGH CITGO", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Niagara Falls":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 55593"
                +"\nLugares de interes: Parque estatal de las Cataratas del Niágara, Cave of the Winds, Cataratas Del Niagara"
                +"\nLugares de comida: Hard Rock Cafe, Fuji Grill Niagara Falls"+
                "\nGasolineras: Elasco of Niagara Falls, Niagara Fuel Mart", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Rochester":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 208123"
                +"\nLugares de interes: George Eastman House, The Strong National Museum of Play"
                +"\nLugares de comida: Tapas 177, Natural Oasis Market"+
                "\nGasolineras: Gulf, Exxon, Malcho's 619 Monroe Ave Inc", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Syracuse":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 147306"
                +"\nLugares de interes: Everson Museum of Art, Rosamond Gifford Zoo"
                +"\nLugares de comida: Dinosaur Bar-B-Que, Texas Roadhouse"+
                "\nGasolineras: Gulf, SOUTH SIDE SELF SERVICE", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Utica":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 60651"
                +"\nLugares de interes: Munson-Williams-Proctor Arts Institute, Utica Zoo, Adirondack Railroad"
                +"\nLugares de comida: Milano Restaurant, Curbside BBQ & Fish Fry, Happy Feet Caribbean cuisine"+
                "\nGasolineras: NORTH UTICA CITGO, Atlas Service Station", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "White Plains":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 53077"
                +"\nLugares de interes: Neuberger Museum of Art, The Haunt at Rocky Ledge, Kensico Dam Plaza"
                +"\nLugares de comida: Sunset Restaurant and Bar, Mulino's of Westchester, BLT Steak White Plains"+
                "\nGasolineras: Mobil, Gulf, Sprinter Service", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Yonkers":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 196086"
                +"\nLugares de interes: LEGOLAND Discovery Center Westchester, Untermyer Park and Gardens, Broadway"
                +"\nLugares de comida: Cariño's Restaurant Corp, Rory Dolan's Restaurant & Bar, Zuppa"+
                "\nGasolineras: Ultimate Gas Station, Yonkers Food & Gas Inc", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }                                    

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {                                      
        searchFilter(searchTxt.getText());
    }                                     

    //main method
    public static void main(String args[]) {

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

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> myJList;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTxt;
}
