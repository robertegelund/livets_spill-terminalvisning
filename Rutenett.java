class Rutenett {
    int antRader, antKolonner;
    Celle[][] rutene;

    Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol) {
        if(!erRadKolLovlig(rad, kol) || (rutene[rad][kol] != null)) {
            //Avslutter metoden hvis ugyldig rad og/eller kolonne
            System.out.println("[ERROR] Ugyldig rutenettkoordinat: " + rad + ", " + kol);
            System.out.println("Celle er hverken laget eller plassert.");
            return;
        }

        Celle nyCelle = new Celle();
        if(Math.random() <= 0.3333) {
            nyCelle.settLevende();
        }
        rutene[rad][kol] = nyCelle;
    }
    
    public void fyllMedTilfeldigeCeller() {
        for(int rad = 0; rad < antRader; rad++) {
            for(int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

    public Celle hentCelle(int rad, int kol) {
        if(erRadKolLovlig(rad, kol)) {
            return rutene[rad][kol];
        }
        return null;
    }

    public void tegnRutenett() {
        for(int rad = 0; rad < antRader; rad++) {
            String ramme = "+";
            String tegn = "|";
            for(int kol = 0; kol < antKolonner; kol++) {
                ramme += "---+";
                tegn  += " " + rutene[rad][kol].hentStatusTegn() + " |";
            }
            System.out.println(ramme);
            System.out.println(tegn);
            if(rad == antRader-1) {
                System.out.println(ramme);
            }
        }
    }

    public void settNaboer(int rad, int kol) {
        
    }


    private boolean erRadKolLovlig(int rad, int kol) {
        if(rad >= antRader || kol >= antKolonner) {
            return false;
        } else if (rad < 0 || kol < 0) {
            return false;
        }
        return true;
    }

}
