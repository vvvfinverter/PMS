import javax.swing.JFrame;

import network.Client;
import network.Server;
import view.LoginView;

public class PMSMain extends JFrame{
	LoginView login;
	
	public PMSMain() {
		
		LoginView login = new LoginView();
		login.setVisible(true);
	}

	public static void main(String[] args) {
		new PMSMain();
		//���� ���� ��� ���� �������� ��쿡�� ���, �� �ܿ� �ּ� ó�� �ʿ� �� �� ����
		Server server = new Server();
		server.networkMethod();
		// �Ʒ� Ŭ���̾�Ʈ �ڵ�� ���⼭ �����ϸ� ������ ���� ���� �� ���Ƽ� MainView class���� ��������
//		Client client = new Client();
//		client.clientMethod();
	}

}  
