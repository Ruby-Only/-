package cn.itcast.txz.ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//用作显示的主窗体
//需要继承Frame类————继承
//出现红色波浪线代表出现了错误，前方有一个红色叉
public class MainFrame extends Frame implements KeyListener{
	//1.最起码应该设置一下窗口最基本的信息
	//1.1窗口是否显示
	//构造方法
	public MainFrame(){
		//由于添加图片组件的时候存在顺序，因此要根据需要调整
		//添加图片组件的顺序
		//背景图片由于其是最大的图片，因此最后添加，其他内容
		//都要在背景图片之前添加
		
		//添加各种各样要显示的东西.....
		
		//做笼子(目标位置)
		targetInit();
		//做灰太狼(人物)
		wolfInit();
		//做懒洋洋(箱子)
		sheepInit();
		//做树木(障碍)
		treeInit();
		//制作一个背景，并将背景添加到窗体中
		backgroundInit();
		//设置整个窗体
		setMainFrameUI();
		//使窗口能够监督用户是不是点了键盘
		this.addKeyListener(this);
	}
	
	//场景数据的模拟，使用二维数组模拟
	//1代表障碍，0代表空地
	//4代表箱子
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
	//代表人物横向的位置
	int wx ;
	//代表人物纵向的位置
	int wy ;
	
	//推箱子障碍的初始化
	private void treeInit(){
		//1.创建图片
		Icon ic = new ImageIcon("tree.png");
		//遍历二维数组
		for(int i = 0;i<datas.length;i++){
			for(int j = 0;j<datas[i].length;j++){
				//判断一下原始数据里面的值如果是1，做障碍
				if(datas[i][j] == 1){
					//障碍的初始化
					//2.创建JLabel
					JLabel lab_tree = new JLabel(ic);
					//3.设置大小位置
					lab_tree.setBounds(12+50*j,36+50*i,50,50);                           
					//4.添加到窗体中
					this.add(lab_tree);
				}
			}
		}
	}
	
	
	//推箱子目标的初始化
	private void targetInit() {
		//制作目标方式同人物或者箱子的制作
		//1.创建图片
		Icon i = new ImageIcon("target.png");
		//2.Jable
		JLabel lab_target1 = new JLabel(i);
		//3.设位置
		lab_target1.setBounds(712, 236, 50, 50);
		//4.添加进窗体
		this.add(lab_target1);
		
		//制作其他两个笼子
		JLabel lab_target2 = new JLabel(i);
		lab_target2.setBounds(712, 286, 50, 50);
		this.add(lab_target2);
		
		JLabel lab_target3 = new JLabel(i);
		lab_target3.setBounds(712, 336, 50, 50);
		this.add(lab_target3);
		
	}

	//推箱子箱子的初始化
	private void sheepInit(){
		//制作一只羊按照下面的方式进行
		//制作箱子的模型
		//1.创建一张图片，箱子图片
		Icon i = new ImageIcon("sheep-no.png");
		//2.使用JLabel组件模拟箱子
		JLabel lab_sheep1 = new JLabel(i);
		//3.设置箱子的位置
		lab_sheep1.setBounds(12+6*50, 36+4*50, 50, 50);
		//4.把箱子添加到窗体中
		this.add(lab_sheep1);
		//修改箱子对应位置上的数据为4
		datas[4][6] = 4;
		
		//制作第二只羊，图片不需要制作了
		//第二只羊制作时，只需要修改对应的显示位置就行了
		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(312, 336, 50, 50);	
		this.add(lab_sheep2);
		datas[6][6] = 4;
		
		//制作第三只羊，图片不需要制作了
		//第三只羊制作时，只需要修改对应的显示位置就行了
		JLabel lab_sheep3 = new JLabel(i);
		lab_sheep3.setBounds(312, 436, 50, 50);	
		this.add(lab_sheep3);
		datas[8][6] = 4;
	}
	
