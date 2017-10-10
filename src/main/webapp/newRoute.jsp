<html>
<body>
Add User:
<form action="searchUser" method="POST" >
    <label for name="firstname">First Name:</label>
    <input type="text" name="firstname" />
    <label for name="lastname">Last Name:</label>
    <input type="text" name="lastname" />
    <input type="submit" value="Add" name="submit" />
</form>

Search all users
<a href ="searchUser">Search all users</a><br />
</body>

Delete User:
<form action="searchUser" method="POST" >
    <label for name="deleteid">Employee ID:</label>
    <input type="text" name="deleteid" />
    <input type="submit" value="Delete" name="submit" />
</form>

Update user:
<form action="searchUser" method="POST" >
    <label for name="updateid">Id to change:</label>
    <input type="text" name="updateid" />
    <label for name="updatefirstname">New First Name:</label>
    <input type="text" name="updatefirstname" />
    <label for name="updatelastname">New Last Name:</label>
    <input type="text" name="updatelastname" />
    <input type="submit" value="Add" name="submit" />
</form>

</html>