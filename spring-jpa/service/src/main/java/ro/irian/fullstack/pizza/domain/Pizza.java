package ro.irian.fullstack.pizza.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristi Toth
 */
@Entity
@Table(name = "pizza")
public class Pizza extends BaseEntity{

    //TODO
    private String name;
    private Double price;
    private Integer weight;
    private String image;
    private String ingredients;

    //TODO
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_id")
    private List<Review> reviews;

    private boolean canPurchase = true;
    private boolean soldOut = false;

    protected Pizza() {}

    public Pizza(String _id, String name, Double price, Integer weight, String image, String ingredients) {
        this.set_id(_id);
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }

    public boolean isCanPurchase() {
        return canPurchase;
    }

    public void setCanPurchase(boolean canPurchase) {
        this.canPurchase = canPurchase;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
}
