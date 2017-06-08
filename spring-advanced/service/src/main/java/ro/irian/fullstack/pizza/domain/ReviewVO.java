package ro.irian.fullstack.pizza.domain;

/**
 * @author Cristi Toth
 */
public class ReviewVO {

    private String pizzaId;
    private String pizzaName;
    private String reviewId;
    private Integer stars;
    private String body;
    private String author;
    private Long createdOn;


    public ReviewVO(String pizzaId,
                    String pizzaName,
                    String reviewId,
                    Integer stars,
                    String body,
                    String author,
                    Long createdOn) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.reviewId = reviewId;
        this.stars = stars;
        this.body = body;
        this.author = author;
        this.createdOn = createdOn;
    }


    public String getPizzaId() {
        return pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getReviewId() {
        return reviewId;
    }

    public Integer getStars() {
        return stars;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public Long getCreatedOn() {
        return createdOn;
    }
}
