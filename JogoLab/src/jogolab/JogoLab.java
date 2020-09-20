package jogolab;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JogoLab {

	public static void main(String[] args) {
		
		int mapa[][] = {
				{1,1,1,0,0,0,0,0,2},
				{1,1,1,0,1,1,1,1,1},
				{1,1,1,0,1,1,1,1,1},
				{1,0,0,0,0,0,1,1,1},
				{1,0,1,0,1,1,1,1,1},
				{0,0,1,0,1,1,1,1,1},
				{1,1,1,0,0,1,1,1,1}
		};
		
		JFrame tela = new JFrame();
		tela.setSize(500,500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout());
		
		JLabel rotulos [][] = new JLabel [7][9];
		
		for(int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				rotulos[i][j] = new JLabel();
				if (mapa[i][j] == 1) {
					rotulos[i][j].setText("X ");
				}
				if (mapa[i][j] == 0) {
					rotulos[i][j].setText("   ");
				}
				if (mapa[i][j] == 2) {
					rotulos[i][j].setText(" H ");
				}
			}
		}
		
		for(int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				rotulos[i][j].setFont(new Font("Arial", Font.BOLD, 50));
				painel.add(rotulos[i][j]);
			}
		}
		
		JTextField caixa = new JTextField();
		painel.add(caixa);
		caixa.setSize(10,20);
		caixa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					for(int i = 0; i < 7; i++) {
						for(int j = 0; j < 9; j++) {
							if (rotulos[i][j].getText() == " H " &&  rotulos[i][j - 1].getText() != "X ") {
								rotulos[i][j].setText("   ");
								rotulos[i][j - 1].setText(" H ");
								break;
							}
						}
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					for(int i = 0; i < 7; i++) {
						for(int j = 0; j < 9; j++) {
							if (rotulos[i][j].getText() == " H " && rotulos[i][j + 1].getText() != "X ") {
								rotulos[i][j].setText("   ");
								rotulos[i][j + 1].setText(" H ");
								break;
							}
						}
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					for(int i = 0; i < 7; i++) {
						for(int j = 0; j < 9; j++) {
							if (rotulos[i][j].getText() == " H " && rotulos[i - 1][j].getText() != "X ") {
								rotulos[i][j].setText("   ");
								rotulos[i - 1][j].setText(" H ");
								break;
							}
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					for(int i = 0; i < 7; i++) {
						for(int j = 0; j < 9; j++) {
							if (rotulos[i][j].getText() == " H " && rotulos[i  + 1][j].getText() != "X ") {
								rotulos[i][j].setText("   ");
								rotulos[i += 1][j].setText(" H ");
								break;
							}
						}
					}
				}
			}
		});
		
		tela.setContentPane(painel);
		tela.setVisible(true);
	}
	
}