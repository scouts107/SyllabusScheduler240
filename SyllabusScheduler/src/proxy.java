package proxyExample;

import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;





public class proxy extends JFrame implements ActionListener {

	public static void main(String[] args) {
	InetAddress address = null;
	
	
	try {
			
			address = InetAddress.getLocalHost();
			
			
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
			
		} 
		final String ip = address.getHostAddress();
		JFrame fj = new JFrame("Proxy");
		final JTextField tf =new JTextField();
		tf.setBounds(50, 50, 150, 20);
		JButton b = new JButton("Connect");
		b.setBounds(100,100,150,30);
		fj.add(b);
		fj.setSize(400,400);
		fj.setLayout(null);
		fj.setVisible(true);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				b.setText("Connecting");
				if(ip.equals("192.168.1.19"))
				{
					Frame frame = new Frame();
					frame.myFrame(args);
				}
			}
		});
		
		}
		

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	


}