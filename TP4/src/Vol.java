public class Vol {

String identifiant;
//ZonedDateTime depart = new ZonedDateTime;
//ZonedDateTime arrivee = new ZonedDateTime;
public static int depart;
public static int arrivee;

	public static int duree() {
		return arrivee-depart;
	}

	public static void ouvrir() {

		System.out.println("vol ouvert");

	}

	public static void fermee() {

		System.out.println("vol fermé");
	}

}
