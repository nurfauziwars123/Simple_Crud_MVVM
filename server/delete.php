<?php

    include_once('koneksi.php');

    if(!empty($_POST['id'])){

        $id = $_POST['id'];
        
        $query = "DELETE FROM biodata WHERE id_mahasiswa = '$id'";

        $delete = mysqli_query($connect, $query);

        if($delete){
        set_response(true, "data berhasil dihapus");

        }else{
        set_response(false, "gagal hapus data");
        }

    }else{
        set_response(false, "silahkan masukan id");
    }

    function set_response($isSuccess, $message){
        $results = array(
            'isSuccess'     => $isSuccess,
            'message'       => $message
        );
        echo json_encode($results);
    }
?>