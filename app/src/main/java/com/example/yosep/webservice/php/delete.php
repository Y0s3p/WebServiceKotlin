<?php
/**
 * Created by PhpStorm.
 * User: Yosep
 * Date: 30/11/2018
 * Time: 17:29
 */

$servername = "localhost";
$username = "root";
$password = "clave";
$dbname = "BDYosep";

$marca = $_POST["marca"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "DELETE FROM componentes WHERE marca='$marca'";

if ($conn->query($sql) === TRUE) {
    //echo "Informacion insertada con exito";
} else {
    //echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();

?>