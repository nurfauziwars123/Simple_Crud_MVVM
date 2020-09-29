<?php
    $hostname = "localhost";
    $username = "root";
    $password = "";
    $database = "mahasiswa";

    $connect = mysqli_connect($hostname, $username, $password, $database);

//     if ($connect) {
//         echo "berhasil koneksi ke database" .mysqli_connect_errno(); die();
//     }else{
//         echo "gagal koneksi";
//     }
// ?>