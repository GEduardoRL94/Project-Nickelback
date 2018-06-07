<?php 

	$cn = mysqli_connect("localhost", "root", "", "usuarios");

	$rs = mysqli_query($cn, "SELECT * FROM usuario");

	while($row = mysqli_fetch_assoc($rs)){

		$resultado[] = array_map("utf8_encode", $row);

	}

	echo json_encode($resultado);

	mysqli_close($cn);

	/*$string1 = "Usuario|Clave";

	$string_array = preg_split("/\|/", $string1);

	print_r($string_array);
	echo "<br>".$string_array[0]."<br>";
	echo $string_array[1]."<br>";*/

 ?>