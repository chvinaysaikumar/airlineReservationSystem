<!-- paymentForm.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Payment Form</title>
</head>
<body>
    <h2>Payment Details</h2>
    <form action="PaymentServlet" method="post">
        <label for="passengerId">Passenger ID:</label>
        <input type="number" id="passengerId" name="passengerId" required><br><br>

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required><br><br>

        <label for="paymentOption">Payment Option:</label>
        <input type="text" id="paymentOption" name="paymentOption" required><br><br>

        <label for="transactionId">Transaction ID:</label>
        <input type="text" id="transactionId" name="transactionId" required><br><br>

        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required><br><br>

        <h3>Card Details (if applicable)</h3>

        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber"><br><br>

        <label for="cardHolder">Card Holder Name:</label>
        <input type="text" id="cardHolder" name="cardHolder"><br><br>

        <label for="expiryDate">Expiry Date (YYYY-MM-DD):</label>
        <input type="text" id="expiryDate" name="expiryDate"><br><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv"><br><br>

        <input type="submit" value="Submit Payment">
    </form>
</body>
</html>
