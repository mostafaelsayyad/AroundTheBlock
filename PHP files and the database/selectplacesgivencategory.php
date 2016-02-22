<?php

$con=mysqli_connect("localhost","root","","AroundTheBlock");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
	$category = "";
	foreach ($_POST as $key => $value) {
		switch ($key) {
			case 'selectedcategory':
			{
				$category = $value;
			}        
			default:
				break;
		}
	}

//////////

$result = mysqli_query($con,"SELECT * FROM places where category = '$category'");

$array_ = Array();

while($returnedArray = mysqli_fetch_array($result))
{
	$placeid = $returnedArray["placeid"];
	$name = $returnedArray["name"];
	$address = $returnedArray["address"];
	$phonenumber = $returnedArray["phonenumber"];
	$latitude = $returnedArray["latitude"];
	$longitude = $returnedArray["longitude"];
	$category = $returnedArray["category"];
	$website = $returnedArray["website"];
	$email = $returnedArray["email"];
	
	$values = Array();

    array_push($values, $placeid);
	array_push($values, $name);
	array_push($values, $address);
    array_push($values, $phonenumber);
	array_push($values, $latitude);
    array_push($values, $longitude);
	array_push($values, $category);
    array_push($values, $website);
	array_push($values, $email);
	
	array_push($array_, $values);
	
}

//echo "<br /> <br />";

echo json_encode(array('users' => $array_));

mysqli_close($con);

?>
