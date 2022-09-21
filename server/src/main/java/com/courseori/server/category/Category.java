package com.courseori.server.category;

public enum Category {

    PORKFEET("족발&보쌈"), SOUP("찜&탕&찌개"), CUTLETANDJAPANESE("돈까스&회&일식"), PIZZA("피자"), PORK("고기"),
    NIGHTSNACK("야식"), WESTERN("양식"), CHICKEN("치킨"), CHINESE("중식"), ASIAN("아시안"), KOREAN("백반&죽&국수"),
    DOSIRAK("도시락"), BUNSIK("분식"), CAFEDESSERT("카페&디저트"), FASTFOOD("패스트푸드");

    private String category;

    private Category(String category) {
        this.category = category;
    }

}
