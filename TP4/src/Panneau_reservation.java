import java.util.Scanner;

public class Panneau_reservation {

private static Scanner sc = new Scanner(System.in);
private static Client client1 = new Client();
private static Vol vol1 = new Vol();
private static Reservation reservation1 = new Reservation();
private static Passager passager1 = new Passager();
private static int i = 0;
private static double ident = 0;


	public static void main(String[] args) {

		vol1.identifiant = "Paris-Tokyo";
		vol1.depart = 10;
		vol1.arrivee = 23;


		System.out.println("Entrez votre nom : ");
		client1.nom = sc.nextLine();
		client1.paiement = "non payé";
		System.out.println("Entrez votre numéro de tel : ");
		client1.contact = sc.nextLine();
		client1.reference = client1.nom + client1.contact;

		System.out.println("Vos informations : \n Nom : " + client1.nom + "\n Paiement reservation : " + client1.paiement + "\n Numéro de téléphone : " + client1.contact + "\n Référence client : " + client1.reference + "\n"); 


		System.out.println("Vous effectuez une reservation pour le vol  " + vol1.identifiant);
		ident++;
		reservation1.identifiant = ident;

		System.out.println("Voules-vous payer(1) ou annuler(2)");
		int val = sc.nextInt();

		while(val != 1 && val != 2) {
			System.out.println("Voulez-vous payer(1) ou annuler(2) :");
			 val = sc.nextInt();
			if(val == 1) reservation1.payer();
			else if(val == 2) {
				reservation1.annuler();
				System.out.println("Reservation annulée");
				System.exit(0);
			}
			else System.out.println("Choix invalide : veuillez recommencer");
		}

		System.out.println("Voulez-vous confirmer(1) ou annuler(2)");
		int val2 = sc.nextInt();
		while(val2 != 1 && val2 != 2) {
			System.out.println("Confirmer(1) ou Annuler (2)");
			val2 = sc.nextInt();
			if(val2==1) reservation1.confirmer();
			else if(val2 == 2) {
				reservation1.annuler();
				System.out.println("reservation annulée");
				System.exit(0);
			}
			else System.out.println("Choix invalide : veuillez recomencer");
		}

		System.out.println("Confirmation effectuée");
		System.out.println("L'identifiant de votre réservation est : " + reservation1.identifiant);
		System.out.println("Le vol par à " + vol1.depart + "h" + "et arrive à " + vol1.arrivee + "h");
		System.out.println("La durée du trajet est de : " + vol1.duree() + "h");

		passager1.nom = client1.nom;
		passager1.contact = client1.contact;

	}
}
