<?php
//extension=php_mysqli.dll

// Connect to database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "rj hotel";
$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}

// Process form data
if (isset($_POST['login'])) {
	$email = $_POST['email'];
	$password = $_POST['password'];

	$sql = "SELECT * FROM registration WHERE email='$email' AND password='$password'";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
		// User found, redirect to home page
		header('Location: index.html');
	} else {
		// User not found, display error message
		echo "Invalid email or password.";
	}
}

$conn->close();
?>
