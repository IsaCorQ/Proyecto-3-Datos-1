import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

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
        ArrayList stars=new ArrayList();
        stars.add("Albany");
        stars.add("Auburn");
        stars.add("Binghamton");
        stars.add("Búfalo");
        stars.add("Ithaca");
        stars.add("Mount Vernon");
        stars.add("New Rochelle");
        stars.add("New York City");
        stars.add("Newburgh");
        stars.add("Nigara Falls");
        stars.add("Rochester");
        stars.add("Syracuse");
        stars.add("Utica");
        stars.add("White Plains");
        stars.add("Yonkers");

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
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 95.658"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Auburn":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 28.574"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Binghamton":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 47380"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Búfalo":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 292648"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Ithaca":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 29287"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Mount Vernon":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 68321"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "New Rochelle":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 72182"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "New York City":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 8274527"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Newburgh":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 28259"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Nigara Falls":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 55593"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Rochester":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 208123"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Syracuse":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 147306"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Utica":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 60651"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "White Plains":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 53077"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Yonkers":
                JOptionPane.showMessageDialog(rootPane,"Habitantes: 196086"+"\nLugares de interes: "+"\nLugares de comida: "+
                "\nGasolineras: ", "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Error");
                break;
        }
        //JOptionPane.showMessageDialog(rootPane,myJList.getSelectedValue()/**Aqui va el texto mostrado */, "Lugar seleccionado", JOptionPane.INFORMATION_MESSAGE);
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
