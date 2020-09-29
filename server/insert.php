<?php

    include_once('koneksi.php');
    
    if(!empty($_POST['nama']) && !empty($_POST['nohp']) && !empty($_POST['alamat'])){
        
        $nama   = $_POST['nama'];
        $nohp   = $_POST['nohp'];
        $alamat = $_POST['alamat'];
        
        $query = "INSERT INTO biodata (mahasiswa_nama,mahasiswa_nohp,mahasiswa_alamat) VALUES('$nama', '$nohp', '$alamat')";
        $insert = mysqli_query($connect, $query);

        if($insert){
            set_response(true, "berhasil imput data");
        }else{
            set_response(false, "gagal insert data");
        }
    }else{
        set_response(false, "semua data harus diisi");
    }

    function set_response($isSuccess, $message){
        $results = array(
            'issSuccess' => $isSuccess,
            'message'    => $message
        );
        echo json_encode($results);
    }
?>