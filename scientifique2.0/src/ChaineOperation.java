public class ChaineOperation {
	private String chaine;
	private char operationType;
	private ConversionNumber myNumber = new ConversionNumber();
	boolean error = false;
	private OperationDetection text = new OperationDetection();
	private boolean multiDiv=false;
	// le processus d'une operation dans une chaine
	public String processus(String b, char a) {
		String resultFinal="";
		if (!error) {
			chaine=b;
			operationType=a;
			int temp=0, position=0, temoin=0;
			int tempOperateur0, tempOperateur1, temp0, temp1, limit1=0, limit2=0;

			for (int i = 0; i < chaine.length()-1; i++) {
				StringBuilder mychaine = new StringBuilder(chaine);
				char sign = chaine.charAt(i);
				char signPlus=chaine.charAt(i+1);
				if(((sign=='*')|| (sign=='/') || (sign =='^') ||(sign =='v')) && (signPlus =='-')) {
					mychaine.deleteCharAt(i+1);
					multiDiv=true;
					chaine="";
					chaine+=mychaine;
				}

				else if((sign =='-') && signPlus=='-') {
					mychaine.delete(i, i+2);
					mychaine.insert(i, '+');
					chaine="";
					chaine+=mychaine;
					operationType='+';
				}
				else if((sign =='-') && signPlus=='+') {
					mychaine.delete(i, i+2);
					mychaine.insert(i, '-');
					chaine="";
					chaine+=mychaine;
					operationType='-';
				}
				else if((sign =='+') && signPlus=='-') {
					mychaine.delete(i, i+2);
					mychaine.insert(i, '-');
					chaine="";
					chaine+=mychaine;
					operationType='-';
				}
				else if((sign =='+') && signPlus=='+') {
					mychaine.delete(i, i+2);
					mychaine.insert(i, '+');
					chaine="";
					chaine+=mychaine;
					operationType='+';

				}


			}

			{
				while(temp<chaine.length() && temoin==0 )
				{
					char c = chaine.charAt(temp);
					// ce que l'on doit faire si on en trouve
					if (c!=operationType) {
						position++;
					}
					if (c==operationType) 
					{
						// tempOperateur0 c pour limite operationType gauche, et l'autre pour limite operationType droite
						// temp0 permet de situer limite operationType gauche, et l'autre operationType droite
						tempOperateur0=0;
						tempOperateur1=0;
						temp0=position;
						temp1=position;
						// tant que le temoin de limite ne se change pas et la location ne limite ne laisse pas la chaine
						while(tempOperateur0==0 && temp0!=0) {
							// on va vers la gauche
							temp0--;
							// si l'on trouve un autre operateur quelconque c'est qu'il y operationType une limite operationType l'operation * 
							if (chaine.charAt(temp0)=='*'|| chaine.charAt(temp0)=='-' || chaine.charAt(temp0)=='+' || chaine.charAt(temp0)=='/')
								// si oui alors le temoin se change
								tempOperateur0++;
						}
						// si le temoin se change, alors la limite temp0;
						if (tempOperateur0>0) {
							limit1=temp0;
						}

						while(tempOperateur1==0 && temp1!= chaine.length()-1) {
							temp1++;
							if (chaine.charAt(temp1)=='*'|| chaine.charAt(temp1)=='-' || chaine.charAt(temp1)=='+' || chaine.charAt(temp1)=='/')
								tempOperateur1++;
							if (tempOperateur1>=0) {
								limit2=temp1;
							}

						}
						temoin++;
					}
					temp=temp+1;
				}
			}


			String monNombregauche ="", monNombredroit="";
			// en dehors du while
			//Capture des nombres operationType gauche et operationType droite
			if (limit1==0 && chaine.charAt(limit1)!='-') {
				for(int i=limit1; i<position; i++ ) {
					monNombregauche = monNombregauche + chaine.charAt(i);
				}
			}
			else {
				for(int i=limit1+1; i<position; i++ ) {
					monNombregauche = monNombregauche + chaine.charAt(i);
				}
			}

			if (limit2==chaine.length()-1) {
				for (int i= position+1; i<= limit2; i++) {
					monNombredroit = monNombredroit + chaine.charAt(i);
				}
			}
			else {
				for (int i= position+1; i< limit2; i++) {
					monNombredroit = monNombredroit + chaine.charAt(i);
				}
			}

			// creation d'un objet de la classe ConversionNumber



			//System.out.println("ma position est: "+position);
			// conversion des nombres operationType gauche et operationType droite
			double monNombregauche1 = Double.parseDouble(monNombregauche);
			monNombregauche1= myNumber.arrondi(monNombregauche1);
			//droit

			double monNombredroit1 = Double.parseDouble(monNombredroit);
			monNombredroit1 = myNumber.arrondi(monNombredroit1);


			//System.out.println("nombre gauche est: "+ monNombregauche1);
			//System.out.println("nombre droit est: "+ monNombredroit1);
			// les calculs pour chaque operateur
			double result=0; // variable stockant le result de l'operation
			switch (operationType) {
			case 'v':
				if(multiDiv) {
					error=true;
				}
				else
					result= Math.pow(monNombredroit1, 1/monNombregauche1);
				break;
			case '^':
				if(multiDiv) {
					result= 1/ Math.pow(monNombregauche1, monNombredroit1 );
					multiDiv=false;
				}
				else
					result=  Math.pow(monNombregauche1, monNombredroit1 );
				break;
			case '*':
				if(multiDiv) {
					result= -monNombregauche1*monNombredroit1;
					multiDiv=false;
				}

				else
					result= monNombregauche1*monNombredroit1;	
				break;
			case '/':
				if(monNombredroit1 == 0) {
					error=true;
				}
				else {
					if(multiDiv) {

						result= -monNombregauche1/monNombredroit1;
						multiDiv=false;
					}

					else
						result= monNombregauche1/monNombredroit1;

				}
				break;
			case '-':{
				if(chaine.charAt(limit1)=='-') //si l'operateur avant est -
					result= -monNombregauche1-monNombredroit1;
				else if(monNombregauche1>=monNombredroit1) // valeur abosolue nombre operationType gache plus grande
					result= monNombregauche1- monNombredroit1;
				else if(monNombregauche1<monNombredroit1) // sinon
					result= -1*( monNombredroit1-monNombregauche1);
			}

			break;
			case '+': {
				if(chaine.charAt(limit1)=='+') // si l'operateur avant est +
					result = monNombregauche1+monNombredroit1;
				else if(chaine.charAt(0)=='-') { // si le nombre operationType gauche est negatif
					if (monNombregauche1 >= monNombredroit1) 
						result =-( monNombregauche1-monNombredroit1);
					else 	// les autres cas
						result =	(monNombredroit1-monNombregauche1);
				}
				else 
					result = monNombregauche1+monNombredroit1;
			}

			break;

			default:
				break;
			}

			//	System.out.println("Le resultat est: " + resultMultiplication);
			double result1 =myNumber.arrondi(result); // result1 est l'arrondi du resultat
			String resultString = String.valueOf(result1); // conversion du resultat de double operationType String

			//	System.out.println("Le resultat est: " + resultMultiplication1);
			resultFinal=""; // variable stockant le resultat final
			if (operationType=='+' && chaine.charAt(limit1)=='-' && monNombregauche1 < monNombredroit1) {
				if(limit1!=0) {
					for (int i=0; i<limit1; i++) {
						resultFinal=resultFinal+ chaine.charAt(i);
					}
					resultFinal=resultFinal+'+';
					//	
				}
				resultFinal= resultFinal  + resultString;

				if (limit2!=chaine.length()-1) {
					for (int i=limit2; i<chaine.length(); i++) {
						resultFinal=resultFinal+ chaine.charAt(i);
					}
				}
			}


			else {
				if(limit1!=0) {
					for (int i=0; i<=limit1; i++) {
						resultFinal=resultFinal+ chaine.charAt(i);
					}
				}
				resultFinal= resultFinal + resultString;
				if (limit2!=chaine.length()-1) {
					for (int i=limit2; i<chaine.length(); i++) {
						resultFinal=resultFinal+ chaine.charAt(i);
					}
				}

			}
			//System.out.println(result + "\nmon nombre gauche: " + monNombregauche+ " mon Nombre droit: "+ monNombredroit) ;



		}
		if(error)
			return "000";
		else 
			return resultFinal;

	}



	public String multiplication (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, '*');
		return result;
	}
	// methode pour faire une addition
	public String addition (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, '+');
		return result;
	}
	// methode pour faire une division
	public String division (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, '/');
		return result;
	}
	// methode pour faire une soustraction
	public String soustraction (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, '-');
		return result;
	}
	// methode pour faire une puissance
	public String puissance (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, '^');
		return result;
	}
	// methode pour faire une puissance
	public String racine (String chaine) {
		String result="";
		ChaineOperation text = new ChaineOperation();
		result = text.processus(chaine, 'v');
		return result;
	}
	public String calcul (String chaine) {
		// detecter l'operation

		ChaineOperation texte = new ChaineOperation();
		String resultat="";
		// resultat
		if(error) {
			resultat = "error";
		}
		else {
			// puissance
			while (text.puissanceVeri(chaine)) {
				chaine=texte.puissance(chaine);
			}
			// racine
			while (text.racineVeri(chaine)) {
				chaine=texte.racine(chaine);
			}
			//division
			while (text.divisionVeri(chaine)) {
				chaine=texte.division(chaine);
			}
			//multiplication
			while (text.multiplicationVeri(chaine)) {
				chaine=texte.multiplication(chaine);
			}
			//addition
			while (text.additionVeri(chaine)) {
				chaine=texte.addition(chaine);
			}
			//soustraction
			while (text.soustractionVeri(chaine)) {
				chaine=texte.soustraction(chaine);
			}

			resultat=chaine;
		}

		return resultat;
		

	}

}
