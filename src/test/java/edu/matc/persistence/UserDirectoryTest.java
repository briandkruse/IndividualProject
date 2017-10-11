package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDirectoryTest {

    private final Logger log = Logger.getLogger(this.getClass());
    UserDirectory userDirectory;
    User user;
    int initialUserCount;


    @Before
    public void setUp() throws Exception {
        userDirectory = new UserDirectory();
        User userTest = new User("usertest", "usertest", "usertest");
        User updateTest = new User("updatetest", "updatetest", "updatetest");
        User deleteTest = new User("deletetest", "deletetest", "deletetest");
        userDirectory.addUser(userTest);
        userDirectory.addUser(updateTest);
        userDirectory.addUser(deleteTest);
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userDirectory.getAllUsers();
        assertTrue("Failed to get all users", users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        user = userDirectory.getUser("usertest");
        assertNotNull("User usertest was not found", user);
    }

    @After
    public void cleanupGetUser() {
        userDirectory.deleteUser("usertest");
    }

    @Test
    public void addUserTest() {
        initialUserCount = userDirectory.getAllUsers().size();
        User user = new User("Steve", "Martin", "FunnyMan");
        userDirectory.addUser(user);
        assertEquals("User was not added to the database", initialUserCount +1, userDirectory.getAllUsers().size());
    }
    @After
    public void cleanupAddUser() {
        userDirectory.deleteUser("FunnyMan");
    }
    @Test
    public void deleteUserTest() {
        initialUserCount = userDirectory.getAllUsers().size();
        userDirectory.deleteUser("deletetest");
        assertEquals("User was not deleted from the database", initialUserCount - 1, userDirectory.getAllUsers().size());
    }
    @After
    public void cleanupAddDelete() {
        userDirectory.deleteUser("deletetest");
    }
    @Test
    public void updateUserTest() throws Exception {
        user = userDirectory.getUser("updatetest");
        user.setFirstName("Billy");
        user.setLastName("Madison");
        userDirectory.updateUser(user);
        assertEquals("user not saved correctly", user.toString(), userDirectory.getUser("updatetest").toString());
    }
    @After
    public void cleanupUpdate() {
        userDirectory.deleteUser("updatetest");
    }
}

