import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JList;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Creates a model to display BuddyInfo
 * @author Liam Murphy
 *
 */
public class labGui {

	private JFrame frame;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField numberText;
	private JMenuItem mntmSave;
	private JMenuItem mntmDisplay;
	private JButton btnNewButton;
	private JButton btnRemoveBuddy;
	private JButton btnEditBuddy;
	
	private List<BuddyInfo> selectedValuesList;
	private JList<BuddyInfo> buddyList;
	private DefaultListModel<BuddyInfo> buddyListModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labGui window = new labGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public labGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnAdressbookMenu = new JMenu("File");
		menuBar.add(mnAdressbookMenu);
		
		JMenu mnAddressbook = new JMenu("AddressBook");
		mnAdressbookMenu.add(mnAddressbook);
		
		mntmSave = new JMenuItem("Save");  //saving the address book
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookString = "";
				for(Object b : buddyListModel.toArray()) {
					bookString += b.toString() + ". ";
				}
				BufferedWriter out;
				try {
					out = new BufferedWriter(new FileWriter("address.txt"));
					out.write(bookString);
					out.close();

				} catch (IOException e) {
					
					e.printStackTrace();
				}

			}
		});
		mnAddressbook.add(mntmSave);
		mntmSave.setEnabled(false);
		
		JMenuItem mntmCreate = new JMenuItem("Create AddressBook");
		mntmCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemoveBuddy.setEnabled(true);  //enables functionality once the book has been created
				btnNewButton.setEnabled(true);
				btnEditBuddy.setEnabled(true);
				mntmSave.setEnabled(true);
				mntmDisplay.setEnabled(true);
				
				buddyListModel = new DefaultListModel<>(); //making the list model and list
				buddyList = new JList<>(buddyListModel);
				buddyList.addListSelectionListener(new ListSelectionListener() {
		            @Override
		            public void valueChanged(ListSelectionEvent e) {
		                if (!e.getValueIsAdjusting()) {
		                    selectedValuesList = buddyList.getSelectedValuesList();
		                    System.out.println(selectedValuesList);
		                }
		            }
		        });
				GridBagConstraints gbc_JList = new GridBagConstraints(); //adding the list to the frame
				gbc_JList.fill = GridBagConstraints.BOTH;
				gbc_JList.gridx = 0;
				gbc_JList.gridy = 8;
				frame.getContentPane().add(buddyList, gbc_JList);
			}
			
		});
		

		
		mnAddressbook.add(mntmCreate);
		
		mntmDisplay = new JMenuItem("Display AddressBook"); //Has no use as List is automatically dispalyed
		mntmDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("No Use");				
			}
		});
		
		mnAddressbook.add(mntmDisplay);
		mntmDisplay.setEnabled(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		//The following sections make and display the text fields that takes the users input
		JLabel lblNameOfBuddy = new JLabel("Name of Buddy");
		GridBagConstraints gbc_lblNameOfBuddy = new GridBagConstraints();
		gbc_lblNameOfBuddy.anchor = GridBagConstraints.WEST;
		gbc_lblNameOfBuddy.insets = new Insets(0, 0, 5, 0);
		gbc_lblNameOfBuddy.gridx = 0;
		gbc_lblNameOfBuddy.gridy = 0;
		frame.getContentPane().add(lblNameOfBuddy, gbc_lblNameOfBuddy);
		
		nameText = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(nameText, gbc_textField);
		nameText.setColumns(20);
		
		JLabel lblAddressOfBuddy = new JLabel("Address of Buddy");
		GridBagConstraints gbc_lblAddressOfBuddy = new GridBagConstraints();
		gbc_lblAddressOfBuddy.anchor = GridBagConstraints.WEST;
		gbc_lblAddressOfBuddy.insets = new Insets(0, 0, 5, 0);
		gbc_lblAddressOfBuddy.gridx = 0;
		gbc_lblAddressOfBuddy.gridy = 2;
		frame.getContentPane().add(lblAddressOfBuddy, gbc_lblAddressOfBuddy);
		
		addressText = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		frame.getContentPane().add(addressText, gbc_textField_1);
		addressText.setColumns(20);
		
		JLabel lblNumberOfBuddy = new JLabel("Number of Buddy");
		GridBagConstraints gbc_lblNumberOfBuddy = new GridBagConstraints();
		gbc_lblNumberOfBuddy.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfBuddy.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumberOfBuddy.gridx = 0;
		gbc_lblNumberOfBuddy.gridy = 4;
		frame.getContentPane().add(lblNumberOfBuddy, gbc_lblNumberOfBuddy);
		
		numberText = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 5;
		frame.getContentPane().add(numberText, gbc_textField_2);
		numberText.setColumns(20);
		
		btnNewButton = new JButton("Add to Book"); //adding a buddy to the book button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buddyListModel.addElement(new BuddyInfo(nameText.getText(), addressText.getText(), numberText.getText()));
				
				clearText(); //clears the text fields
				
			}
		});
		
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnRemoveBuddy = new JButton("Remove Buddy");
		btnRemoveBuddy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedValuesList != null) {
					for(BuddyInfo b : selectedValuesList) {
						buddyListModel.removeElement(b);
					}
				}
				
			}
		});
		
		btnRemoveBuddy.setEnabled(false);
		GridBagConstraints gbc_btnRemoveBuddy = new GridBagConstraints();
		gbc_btnRemoveBuddy.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveBuddy.anchor = GridBagConstraints.WEST;
		gbc_btnRemoveBuddy.gridx = 1;
		gbc_btnRemoveBuddy.gridy = 6;
		frame.getContentPane().add(btnRemoveBuddy, gbc_btnRemoveBuddy);
		
		btnEditBuddy = new JButton("Edit Buddy");
		btnEditBuddy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedValuesList.size() == 1) { //Only edits the a selected buddy, and  one only
					
					BuddyInfo b = selectedValuesList.get(0);//gets the selected buddy 
					String newAdd = b.getAdress(), newName = b.getName(), newNum = b.getNumber();
					
					if(!(addressText.getText().equals(""))) { //Doesn't edit the data if the fields are empty
						newAdd = addressText.getText();
					}
					if(!(nameText.getText().equals(""))) {
						newName = nameText.getText();
					}
					if(!(addressText.getText().equals(""))) {
						newNum = numberText.getText();
					}
					
					//Removes the old buddyInfo and adds the new one with edited fields 
					BuddyInfo bNew = new BuddyInfo(newName, newAdd, newNum);
					int t = buddyListModel.indexOf(b);
					buddyListModel.removeElementAt(t);
					buddyListModel.add(t, bNew);
					
					clearText();
				}
			}
		});
		
		btnEditBuddy.setEnabled(false);
		GridBagConstraints gbc_btnEditBuddy = new GridBagConstraints();
		gbc_btnEditBuddy.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditBuddy.anchor = GridBagConstraints.WEST;
		gbc_btnEditBuddy.gridx = 1;
		gbc_btnEditBuddy.gridy = 5;
		frame.getContentPane().add(btnEditBuddy, gbc_btnEditBuddy);
		
	}
	/**
	 * Clears the JText fields
	 */
	private void clearText() {
		nameText.setText("");
		addressText.setText("");
		numberText.setText("");
	}
	

}
