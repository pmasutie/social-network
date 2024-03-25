import com.codurance.Timeline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimelineShould {
    @Test
    public void start_empty() {
        Timeline timeline = new Timeline();
        assertTrue(timeline.isEmpty());
    }

    @Test
    public void not_be_empty_after_first_post() {
        Timeline timeline = new Timeline();
        String username = "Alice";
        String userPost = "Message 1";
        timeline.post(username, userPost);
        assertFalse(timeline.isEmpty());
    }
}
