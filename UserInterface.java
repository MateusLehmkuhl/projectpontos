package projectpontos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class UserInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	private int heightBtn = 40;
	private int widthBtn = 100;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String dataDeHoje;
	SimpleDateFormat horarioFormat = new SimpleDateFormat("HH:mm:ss");
	String horarioAtual;
	
	private void createButtons() {
		Arquivos arquivo = new Arquivos();
		dataDeHoje  = dateFormat.format(new Date());
		JLabel texto = new JLabel(dataDeHoje);
		texto.setSize(200,40);
		texto.setBounds(80,0, 200, 40);
		add(texto);
		
		JButton quitBtn = new JButton("File");
		quitBtn.setBounds(150, 50, widthBtn, heightBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser fileChooser = new JFileChooser();
				int retorno = fileChooser.showOpenDialog(null);

				if (retorno == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  String f = file.toString();
				  System.out.println(f);  //Debug
				  arquivo.setFilename(f);
				} else {
					System.err.println("Não foi possível selecionar o arquivo");
					return;
				}
			}
		});
		add(quitBtn);

		JButton entradaBtn = new JButton("Entrada");
		entradaBtn.setBounds(10, 100, widthBtn, heightBtn);
		entradaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				texto.setText("Salvando");
				dataDeHoje  = dateFormat.format(new Date());
				arquivo.escrever(dataDeHoje+" E\n", true);
				texto.setText("Registrado");
			}
		});
		add(entradaBtn);

		JButton saidaBtn = new JButton("Saida");
		saidaBtn.setBounds(150, 100, widthBtn, heightBtn);
		saidaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				texto.setText("Salvando");
				dataDeHoje  = dateFormat.format(new Date());
				arquivo.escrever(dataDeHoje + " S\n", true);
				texto.setText("Registrado");
			}
		});
		add(saidaBtn);
		
		JButton horarioBtn = new JButton("Att Horario");
		horarioBtn.setBounds(10, 50, widthBtn, heightBtn);
		horarioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dataDeHoje  = dateFormat.format(new Date());
				texto.setText(dataDeHoje);
			}
		});
		add(horarioBtn);		
	}


	public void startUI() {
		createButtons();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ponto");
		setSize(300, 200);
		setLayout(null);
		setVisible(true);
	}

}