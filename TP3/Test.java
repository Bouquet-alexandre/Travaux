/* Ce programme permet de tester une valeur entrée par l'utilisateur.
Cette valeur (entier ou chaine de caractere) est stockée dans un type string.

Celle-ci passe par les tests unitaires : une message d'erreur est déclenchée
si un test detecte une erreur sur la valeur.

Enfin, les deux methodes fromRoman et toRoman permettent de renvoyer des valeurs
entières ou romaines connues.

*/





import java.util.Scanner;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.Map;

public class Test{

public static HashMap<Integer, String> KNOWN_VALUES = new HashMap<>();
	static {
    KNOWN_VALUES.put(1, "I");
    KNOWN_VALUES.put(2, "II");
    KNOWN_VALUES.put(3, "III");
    KNOWN_VALUES.put(4, "IV");
    KNOWN_VALUES.put(5, "V");
    KNOWN_VALUES.put(6, "VI");
    KNOWN_VALUES.put(7, "VII");
    KNOWN_VALUES.put(8, "VIII");
    KNOWN_VALUES.put(9, "IX");
    KNOWN_VALUES.put(10, "X");
    KNOWN_VALUES.put(50, "L");
    KNOWN_VALUES.put(100, "C");
    KNOWN_VALUES.put(500, "D");
    KNOWN_VALUES.put(1000, "M");
    KNOWN_VALUES.put(31, "XXXI");
    KNOWN_VALUES.put(148, "CXLVIII");
    KNOWN_VALUES.put(294, "CCXCIV");
    KNOWN_VALUES.put(312, "CCCXII");
    KNOWN_VALUES.put(421, "CDXXI");
    KNOWN_VALUES.put(528, "DXXVIII");
    KNOWN_VALUES.put(621, "DCXXI");
    KNOWN_VALUES.put(782, "DCCLXXXII");
    KNOWN_VALUES.put(870, "DCCCLXX");
    KNOWN_VALUES.put(941, "CMXLI");
    KNOWN_VALUES.put(1043, "MXLIII");
    KNOWN_VALUES.put(1110, "MCX");
    KNOWN_VALUES.put(1226, "MCCXXVI");
    KNOWN_VALUES.put(1301, "MCCCI");
    KNOWN_VALUES.put(1485, "MCDLXXXV");
    KNOWN_VALUES.put(1509, "MDIX");
    KNOWN_VALUES.put(1607, "MDCVII");
    KNOWN_VALUES.put(1754, "MDCCLIV");
    KNOWN_VALUES.put(1832, "MDCCCXXXII");
    KNOWN_VALUES.put(1993, "MCMXCIII");
    KNOWN_VALUES.put(2074, "MMLXXIV");
    KNOWN_VALUES.put(2152, "MMCLII");
    KNOWN_VALUES.put(2212, "MMCCXII");
    KNOWN_VALUES.put(2343, "MMCCCXLIII");
    KNOWN_VALUES.put(2499, "MMCDXCIX");
    KNOWN_VALUES.put(2574, "MMDLXXIV");
    KNOWN_VALUES.put(2646, "MMDCXLVI");
    KNOWN_VALUES.put(2723, "MMDCCXXIII");
    KNOWN_VALUES.put(2892, "MMDCCCXCII");
    KNOWN_VALUES.put(2975, "MMCMLXXV");
    KNOWN_VALUES.put(3051, "MMMLI");
    KNOWN_VALUES.put(3185, "MMMCLXXXV");
    KNOWN_VALUES.put(3250, "MMMCCL");
    KNOWN_VALUES.put(3313, "MMMCCCXIII");
    KNOWN_VALUES.put(3408, "MMMCDVIII");
    KNOWN_VALUES.put(3501, "MMMDI");
    KNOWN_VALUES.put(3610, "MMMDCX");
    KNOWN_VALUES.put(3743, "MMMDCCXLIII");
    KNOWN_VALUES.put(3844, "MMMDCCCXLIV");
    KNOWN_VALUES.put(3888, "MMMDCCCLXXXVIII");
    KNOWN_VALUES.put(3940, "MMMCMXL");
    KNOWN_VALUES.put(3999, "MMMCMXCIX");
	}


  public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	System.out.println("Entrée un chiffre romain ou un chiffre : celui-ci sera vérifié  ");
	String str = sc.nextLine();

