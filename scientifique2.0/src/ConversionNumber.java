import java.math.BigDecimal;

public class ConversionNumber {
	private double number;
	// Methode permettant d'arrondir les nombres
	public double arrondi(double nombre) {
		this.number=nombre;
		double result;
		BigDecimal bd = new BigDecimal(number);
		bd= bd.setScale(3,BigDecimal.ROUND_UP);
		result = bd.doubleValue();
		return result;
	}

	// methode permettant d'effacer les espaces dans une chaine de caractere
	public String deleteSpaces (String text) {
		String textwithoutspace = text.replaceAll("\\s", "");
		return textwithoutspace;
	}
	public boolean isNumber(String chaine) {
		boolean temoin=true;
		char number[]= {'0','1','2','3','4','5','6','7','8','9'};
		if(chaine.charAt(0)=='-') {
			for (int j = 1; j < chaine.length(); j++) {
				char b = chaine.charAt(j);
				for (int i = 0; i < number.length; i++) {
					if(b!=number[i])
						temoin=false;
				}
			}
		}
		else {
			for (int j = 0; j < chaine.length(); j++) {


				char b = chaine.charAt(j);
				for (int i = 0; i < number.length; i++) {
					if(b!=number[i])
						temoin=false;
				}
			}
		}

		return temoin;
		

	}
}