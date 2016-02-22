<?php

$con=mysqli_connect("localhost","root","","AroundTheBlock");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"select * from places");

$values = Array();

while($returnedArray = mysqli_fetch_array($result))
{
	$category = $returnedArray["name"];

    array_push($values, $category);
   	
}

//echo "<br /> <br />";

echo json_encode(array('users' => $values));

mysqli_close($con);

?>