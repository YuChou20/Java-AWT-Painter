import java.awt.*;
import java.awt.event.*;
public class painter extends Frame implements MouseMotionListener,MouseListener,ActionListener{
	static void setMenu(){
		mb.add(clear);
		mb.add(color);
		mb.add(draw);
		clear.add(clr);
		color.add(blk);
		color.add(rd);
		color.add(green);
		color.add(blue);
		draw.add(pen);
		draw.add(rectangle);
		draw.add(circle);
		clr.addActionListener(frm);
		blk.addActionListener(frm);
		rd.addActionListener(frm);
		green.addActionListener(frm);
		blue.addActionListener(frm);
		pen.addActionListener(frm);
		rectangle.addActionListener(frm);
		circle.addActionListener(frm);
	}
	static painter frm = new painter();
	
	static MenuBar mb = new MenuBar();
	static Menu clear = new Menu("Clear");
	static Menu color = new Menu("Color");
	static Menu draw = new Menu("Draw");
	static MenuItem clr = new MenuItem("Clear");
	static MenuItem blk = new MenuItem("Black");
	static MenuItem rd = new MenuItem("Red");
	static MenuItem green = new MenuItem("Green");
	static MenuItem blue = new MenuItem("Blue");
	static MenuItem pen = new MenuItem("Pen");
	static MenuItem rectangle = new MenuItem("Rectangle");
	static MenuItem circle = new MenuItem("Circle");
	static int cr = 0,cg = 0,cb = 0;
	
	static int mode = 0 , x1 , x2 , y1 , y2;
	public static void main(String args[]){
		frm.setLayout(null);
		frm.setResizable(false);
		frm.setTitle("painter");
		frm.setLocation(450,150);      
		frm.setSize(700,700);
		frm.setResizable(false);
		frm.setVisible(true);
		frm.setMenuBar(mb);
		setMenu();
		frm.addMouseListener(frm);    // 設定MouseListener
		frm.addMouseMotionListener(frm); // 設定MouseMotionListener
		circle.addActionListener(frm);
		frm.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent event) {System.exit(0);
			}
		}
	    );
	}
	public void actionPerformed(ActionEvent e){
		MenuItem mi = (MenuItem) e.getSource();
		if (mi == blk){
			cr = 0;
			cg = 0;
			cb = 0;
		}
		else if (mi == rd){
			cr = 255;
			cg = 0;
			cb = 0;
		}
		else if (mi == green){
			cr = 0;
			cg = 255;
			cb = 0;
		}
		else if (mi == blue){
			cr = 0;
			cg = 0;
			cb = 255;
		}
		else if (mi == clr){
			Graphics g = getGraphics();
			repaint();
		}
		else if (mi == pen){
			mode = 1;
		}
		else if (mi == rectangle){
			mode = 2;
		}
		else if (mi == circle){
			mode = 3;
		}
	}	
	public void mouseDragged(MouseEvent e){
		Graphics g = getGraphics();
		g.setColor(new Color(cr,cg,cb));
		if (mode == 1){
			x2 = e.getX();               // 取得拖曳滑鼠時的x座標
			y2 = e.getY();               // 取得拖曳滑鼠時的y座標
			g.drawLine(x1,y1,x2,y2);      // 繪出(x1,y1)到(x2,y2)的連線
			x1 = x2;                  // 更新繪圖起始點的x座標
			y1 = y2;                // 更新繪圖起始點的y座標*/
		}
		else if (mode == 2){
			int x3 = e.getX();               // 取得拖曳滑鼠時的x座標
			int y3 = e.getY();               // 取得拖曳滑鼠時的y座標
			g.setColor(Color.white);
			g.drawLine(x1,y1,x2,y1);
			g.drawLine(x2,y1,x2,y2);
			g.drawLine(x2,y2,x1,y2);
			g.drawLine(x1,y2,x1,y1);
			g.setColor(new Color(cr,cg,cb));
			g.drawLine(x1,y1,x3,y1);
			g.drawLine(x3,y1,x3,y3);
			g.drawLine(x3,y3,x1,y3);
			g.drawLine(x1,y3,x1,y1);
			x2 = x3;
			y2 = y3;
		}
		else if (mode == 3){
			int x3 = e.getX();   // 取得滑鼠按下時的x座標 (繪圖起始點的x座標)
			int y3 = e.getY();   // 取得滑鼠按下時的y座標 (繪圖起始點的y座標)
			g.setColor(Color.white);
			if ( x1 >= x2 && y1 >= y2){			//右下到左上
				g.drawOval(x2,y2,x1-x2,y1-y2);
			}
			else if (x1 >= x2 && y1 <= y2){		//右上到左下
				g.drawOval(x2,y1,x1-x2,y2-y1);
			}
			else if (x1 <= x2 && y1 >= y2){		//左下到右上
				g.drawOval(x1,y2,x2-x1,y1-y2);
			}
			else{								//左上到右下
				g.drawOval(x1,y1,x2-x1,y2-y1);
			}
			g.setColor(new Color(cr,cg,cb));
			x2 = x3;
			y2 = y3;
			if ( x1 >= x2 && y1 >= y2){			//右下到左上
				g.drawOval(x2,y2,x1-x2,y1-y2);
			}
			else if (x1 >= x2 && y1 <= y2){		//右上到左下
				g.drawOval(x2,y1,x1-x2,y2-y1);
			}
			else if (x1 <= x2 && y1 >= y2){		//左下到右上
				g.drawOval(x1,y2,x2-x1,y1-y2);
			}
			else{								//左上到右下
				g.drawOval(x1,y1,x2-x1,y2-y1);
			}
		}
	}
	public void mousePressed(MouseEvent e){
		x1 = e.getX();   // 取得滑鼠按下時的x座標 (繪圖起始點的x座標)
		y1 = e.getY();   // 取得滑鼠按下時的y座標 (繪圖起始點的y座標)
		x2 = x1;
		y2 = y1;
	}
	public void mouseMoved(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}