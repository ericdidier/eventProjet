package be.formation.backend.utils.enums;

import be.formation.backend.utils.EnumValueForhrm;

public class EnumUtils {
    /**
     * Recherche un élément d'une énumération à partir de sa valeur.
     * La méthode permet l'introduction de nombreux types de paramètres. Les seules restrictions sont :
     * <ul>
     * 		<li>la classe doit être une classe étendant {@link Enum} et implementant l'interface {@link EnumValueForhrm}</li>
     * 		<li>La type de la valeur recherchée doit seulement étendre {@link Object}</li>
     * </ul>
     *
     * @param <V> La classe du paramètre value (cette classe doit étendre la classe {@link Object}).
     * @param <T> La classe de l'énumération. Elle doit donc étendre {@link Enum} mais également implémenter l'interface {@link EnumValueForhrm}
     * du même type que le paramètre value.
     * @param classe La classe de l'énumération à parcourir.
     * @param value La valeur à rechercher
     * @return L'élément correspondant à la valeur
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
        throw new IllegalArgumentException("Aucun élément de l'énumération " + classe.getName() + " ne correspond à la valeur " + value);
    }

    /**
     * Recherche un élément d'une énumération à partir de son ordinal.
     * @param <T> La classe de l'énumération. Il faut que ce soit une énumération et doit donc étendre {@link Enum}.
     * @param classe La classe de l'énumération à parcourir.
     * @param ordinal L'ordinal à rechercher
     * @return L'élément correspondant à l'ordinal
     */
    public static <T extends Enum<?>>T findEnumByOrdinal(Class<T> classe, int ordinal) {
        T [] values = (T[])classe.getEnumConstants();
        if (ordinal < values.length) {
            return values[ordinal];
        }
        throw new IllegalArgumentException("Aucun élément de l'énumération " + classe.getName() + " ne correspond à l'ordinal " + ordinal);
    }

}

