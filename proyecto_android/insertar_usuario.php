<?php 

	$cn = mysqli_connect("localhost", "root", "", "usuarios");

	$nombre = $_POST["Nombre"];
	$apellido = $_POST["Apellido"];
	$email = $_POST["Email"];
	$usuario = $_POST["Usuario"];
	$clave = $_POST["Clave"];

	$rs = mysqli_query($cn, "INSERT INTO usuario(nombre, apellido, email, n_usuario, c_usuario) 
		VALUES ('$nombre', '$apellido', '$email', '$usuario', '$clave')");

	if($rs){

		echo ('Guardado Exitosamente');

	}else{

		echo ('No se guardó con exito');

	}

 ?>