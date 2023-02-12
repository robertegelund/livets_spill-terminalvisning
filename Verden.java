class Verden {
    Rutenett rutenett;
    int genNr = 0;
    
    Verden(int antRader, int antKolonner) {
        rutenett = new Rutenett(antRader, antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    public void tegn() {
        System.out.println("\nGenerasjon nr. " + genNr);
        rutenett.tegnRutenett();
        System.out.println("Det er " + rutenett.antallLevende() + " levende celler.\n");
    }
}
