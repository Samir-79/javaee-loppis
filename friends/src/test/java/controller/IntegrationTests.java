package controller;

import com.widebrain.friends.controller.FriendController;
import com.widebrain.friends.model.Friend;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class IntegrationTests {



    @Autowired
    FriendController friendController;

    @Test
    public void testCreateAndDelete() {
        Friend friend = new Friend("Gordon","Moore");

        Friend friendResult = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName","Gordon");

        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.read()).isEmpty();

    }

}
