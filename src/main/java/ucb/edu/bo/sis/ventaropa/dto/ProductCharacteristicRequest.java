package ucb.edu.bo.sis.ventaropa.dto;

public class ProductCharacteristicRequest {
    private Integer productId;
    private Integer tallaId;
    private Integer colorId;
    private Integer stock;

    public ProductCharacteristicRequest(Integer productId, Integer tallaId, Integer colorId, Integer stock) {
        this.productId = productId;
        this.tallaId = tallaId;
        this.colorId = colorId;
        this.stock = stock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTallaId() {
        return tallaId;
    }

    public void setTallaId(Integer tallaId) {
        this.tallaId = tallaId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductCharacteristic{" +
                "productId=" + productId +
                ", tallaId=" + tallaId +
                ", colorId=" + colorId +
                ", stock=" + stock +
                '}';
    }
}
