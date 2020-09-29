<?php

    include_once('koneksi.php');

    if(!empty($_POST['id']) && !empty($_POST['nama']) && !empty($_POST['nohp']) && !empty($_POST['alamat'])){
        
        $id     = $_POST['id'];
        $nama   = $_POST['nama'];
        $nohp   = $_POST['nohp'];
        $alamat = $_POST['alamat'];

        $query = "UPDATE biodata set mahasiswa_nama = '$nama', mahasiswa_nohp = '$nohp', mahasiswa_alamat = '$alamat' WHERE id_mahasiswa = '$id'";
        
        $update = mysqli_query($connect, $query);

        if($update){
            set_response(true, "berhasil update data");
        }else{
            set_response(false, "gagal update data");
        }
    }else{
            set_response(false, "semua data harus diisi");
    }

    function set_response($isSuccess, $message){
        $results = array(
            'isSuccess' => $isSuccess,
            'message'   => $message
        );
        echo json_encode($results);
    }
?>