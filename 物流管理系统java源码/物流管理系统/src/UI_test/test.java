package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

public class test extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pp\\Desktop\\\u7B2C1\u7EC4\u8F6F\u4EF6\u5DE5\u7A0B\u56FE\u6807.jpg"));
		setTitle("\u7269\u6D41\u516C\u53F8\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setText("123456");
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrPackageUitestImport = new JTextArea();
		scrollPane.setViewportView(txtrPackageUitestImport);
		
		JButton btnNewButton = new JButton("\u4EBA\u5458\u7BA1\u7406");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new second();
			}
		});
		btnNewButton.setToolTipText("\u67E5\u770B\u4EBA\u5458\u4FE1\u606F");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
