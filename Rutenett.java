class Rutenett {
    int antRader, antKolonner;
    Celle[][] rutene;

    Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol) {
        if(rutene[rad][kol] != null) {
            System.out.println("[ERROR] Det finnes en celle paa angitt plass. Celle ikke opprettet.");
            return;
        }
        
        try {
            Celle nyCelle = new Celle();
            if(Math.random() <= 0.3333) nyCelle.settLevende();
            rutene[rad][kol] = nyCelle;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] Ugyldige cellekoordinater. Celle ikke opprettet.");   
        }
    }
    
    public void fyllMedTilfeldigeCeller() {
        for(int rad = 0; rad < antRader; rad++) {
            for(int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

    public Celle hentCelle(int rad, int kol) {
        try {
            Celle celle = rutene[rad][kol];
            if(celle == null) throw new NullPointerException();
            return celle;
        } catch (Exception e) {
            // ArrayIndexOutOfBoundsException eller NullointerException
            return null;
        }
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
        Celle celle = hentCelle(rad, kol);
        try {
            if(celle == null) throw new NullPointerException();
        } catch(NullPointerException e) {
            System.out.println("Cellen eksisterer ikke, og kan ikke ha naboer.");
            return;
        }
        
        for(int r = -1; r <= 1; r++) {
            for (int k = -1; k <= 1; k++) {
                
                // Hopper over cellen selv (celler er ikke sin egen nabo)
                if(r == 0 && k == 0) continue;
                
                Celle nabo = hentCelle(rad+r, kol+k);
                if(nabo != null) {
                    // Legger til nabo hvis man er innenfor brettet
                    celle.leggTilNabo(nabo);
                }
            }
        }
    }

    public void kobleAlleCeller() {
        for(int rad = 0; rad < antRader; rad++) {
            for(int kol = 0; kol < antKolonner; kol++) {
                settNaboer(rad, kol);
            }
        }
    }

    public int antallLevende() {
        int antallLevende = 0;
        for(int rad = 0; rad < antRader; rad++) {
            for(int kol = 0; kol < antKolonner; kol++) {
                Celle celle = rutene[rad][kol];
                if(celle != null && celle.erLevende()) {
                    antallLevende++;
                }
            }
        }
        return antallLevende;
    }
}
