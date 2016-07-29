package loc.ecs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ecs_products")
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "products_seq_gen")
    @SequenceGenerator(name = "products_seq_gen", sequenceName = "product_id_seq")
    @Column(name = "product_id", nullable = false)
    private int pid;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "image", nullable = false)
    private String image;

    protected Products() {}

    public Products(int pid, String name, String description, int price, String image) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
