<?php 

	$cn = mysqli_connect("localhost", "root", "", "usuarios");

	$idAlbum = $_POST["idAlbum"];

	$rs = mysqli_query($cn, "SELECT cancion FROM Tbl_Cancion WHERE idalbum = '$idAlbum'");

	while($row = mysqli_fetch_assoc($rs)){

		$resultado[] = array_map("utf8_encode",$row);

	}

	echo json_encode($resultado);

	mysqli_close($cn);

 ?>