	//推箱子人物的初始化
	private void wolfInit() {
		//人物最初位置在哪里？
		wx = 4 ;
		wy = 5 ;
		
		//使用一张图片来模拟人物
		//1.创建一张图片，人物图片
		Icon i = new ImageIcon("wolf-zm.png");
		//2.使用JLabel组件模拟人物
		lab_wolf = new JLabel(i);
		//3.设置人物在屏幕上的显示位置
		//人物的显示位置放置在何处较为合理？----------------
		lab_wolf.setBounds(12 + wx*50, 36 + wy*50, 50, 50);
		//4.把这个人物放到窗体里面
		this.add(lab_wolf);
	}
	JLabel lab_wolf;
	//背景初始化
	private void backgroundInit() {
		//背景是如何实现的？如何做背景？
		//想使用图片作为JLabel内部显示的内容
		//创建一个图片
		Icon i = new ImageIcon("bg.png");
		//使用JLabel制作背景
		JLabel lab_bg = new JLabel(i);
		//设置要添加的组件的位置与大小
		lab_bg.setBounds(12, 36, 800, 600);
		//将这个东西添加到窗体里面
		this.add(lab_bg);
	}
	//设置主窗体界面显示效果
	private void setMainFrameUI(){
		//设置整个窗体的布局模式为自由布局
		this.setLayout(null);
		//设置窗口的标题
		this.setTitle("推箱子 v1.0 - java.itcast.cn");
		//设置窗口的位置
		this.setLocation(110, 30);
		//设置窗口尺寸，多长400，多宽300
		this.setSize(826,650);
		//设置窗口不能最大化
		//this.setResizable(false);
		//设置窗口显示出来
		this.setVisible(true);
	}
	
	public void keyReleased(KeyEvent e) {
		//点击键盘后现在程序有动作执行了
		//如何分辨用户点击的是键盘上的某个按键？
		//通过键码值分辨是哪一个按键
		//获取键码值的方式：
		//key代表了你输入的是哪个按键
		//左 37
		//上 38
		//右 39
		//下 40
		int key = e.getKeyCode();
		if(key == 39){
			//让人物向右移动
			//一定要知道移动的位置前面有没有障碍
			//如果没有障碍移动
			//如果有障碍，什么事情都不做
			
			
			//碰撞检测之人物遇到障碍
			if(datas[wy][wx+1] == 1){
				//所谓什么事情都不做就是不让下面的代码执行
				return;
			}
			//碰撞检测之人物遇到箱子
			if(datas[wy][wx+1] == 4){
				//遇到了箱子
				//如果遇到了箱子
				
				//箱子在方向上移动一格
				//1.箱子的实际数据4的位置要发生变化
				//当前箱子所在的位置值变成0
				datas[wy][wx+1] = 0;
				//移动以后箱子所在的位置值变成4
				datas[wy][wx+2] = 4;
				//2.箱子的显示位置也要发生变化
				//所谓箱子模型的移动其实和人物的移动是一样的
				//就是改变箱子的坐标
				//改变箱子的坐标是使用箱子对象调用改变坐标的方法
				//只要能够获取到箱子对象和计算出要移动的坐标就OK了
				//箱子.setLocation(坐标，坐标);
				//箱子一定要使用你要移动的那个箱子
				
				
				//人物在方向上移动一格
				//-------人物移动代码开始----------
				wx = wx+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("wolf-ym.png");
				lab_wolf.setIcon(i);
				//-------人物移动代码结束---------------
				return;
			}
			
				
				
			//首先要知道人物现在在什么位置
			wx = wx+1;
			//人物就是lab_wolf这个组件
			//使用lab_wolf.getLocation()可以得到人物的位置
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			//要知道移动一次步子多大
			//一步移动50？向右移动
			//x方向的值要变大50，y方向的值不变
			//最终要移动到x+50   y 这个地方
			//由上面的两个数据计算出移动以后人物在哪里
			lab_wolf.setLocation(x+50, y);
			//人物移动后要进行图片更新
			//首先要有图片
			Icon i = new ImageIcon("wolf-ym.png");
			//然后设置显示图片为指定图片
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
				//所谓什么事情都不做就是不让下面的代码执行
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
				//所谓什么事情都不做就是不让下面的代码执行
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
