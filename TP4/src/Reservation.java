public class Reservation {

public static Double identifiant;
public static String etat;


	public static void annuler() {
		etat = "annulée";
	}

	public static void confirmer() {

		etat = "confirmée";
	}

	public static void payer() {
			etat = "payée";
	}

}
