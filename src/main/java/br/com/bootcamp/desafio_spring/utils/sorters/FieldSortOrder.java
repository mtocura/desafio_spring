package br.com.bootcamp.desafio_spring.utils.sorters;

public final class FieldSortOrder {
    private static String NAME_ASC = "name_asc";
    private static String NAME_DESC = "name_desc";

    private static String DATE_ASC = "date_asc";
    private static String DATE_DESC = "date_desc";

    private FieldSortOrder() {}

    public static boolean isNameAsc(String order) {
        return NAME_ASC.equals(order);
    }

    public static boolean isNameDesc(String order) {
        return NAME_DESC.equals(order);
    }

    public static boolean isDateAsc(String order) {
        return DATE_ASC.equals(order);
    }

    public static boolean isDateDesc(String order) {
        return DATE_DESC.equals(order);
    }
}
