<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
	require_once('dbConnect.php');
	
	
	$name = $_POST["name"];	
	$mail = $_POST["mail"];
	$password = $_POST["password"];
	$phone = $_POST["phone"];
	
	
	$query = " Insert into user(name,mail,phone,active,password) values ('$name','$mail','$phone','0','$password');";
	
	mysqli_query($con, $query) or die (mysqli_error($con));
	mysqli_close($con);
}
?>