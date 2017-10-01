package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDirectoryTest {

    private final Logger log = Logger.getLogger(this.getClass());
    UserDirectory userDirectory = new UserDirectory();
    int initialUserCount;


    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userDirectory.getAllUsers();
        assertTrue("Failed to get all users", users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        User user = userDirectory.getUser(3);
        assertNotNull("User with id: 3 was not found", user);
    }

    @Test
    public void addUserTest() {
        initialUserCount = userDirectory.getAllUsers().size();
        User user = new User();
        user.setFirstName("Steve");
        user.setLastName("Martin");
        userDirectory.addUser(user);
        assertEquals("User was not added to the database", initialUserCount +1, userDirectory.getAllUsers().size());
    }

    @Test
    public void deleteUserTest() {
        initialUserCount = userDirectory.getAllUsers().size();
        userDirectory.deleteUser(initialUserCount);
        assertEquals("User was not deleted from the database", initialUserCount - 1, userDirectory.getAllUsers().size());
    }

    @Test
    public void updateUserTest() throws Exception {
        initialUserCount = 3;
        User user = userDirectory.getUser(initialUserCount);
        user.setFirstName("Billy");
        user.setLastName("Madison");
        userDirectory.updateUser(user);
        assertEquals("user not saved correctly", user.toString(), userDirectory.getUser(initialUserCount).toString());
    }
}
