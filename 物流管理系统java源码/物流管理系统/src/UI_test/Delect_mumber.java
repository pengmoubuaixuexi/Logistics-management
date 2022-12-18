package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delect_mumber extends JFrame {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistics_company";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public PreparedStatement statement = null;
    public ResultSet result = null;
    public int success = 0;
	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Delect_mumber frame = new Delect_mumber();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Delect_mumber(DefaultTableModel model,Object[] Table_Column) {
		ToSQLserver();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u4F5C\u8BC1\u53F7\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("      ");
		lblNewLabel_1.setAutoscrolls(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		JButton btnNewButton = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//������������ݿ��ҵ�����ΪtextField.getText()���ˣ�����������ֺ���������
			public void mouseClicked(MouseEvent e) {
				try {
					statement = dbConn.prepareStatement("select * from member where Id = "+"'"+textField.getText()+"'");
					result = statement.executeQuery();
					result.next();
					String name = result.getString("name");
					String bumen = result.getString("department");
					lblNewLabel_1.setText("��Ա��Ϊ"+name+",��"+bumen+"����,�Ƿ�Ҫɾ����Ա������Ϣ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblNewLabel_1.setText("����֤��Ϊ"+textField.getText()+"��Ա��������");
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					statement = dbConn.prepareStatement("delete from member where id = "+"'"+textField.getText()+"'");
					int success = statement.executeUpdate();
					if (success==1) {
						lblNewLabel_1.setText("Ա����Ϣ��ɾ��");
					}
					else {
						lblNewLabel_1.setText("���ִ���ɾ��ʧ��");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.setDataVector(huoquTable_Content(), Table_Column);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(43)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addGap(34))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField))
					.addGap(24)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	public void ToSQLserver() {
        try {
            //1.��������
            //Class.forName����������,���ǳ�ʼ����������.�����Ǹ�����MySQL��Driver����,
            // ���ھ�̬�������ͨ��JDBC��DriverManagerע����һ������.����Ҳ����ֱ��ʹ��JDBC������������ע��mysql����.
            // �Ӷ�����ʹ��Class.forName.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.����
            dbConn = DriverManager.getConnection(dbURL, name, passwd);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	public Object[][] huoquTable_Content(){
		ToSQLserver();
		int rowCount = 0,i=0;
		Object[][] Table_Content = null;
		try {
			statement = dbConn.prepareStatement("select * from member");
			result = statement.executeQuery();
			while(result.next()) {
				rowCount++;
			}
			Table_Content = new Object[rowCount][7];
			result = statement.executeQuery();
			while(result.next()) {
				Table_Content[i][0] = result.getString("id");
				Table_Content[i][1] = result.getString("name");
				Table_Content[i][2] = result.getString("sex");
				Table_Content[i][3] = result.getString("identyid");
				Table_Content[i][4] = result.getString("address");
				Table_Content[i][5] = result.getString("phoneNumber");
				Table_Content[i][6] = result.getString("department");
				i++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Table_Content;
	}
}
