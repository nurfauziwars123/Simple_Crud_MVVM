<?php

    include_once('koneksi.php');

    if(!empty($_GET['id'])){
    $id = $_GET['id'];
    $query = "SELECT * FROM biodata WHERE id_mahasiswa = $id";

    }else{
        $query = "SELECT * FROM biodata";
    }

    $get = mysqli_query($connect, $query);
    $data = array();

    if (mysqli_num_rows($get) > 0) {
        while($row = mysqli_fetch_assoc($get)){
            $data[] = $row;
        }
        set_response(true, "datanya berhasil diambil", $data );
        
    }else{
        set_response(false, "datanya gagal diambil", $data);
    }

    function set_response($isSuccess, $message, $data){
        $result = array(
          'isSuccess'   => $isSuccess,
           'message'    => $message,
            'data'      => $data  
        );

        echo json_encode($result);
    }
?>