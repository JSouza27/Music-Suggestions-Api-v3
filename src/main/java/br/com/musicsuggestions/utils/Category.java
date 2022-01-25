package br.com.musicsuggestions.utils;

public enum Category {

    PARTY(null),
    POP(null),
    ROCK(null),
    CLASSICAL(null);

    private SelectCategory selectCategory;

    Category(SelectCategory selectCategory) {
        this.selectCategory = selectCategory;
    }

    public SelectCategory getSelectCategory() {
        return selectCategory;
    }
}
