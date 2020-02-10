public class Operation {


	public boolean isParenthese(String chaine) {
		boolean result=false;
		int compt1=0;
		int compt2=0;
		int lng=chaine.length();
		for (int i = 0; i < lng; i++) {
			char b=chaine.charAt(i);
			if(b=='(') {
				result=true;
				compt1++;
			}
			if(b==')')
				compt2++;
		}
		if(result==true && compt1==compt2)
			return true;
		else
			return false;
		//return result;
	}
	public String parenthese (String chaine) {
		ChaineOperation operation = new ChaineOperation();
		int compt1=0;
		int compt2=0;
		int position1=0;
		int position2=0;
		int lng=chaine.length();
		compt1=compt2;
		compt2=compt1;

		String result="";
		Operation op = new Operation();
		if(op.isParenthese(chaine)) {

			// control des parentheses
			for (int i = 0; i < lng; i++) {
				char b=chaine.charAt(i);
				if(b=='(') {
					compt1++;
					position1=i;
				}


			}
			// prise de la parenthese la plus au milieu
			char c='x';
			int i=position1;
			while((c!=')') && i<lng) {
				char b=chaine.charAt(i);
				if(b==')') {

					c=')';
					position2=i;

				}
				i++;

			}

			for (int j = position1 + 1; j < position2 ; j++) {
				result+=chaine.charAt(j);
			}


		}

		String bb = result;
		result="";
		for (int i = 0; i < position1; i++) {
			result+= chaine.charAt(i);
		}
		result+=operation.calcul(bb);
		for (int i = position2 + 1; i < lng; i++) {
			result+=chaine.charAt(i);

		}

		return result;

	}

	public String parOp (String chaine) {
		String result=chaine;
	//	double resultat=0;
		while(this.isParenthese(result)) {
			result= this.parenthese(result);
		}

		return result;
	}
	public boolean isExposant(String chaine) {
		boolean result=false;

		int lng=chaine.length();
		for (int i = 0; i < lng; i++) {
			char b=chaine.charAt(i);
			if(b=='^') {
				result=true;

			}

		}

		return result;
	}
	

}
