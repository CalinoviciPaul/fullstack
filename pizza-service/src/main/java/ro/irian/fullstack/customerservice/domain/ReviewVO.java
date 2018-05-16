package ro.irian.fullstack.customerservice.domain;

/**
 * @author Cristi Toth
 */
public class ReviewVO {

    private String pizzaName;
    private Integer stars;
    private String body;
    private String author;


    public ReviewVO(String pizzaName,
                    Integer stars,
                    String body,
                    String author) {
        this.pizzaName = pizzaName;
        this.stars = stars;
        this.body = body;
        this.author = author;
    }

    public String getPizzaName() {
        return pizzaName;
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
}
