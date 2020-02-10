import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class MyScienceFrame extends JFrame{


	private boolean openP=false,closeP=false, haveParentheses=false;
	private pointListener decimal=new pointListener();
	private EgalListener egalite=new EgalListener();
	private String TextBouton, insider="", chainResult="";
	private Operation op=new Operation();
	private ChaineOperation chaineop=new ChaineOperation();
	private boolean function=false, noRadian=false;
	private ChiffrierListener chiffre = new ChiffrierListener();

	private static final String ErreurDiv0 = "Err: Div par 0";
	private static final String Erreur = "Erreur";
	private String inside="", chaine="";
	private Double provisoire, droite,resultat,underRoot;
	private boolean pointPresent=false;
	private String operateur="";
	private Double memory;
	private String tempon="";



	private JLabel ecranBas= new JLabel("0");
	private JLabel ecranHaut= new JLabel("");
	private JPanel jpan= new JPanel();
	private JPanel ouest=new JPanel(),est=new JPanel(), nord=new JPanel(), haut=new JPanel(), bas=new JPanel();

	//chiffrier
	private JButton zero = new JButton("0");
	private JButton un = new JButton("1");
	private JButton deux = new JButton("2");
	private JButton trois = new JButton("3");
	private JButton quatre = new JButton("4");
	private JButton cinq = new JButton("5");
	private JButton six = new JButton("6");
	private JButton sept = new JButton("7");
	private JButton huit = new JButton("8");
	private JButton neuf = new JButton("9");

	//
	private JButton ouvrirP = new JButton("(");
	private JButton fermerP = new JButton(")");
	private JButton point = new JButton(".");
	private JButton egal = new JButton("=");
	private JButton plusOuMoins = new JButton("+/-");
	private JButton clear = new JButton("CE");
	private JButton div = new JButton("/");
	private JButton mult = new JButton("*");
	private JButton plus = new JButton("+");
	private JButton moins = new JButton("-");
	private JButton cos = new JButton("cos");
	private JButton arccos = new JButton("acos");
	private JButton sin = new JButton("sin");
	private JButton arcsin = new JButton("asin");
	private JButton tg = new JButton("tan");
	private JButton cotg = new JButton("atan");
	private JButton facto = new JButton("!");
	private JButton sinh = new JButton("sinh");
	private JButton radian = new JButton("RD");
	private JButton degre = new JButton("DG");
	private JButton expoBaseA = new JButton("x^y");
	private JButton log = new JButton("log");
	private JButton ln = new JButton("ln");
	private JButton expo = new JButton("e^");
	private JButton racineKare = new JButton("\u221A");
	private JButton cosh = new JButton("cosh");



	public MyScienceFrame() {
		super("Scientific");

		this.setSize(680, 380);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		jpan.setFocusable(true);
		this.setContentPane(jpan);
		BorderLayout layout= new BorderLayout();
		layout.setHgap(1);
		layout.setVgap(1);
		this.setLayout(layout);
		jpan.setBorder(BorderFactory.createRaisedBevelBorder());
		jpan.setBackground(Color.CYAN);

		// Est
		GridLayout EstLayout=new GridLayout(5,3);
		EstLayout.setHgap(3);
		EstLayout.setVgap(3);
		est.setLayout(EstLayout);
		est.setPreferredSize(new Dimension(274,274));

		est.add(degre);
		degre.setFocusable(false);
		degre.addActionListener(new modeListener());


		est.add(radian);
		radian.setFocusable(false);
		radian.addActionListener(new modeListener());


		est.add(tg);
		tg.setFocusable(false);
		tg.addActionListener(new FunctionListener());


		est.add(cos);
		cos.setFocusable(false);
		cos.addActionListener(new FunctionListener());



		est.add(sin);
		sin.setFocusable(false);
		sin.addActionListener(new FunctionListener());


		est.add(cotg);
		cotg.setFocusable(false);
		cotg.addActionListener(new FunctionListener());


		est.add(arccos);
		arccos.setFocusable(false);
		arccos.addActionListener(new FunctionListener());

		est.add(arcsin);
		arcsin.setFocusable(false);
		arcsin.addActionListener(new FunctionListener());

		est.add(racineKare);
		racineKare.setFocusable(false);
		racineKare.addActionListener(new FunctionListener());

		est.add(cosh);
		cosh.setFocusable(false);
		cosh.addActionListener(new FunctionListener());


		est.add(expoBaseA);
		expoBaseA.setFocusable(false);
		expoBaseA.addActionListener(new exposant());

		est.add(log);
		log.setFocusable(false);
		log.addActionListener(new FunctionListener() );

		est.add(facto);
		facto.setFocusable(false);
		facto.addActionListener(new FunctionListener() );

		est.add(expo);
		expo.setFocusable(false);
		expo.addActionListener(new FunctionListener() );

		est.add(ln);
		ln.setFocusable(false);
		ln.addActionListener(new FunctionListener() );

		//ouest
		GridLayout OuestLayout = new GridLayout(5,4);
		OuestLayout.setHgap(3);
		OuestLayout.setVgap(3);
		ouest.setPreferredSize(new Dimension(375,274));
		ouest.setLayout(OuestLayout);

		ouest.add(ouvrirP);
		ouvrirP.setFocusable(false);
		ouvrirP.addActionListener(new paranthese());

		ouest.add(fermerP);
		fermerP.setFocusable(false);
		fermerP.addActionListener(new paranthese());

		ouest.add(plusOuMoins);
		plusOuMoins.setFocusable(false);
		plusOuMoins.addActionListener(new plusOuMoinsListener());

		ouest.add(clear);
		clear.setFocusable(false);
		clear.addActionListener(new clearListener());

		ouest.add(sept);
		ouest.add(huit);
		ouest.add(neuf);
		ouest.add(div);

		ouest.add(quatre);
		ouest.add(cinq);
		ouest.add(six);
		ouest.add(mult);

		ouest.add(un);
		ouest.add(deux);
		ouest.add(trois);
		ouest.add(moins);

		ouest.add(zero);
		ouest.add(point);
		ouest.add(egal);
		ouest.add(plus);

		point.setFocusable(false);
		point.setForeground(Color.RED);
		point.setFont(point.getFont().deriveFont(Font.BOLD));
		point.addActionListener(decimal);

		egal.setFocusable(true);
		egal.addActionListener(egalite );
		egal.addKeyListener(egalite);
		egal.setForeground(Color.RED);
		egal.setFont(egal.getFont().deriveFont(Font.BOLD));

		moins.setFocusable(false);
		moins.addActionListener(new ArithmetiqueListener());
		moins.setForeground(Color.RED);
		moins.setFont(moins.getFont().deriveFont(Font.BOLD));

		zero.setFocusable(false);
		zero.addActionListener(chiffre);

		un.setFocusable(false);
		un.addActionListener(chiffre);

		deux.setFocusable(false);
		deux.addActionListener(chiffre);


		trois.setFocusable(false);
		trois.addActionListener(chiffre);

		quatre.setFocusable(false);
		quatre.addActionListener(chiffre);

		cinq.setFocusable(false);
		cinq.addActionListener(chiffre);

		six.setFocusable(false);
		six.addActionListener(chiffre);

		sept.setFocusable(false);
		sept.addActionListener(chiffre);

		huit.setFocusable(false);
		huit.addActionListener(chiffre);

		neuf.setFocusable(false);
		neuf.addActionListener(chiffre);


		mult.setFocusable(false);
		mult.addActionListener(new ArithmetiqueListener());
		mult.setForeground(Color.RED);
		mult.setFont(mult.getFont().deriveFont(Font.BOLD));


		div.setFocusable(false);
		div.addActionListener(new ArithmetiqueListener());
		div.setForeground(Color.RED);
		div.setFont(div.getFont().deriveFont(Font.BOLD));

		plus.setFocusable(false);
		plus.addActionListener(new ArithmetiqueListener());
		plus.setForeground(Color.RED);
		plus.setFont(plus.getFont().deriveFont(Font.BOLD));

		//nord

		GridLayout nordLayout=new GridLayout(2,1);
		nordLayout.setVgap(2);
		ecranBas.setHorizontalAlignment(JLabel.RIGHT);
		ecranHaut.setHorizontalAlignment(JLabel.RIGHT);

		nord.setLayout(nordLayout);
		//		bas.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		bas.setSize(new Dimension(668,50));
		bas.setBackground(Color.WHITE);
		bas.add(ecranBas, BorderLayout.WEST);
		haut.add(ecranHaut, BorderLayout.WEST);
		nord.setPreferredSize(new Dimension(550,80));
		nord.add(haut);
		nord.add(bas);


		jpan.add(nord,BorderLayout.NORTH);
		jpan.add(ouest, BorderLayout.WEST);
		jpan.add(est, BorderLayout.EAST);


		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				egal.requestFocusInWindow();
			}
		});
		radian.doClick(0);
		clear.setForeground(Color.RED);
		this.setVisible(true);

	}

	private Double factoriel(Double number) {
		long result = 1;

		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}

		return new Double(result);
	}

	private Double calculFunction(String p, String Bouton) {

		Double x=new Double(-66.0), parametre;

		if(!radian.isEnabled() && noRadian==false) {
			parametre = Math.toRadians(Double.parseDouble(p));//conversion en radians
		}else {
			parametre = Double.parseDouble(p);
			noRadian=false;
		}

		switch(Bouton) {

		case "cos":
			x=Math.cos(parametre);
			break;

		case "sin":
			x=Math.sin(parametre); 
			break;

		case "acos":
			x=Math.acos(parametre);
			break;

		case "asin":
			x=Math.asin(parametre);
			break;

		case "tan":
			x=Math.tan(parametre);
			break;

		case "atan":
			x=Math.atan(parametre);
			break;

		case "cosh":
			x=Math.cosh(parametre);
			break;

		case "sinh":
			x=Math.sinh(parametre);
			break;

		case "ln":
			x=Math.log(parametre);
			break;

		case "log":
			x=Math.log10(parametre);
			break;

		case "e^":
			x=Math.exp(parametre);
			break;

		case "\u221A":
			x=Math.sqrt(parametre);
			break;
		case "!":
			x=factoriel(parametre);
			break;


		default:
			x=-66.0;

		}

		return x;
	}

	class EgalListener implements KeyListener, ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if( function == true) {

				provisoire = calculFunction(insider, TextBouton);

				if(provisoire !=-66.0) {

					chaine+=String.valueOf(provisoire) ;
					ecranHaut.setText(TextBouton + insider + "= " + String.valueOf(provisoire));
					function = false;
					insider = "";
					ecranBas.setText(chaine);
					if( haveParentheses == true) {
						inside = op.parOp(chaine);
						inside = chaineop.calcul(inside);
						haveParentheses = false;

					}
					chaine= chaineop.calcul(chaine);
					resultat = Double.parseDouble(chaine);
					//reinitialisation des variables
					insider="";
					function = false;
					ecranHaut.setText(ecranBas.getText()+"="+String.valueOf(resultat));
					ecranBas.setText(chaine);

				}else {
					ecranBas.setText(Erreur);
				}


			}else {
//				if( haveParentheses == true) {
//					System.out.println(chaine+"-->chaine");
					inside = op.parOp(chaine);
//					System.out.println(inside+"-->inside apres parOP");
					inside = chaineop.calcul(inside);
//					System.out.println(inside+"-->inside apres chaineOP");
					haveParentheses = false;

//				}
				chaine = inside;
				resultat = Double.parseDouble(chaine);
				//reinitialisation des variables
				insider="";
				function = false;
				ecranHaut.setText(ecranBas.getText()+"="+String.valueOf(resultat));
				ecranBas.setText(chaine);
				chaine="";
				insider="";

			}



		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			if(arg0.getKeyCode()==96 || arg0.getKeyChar()=='0') {
				zero.doClick();
			}
			if(arg0.getKeyCode()==97|| arg0.getKeyChar()=='1') {
				un.doClick();
			}
			if(arg0.getKeyCode()==98 || arg0.getKeyChar()=='2' ) {
				deux.doClick();
			}
			if(arg0.getKeyCode()==99 || arg0.getKeyChar()=='3') {
				trois.doClick();
			}
			if(arg0.getKeyCode()==100 || arg0.getKeyChar()=='4') {
				quatre.doClick();
			}
			if(arg0.getKeyCode()==101 || arg0.getKeyChar()=='5') {
				cinq.doClick();
			}
			if(arg0.getKeyCode()==102 || arg0.getKeyChar()=='6') {
				six.doClick();
			}
			if(arg0.getKeyCode()==103 || arg0.getKeyChar()=='7') {
				sept.doClick();
			}
			if(arg0.getKeyCode()==104 || arg0.getKeyChar()=='8') {
				huit.doClick();
			}
			if(arg0.getKeyCode()==105 || arg0.getKeyChar()=='9') {
				neuf.doClick();
			}
			//operateurs
			if(arg0.getKeyChar()=='*') {
				mult.doClick();
			}
			if(arg0.getKeyChar()=='/') {
				div.doClick();
			}
			if(arg0.getKeyChar()=='-') {
				moins.doClick();
			}
			if(arg0.getKeyChar()=='+') {
				plus.doClick();
			}
			if(arg0.getKeyChar()=='.') {
				point.doClick();
			}

			else {
				Integer i= new Integer(arg0.getKeyCode());
				if( (i==null) && (arg0.getKeyLocation()==0) ) {
					egal.doClick();
				}

			}

		}

	}





	class pointListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ecranBas.setText(ecranBas.getText()+".");
			chaine+=".";
			pointPresent=true;
			//					ecranBasHaut.setText(ecranBasBas.getText());

		}

	}
	class plusOuMoinsListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ecran="";
			ecran = ecranBas.getText();
			if(DoesHaveOP(ecran)==false) {
				ecranBas.setText(String.valueOf( (Double.valueOf(ecran)) * (-1)));
			}
		}
	}
	class ChiffrierListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//on teste si ce qui est affiche sur l'ecranBasBas est egal au dernier resultat
			if(ecranBas.getText().equals(String.valueOf(resultat)) || ecranBas.getText().equals("0.0")) {
//				System.out.println("in");
				//ecranHaut.setText(chaine+" ="+String.valueOf(resultat));
				ecranBas.setText( ((JButton) arg0.getSource()).getText() );
				chaine+= ((JButton) arg0.getSource()).getText();

			}else {
				//il y a un operateur comme log ou sin qui attend un parametre
				if(function == true) {
//					ecranBas.setText(ecranBas.getText()+ ((JButton) arg0.getSource()).getText());
					insider+= ((JButton) arg0.getSource()).getText();
					ecranHaut.setText(ecranHaut.getText()+insider);
				}else {
					//pas d'operateurs comme log ou cos
					chaine += ( (JButton) arg0.getSource() ).getText();
					ecranBas.setText(chaine);
				}
			}
		}

	}

	class exposant implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {


			if(ecranBas.getText().equals("")) {
				ecranBas.setText("Erreur, pressez CE");

			}else {
				chaine+="^";
				ecranBas.setText(ecranBas.getText()+"^");

			}


		}

	}
	private boolean DoesHaveOP(String a) {
		if( a.contains("+") || a.contains("-") ||  a.contains("*") ||  a.contains("/") ) {
			return true;

		}else {
			return false;
		}
	}
	private boolean DoesHaveOP(char a) { 
		if( a=='+' || a=='-' ||  a=='*' || a=='/' || a=='.' || a=='^') {
			return true; 

		}else { 
			return false;
		}
	}

	class FunctionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean hasOperator=false;
			hasOperator = DoesHaveOP(ecranBas.getText());
			TextBouton = ( (JButton) arg0.getSource() ).getText();

			if( (ecranBas.getText().equals(String.valueOf(resultat)) ) || (hasOperator==false) ) {
				switch(TextBouton) {

				case "ln":
					noRadian=true;
					break;

				case "log":
					noRadian=true;
					break;

				case "e^":
					noRadian=true;
					break;

				case "\u221A":
					noRadian=true;
					break;

				case "!":
					noRadian=true;
					break;

				default:
					noRadian=false;

				}
				resultat = calculFunction( ecranBas.getText(), TextBouton );
//				System.out.println(resultat);
				if(resultat != -66.0) {
					ecranHaut.setText(TextBouton+ecranBas.getText()+" = "+String.valueOf(resultat));
					ecranBas.setText(String.valueOf(resultat));
					chaine+=String.valueOf(resultat);

				}else {
					ecranBas.setText(Erreur);
				}



			} else {

				function = true;

				switch(TextBouton) {

				case "ln":
					noRadian=true;
					break;

				case "log":
					noRadian=true;
					break;

				case "e^":
					noRadian=true;
					break;

				case "\u221A":
					noRadian=true;
					break;

				case "!":
					noRadian=true;
					break;

				default:
					noRadian=false;

				}


				ecranHaut.setText(TextBouton);

			}//fin else
		}//fin methode


	}



	class clearListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resultat=null;
			haveParentheses= false;
			inside="";
			insider="";
			chaine="";
			noRadian=false;
			chainResult="";
			function =false;
			ecranBas.setText("0");
			ecranHaut.setText("");

		}
	}
	class modeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(( (JButton) e.getSource()).getText().equals("RD")) {
				( (JButton) e.getSource()).setBackground(Color.CYAN);
				( (JButton) e.getSource()).setForeground(Color.black);
				( (JButton) e.getSource()).setOpaque(true);
				//				( (JButton) e.getSource()).setBorder(BorderFactory.createRaisedSoftBevelBorder());				
				( (JButton) e.getSource()).setEnabled(false);
				degre.setEnabled(true);
				degre.setBackground(Color.LIGHT_GRAY);


			}else {
				( (JButton) e.getSource()).setBackground(Color.CYAN);
				( (JButton) e.getSource()).setForeground(Color.black);
				( (JButton) e.getSource()).setOpaque(true);
				//				( (JButton) e.getSource()).setBorder(BorderFactory.createRaisedSoftBevelBorder());
				( (JButton) e.getSource()).setEnabled(false);
				radian.setEnabled(true);
				radian.setBackground(Color.LIGHT_GRAY);

			}
		}

	}
	class paranthese implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {


			haveParentheses = true;
			if(ecranBas.getText().equals("0") || ecranBas.getText().equals(""+resultat)) {
				ecranBas.setText(((JButton) arg0.getSource()).getText());
			}else {
				ecranBas.setText(ecranBas.getText()+ ((JButton) arg0.getSource()).getText());

			}
			chaine+=((JButton) arg0.getSource()).getText();
		}

	}
	class ArithmetiqueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if( function == true ) {
				provisoire = calculFunction(insider, TextBouton);

				if(provisoire !=-66.0) {

					chaine+=String.valueOf(provisoire) ;
					ecranHaut.setText(TextBouton + insider + "= " + String.valueOf(provisoire));
					function = false;
					insider = "";
					chaine += ( (JButton) arg0.getSource() ).getText();
					ecranBas.setText(chaine);

				}else {
					ecranBas.setText(Erreur);
				}
			}
			else {
				//pas de function
				if(chaine.equals("")) {
					chaine+=ecranBas.getText();
				}

				if(DoesHaveOP(chaine.charAt(chaine.length()-1))==true) {
					ecranBas.setText(Erreur);
				}else {


					chaine+=( (JButton) arg0.getSource() ).getText();
					ecranBas.setText(ecranBas.getText()+( (JButton) arg0.getSource() ).getText()); 
				}

			}
		}

	}







}
