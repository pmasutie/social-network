import com.codurance.InMemoryMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryMessageRepositoryShould {
    InMemoryMessageRepository messageRepository;
    String ALICE_USERNAME = "Alice";
    String MESSAGE_ONE = "Message 1";
    @BeforeEach
    void setUp() {
        messageRepository = new InMemoryMessageRepository();
    }

    @Test
    public void start_empty() {
        assertTrue(messageRepository.isEmpty());
    }

    @Test
    public void not_be_empty_after_first_post() {
        messageRepository.postMessageByUsername(ALICE_USERNAME, MESSAGE_ONE);
        assertFalse(messageRepository.isEmpty());
    }

    @Test
    public void get_a_list_of_posted_messages_with_one_message() {
        messageRepository.postMessageByUsername(ALICE_USERNAME, MESSAGE_ONE);
        assertEquals(List.of(MESSAGE_ONE), messageRepository.getMessagesByUsername(ALICE_USERNAME));
    }

    @Test
    public void get_a_list_of_posted_messages_with_two_messages_by_the_same_user() {
        String messageTwo = "Message 2";
        messageRepository.postMessageByUsername(ALICE_USERNAME, MESSAGE_ONE);
        messageRepository.postMessageByUsername(ALICE_USERNAME, messageTwo);
        assertEquals(List.of(MESSAGE_ONE, messageTwo), messageRepository.getMessagesByUsername(ALICE_USERNAME));
    }

    @Test
    public void get_a_list_of_posted_messages_for_one_user_with_two_messages_by_different_users() {
        String bobUsername = "Bob";
        String messageTwo = "Message 2";
        messageRepository.postMessageByUsername(ALICE_USERNAME, MESSAGE_ONE);
        messageRepository.postMessageByUsername(bobUsername, messageTwo);
        assertEquals(List.of(MESSAGE_ONE), messageRepository.getMessagesByUsername(ALICE_USERNAME));
        assertEquals(List.of(messageTwo), messageRepository.getMessagesByUsername(bobUsername));
    }
}