	//Les tests
	supperieurZero(str);
	valeurNonEntiere(str);
	valeurSortantInterval(str);
	repetitionSymbole(str);
	repetitionPair(str);
	antecedentsIncorrects(str);
	fromRoman(str);
	toRoman(str);
	testFromToRoman(str);
  }

 public static int supperieurZero(String v) {
	int val = Integer.parseInt(v);
	if(val <= 0) {
		System.out.println("Erreur : valeur entrée inférieur ou égal à zero");
		return 1;
	}
	return 0;
  }

 public static int valeurNonEntiere(String v) {
	//int val = Integer.parseInt(v);

	try {
		Integer.parseInt(v);
	} catch (Exception e) {
		System.out.println("Erreur : valeur entrée non entière");
		return 1;
	}
	return 0;
  }

  public static int valeurSortantInterval(String v) {
	int val = Integer.parseInt(v);
	if(val < 1 | val > 3999) {
		System.out.println("valeur sortant de l'interval [1,3999]");
		return 1;
	}
	return 0;
  }

  public static int repetitionSymbole(String v) {
	int longueur = v.length();
	int i=0, nbI=0, nbV=0, nbX=0, nbL=0, nbC=0, nbD=0, nbM=0;

	for(i=0;i<longueur;i++) {
		if(v.substring(i,i+1).equals("I")) {
			nbV++; nbV=0; nbX=0; nbL=0; nbC=0; nbD=0; nbM=0;
				if(nbI>3) {
					System.out.println("Erreur : plus de 3 symbole I répétés");
					 return 1;
				}
		}
		else if(v.substring(i,i+1) == "V") {
			nbV++; nbI=0; nbX=0; nbL=0; nbC=0; nbD=0; nbM=0;
				if(nbV>1){
					System.out.println("Erreur : plus d'un symbole V répété");
					 return 1;
				}
		}
		else if(v.substring(i,i+1).equals("X")) {
			nbX++; nbI=0; nbV=0; nbL=0; nbC=0; nbD=0; nbM=0;
			System.out.println("x = " + nbX);
				if(nbX>3) {
					System.out.println("Erreur : plus de 3 symbole X répétés");
					return 1;
				}
		}
		else if(v.substring(i,i+1) == "L") {
			nbL++; nbI=0; nbV=0; nbX=0; nbC=0; nbD=0; nbM=0;
				if(nbL>1) {
					System.out.println("Erreur : plus d'un symbole L répété");
					 return 1;
				}
		}
		else if(v.substring(i,i+1) == "C") {
			nbC++; nbI=0; nbV=0; nbX=0; nbL=0; nbD=0; nbM=0;
				if(nbC>3) {
					System.out.println("Erreur : plus de 3 symbole C répété");
					return 1;
				}
		}
		else if(v.substring(i,i+1) == "D") {
			nbD++; nbI=0; nbV=0; nbX=0; nbL=0; nbC=0; nbM=0;
				if(nbD>1) {
					System.out.println("Erreur : plus d'un symbole D répété");
					return 1;
				}
		}
		else if(v.substring(i,i+1) == "M") {
			nbM=0; nbI=0; nbV=0; nbX=0; nbL=0; nbC=0; nbD=0;
				if(nbM>3) {
					System.out.println("Erreur : plus de 3 symbole M répétés");
					 return 1;
				}
		}
		else  return 1; //Cela voudrait dire qu'un des symbole n'est pas conforme
	}
	return 0;
  }


  public static int repetitionPair(String v) {
	int i=0, y=0, z=0;
	String lettre;
	int longueur = v.length();
	for(i=0;i<longueur;i++) {
		lettre = v.substring(i,i+1);
		for(y=i+1;y<longueur;y++) {
			if(!lettre.equals(v.substring(y,y+1))) {
				z=1;
			}
			else if(z==1 && lettre.equals(v.substring(y,y+1))) {
				z=2;
			}
			else if(z>2 && lettre.equals(v.substring(y,y+1))) {
				System.out.println("Erreur : repetition de paires de " + lettre);
				return 1;
			}
		}
		z=0;
	}

	return 0;
  }


  public static int antecedentsIncorrects(String v) {
	int i = 0;
	int longueur = v.length();

	for(i=0;i<longueur;i++) {
		if(i<longueur-1 && v.substring(i,i+2).equals("VX")) {
			System.out.println("Erreur : une suite VX detectée");
			return 1;
		}
		if( i<longueur-2 && v.substring(i,i+3).equals("XCX")) {
			System.out.println("Erreur : une suite XCX detectée");
			return 1;
		}

	}
	return 0;
  }

  public static int fromRoman(String v) {
	//int val = KNOWN_VALUES.get(v);
	int valeur_entiere = 0;
	for(int key : KNOWN_VALUES.keySet()) {
		String value = KNOWN_VALUES.get(key);
		if(value.equals(v)) {
		valeur_entiere = key;
		break;
		}
	}

	if(valeur_entiere == 0) return 1;
	else System.out.println("la valeur entière est  : " + valeur_entiere);
	return valeur_entiere;
  }

  public static String toRoman(String v) {
	String valeur_Romaine = "";
	int cle = Integer.parseInt(v);
	valeur_Romaine = KNOWN_VALUES.get(cle);

	if(valeur_Romaine == null) System.out.println("La valeur romaine n'est pas connue pour ce nombre");
	else System.out.println("la valeur romaine est : " + KNOWN_VALUES.get(cle));
	return valeur_Romaine;
  }

  public static int testFromToRoman(String v) {
	int val_compare = fromRoman(toRoman(v));
	int val = Integer.parseInt(v);

	if(val != val_compare) {
		System.out.println("Erreur : valeur de départ differente de la valeur transformée");
		return 1;
	}
	else System.out.println("Valeur conforme après transformation");
	return 0;
  }
}

