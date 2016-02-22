<?php

$con=mysqli_connect("localhost","root","","AroundTheBlock");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"SELECT * FROM users");

$values = Array();

while($returnedArray = mysqli_fetch_array($result))
{
	$phoneid = $returnedArray["phoneid"];

    array_push($values, $phoneid);
   	
}

//echo "<br /> <br />";

echo json_encode(array('users' => $values));

mysqli_close($con);

?>