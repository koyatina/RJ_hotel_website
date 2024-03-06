
<?php
$email = $_POST['email'];
$password = $_POST['password'];
$confirm_password = $_POST['confirm_password'];

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
if (isset($_POST['register'])) {
	$email = $_POST['email'];
	$password = $_POST['password'];
	$confirm_password = $_POST['confirm_password'];

	// Check if passwords match
	if ($password != $confirm_password) {
		echo "Passwords do not match.";
		exit();
	}

	// Check if user already exists
	$sql = "SELECT * FROM registration WHERE email='$email'";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
		echo "Email already registered.";
		exit();
	}

	// Insert user into database
	$sql = "INSERT INTO registration (email, password) VALUES ('$email', '$password')";

	if ($conn->query($sql) === TRUE) {
		header('Location: index.html');
	} else {
		echo "Error: " . $sql . "<br>" . $conn->error;
	}
}

$conn->close();
?>
