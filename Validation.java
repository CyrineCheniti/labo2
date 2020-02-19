public class Validation {

    public static final String MSG_ERREUR = "erreurs";
    public static final String MSG_ERREUR1 = "Uniquement le cycle \"2018-2020\" sera supporté";
    public static final String MSG_ERREUR2 = "Les activités déclarées doivent avoir été complétées entre le\n" +
            "1er avril 2018 et le 1er avril 2020";
    public static final String MSG_ERREUR3 ="Toutes les activités doivent appartenir à une des catégories reconnues";
    public static final String MSG_ERREUR4 ="Ce nombre ne doit pas être supérieur à 7";

    private static boolean verifieCycle(String cycle) {
        boolean test = true;

        if (cycle != "2018-2020") {
            test = false;
        }

        return test;
    }

    public static String afficherErreur1(String cycle) {
        String message = null;

        if (!verifieCycle(cycle)) {
            message = MSG_ERREUR1;
        }

        return message;
    }




    private static boolean verifieDate(String date) {
        boolean test = true;
        int année = Integer.parseInt(date.substring(0,4));
        int mois = Integer.parseInt(date.substring(5,7));
        int jour = Integer.parseInt(date.substring(8,10));
        if (année<2018){
            test=false;
        }else if (année==2018) {
            if (mois<4) {
                test = false;
            }
        }else if (année==2020) {
            if (mois > 4) {
                test = false;
            } else if (mois == 4) {
                if (jour > 1) {
                    test = false;
                }
            }

        }else if (année>2020){
            test=false;
        }

        return test;
    }

    public static String afficherErreur2(String date) {
        String message = null;

        if (!verifieDate(date)) {
            message = MSG_ERREUR2;
        }

        return message;
    }

    public static boolean vériferCatégories(String catégorie) {
        boolean test = true;
        if (catégorie != "cours" &&  catégorie != "atelier" && catégorie != "séminaire" && catégorie != "colloque"
                && catégorie != "conférence" && catégorie != "lecture dirigée" &&  catégorie != "présentation"
                && catégorie != "groupe de discussion"  && catégorie != "projet de recherche"
                && catégorie != "rédaction professionnelle"
        ) {
            test = false;
        }
        return test;

    }
    public static String afficherErreur3(String catégorie) {
        String message = null;

        if (!vériferCatégories(catégorie)) {
            message = MSG_ERREUR3;
        }

        return message;
    }
    public static boolean vériferheures (int heures_transferees_du_cycle_precedent) {
        boolean test = true;

        if (heures_transferees_du_cycle_precedent<0 || heures_transferees_du_cycle_precedent>7){
            test = false;
        }
        return test;

    }
    public static String afficherErreur4(int heures_transferees_du_cycle_precedent ) {
        String message = null;

        if (!vériferheures(heures_transferees_du_cycle_precedent)) {
            message = MSG_ERREUR4;
        }

        return message;
    }
}

