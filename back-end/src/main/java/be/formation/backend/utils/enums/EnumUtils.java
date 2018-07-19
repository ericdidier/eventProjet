package be.formation.backend.utils.enums;

import be.formation.backend.utils.EnumValueForhrm;

public class EnumUtils {
    /**
     * Recherche un ?l?ment d'une ?num?ration ? partir de sa valeur.
     * La m?thode permet l'introduction de nombreux types de param?tres. Les seules restrictions sont :
     * <ul>
     * 		<li>la classe doit ?tre une classe ?tendant {@link Enum} et implementant l'interface {@link EnumValueForhrm}</li>
     * 		<li>La type de la valeur recherch?e doit seulement ?tendre {@link Object}</li>
     * </ul>
     *
     * @param <V> La classe du param?tre value (cette classe doit ?tendre la classe {@link Object}).
     * @param <T> La classe de l'?num?ration. Elle doit donc ?tendre {@link Enum} mais ?galement impl?menter l'interface {@link EnumValueForhrm}
     * du m?me type que le param?tre value.
     * @param classe La classe de l'?num?ration ? parcourir.
     * @param value La valeur ? rechercher
     * @return L'?l?ment correspondant ? la valeur
     */
    public static <T extends Enum<?> & EnumValueForhrm<V>, V>T findEnumByValue(Class<T> classe, V value) {
        T[] values = (T[])classe.getEnumConstants();

        for (T item : values) {
            if (value == null) {
                if (item.getValue() == null) {
                    return item;
                }
            } else if (value.equals(item.getValue())) {
                return item;
            }
        }
        throw new IllegalArgumentException("Aucun ?l?ment de l'?num?ration " + classe.getName() + " ne correspond ? la valeur " + value);
    }

    /**
     * Recherche un ?l?ment d'une ?num?ration ? partir de son ordinal.
     * @param <T> La classe de l'?num?ration. Il faut que ce soit une ?num?ration et doit donc ?tendre {@link Enum}.
     * @param classe La classe de l'?num?ration ? parcourir.
     * @param ordinal L'ordinal ? rechercher
     * @return L'?l?ment correspondant ? l'ordinal
     */
    public static <T extends Enum<?>>T findEnumByOrdinal(Class<T> classe, int ordinal) {
        T [] values = (T[])classe.getEnumConstants();
        if (ordinal < values.length) {
            return values[ordinal];
        }
        throw new IllegalArgumentException("Aucun ?l?ment de l'?num?ration " + classe.getName() + " ne correspond ? l'ordinal " + ordinal);
    }

}

