package cn.itcast.txz.ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//������ʾ��������
//��Ҫ�̳�Frame�ࡪ�������̳�
//���ֺ�ɫ�����ߴ�������˴���ǰ����һ����ɫ��
public class MainFrame extends Frame implements KeyListener{
	//1.������Ӧ������һ�´������������Ϣ
	//1.1�����Ƿ���ʾ
	//���췽��
	public MainFrame(){
		//�������ͼƬ�����ʱ�����˳�����Ҫ������Ҫ����
		//���ͼƬ�����˳��
		//����ͼƬ������������ͼƬ����������ӣ���������
		//��Ҫ�ڱ���ͼƬ֮ǰ���
		
		//��Ӹ��ָ���Ҫ��ʾ�Ķ���.....
		
		//������(Ŀ��λ��)
		targetInit();
		//����̫��(����)
		wolfInit();
		//��������(����)
		sheepInit();
		//����ľ(�ϰ�)
		treeInit();
		//����һ������������������ӵ�������
		backgroundInit();
		//������������
		setMainFrameUI();
		//ʹ�����ܹ��ල�û��ǲ��ǵ��˼���
		this.addKeyListener(this);
	}
	
	//�������ݵ�ģ�⣬ʹ�ö�ά����ģ��
	//1�����ϰ���0����յ�
	//4��������
	int[][] datas = {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	//������������λ��
	int wx ;
	//�������������λ��
	int wy ;
	
	//�������ϰ��ĳ�ʼ��
	private void treeInit(){
		//1.����ͼƬ
		Icon ic = new ImageIcon("tree.png");
		//������ά����
		for(int i = 0;i<datas.length;i++){
			for(int j = 0;j<datas[i].length;j++){
				//�ж�һ��ԭʼ���������ֵ�����1�����ϰ�
				if(datas[i][j] == 1){
					//�ϰ��ĳ�ʼ��
					//2.����JLabel
					JLabel lab_tree = new JLabel(ic);
					//3.���ô�Сλ��
					lab_tree.setBounds(12+50*j,36+50*i,50,50);                           
					//4.��ӵ�������
					this.add(lab_tree);
				}
			}
		}
	}
	
	
	//������Ŀ��ĳ�ʼ��
	private void targetInit() {
		//����Ŀ�귽ʽͬ����������ӵ�����
		//1.����ͼƬ
		Icon i = new ImageIcon("target.png");
		//2.Jable
		JLabel lab_target1 = new JLabel(i);
		//3.��λ��
		lab_target1.setBounds(712, 236, 50, 50);
		//4.��ӽ�����
		this.add(lab_target1);
		
		//����������������
		JLabel lab_target2 = new JLabel(i);
		lab_target2.setBounds(712, 286, 50, 50);
		this.add(lab_target2);
		
		JLabel lab_target3 = new JLabel(i);
		lab_target3.setBounds(712, 336, 50, 50);
		this.add(lab_target3);
		
	}

	//���������ӵĳ�ʼ��
	private void sheepInit(){
		//����һֻ��������ķ�ʽ����
		//�������ӵ�ģ��
		//1.����һ��ͼƬ������ͼƬ
		Icon i = new ImageIcon("sheep-no.png");
		//2.ʹ��JLabel���ģ������
		JLabel lab_sheep1 = new JLabel(i);
		//3.�������ӵ�λ��
		lab_sheep1.setBounds(12+6*50, 36+4*50, 50, 50);
		//4.��������ӵ�������
		this.add(lab_sheep1);
		//�޸����Ӷ�Ӧλ���ϵ�����Ϊ4
		datas[4][6] = 4;
		
		//�����ڶ�ֻ��ͼƬ����Ҫ������
		//�ڶ�ֻ������ʱ��ֻ��Ҫ�޸Ķ�Ӧ����ʾλ�þ�����
		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(312, 336, 50, 50);	
		this.add(lab_sheep2);
		datas[6][6] = 4;
		
		//��������ֻ��ͼƬ����Ҫ������
		//����ֻ������ʱ��ֻ��Ҫ�޸Ķ�Ӧ����ʾλ�þ�����
		JLabel lab_sheep3 = new JLabel(i);
		lab_sheep3.setBounds(312, 436, 50, 50);	
		this.add(lab_sheep3);
		datas[8][6] = 4;
	}
	
	//����������ĳ�ʼ��
	private void wolfInit() {
		//�������λ�������
		wx = 4 ;
		wy = 5 ;
		
		//ʹ��һ��ͼƬ��ģ������
		//1.����һ��ͼƬ������ͼƬ
		Icon i = new ImageIcon("wolf-zm.png");
		//2.ʹ��JLabel���ģ������
		lab_wolf = new JLabel(i);
		//3.������������Ļ�ϵ���ʾλ��
		//�������ʾλ�÷����ںδ���Ϊ����----------------
		lab_wolf.setBounds(12 + wx*50, 36 + wy*50, 50, 50);
		//4.���������ŵ���������
		this.add(lab_wolf);
	}
	JLabel lab_wolf;
	//������ʼ��
	private void backgroundInit() {
		//���������ʵ�ֵģ������������
		//��ʹ��ͼƬ��ΪJLabel�ڲ���ʾ������
		//����һ��ͼƬ
		Icon i = new ImageIcon("bg.png");
		//ʹ��JLabel��������
		JLabel lab_bg = new JLabel(i);
		//����Ҫ��ӵ������λ�����С
		lab_bg.setBounds(12, 36, 800, 600);
		//�����������ӵ���������
		this.add(lab_bg);
	}
	//���������������ʾЧ��
	private void setMainFrameUI(){
		//������������Ĳ���ģʽΪ���ɲ���
		this.setLayout(null);
		//���ô��ڵı���
		this.setTitle("������ v1.0 - java.itcast.cn");
		//���ô��ڵ�λ��
		this.setLocation(110, 30);
		//���ô��ڳߴ磬�೤400�����300
		this.setSize(826,650);
		//���ô��ڲ������
		//this.setResizable(false);
		//���ô�����ʾ����
		this.setVisible(true);
	}
	
	public void keyReleased(KeyEvent e) {
		//������̺����ڳ����ж���ִ����
		//��ηֱ��û�������Ǽ����ϵ�ĳ��������
		//ͨ������ֵ�ֱ�����һ������
		//��ȡ����ֵ�ķ�ʽ��
		//key����������������ĸ�����
		//�� 37
		//�� 38
		//�� 39
		//�� 40
		int key = e.getKeyCode();
		if(key == 39){
			//�����������ƶ�
			//һ��Ҫ֪���ƶ���λ��ǰ����û���ϰ�
			//���û���ϰ��ƶ�
			//������ϰ���ʲô���鶼����
			
			
			//��ײ���֮���������ϰ�
			if(datas[wy][wx+1] == 1){
				//��νʲô���鶼�������ǲ�������Ĵ���ִ��
				return;
			}
			//��ײ���֮������������
			if(datas[wy][wx+1] == 4){
				//����������
				//�������������
				
				//�����ڷ������ƶ�һ��
				//1.���ӵ�ʵ������4��λ��Ҫ�����仯
				//��ǰ�������ڵ�λ��ֵ���0
				datas[wy][wx+1] = 0;
				//�ƶ��Ժ��������ڵ�λ��ֵ���4
				datas[wy][wx+2] = 4;
				//2.���ӵ���ʾλ��ҲҪ�����仯
				//��ν����ģ�͵��ƶ���ʵ��������ƶ���һ����
				//���Ǹı����ӵ�����
				//�ı����ӵ�������ʹ�����Ӷ�����øı�����ķ���
				//ֻҪ�ܹ���ȡ�����Ӷ���ͼ����Ҫ�ƶ��������OK��
				//����.setLocation(���꣬����);
				//����һ��Ҫʹ����Ҫ�ƶ����Ǹ�����
				
				
				//�����ڷ������ƶ�һ��
				//-------�����ƶ����뿪ʼ----------
				wx = wx+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("wolf-ym.png");
				lab_wolf.setIcon(i);
				//-------�����ƶ��������---------------
				return;
			}
			
				
				
			//����Ҫ֪������������ʲôλ��
			wx = wx+1;
			//�������lab_wolf������
			//ʹ��lab_wolf.getLocation()���Եõ������λ��
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			//Ҫ֪���ƶ�һ�β��Ӷ��
			//һ���ƶ�50�������ƶ�
			//x�����ֵҪ���50��y�����ֵ����
			//����Ҫ�ƶ���x+50   y ����ط�
			//��������������ݼ�����ƶ��Ժ�����������
			lab_wolf.setLocation(x+50, y);
			//�����ƶ���Ҫ����ͼƬ����
			//����Ҫ��ͼƬ
			Icon i = new ImageIcon("wolf-ym.png");
			//Ȼ��������ʾͼƬΪָ��ͼƬ
			lab_wolf.setIcon(i);
		}
		if(key == 37){
			if(datas[wy][wx-1] == 1){
				return;
			}
			wx = wx-1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x-50, y);
			Icon i = new ImageIcon("wolf-zb.png");
			lab_wolf.setIcon(i);
		}
		if(key == 38){
			if(datas[wy-1][wx] == 1){
				//��νʲô���鶼�������ǲ�������Ĵ���ִ��
				return;
			}
			wy = wy-1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y-50);
			Icon i = new ImageIcon("wolf-sm.png");
			lab_wolf.setIcon(i);
		}
		if(key == 40){
			if(datas[wy+1][wx] == 1){
				//��νʲô���鶼�������ǲ�������Ĵ���ִ��
				return;
			}
			wy = wy+1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y+50);
			Icon i = new ImageIcon("wolf-zm.png");
			lab_wolf.setIcon(i);
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
}
