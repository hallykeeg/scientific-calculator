public class OperationDetection {
	private String opName;

	public boolean additionVeri(String opName) {

		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		for(int i=0; i<opName.length(); i++ ) {
			if (opName.charAt(i)=='+')
				temoin=true;
		}
		if (!temoin) // resultat negatif
			return false;
		else // resultat positif
			return true;
	}

	// Methode de detection d'une operation multiplication

	public boolean multiplicationVeri(String chaine) {
		opName= chaine;
		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		for(int i=0; i<opName.length(); i++ ) {
			if (opName.charAt(i)=='*')
				temoin=true;
		}
		if (!temoin) // resultat negatif
			return false;
		else // resultat positif
			return true;

	}

	// Methode de detection d'une operation de soustraction

	public boolean soustractionVeri(String chaine) {
		opName= chaine;
		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		boolean moins= false;
		int compt=0;
		//double resultat;
		if(chaine.charAt(0)=='-')
			moins=true;
		for (int i = 0; i < chaine.length(); i++) {
			char element = chaine.charAt(i);
			if(element =='-' || element =='+' || element =='*' || element =='/' ) {
				compt++;
			}
		}
		if(moins==true && compt==1) {
			return false;
		}
		else {
			for(int i=0; i<opName.length(); i++ ) {
				if (opName.charAt(i)=='-')
					temoin=true;
			}
			if (!temoin) // resultat negatif
				return false;
			else // resultat positif
				return true;
		}

	}

	// Methode de detection d'une operation de  division

	public boolean divisionVeri(String chaine) {
		opName= chaine;
		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		for(int i=0; i<opName.length(); i++ ) {
			if (opName.charAt(i)=='/')
				temoin=true;
		}
		if (!temoin) // resultat negatif
			return false;
		else // resultat positif
			return true;
	}
	// Methode de detection d'une operation de  puissance

	public boolean puissanceVeri(String chaine) {
		opName= chaine;
		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		for(int i=0; i<opName.length(); i++ ) {
			if (opName.charAt(i)=='^')
				temoin=true;
		}
		if (!temoin) // resultat negatif
			return false;
		else // resultat positif
			return true;
	}
	// Methode de detection d'une operation de  puissance

	public boolean racineVeri(String chaine) {
		opName= chaine;
		boolean temoin=false; // temoin pour savoir s'il y a une telle operation
		for(int i=0; i<opName.length(); i++ ) {
			if (opName.charAt(i)=='\u221A')
				temoin=true;
		}
		if (!temoin) // resultat negatif
			return false;
		else // resultat positif
			return true;
	}
	
}
