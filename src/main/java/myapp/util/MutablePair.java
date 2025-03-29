package myapp.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * @brief Contenitore per una coppia di oggetti.
 *
 * Questa classe fornisce un'implementazione per una coppia di oggetti di tipi generici.
 * Fornisce metodi per ottenere e impostare i valori della coppia e per verificare
 * l'uguaglianza tra due coppie.
 *
 * @param <F> Tipo del primo oggetto nella coppia.
 * @param <S> Tipo del secondo oggetto nella coppia.
 */
public class MutablePair<F, S> implements Serializable {
    
    private F first;  ///< Primo oggetto nella coppia.
    private S second; ///< Secondo oggetto nella coppia.
    
    /**
     * @brief Costruttore della coppia.
     *
     * @param first Il primo oggetto nella coppia.
     * @param second Il secondo oggetto nella coppia.
     */
    public MutablePair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * @brief Ottiene il primo elemento della coppia.
     *
     * @return Il primo elemento della coppia.
     */
    public F getFirst() {
        return this.first;
    }
    
    /**
     * @brief Imposta il primo elemento della coppia.
     *
     * @param first Il primo oggetto nella coppia.
     */
    public void setFirst(F first) {
        this.first = first;
    }
    
    /**
     * @brief Ottiene il secondo elemento della coppia.
     *
     * @return Il secondo elemento della coppia.
     */
    public S getSecond() {
        return this.second;
    }
    
    /**
     * @brief Imposta il secondo elemento della coppia.
     *
     * @param second Il secondo oggetto nella coppia.
     */
    public void setSecond(S second) {
        this.second = second;
    }
    
    /**
     * @brief Imposta entrambi gli elementi della coppia.
     *
     * @param first Il primo oggetto nella coppia.
     * @param second Il secondo oggetto nella coppia.
     */
    public void setValues(F first, S second) {
        this.setFirst(first);
        this.setSecond(second);
    }
    
    /**
     * @brief Verifica l'uguaglianza con un'altra coppia.
     *
     * Confronta questo oggetto con un altro per verificare se entrambi
     * gli oggetti nella coppia sono considerati uguali.
     *
     * @param o L'oggetto {@link MutablePair} con cui confrontare.
     * @return true se entrambi gli oggetti della coppia sono uguali.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MutablePair<?, ?> p)) {
            return false;
        }
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }
    
    /**
     * @brief Calcola il codice hash per la coppia.
     *
     * @return Il codice hash della coppia.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }
    
    /**
     * @brief Metodo di convenienza per creare una coppia di tipi appropriati.
     *
     * @param a Il primo oggetto nella coppia.
     * @param b Il secondo oggetto nella coppia.
     * @return Una nuova coppia con i tipi degli oggetti passati.
     */
    public static <A, B> MutablePair<A, B> create(A a, B b) {
        return new MutablePair<>(a, b);
    }
}
