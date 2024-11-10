<!-- passengerForm.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Passenger Registration</title>
</head>
<body>
    <h2>Passenger Registration</h2>
    <form action="PassengerServlet" method="post">
        <label for="first_name">First Name:</label>
        <input type="text" id="first_name" name="first_name" required><br><br>

        <label for="last_name">Last Name:</label>
        <input type="text" id="last_name" name="last_name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone"><br><br>

        <label for="passport_number">Passport Number:</label>
        <input type="text" id="passport_number" name="passport_number" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>