/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1109.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import s1109.Contact;


/**
 *
 * @author guevarag
 */
public class ListeContacts {
    
    private JPanel panelPrincipal;
    private JTable tableContacts;
    

    /**
     * Formulaire pour saisir les informations relatives Ã  un contact
     */
    public ListeContacts() {
        panelPrincipal = new JPanel();
    
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setSize(100,100);
        
        initUIComponent();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    /**
     * CrÃ©e les composants graphiques constituant l'interface
     */
    private void initUIComponent() {      //A TRAVAILLER
        JPanel panelContact=new JPanel();
     //   panelContact.setLayout(new GridLayout(3,2));
        panelContact.setSize(600,400);
        
        tableContacts=newTableContacts();
        panelContact.add(tableContacts.getTableHeader(),BorderLayout.CENTER);
       // getPanelPrincipal().add(tableContacts,BorderLayout.CENTER);

        panelContact.setBorder(BorderFactory.createTitledBorder(null,"Contact"));
        getPanelPrincipal().add(panelContact, BorderLayout.NORTH);
    }
    
    public JTable newTableContacts(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Téléphone");

        JTable table=new JTable();
        
        
        return table;
    }
}
