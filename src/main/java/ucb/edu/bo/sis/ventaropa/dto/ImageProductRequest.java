package ucb.edu.bo.sis.ventaropa.dto;

public class ImageProductRequest {
    private Integer productoId;
    private String foto;

    public ImageProductRequest(Integer productoId, String foto) {
        this.productoId = productoId;
        this.foto = foto;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "ImageProductRequest{" +
                "productoId='" + productoId + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
