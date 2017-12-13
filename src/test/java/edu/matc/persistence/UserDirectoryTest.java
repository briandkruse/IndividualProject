
package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class UserDirectoryTest {

    private final Logger log = Logger.getLogger(this.getClass());
    UserDirectory userDirectory = new UserDirectory();;
    User user;
    int initialUserCount;


    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userDirectory.getAllUsers();
        assertTrue("Failed to get all users" + users.size(), users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        User userTest = userDirectory.getUser("admin");
        userDirectory.addUser(userTest);
        user = userDirectory.getUser("usertest");
        assertNotNull("User usertest was not found", user);
        userDirectory.deleteUser("usertest");
    }

    @Test
    public void addUserTest() {
        initialUserCount = userDirectory.getAllUsers().size();
        User user = userDirectory.getUser("admin");
        userDirectory.addUser(user);
        assertEquals("User was not added to the database", initialUserCount +1, userDirectory.getAllUsers().size());
        userDirectory.deleteUser("Martin");
    }

    @Test
    public void deleteUserTest() {
        User deleteTest = userDirectory.getUser("admin");
        userDirectory.addUser(deleteTest);
        initialUserCount = userDirectory.getAllUsers().size();
        userDirectory.deleteUser("deletetest");
        assertEquals("User was not deleted from the database", initialUserCount - 1, userDirectory.getAllUsers().size());
    }

    @Test
    public void updateUserTest() throws Exception {
        User updateTest = userDirectory.getUser("admin");
        userDirectory.addUser(updateTest);
        user = userDirectory.getUser("updatetest");
        user.setFirstName("Billy");
        user.setLastName("Madison");
        userDirectory.updateUser(user);
        assertEquals("user not saved correctly", user.toString(), userDirectory.getUser("updatetest").toString());
        userDirectory.deleteUser("updatetest");
    }

    @Test
    public void addRoleTest() {
        UserRole role = new UserRole("test", "user");
        userDirectory.addRole(role);
        assertEquals("Role was not added to the database", initialUserCount +1, userDirectory.getAllUsers().size());

    }

}


