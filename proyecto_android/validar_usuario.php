<?php 

	$cn = mysqli_connect("localhost", "root", "", "usuarios");

	$datos = $_POST["datos"];
	//$datos = "Usuario|Clave";

	$datos_array = preg_split("/\|/", $datos);
	$usuario = $datos_array[0];
	$clave = $datos_array[1];

	$rs = mysqli_query($cn, "SELECT * FROM usuario
		WHERE n_usuario = '$usuario' AND c_usuario = '$clave'");

	if($rs != null){

		$row = mysqli_fetch_assoc($rs);
		$resultado[] = array_map("utf8_encode", $row);
		echo json_encode($resultado);

	}else{

		echo "Usuario o constraseña incorrectos";

	}

	mysqli_close($cn);

 ?>