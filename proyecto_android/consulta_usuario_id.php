<?php 

	$codigo_usuario = $_POST["cod"];
	$nombre_usuario = $_POST["nom"];

	$cn = mysqli_connect("localhost", "root", "", "usuarios");

	$rs = mysqli_query($cn, "SELECT * FROM usuario 
		WHERE id_usuario = ".$codigo_usuario." AND nombre = ".$nombre_usuario);

	while($row = mysqli_fetch_assoc($rs)){

		$resultado[] = array_map("utf8_encode", $row);

	}

	echo json_encode($resultado);

	mysqli_close($cn);

 ?>