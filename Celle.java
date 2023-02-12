class Celle{
    boolean levende;
    Celle[] naboer = new Celle[8];
    int antNaboer = 0;
    int antLevendeNaboer = 0;
    
    Celle() {
        levende = false;
    }

    public void settLevende() {
        levende = true;
    }

    public void settDoed() {
        levende = false;
    }

    public boolean erLevende() {
        return levende;
    }

    public char hentStatusTegn() {
        // Bruker ternary operator til if-sjekk
        return levende ? 'O' : '.';
    }

    public void leggTilNabo(Celle nabo) {
        if(antNaboer < 8) {
            naboer[antNaboer] = nabo;
            antNaboer++;
        } else {
            System.out.println("Cellen har allerede 8 naboer!");
        }
    }

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for(Celle nabo : naboer) {
            if(nabo != null && nabo.erLevende()) {
                antLevendeNaboer++;
            }
        }
    }

    public void oppdaterStatus() {
        boolean skalSettesDoed = levende && (antLevendeNaboer < 2 || antLevendeNaboer > 3);
        boolean skalSettesLevende = !levende && antLevendeNaboer == 3;
        if(skalSettesDoed) {
            settDoed(); 
        } else if(skalSettesLevende) {
            settLevende();
        }
    }
}