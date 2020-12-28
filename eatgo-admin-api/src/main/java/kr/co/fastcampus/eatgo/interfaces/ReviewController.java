package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.ReviewService;
import com.example.eatgocommon.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create(
            @PathVariable("restaurantId") Long retsaurantId,
            @Valid @RequestBody Review resource)
            throws URISyntaxException {
        Review review = reviewService.addReview(retsaurantId,resource);
        String url = "/restaurants/" + retsaurantId + "/reviews/"+review.getId();
        return ResponseEntity.created(new URI(url))
                .body("{}");
    }
}
