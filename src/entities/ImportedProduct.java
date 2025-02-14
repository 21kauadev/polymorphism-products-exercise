package entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    // polimorfismo
    // sobrescrevendo o método. aplicando a lógica mais específica desse caso.
    @Override
    public String priceTag() {
        return String.format("%s, $ %.2f (Customs fee: $ %.2f)", this.name, (this.price + customsFee), this.customsFee);
    }
}
