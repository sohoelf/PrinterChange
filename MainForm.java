package oooo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainForm extends JFrame {
	short s = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setLocationRelativeTo(null); 
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
	public MainForm() {
		 
		setTitle("\u6253\u5370\u673A\u5FEB\u901F\u5207\u6362");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/ico/prtsc.png")));
		setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		
		/////////////
		BufferedReader br = null;
		
		try {
			Process p = Runtime.getRuntime().exec("cscript C:\\Windows\\System32\\Printing_Admin_Scripts\\zh-CN\\prnmngr.vbs -g");
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
		
			while ((line = br.readLine()) != null) {
				//System.out.print(line);
				if(line.indexOf("M200 Series")!=-1)
				{
					s = 2;
				}else if(line.indexOf("Canon LBP3000")!=-1)
				{
					s = 3;
				}else if(line.indexOf("")!=-1)
				{
					s = 4;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		////////
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(this.getHeight()/2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled(false);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		splitPane_1.setDividerLocation(this.getHeight()/2);
		
		JButton btnNewButton_1 = new JButton("<html><br><b><font color=\"#AF1313\" size=\"6\"></font></b></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//右
				//try {
				//	Runtime.getRuntime().exec("rundll32 printui.dll,PrintUIEntry /y /n \\\\2012-20140208WB\\CanonLBP.2");
				//
				//} catch (Exception e1) {
				//	e1.printStackTrace();
				//} finally {
				//	System.exit(0); 
				//}
				//System.out.print("!");
			}
		});
		if(s == 1)
		{
			btnNewButton_1.setBackground(new Color(153, 255, 204));
		}else
		{
			btnNewButton_1.setBackground(new Color(240, 248, 255));
		}
		
		btnNewButton_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		splitPane_1.setLeftComponent(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//4
				try {
					//Runtime.getRuntime().exec("rundll32 printui.dll,PrintUIEntry /y /n \\\\PACS0001\\CanonLBP2900");
				
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					//System.exit(0); 
				}
			}
		});
		btnNewButton_3.setBackground(new Color(240, 248, 255));
		splitPane_1.setRightComponent(btnNewButton_3);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);
		splitPane_2.setDividerLocation(this.getWidth()/3);
		
		JButton btnNewButton = new JButton("<html><b><font color=\"#AF1313\" size=\"6\">自己</font></b>屋子里那台</html>");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//3
				try {
					Runtime.getRuntime().exec("rundll32 printui.dll,PrintUIEntry /y /n \"Canon LBP3000\"");
				
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					System.exit(0); 
				}
			}
		});
		if(s == 3)
		{
			btnNewButton.setBackground(new Color(153, 255, 204));
		}else
		{
			btnNewButton.setBackground(new Color(240, 248, 255));
		}
		splitPane_2.setLeftComponent(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("<html><b><font color=\"#AF1313\" size=\"6\">综合</font></b>打印机</html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//左
				try {
					Runtime.getRuntime().exec("rundll32 printui.dll,PrintUIEntry /y /n \"M200 Series\"");
				
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					System.exit(0); 
				}
				//System.out.print("?");
			}
		});
		if(s == 2)
		{
			btnNewButton_2.setBackground(new Color(153, 255, 204));
		}else
		{
			btnNewButton_2.setBackground(new Color(240, 248, 255));
		}
		btnNewButton_2.setFont(new Font("新宋体", Font.PLAIN, 12));
		splitPane_2.setRightComponent(btnNewButton_2);
	}

}
