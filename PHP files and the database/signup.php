<?php
$con=mysqli_connect("localhost","root","","AroundTheBlock");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$phoneid = "";
$name = "";
$email = "";
$address = "";
$gender = "";

foreach ($_POST as $key => $value) {
    switch ($key) {
        case 'phoneid':
		{
			echo $phoneid = $value;
		}        
		break;
        case 'name':
            echo $name = $value;
            break;
        default:
            break;
    }
}

$sql = "INSERT INTO `users` (`phoneid`, `name`)
VALUES ('$phoneid', '$name');";

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