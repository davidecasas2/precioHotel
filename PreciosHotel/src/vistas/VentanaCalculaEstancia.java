package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaCalculaEstancia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private final ButtonGroup grupoRegimen = new ButtonGroup();
	private JComboBox<String> comboTipo;
	private JRadioButton rdbDesayuno;
	private JRadioButton rdbCompleta;
	private JRadioButton rdbMedia;
	private JRadioButton rdbTodo;
	private JSpinner spinnerNoches;
	private JTextArea textAreaResumen;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalculaEstancia frame = new VentanaCalculaEstancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCalculaEstancia() {
		setTitle("Calcular Estancia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtNombre, "cell 1 0,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtApellidos, "cell 1 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtDni, "cell 1 2,growx");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Habitación:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		comboTipo = new JComboBox();
		comboTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Doble", "Triple", "Suite Deluxe"}));
		contentPane.add(comboTipo, "cell 1 3,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Régimen:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4, "cell 0 4");
		
		rdbDesayuno = new JRadioButton("Desayuno");
		rdbDesayuno.setSelected(true);
		grupoRegimen.add(rdbDesayuno);
		rdbDesayuno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbDesayuno, "flowx,cell 1 4");
		
		rdbCompleta = new JRadioButton("Pensión completa");
		grupoRegimen.add(rdbCompleta);
		rdbCompleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbCompleta, "flowx,cell 1 5");
		
		JLabel lblNewLabel_6 = new JLabel("Num noches:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_6, "cell 0 6");
		
		spinnerNoches = new JSpinner();
		spinnerNoches.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(spinnerNoches, "cell 1 6");
		
		JButton btnNewButton = new JButton("Calcular Importe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarYCalcular();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton, "cell 0 7 2 1,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel("Resumen:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5, "cell 0 8");
		
		rdbMedia = new JRadioButton("Media Pensión");
		grupoRegimen.add(rdbMedia);
		rdbMedia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbMedia, "cell 1 4");
		
		rdbTodo = new JRadioButton("Todo Incluido");
		grupoRegimen.add(rdbTodo);
		rdbTodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbTodo, "cell 1 5");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 9 2 1,grow");
		
		textAreaResumen = new JTextArea();
		scrollPane.setViewportView(textAreaResumen);
	}

	protected void validarYCalcular() {
		if (txtNombre.getText()==null || txtNombre.getText().isBlank() ||
			txtApellidos.getText()==null || txtApellidos.getText().isBlank()||
			txtDni.getText()==null || txtDni.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(this,
				"Debe introducir los campos de nombre, apellidos y DNI.",
				"Compruebe los datos", JOptionPane.WARNING_MESSAGE);
			
			return;
		}
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDni.getText();
		int precio=60;
		String tipo =(String) comboTipo.getSelectedItem();
		
		if (tipo.equals("Doble")) {
			precio = 85;
		} else if (tipo.equals("Triple")) {
			precio= 102;
		} else if (tipo.equals("Suite Deluxe")) {
			precio=350;
		}
		
		
		String regimen="Desayuno";
		if (rdbDesayuno.isSelected()) {
			precio=precio+3;
		}
		if (rdbMedia.isSelected()) {
			regimen = "Media Pensión";
			precio=precio+5;
		}
		if (rdbCompleta.isSelected()) {
			regimen = "Pensión Completa";
			precio=precio+7;
		}
		if (rdbTodo.isSelected()) {
			regimen = "Todo incluido";
			precio=precio+16;
		}
		int noches = (int) spinnerNoches.getValue();
		precio = precio*noches;
		
		textAreaResumen.setText(
			"Nombre: " +nombre + "\n"+
			"Apellidos: " +apellidos + "\n"+
			"Dni: " +dni + "\n"+
			"tipo: " +tipo + "\n"+
			"Régimen: " +regimen + "\n"+
			"Num. noches: " +noches + "\n"+
			"Precio total: " +precio);
		
	}

}
