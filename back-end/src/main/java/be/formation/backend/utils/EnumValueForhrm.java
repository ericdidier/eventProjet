package be.formation.backend.utils;

/**
 * Interface � impl�menter pour pour les enums qui utilisent une valeur pour les repr�senter.
 * Typiquement, ce sera la valeur qui sera utilis�e pour repr�senter l'enum dans une base de donn�es.
 *
 */
public interface EnumValueForhrm<V> {
    /**
     * Retourne la valeur repr�sentant l'enum.
     * @return
     */
    V getValue();
}
