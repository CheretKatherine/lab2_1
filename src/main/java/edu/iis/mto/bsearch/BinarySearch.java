/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Klasa implementująca wyszukiwanie binarne
 *
 */
public class BinarySearch {

    private BinarySearch() {}

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) {
        if(seq==null || seq.length<=0 || !checkArray(seq))
            throw new IllegalArgumentException();

        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }

        return result;
    }

    private static boolean checkArray(int[] seq) {
        for(int ind=0; ind < seq.length-1; ind++){
            if(seq[ind]>seq[ind+1])
                return false;
        }
        return true;
    }
}
