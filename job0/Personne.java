package job0;
import java.util.Scanner;
import java.util.Vector;

// ===================== PERSONNE =====================
abstract class Personne {
    protected int identite;
    protected String nomSocial;
    protected String adresse;

    protected Personne(int identite, String nomSocial, String adresse) {
        this.identite = identite;
        this.nomSocial = nomSocial;
        this.adresse = adresse;
    }

    public int getIdentite() { return identite; }
    public void setIdentite(int identite) { this.identite = identite; }
    public String getNomSocial() { return nomSocial; }
    public void setNomSocial(String nomSocial) { this.nomSocial = nomSocial; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public void affiche() {
        System.out.println("ID: " + identite + " | Nom: " + nomSocial + " | Adresse: " + adresse);
    }
}

// ===================== CLIENT =====================
class Client extends Personne {
    private double chiffreAffaire;

    public Client(int identite, String nomSocial, String adresse, double chiffreAffaire) {
        super(identite, nomSocial, adresse);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire() { return chiffreAffaire; }
    public void setChiffreAffaire(double ca) { this.chiffreAffaire = ca; }

    @Override
    public void affiche() {
        super.affiche(); // affiche les infos Personne
        System.out.println("Chiffre d'affaire: " + chiffreAffaire);
    }
}

// ===================== ARTICLE =====================
class Article {
    private String reference;
    private String designation;
    private double prixUnitaire;
    private int quantiteStock;

    public Article(String reference, String designation, double prixUnitaire, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }

    // Constructeur par copie
    public Article(Article a) {
        this.reference = a.reference;
        this.designation = a.designation;
        this.prixUnitaire = a.prixUnitaire;
        this.quantiteStock = a.quantiteStock;
    }

    public String getReference() { return reference; }
    public String getDesignation() { return designation; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public int getQuantiteStock() { return quantiteStock; }

    public void affiche() {
        System.out.println("Ref: " + reference + " | " + designation +
                " | Prix: " + prixUnitaire + " | Stock: " + quantiteStock);
    }
}

// ===================== COMMANDE =====================
class Commande {
    private int numeroCommande;
    private String dateCommande;
    private Client client;

    public Commande(int numeroCommande, String dateCommande, Client client) {
        this.numeroCommande = numeroCommande;
        this.dateCommande = dateCommande;
        this.client = client;
    }

    public int getNumeroCommande() { return numeroCommande; }
    public String getDateCommande() { return dateCommande; }
    public Client getClient() { return client; }

    public void affiche() {
        System.out.println("Commande #" + numeroCommande + " du " + dateCommande);
        client.affiche();
    }
}

// ===================== LIGNE =====================
class Ligne {
    private Commande commande;
    private Article article;
    private int quantiteCommande;

    public Ligne(Commande commande, Article article, int quantiteCommande) {
        this.commande = commande;
        this.article = article;
        this.quantiteCommande = quantiteCommande;
    }

    public Commande getCommande() { return commande; }
    public Article getArticle() { return article; }
    public int getQuantiteCommande() { return quantiteCommande; }
}

// ===================== COMMERCIALE =====================
class Commerciale {
    private Vector<Article> articles = new Vector<>();
    private Vector<Client> clients = new Vector<>();
    private Vector<Commande> commandes = new Vector<>();
    private Vector<Ligne> lignes = new Vector<>();

    public void ajouterArticle(Article a) { articles.add(a); }
    public void supprimerArticle(Article a) { articles.remove(a); }

    public void ajouterClient(Client c) { clients.add(c); }
    public void supprimerClient(Client c) { clients.remove(c); }

    public void passerCommande(Commande c) { commandes.add(c); }
    public void annulerCommande(Commande c) { commandes.remove(c); }

    // ===================== MENU =====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Commerciale app = new Commerciale();
        int choix = -1;

        while (choix != 0) {
            System.out.println("--------Gestion commerciale-----------");
            System.out.println("1) Ajouter un article");
            System.out.println("2) Supprimer un article");
            System.out.println("3) Ajouter un client");
            System.out.println("4) Supprimer un client");
            System.out.println("5) Passer une commande");
            System.out.println("6) Annuler une commande");
            System.out.println("0) Quitter");
            System.out.print("Entrer un choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // vide le buffer

            switch (choix) {
                case 1:
                    System.out.print("Référence : "); String ref = sc.nextLine();
                    System.out.print("Désignation : "); String des = sc.nextLine();
                    System.out.print("Prix : "); double prix = sc.nextDouble();
                    System.out.print("Stock : "); int stock = sc.nextInt(); sc.nextLine();
                    app.ajouterArticle(new Article(ref, des, prix, stock));
                    System.out.println("Article ajouté !");
                    break;

                case 2:
                    if (app.articles.isEmpty()) { System.out.println("Aucun article."); break; }
                    System.out.println("Articles disponibles :");
                    for (int i = 0; i < app.articles.size(); i++) {
                        System.out.print(i + ") "); app.articles.get(i).affiche();
                    }
                    System.out.print("Numéro à supprimer : ");
                    int idxA = sc.nextInt(); sc.nextLine();
                    app.supprimerArticle(app.articles.get(idxA));
                    System.out.println("Article supprimé !");
                    break;

                case 3:
                    System.out.print("ID : "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nom : "); String nom = sc.nextLine();
                    System.out.print("Adresse : "); String adr = sc.nextLine();
                    System.out.print("Chiffre d'affaire : "); double ca = sc.nextDouble(); sc.nextLine();
                    app.ajouterClient(new Client(id, nom, adr, ca));
                    System.out.println("Client ajouté !");
                    break;

                case 4:
                    if (app.clients.isEmpty()) { System.out.println("Aucun client."); break; }
                    for (int i = 0; i < app.clients.size(); i++) {
                        System.out.print(i + ") "); app.clients.get(i).affiche();
                    }
                    System.out.print("Numéro à supprimer : ");
                    int idxC = sc.nextInt(); sc.nextLine();
                    app.supprimerClient(app.clients.get(idxC));
                    System.out.println("Client supprimé !");
                    break;

                case 5:
                    if (app.clients.isEmpty()) { System.out.println("Aucun client."); break; }
                    System.out.print("Numéro de commande : "); int num = sc.nextInt(); sc.nextLine();
                    System.out.print("Date (jj/mm/aaaa) : "); String date = sc.nextLine();
                    System.out.println("Choisir le client :");
                    for (int i = 0; i < app.clients.size(); i++) {
                        System.out.print(i + ") "); app.clients.get(i).affiche();
                    }
                    int idxCl = sc.nextInt(); sc.nextLine();
                    app.passerCommande(new Commande(num, date, app.clients.get(idxCl)));
                    System.out.println("Commande passée !");
                    break;

                case 6:
                    if (app.commandes.isEmpty()) { System.out.println("Aucune commande."); break; }
                    for (int i = 0; i < app.commandes.size(); i++) {
                        System.out.print(i + ") "); app.commandes.get(i).affiche();
                    }
                    System.out.print("Numéro à annuler : ");
                    int idxCmd = sc.nextInt(); sc.nextLine();
                    app.annulerCommande(app.commandes.get(idxCmd));
                    System.out.println("Commande annulée !");
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }
        sc.close();
    }
}