<?php
$con=mysqli_connect("localhost","root","","AroundTheBlock");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$phoneid = "";
$placeid = "";
$rating = "";

foreach ($_POST as $key => $value) {
    switch ($key) {
        case 'phoneid':
		{
			echo $phoneid = $value;
		}        
		break;
        case 'placeid':
            echo $placeid = $value;
            break;
		case 'rating':
            echo $rating = $value;
            break;
        default:
            break;
    }
}

$sql = "INSERT INTO `ratings` (`userid`, `placeid`, `rating`)
VALUES ('$phoneid', '$placeid', '$rating');";

$result = mysqli_query($con, $sql) or die(mysqli_error($con));

if(mysqli_query($con, $sql))
{
	echo "done";
}
else
{
	echo "QUERY NOT INSERTED";
	echo mysqli_error($con);
}

mysqli_close($con);



?>