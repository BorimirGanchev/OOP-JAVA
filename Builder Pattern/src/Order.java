class Order {
    String mainDish;
    String drink;
    String dessert;
    String notes;

    private Order(Builder builder) {
        this.mainDish = builder.mainDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
        this.notes = builder.notes;
    }

    public static class Builder {
        String mainDish;
        String drink;
        String dessert;
        String notes;

        public Builder setMainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Поръчка: ");
        result.append(mainDish);
        if (drink != null) result.append(drink);
        if (dessert != null) result.append(dessert);
        if (notes != null) result.append(" (Бележки: ").append(notes).append(")");
        return result.toString();
    }
}